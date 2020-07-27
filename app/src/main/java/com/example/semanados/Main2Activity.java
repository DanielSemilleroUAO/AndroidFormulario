package com.example.semanados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> datos_editar;

    Button volver;
    TextView nombre;
    TextView fecha;
    TextView telefono;
    TextView correo;
    TextView descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle parametros = getIntent().getExtras();
        ArrayList<String> datos = parametros.getStringArrayList("datos");

        nombre = (TextView) findViewById(R.id.nombre);
        fecha = (TextView) findViewById(R.id.fecha);
        telefono = (TextView) findViewById(R.id.telefono);
        correo = (TextView) findViewById(R.id.email);
        descripcion = (TextView) findViewById(R.id.descripcion);
        volver = (Button) findViewById(R.id.buton);

        nombre.setText(datos.get(0));
        fecha.setText("Fecha de Nacimiento: "+datos.get(1));
        telefono.setText("Tel: "+datos.get(2));
        correo.setText("Email: "+datos.get(3));
        descripcion.setText(datos.get(4));

        datos_editar = new ArrayList<>();

        datos_editar.add(datos.get(0));
        datos_editar.add(datos.get(1));
        datos_editar.add(datos.get(2));
        datos_editar.add(datos.get(3));
        datos_editar.add(datos.get(4));

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                i.putStringArrayListExtra("datos_r",datos_editar);
                startActivity(i);
                finish();
            }
        });

    }
}
