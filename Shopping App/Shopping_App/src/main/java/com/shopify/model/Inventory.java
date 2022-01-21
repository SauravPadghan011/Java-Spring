/**
 * Class which stores the Inventory details.
 * It has ordered i.e. number of times it ordered.
 * Then Price which is the price of the item.
 * And last available which is the availability of the product
 */

package com.shopify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Inventory {
    private Integer ordered;
    private Integer price;
    private Integer available;
}
