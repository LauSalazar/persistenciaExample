package com.example.u93.persistenciaExample.dao;

import com.example.u93.persistenciaExample.models.Contacto;

import java.util.ArrayList;

public interface IContactosDAO {

    public ArrayList<Contacto> fetchAllContacts();
    public Boolean createContacto(Contacto contacto);
}
