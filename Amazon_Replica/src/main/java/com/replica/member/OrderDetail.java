package com.replica.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "orderDetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oId")
    private Integer oId;

    @Column(name = "orderId")
    private String orderId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private Integer productPrice;

    @Column(name = "productDiscount")
    private Integer productDiscount;

    @Column(name = "priceAfterDis")
    private Integer priceAfterDis;

    @Column(name = "totalCost")
    private Integer totalCost;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "orderedBy")
    private String orderedBy;

    @Column(name = "deliveryAddr")
    private String deliveryAddr;

    public OrderDetail(String orderId, String productName, Integer productPrice, Integer productDiscount,
                       Integer priceAfterDis, Integer totalCost, Integer quantity, String orderedBy, String deliveryAddr) {
        this.orderId = orderId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.priceAfterDis = priceAfterDis;
        this.totalCost = totalCost;
        this.quantity = quantity;
        this.orderedBy = orderedBy;
        this.deliveryAddr = deliveryAddr;
    }

    public String toString() {
        return "[Order Id = "+orderId+", Product Name = " + productName + ", Product Price" + productPrice +
                ", Product Discount = " + productDiscount + ",% Price After Discount = " + priceAfterDis +
                ", Total Cost = " + totalCost + ", Quantity = " + quantity + ", Delivery Address: "+ deliveryAddr + "]";
    }
}
