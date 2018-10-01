package com.edwinacubillos.peluchitosmvp.agregar;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.edwinacubillos.peluchitosmvp.PeluchitosMVP;
import com.edwinacubillos.peluchitosmvp.Persistency.PeluchesSQLiteHelper;

public class AgregarRepository implements IAgregarRepository{

    private IAgregarContract.interactor agregarInteractor;
    private PeluchesSQLiteHelper peluchesSQLiteHelper;
    private SQLiteDatabase dbContactos;
    private ContentValues dataBD;


    public AgregarRepository(IAgregarContract.interactor agregarInteractor) {
        this.agregarInteractor = agregarInteractor;
    }

    @Override
    public void guardarDatos(String nombre, String cantidad, String precio) {
        long band;
        peluchesSQLiteHelper = new PeluchesSQLiteHelper(
                PeluchitosMVP.getmContext(),
                "peluchesBD",
                null,
                1);

        dbContactos = peluchesSQLiteHelper.getWritableDatabase();

        dataBD = new ContentValues();
        dataBD.put("nombre",nombre);
        dataBD.put("cantidad", cantidad);
        dataBD.put("precio",precio);

        band = dbContactos.insert("peluches",null,dataBD);

        dbContactos.close();

        if (band == 0) //guardo exitosamente
            agregarInteractor.mostrarMensajeExitoso();




    }
}
