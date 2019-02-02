package com.example.u93.persistenciaExample.presenters;

import com.example.u93.persistenciaExample.helper.Database;
import com.example.u93.persistenciaExample.models.Contacto;
import com.example.u93.persistenciaExample.views.interfaces.IMainView;

public class MainPresenter extends BasePresenter<IMainView> {
    public int calcularSuma(int i, int i1) {
        return i+i1;
    }

    public void calculate(int i, int i1) {
        getView().showResult(i+i1);

    }

    public void calcular(int i, int i1) {
        getView().showResultBase(i+i1);

    }

    private void createContactos(){
        Contacto contacto = new Contacto(0,"Laura","4556677","Matrix");
        Contacto contacto2 = new Contacto(0,"Karen","4556677","Matrix");
        createThreadContact(contacto);
        createThreadContact(contacto2);
    }

    private void createThreadContact(final Contacto contacto) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                createContactLocalDataBase(contacto);
            }
        });
        thread.start();

    }

    private void createContactLocalDataBase(Contacto contacto) {
        try{
            boolean isSaved = Database.contactosDAO.createContacto(contacto);
            String msg = isSaved ? "Contacto creado" : "Contacto no creado";
            getView().showToast(msg);
        } catch (Exception e){
            getView().showToast("Contacto no creado");
        }
    }
}
