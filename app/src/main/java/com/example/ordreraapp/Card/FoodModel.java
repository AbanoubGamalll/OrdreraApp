package com.example.ordreraapp.Card;

public class FoodModel {
    String name, price, num;
    int photo;

    public FoodModel(String name, String price, String num, int photo) {
        this.name = name;
        this.price = price;
        this.num = num;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
