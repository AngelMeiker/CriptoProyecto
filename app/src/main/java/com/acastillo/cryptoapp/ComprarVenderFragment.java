package com.acastillo.cryptoapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;  // Necesario para usar ContextCompat

public class ComprarVenderFragment extends Fragment {

    // Constante para pasar el argumento (operación: "Comprar" o "Vender")
    public static final String ARG_OPERACION = "operacion";

    // Método estático para crear una nueva instancia del fragmento con el parámetro
    public static ComprarVenderFragment newInstance(String operacion) {
        ComprarVenderFragment fragment = new ComprarVenderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_OPERACION, operacion); // Pasa el argumento (Comprar/Vender)
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Infla el layout del fragmento
        View rootView = inflater.inflate(R.layout.activity_comprar_vender_fragment, container, false);

        // Obtiene el argumento (Comprar o Vender) pasado al fragmento
        String operacion = getArguments().getString(ARG_OPERACION);

        // Configura el texto del botón según la operación
        Button actionButton = rootView.findViewById(R.id.actionButton);
        actionButton.setText(operacion); // "Comprar" o "Vender"
        actionButton.setOnClickListener(v -> {
            // Mostrar el diálogo de éxito
            showSuccessDialog(operacion);
        });

        return rootView;
    }

    private void showSuccessDialog(String operacion) {
        // Crear el AlertDialog Builder (sin personalización de fondo)
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Configura el mensaje y el título del diálogo
        builder.setTitle("Operación Exitosa")
                .setMessage(operacion + " realizado con éxito.")
                .setCancelable(false) // No permitir cerrar el diálogo tocando fuera de él
                .setPositiveButton("Cerrar", (dialog, which) -> {
                    // Cierra el diálogo cuando se presiona el botón "Cerrar"
                    dialog.dismiss();
                });

        // Mostrar el diálogo
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
