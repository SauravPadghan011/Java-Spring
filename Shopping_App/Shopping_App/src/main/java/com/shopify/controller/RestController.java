package com.shopify.controller;

import com.shopify.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/shopping")
public class RestController {

    /**
     * Suppose we have only product.
     * At startup add default Inventory
     * At startup add default orders
     * Initially orderId will start from 100, and it will increase as we order each time. One way to generate orderId
     * orderDetailsList = list of OrderDetails which contains details of the orders
     * paymentList = list of Payments which contains all the payment transaction record
     */
    private Inventory inventoryObj = new Inventory(0, 100, 100);
    private Order orderObj = new Order(100, 1, 10, 950, "OFF5");
    private Coupons couponsObj = new Coupons();

    private Integer orderId = 100;
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
    private List<Payment> paymentList = new ArrayList<>();


    /**
     * Display the inventory.
     */
    @RequestMapping(value = "/inventory", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Inventory inventory(@RequestParam(value = "ordered", defaultValue = "0") Integer ordered) {
        return new Inventory(ordered, inventoryObj.getPrice(), inventoryObj.getAvailable()-ordered);
    }

    /**
     * Fetch the coupons.
     */
    @RequestMapping(value = "/fetchCoupons", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Integer> fetchCoupons(@RequestParam(value = "OFF", defaultValue = "5") Integer OFF) {
        return couponsObj.getCouponList();
    }

    /**
     * Here I have performed the logic display the orders.
     * 1st Condition will return Status Code: 404 as quantity is invalid.
     * 2nd Condition will return Status Code: 404 as coupon used is invalid.
     * If all the conditions fails then perform the operations,
     * price = Total cost,
     * discount = Calculated discount as per coupon used,
     * offPrice = Final price after using coupon,
     * Then store the all details into Order class. and change the availability from Inventory.
     *
     * Lastly add order details in OrderDetails list for further display operations.
     * After that increment orderId to get the unique orderId.
     */
    @RequestMapping(value = "/{userId}/order", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> order(@PathVariable("userId") Integer userId,
                                        @RequestParam("qty") Integer qty,
                                        @RequestParam("coupon") String coupon) {
        if(qty > inventoryObj.getAvailable()) {
            ErrorStatus validateAvailability = new ErrorStatus("Invalid quantity",
                    "Quantity is either less than 1 more than the maximum quantity of product available");
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return new ResponseEntity<>(validateAvailability, HttpStatus.NOT_FOUND);
        }
        else if(!couponsObj.getCouponList().containsKey(coupon)){
            ErrorStatus validateCoupon = new ErrorStatus("Invalid coupon",
                    "User has already used the coupon before, or coupon does not exist");
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return new ResponseEntity<>(validateCoupon, HttpStatus.NOT_FOUND);
        }
        else{
            Integer price = qty * inventoryObj.getPrice();
            Integer discount = couponsObj.getCouponList().get(coupon);
            Integer offPrice = price - (price*discount)/100;
            Object order = new Order(orderId, 1, qty, offPrice, coupon);
            inventoryObj = new Inventory(inventoryObj.getOrdered(), inventoryObj.getPrice(), inventoryObj.getAvailable()-qty);

            LocalDateTime dateToday = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date = dateToday.format(dateTimeFormatter);
            orderDetailsList.add(new OrderDetails(orderId, offPrice, date, coupon));

            this.orderId++;
            return ResponseEntity.of(Optional.of(order));
        }
    }


    /**
     * Now perform the payment operation
     * First it will check whether entered amount is valid or not. If it is invalid then we will get Status Code: 404.
     * If conditions failed i.e. given amount is valid then perform the Payment and store the status into the payment list.
     */
    @RequestMapping(value = "/{userId}/{orderId}/pay", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> pay(@PathVariable("userId") Integer userId,
                                      @PathVariable("orderId") Integer orderId,
                                      @RequestParam("amount") Integer amount) {

        if(amount < orderObj.getAmount()) {
            Payment pay = new Payment(userId, orderId, "trans010100001", "failed",
                    "Payment Failed as amount is invalid");
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return new ResponseEntity<>(pay, HttpStatus.NOT_FOUND);
        } else {
            Payment pay = new Payment(userId, orderId, "trans010100001", "successful", "Payment Successful");
            paymentList.add(pay);
            return ResponseEntity.of(Optional.of(pay));
        }
    }

    /**
     * Display the order details.
     */
    @RequestMapping(value = "/{userId}/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> orders(@PathVariable("userId") Integer userId) {
        return ResponseEntity.of(Optional.of(orderDetailsList));
    }

    /**
     * Display payment transactions.
     */
    @RequestMapping(value = "/{userId}/payments", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> payments() {
        return ResponseEntity.of(Optional.of(paymentList));
    }
}