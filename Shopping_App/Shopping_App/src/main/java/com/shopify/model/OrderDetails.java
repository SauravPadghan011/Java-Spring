/**
 * Class to Display order details.
 * OrderID is the unique id for each order.
 * Amount, final price of the order/product.
 * Date, which represents the date of purchased or added into cart or transaction.
 * Coupon is just a property which shows which coupon applied.
 */

package com.shopify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OrderDetails {
    private Integer orderId;
    private Integer amount;
    private String date;
    private String coupon;
}
