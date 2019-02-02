package com.example.u93.mvp.schemes;

public interface IContactosScheme {

    String CONTACTOS_TABLE = "contactos";
    String COLUMN_ID = "id";
    String COLUMN_NOMBRE = "nombre";
    String COLUMN_TELEFONO = "telefono";
    String COLUMN_EMPRESA = "empresa";

    String CONTACTOS_TABLE_CREATE = "CREATE TABLE IF NOT EXIST "
            + CONTACTOS_TABLE +" ( "
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  "
            + COLUMN_NOMBRE + " TEXT NOT NULL, "
            + COLUMN_TELEFONO + " TEXT, "
            + COLUMN_EMPRESA + " TEXT "
            + " );";

    String [] CONTACTOS_COLUMNS = new String[]{
            COLUMN_ID, COLUMN_NOMBRE, COLUMN_TELEFONO, COLUMN_EMPRESA
    };

}
