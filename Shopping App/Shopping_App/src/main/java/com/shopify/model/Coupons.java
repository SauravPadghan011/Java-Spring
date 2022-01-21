/**
 * Stores the information about the coupons.
 */

package com.shopify.model;

import java.util.HashMap;
import java.util.Map;

public class Coupons {
    private Map<String, Integer> couponList;

    public Map<String, Integer> getCouponList() {
        return this.couponList;
    }

    public Coupons() {
        this.couponList = new HashMap<>();
        this.couponList.put("OFF5", 5);
        this.couponList.put("OFF10", 10);
    }
}
