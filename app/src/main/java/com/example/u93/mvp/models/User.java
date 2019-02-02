package com.example.u93.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("_id")
    @Expose
    private  String id;

    @SerializedName("name")
    @Expose
    private  String name;

    @SerializedName("username")
    @Expose
    private  String username;

    @SerializedName("password")
    @Expose
    private  String password;

    @SerializedName("email")
    @Expose
    private  String email;

    @SerializedName("photo")
    @Expose
    private  String photo;

    @SerializedName("token")
    @Expose
    private  String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
