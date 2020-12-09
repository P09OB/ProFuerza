package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

public class Pantallaprincipaldonacion extends AppCompatActivity {

    private ConstraintLayout Donaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaprincipaldonacion);

        Donaciones=findViewById(R.id.Donaciones);

        Donaciones.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this,Pantalladiferentesdonaciones.class);
                    startActivity(intent);

                }
        );
    }
}