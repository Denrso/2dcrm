package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class itemlv {

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

    itemlv(String _name, int _cost, String _images) {
        name = _name;
        cost = _cost;
        images = _images;
    }

}
