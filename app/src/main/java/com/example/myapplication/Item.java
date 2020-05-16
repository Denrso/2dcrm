package com.example.myapplication;


import com.google.gson.annotations.SerializedName;

public class Item {
    private int id;
    private int category_id;
    private int user_id;
    private int town_id;
    private String name;

    @SerializedName("body")
    private String description;
    private String createdate;
    private String cadastral;
    private int cost;
    private int rooms;
    private int floors;
    private int floor;
    private int area;
    private int living_space;
    private String address;
    private String images;
    private int status;

    public int getId() {
        return id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getTown_id() {
        return town_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedate() {
        return createdate;
    }

    public String getCadastral() {
        return cadastral;
    }

    public int getCost() {
        return cost;
    }

    public int getRooms() {
        return rooms;
    }

    public int getFloors() {
        return floors;
    }

    public int getFloor() {
        return floor;
    }

    public int getArea() {
        return area;
    }

    public int getLiving_space() {
        return living_space;
    }

    public String getAddress() {
        return address;
    }

    public String getImages() {
        return images;
    }

    public int getStatus() {
        return status;
    }
}
