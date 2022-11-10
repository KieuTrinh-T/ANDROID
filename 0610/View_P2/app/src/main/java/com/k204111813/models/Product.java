package com.k204111813.models;

public class Product {
    String productName;
    String productColor;
    //Constructor

    public Product(String productName, String productColor) {
        this.productName = productName;
        this.productColor = productColor;
    }
    //Getter and Setter

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    @Override
    public String toString() {
        return   productName + '\n' + productColor;
    }
}
