package com.example.entidadbancaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText entradaDNI, entradaPASS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        entradaDNI = findViewById(R.id.dni);
        entradaPASS = findViewById(R.id.password);

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = entradaDNI.getText().toString();
                String pass = entradaPASS.getText().toString();

                if (!dni.isEmpty() && !pass.isEmpty()) {
                    Intent intent = new Intent(Login.this, DatosBancarios.class);
                    intent.putExtra("dni", dni);
                    startActivity(intent);

                } else {
                    Toast.makeText(Login.this, "Denied Access", Toast.LENGTH_SHORT).show();
                }

            }
        });

        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });

    }
}
