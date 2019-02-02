package com.example.u93.mvp.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.u93.mvp.models.User;
import com.google.gson.Gson;

public class CustomSharedPreferences {

    private SharedPreferences sharedPreferences;

    public CustomSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
    }

    public String getString(String key){
        if (sharedPreferences.contains(key)){
            return sharedPreferences.getString(key,null);
        }
        return  null;
    }

    public void addString(String key, String value){
        if(value != null){
            addValue(key,value);
        }
    }

    private void addValue(String key, String value) {
        sharedPreferences.edit().putString(key,value).apply();
    }

    public void deleteValue(String value){
        sharedPreferences.edit().remove(value).apply();
    }

    public void saveUser(String key, User user){
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);
        addValue(key, jsonUser);
    }

    public User getUser(String key){
        Gson gson = new Gson();
        String jsonUser = sharedPreferences.getString(key, null);
        User user = gson.fromJson(jsonUser, User.class);
        return user;
    }
}
