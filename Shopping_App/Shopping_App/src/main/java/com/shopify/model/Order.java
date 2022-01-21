/**
 * Class to store order details
 */

package com.shopify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer quantity;
    private Integer amount;
    private String coupon;
}
