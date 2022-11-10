package com.k204111813.models;

import android.media.Image;

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
    //Getter Setter

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
