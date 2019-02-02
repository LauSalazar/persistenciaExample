package com.example.u93.persistenciaExample.models;

public class Contacto {

    private int id;
    private String nombre;
    private String telefono;
    private String empresa;

    public Contacto() {
    }

    public Contacto(int id, String nombre, String telefono, String empresa) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
