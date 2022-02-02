package com.replica.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productDetails")
@Getter @Setter
@NoArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pId")
    private Integer pId;

    @Column(name = "productId")
    private String productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "manufacturerName")
    private String manufacturerName;

    @Column(name = "productPrice")
    private Integer productPrice;

    @Column(name = "productDiscount")
    private Integer productDiscount;

    @Column(name = "productStock")
    private Integer productStock;

    @Column(name = "createdBy")
    private String createdBy;

    public ProductDetail(String productId, String productName, String manufacturerName, Integer productPrice,
                         Integer productDiscount, Integer productStock, String createdBy) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productStock = productStock;
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "[Product Id = "+productId+", Product Name = " + productName + ", Manufacturer Name" + manufacturerName +
                ", Price = " + productPrice + ", Discount = " + productDiscount + "%, Stock Available = " + productStock +
                ", Created By = " + createdBy + "]";
    }
}
