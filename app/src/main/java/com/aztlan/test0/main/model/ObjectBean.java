package com.aztlan.test0.main.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ObjectBean implements Serializable{
    @SerializedName("userId")
    public int userId;
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("body")
    public String body;

    public ObjectBean(int userId, int id, String title, String body){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
