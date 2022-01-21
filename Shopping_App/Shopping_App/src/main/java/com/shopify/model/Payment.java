/**
 * To store payment transaction record.
 * UserId which the id of the user, also it is unique.
 * OrderID, unique orderId or order transaction id.
 * TransactionId unique transaction id.
 * Status, Tells the status of the transaction, whether it is failed or successful.
 * Description, in case transaction fails due to any condition like,
 * failed due to invalid amount or failed due to server error or anything. Here will get the information about that.
 */

package com.shopify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Payment {
    private Integer userId;
    private Integer orderId;
    private String transactionId;
    private String status;
    private String description;
}
