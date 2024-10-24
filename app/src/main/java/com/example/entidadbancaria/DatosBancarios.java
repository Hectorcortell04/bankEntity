package com.example.entidadbancaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DatosBancarios extends AppCompatActivity {
    private int dinero = 1000;
    private TextView saldo;
    private EditText importe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.datos_bancarios);

        importe = findViewById(R.id.importe);
        saldo = findViewById(R.id.saldo);

        String dni = getIntent().getStringExtra("dni");
        TextView bienvenida = findViewById(R.id.bienvenido);
        bienvenida.setText("Bienvenido " + dni);

        findViewById(R.id.ingresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = Integer.parseInt(importe.getText().toString());
                dinero += cantidad;
                actualizarDinero();
            }


        });
        findViewById(R.id.extraer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = Integer.parseInt(importe.getText().toString());
                if (dinero >= cantidad) {
                    dinero -= cantidad;
                    actualizarDinero();
                } else {
                    Toast.makeText(DatosBancarios.this, "No hay suficiente saldo", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.salir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DatosBancarios.this, MainActivity.class));
            }

        });
    }

    private void actualizarDinero() {
        saldo.setText("Balance " + dinero + "€");
    }

}