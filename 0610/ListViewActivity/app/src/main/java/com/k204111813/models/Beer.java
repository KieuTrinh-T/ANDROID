package com.k204111813.models;

public class Beer {
    int productThumb;
    String productName;
    double productPrice;

    //Constructor
    public Beer(int productThumb, String productName, double productPrice) {
        this.productThumb = productThumb;
        this.productName = productName;
        this.productPrice = productPrice;

    }
    //Setter and Getter

    public int getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
    }

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
}
