package com.example.u93.mvp.providers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class DBContentProvider {

    public SQLiteDatabase mDB;
    public DBContentProvider(SQLiteDatabase mDB){
        this.mDB = mDB;
    }

    public int delete(String tableName, String selection, String [] selectionArguments){
        return mDB.delete(tableName,selection,selectionArguments);
    };

    public long insert(String tableName, ContentValues values){
        return mDB.insert(tableName,null,values);
    };


    public Cursor query(String tableName, String [] columns, String selection,
                          String [] selectionsArg, String sortOrder){
        return mDB.query(tableName,columns,selection,selectionsArg,null,null,sortOrder);

    };

    public Cursor query(String tableName, String [] columns, String selection,
                        String [] selectionsArg, String sortOrder, String limit ){
        return mDB.query(tableName,columns,selection,selectionsArg,null,null,sortOrder, limit);

    };

    public Cursor query(String tableName, String [] columns, String selection,
                        String [] selectionsArg, String groupBy, String sortOrder, String limit ){
        return mDB.query(tableName,columns,selection,selectionsArg, groupBy,null,sortOrder, limit);

    };

    public Cursor query(String tableName, String [] columns, String selection,
                        String [] selectionsArg, String groupBy, String having, String sortOrder, String limit ){
        return mDB.query(tableName,columns,selection,selectionsArg, groupBy,having,sortOrder, limit);

    };

    public int update(String tableName, ContentValues values, String selections, String [] selectionArgs){
        return  mDB.update(tableName,values,selections,selectionArgs);
    };
}
