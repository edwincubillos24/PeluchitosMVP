package com.edwinacubillos.peluchitosmvp.agregar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edwinacubillos.peluchitosmvp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment implements IAgregarContract.view {

    private EditText eNombre, eCantidad, ePrecio;
    private Button bGuardar;
    private IAgregarContract.presenter agregarPresenter;

    public AgregarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar, container, false);

        agregarPresenter = new AgregarPresenter(this);

        eNombre = view.findViewById(R.id.eNombre);
        eCantidad = view.findViewById(R.id.eCantidad);
        ePrecio = view.findViewById(R.id.ePrecio);
        bGuardar = view.findViewById(R.id.bGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarPresenter.enviarDatos(eNombre.getText().toString(),
                        eCantidad.getText().toString(),
                        ePrecio.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarMensajeExitoso(String msj) {
        Toast.makeText(getContext(), msj, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cleanWidgets() {
        eNombre.setText("");
        eCantidad.setText("");
        ePrecio.setText("");
    }
}
