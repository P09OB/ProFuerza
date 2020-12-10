package co.diana.proyectofinal.pantallas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.diana.proyectofinal.R;

public class Servicios extends AppCompatActivity implements View.OnClickListener{

    private ConstraintLayout reparacion, limpieza, varios, exterior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        reparacion = findViewById(R.id.reparacion);
        limpieza = findViewById(R.id.limpieza);
        varios = findViewById(R.id.varios);
        exterior = findViewById(R.id.exterior);

        reparacion.setOnClickListener(this);
        limpieza.setOnClickListener(this);
        varios.setOnClickListener(this);
        exterior.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this,List.class);


        switch (view.getId()){

            case R.id.reparacion:

                i.putExtra("service","reparacion");



                break;

            case R.id.varios:

                i.putExtra("service","varios");


                break;

            case  R.id.limpieza:

                i.putExtra("service","limpieza");


                break;

            case R.id.exterior:

                i.putExtra("service","exteriores");


                break;
        }

        startActivity(i);

    }
}