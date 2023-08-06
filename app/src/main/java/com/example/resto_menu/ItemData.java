package com.example.resto_menu;


public class ItemData {

    private int id;
    private String name;
    private double price;
    private int imageResourceId;
    private String description;

    public ItemData(int id, String name, double price, int imageResourceId, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }
}
