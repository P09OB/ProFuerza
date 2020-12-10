package co.diana.proyectofinal.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import co.diana.proyectofinal.MainActivity;
import co.diana.proyectofinal.Pantalladiferentesdonaciones;
import co.diana.proyectofinal.R;
import co.diana.proyectofinal.pantallausuario;

public class donacionesRecogidas extends AppCompatActivity implements View.OnClickListener {

    private ImageView servicioButton, donacionButton, perfilButton, homeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donaciones_recogidas);

        servicioButton = findViewById(R.id.serviciobutton);
        donacionButton = findViewById(R.id.donacionbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);

        servicioButton.setOnClickListener(this);
        donacionButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
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

                Intent s = new Intent(this,Servicios.class);
                startActivity(s);
                finish();

                break;

            case R.id.donacionbutton:

                Intent d = new Intent(this, Pantalladiferentesdonaciones.class);
                startActivity(d);
                finish();
                break;


            case R.id.perfilbutton:

                Intent p = new Intent(this, pantallausuario.class);
                startActivity(p);
                finish();
                break;

        }

    }
}