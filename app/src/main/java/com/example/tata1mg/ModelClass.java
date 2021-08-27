package com.example.tata1mg;

import android.widget.Button;

public class ModelClass {
    private int image;
    private String product,quantity,price;
    private String cart;

    public ModelClass(int image, String product, String quantity, String price, String cart) {
        this.image = image;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.cart = cart;
    }

    public int getImage() {
        return image;
    }

    public String getProduct() {
        return product;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getCart() {
        return cart;
    }
}
