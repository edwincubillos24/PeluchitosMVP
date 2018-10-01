package com.edwinacubillos.peluchitosmvp.agregar;

public interface IAgregarContract {

    interface view {

        void mostrarError(String error);

        void mostrarMensajeExitoso(String msj);

        void cleanWidgets();
    }

    interface presenter {

        void enviarDatos(String s, String s1, String s2);

        void mostrarError(String s);

        void mostrarMensajeExitoso(String msj);
    }

    interface interactor {

        void enviarDatos(String nombre, String cantidad, String precio);

        void mostrarMensajeExitoso();
    }
}
