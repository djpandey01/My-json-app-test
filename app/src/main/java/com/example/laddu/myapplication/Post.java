package com.example.laddu.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Laddu on 25/09/2017.
 */

public class Post {

    @SerializedName("city")
    public String city;
    @SerializedName("petrol")
    public float petrol;
    @SerializedName("diesel")
    public float diesel;

}
