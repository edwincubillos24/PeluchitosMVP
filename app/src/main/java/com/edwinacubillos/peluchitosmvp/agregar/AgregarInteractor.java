package com.edwinacubillos.peluchitosmvp.agregar;

public class AgregarInteractor implements IAgregarContract.interactor{

    private IAgregarContract.presenter agregarPresenter;
    private IAgregarRepository  agregarRepository;

    public AgregarInteractor(IAgregarContract.presenter agregarPresenter) {
        this.agregarPresenter = agregarPresenter;
        agregarRepository = new AgregarRepository(this);
    }

    @Override
    public void enviarDatos(String nombre, String cantidad, String precio) {
        if (nombre.equals("") || cantidad.equals("") || precio.equals(""))
            agregarPresenter.mostrarError("ERROR, debe digitar todos los campos");
        else{
            agregarRepository.guardarDatos(nombre, cantidad, precio);

        }

    }

    @Override
    public void mostrarMensajeExitoso() {
        agregarPresenter.mostrarMensajeExitoso("Peluche guardado exitosamente");
    }
}
