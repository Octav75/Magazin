package com.sda.project.products;


import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String productName;
    private double productPrice;
    private String productDescription;
    private String productStock;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] productImage;




    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString(){
        return "Product{" + "id" + id + ", product name" + productName + ", product price" + productPrice + ", product description" +
                productDescription + ", product stock" + productStock + "}";

    }
}

