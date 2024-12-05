package com.acastillo.cryptoapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los botones Comprar y Vender
        Button btnComprar = findViewById(R.id.btnComprar);
        Button btnVender = findViewById(R.id.btnVender);

        // Cuando se hace clic en "Comprar"
        btnComprar.setOnClickListener(v -> mostrarFragment("Comprar"));

        // Cuando se hace clic en "Vender"
        btnVender.setOnClickListener(v -> mostrarFragment("Vender"));
    }

    // Método para mostrar el fragment
    private void mostrarFragment(String operacion) {
        // Crear el fragmento con el argumento correspondiente
        ComprarVenderFragment fragment = ComprarVenderFragment.newInstance(operacion);

        // Reemplazar el fragmento en el contenedor
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null); //
        transaction.commit();
    }
}
