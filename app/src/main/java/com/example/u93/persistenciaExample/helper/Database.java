package com.example.u93.persistenciaExample.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.u93.persistenciaExample.dao.ContactosDAO;

public class Database {

    private final Context context;
    private DataBaseHelper dbHelper;

    //daos
    public static ContactosDAO contactosDAO;

    public Database(Context context) {
        this.context = context;
    }

    public Database open(){
        try{
            dbHelper = new DataBaseHelper(context);
            SQLiteDatabase sdb = dbHelper.getWritableDatabase();
            contactosDAO = new ContactosDAO(sdb);
            return this;
        } catch (SQLiteException e){
            throw  e;
        }
    }

    public void close(){
        dbHelper.close();
    }
}
