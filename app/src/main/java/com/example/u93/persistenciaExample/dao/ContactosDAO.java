package com.example.u93.persistenciaExample.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.u93.persistenciaExample.models.Contacto;
import com.example.u93.persistenciaExample.providers.DBContentProvider;
import com.example.u93.persistenciaExample.schemes.IContactosScheme;

import java.util.ArrayList;

public class ContactosDAO extends DBContentProvider implements IContactosScheme, IContactosDAO {
    private Cursor cursor;
    private ContentValues values;
    private final static String TAG = "ContactosDAO";

    public ContactosDAO(SQLiteDatabase mDB) {
        super(mDB);
    }

    @Override
    protected Contacto cursorToEntity(Cursor cursor) {
        Contacto contacto = new Contacto();
        if(cursor.getColumnIndex(COLUMN_ID) != -1){
            int idIndex = cursor.getColumnIndexOrThrow(COLUMN_ID);
            contacto.setId(cursor.getInt(idIndex));
        }
        if(cursor.getColumnIndex(COLUMN_NOMBRE) != -1){
            int idIndex = cursor.getColumnIndexOrThrow(COLUMN_NOMBRE);
            contacto.setNombre(cursor.getString(idIndex));
        }
        if(cursor.getColumnIndex(COLUMN_TELEFONO) != -1){
            int idIndex = cursor.getColumnIndexOrThrow(COLUMN_TELEFONO);
            contacto.setTelefono(cursor.getString(idIndex));
        }
        if(cursor.getColumnIndex(COLUMN_EMPRESA) != -1){
            int idIndex = cursor.getColumnIndexOrThrow(COLUMN_EMPRESA);
            contacto.setEmpresa(cursor.getString(idIndex));
        }

        return contacto;
    }

    @Override
    public ArrayList<Contacto> fetchAllContacts() {
        ArrayList<Contacto> contactosList = new ArrayList<>();
        cursor = query(CONTACTOS_TABLE,CONTACTOS_COLUMNS,null,null,COLUMN_NOMBRE);
        if (cursor != null){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                Contacto  contacto = cursorToEntity(cursor);
                contactosList.add(contacto);
                cursor.moveToNext();
            }
        }
        return contactosList;
    }

    @Override
    public Boolean createContacto(Contacto contacto) {
        setContentValueContacto(contacto);
        try{
            return super.insert(CONTACTOS_TABLE,getContentValue()) >= 0;
        }
        catch (SQLiteException e){
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    private ContentValues getContentValue() {
        return values;
    }

    private void setContentValueContacto(Contacto contacto) {
        values = new ContentValues();
        //values.put(COLUMN_ID,contacto.getId());
        values.put(COLUMN_NOMBRE,contacto.getNombre());
        values.put(COLUMN_TELEFONO,contacto.getTelefono());
        values.put(COLUMN_EMPRESA,contacto.getEmpresa());
    }
}
