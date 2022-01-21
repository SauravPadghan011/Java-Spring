/**
 * Just to show what kind of error/exception we got.
 * Also this is mostly used to show the HTTP status.
 */

package com.shopify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ErrorStatus {
    private String description;
    private String message;
}
