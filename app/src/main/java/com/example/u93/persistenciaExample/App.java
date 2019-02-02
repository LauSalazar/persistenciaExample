package com.example.u93.persistenciaExample;

import android.app.Application;

import com.example.u93.persistenciaExample.helper.Database;

public class App extends Application {

    public static Database mDB;

    @Override
    public void onCreate() {
        super.onCreate();
        createDataBase();
    }

    private void createDataBase() {
        mDB = new Database(this);
        mDB.open();
    }

    @Override
    public void onTerminate() {
        mDB.close();
        super.onTerminate();
    }
}
