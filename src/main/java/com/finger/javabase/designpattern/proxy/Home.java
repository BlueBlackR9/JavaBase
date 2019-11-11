package com.finger.javabase.designpattern.proxy;

/**
 * @Author: hushuai
 * @Date: 19-7-11 下午11:26
 * @Description
 */
public class Home{
    Integer price;
    String color;

    public Home(Integer price, String color) {
        this.price = price;
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}