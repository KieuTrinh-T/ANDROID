package com.k204111813.models;

import com.k204111813.gridviewactivity.R;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    int Thumb;
    String Name;
    Double Price;

    //Constructor

    public Beer(int thumb, String name, Double price) {
        Thumb = thumb;
        Name = name;
        Price = price;
    }

    public int getThumb() {
        return Thumb;
    }

    public void setThumb(int thumb) {
        Thumb = thumb;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }





}
