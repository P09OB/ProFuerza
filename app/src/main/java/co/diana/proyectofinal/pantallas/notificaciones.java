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

public class notificaciones extends AppCompatActivity implements View.OnClickListener {

    private ImageView servicioButton, donacionButton, recogerButton, perfilButton, homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        servicioButton = findViewById(R.id.serviciobutton);
        donacionButton = findViewById(R.id.donacionbutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);

        servicioButton.setOnClickListener(this);
        donacionButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
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

            case R.id.recolectarbutton:

                Intent r = new Intent(this, donacionesRecogidas.class);
                startActivity(r);
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