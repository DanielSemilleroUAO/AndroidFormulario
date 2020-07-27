package com.example.semanados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> datos;

    DatePicker fecha_nacimiento;
    TextInputEditText nombre;
    TextInputEditText telefono;
    TextInputEditText correo;
    TextInputEditText descripcion;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha_nacimiento = (DatePicker) findViewById(R.id.fecha);
        nombre = (TextInputEditText) findViewById(R.id.nombre_ingresado);
        telefono = (TextInputEditText) findViewById(R.id.telefono_ingresado);
        correo = (TextInputEditText) findViewById(R.id.email_ingresado);
        descripcion = (TextInputEditText) findViewById(R.id.descripcion_ingresado);
        siguiente = (Button) findViewById(R.id.siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos = new ArrayList<>();

                datos.add(nombre.getText().toString());
                datos.add(String.valueOf(fecha_nacimiento.getMonth())+"/"+String.valueOf(fecha_nacimiento.getDayOfMonth())+"/"+String.valueOf(fecha_nacimiento.getYear()));
                datos.add(telefono.getText().toString());
                datos.add(correo.getText().toString());
                datos.add(descripcion.getText().toString());

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putStringArrayListExtra("datos",datos);

                startActivity(i);
                finish();
            }
        });

    }
}
