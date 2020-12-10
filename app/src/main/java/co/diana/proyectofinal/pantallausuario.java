package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import co.diana.proyectofinal.pantallas.Servicios;
import co.diana.proyectofinal.pantallas.donacionesRecogidas;

public class pantallausuario extends AppCompatActivity implements View.OnClickListener{

    private TextView name;
    private String nombreEmployee,correo;
    private ImageView servicioButton, donacionButton, recogerButton, homeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallausuario);

        name = findViewById(R.id.nameUser);

        servicioButton = findViewById(R.id.serviciobutton);
        donacionButton = findViewById(R.id.donacionbutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        homeButton = findViewById(R.id.homeButton);

        servicioButton.setOnClickListener(this);
        donacionButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);


        SharedPreferences pre = getSharedPreferences("Casillero", Context.MODE_PRIVATE);
        nombreEmployee = pre.getString("nameUser", "NO_USER");
        correo = pre.getString("correo","NO_CORREO");

        name.setText(nombreEmployee);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.homeButton:

                Intent h = new Intent(this, MainActivity.class);
                startActivity(h);
                finish();

                break;

            case R.id.serviciobutton:

                Intent s = new Intent(this, Servicios.class);
                startActivity(s);
                finish();

                break;

            case R.id.donacionbutton:

                Intent d = new Intent(this, Pantalladiferentesdonaciones.class);
                startActivity(d);
                finish();
                break;

            case R.id.recolectarbutton:

                Intent r = new Intent(this, donacionesRecogidas.class);
                startActivity(r);
                finish();
                break;


        }
    }
}
