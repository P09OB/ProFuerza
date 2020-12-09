package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Pantallaropa extends AppCompatActivity {

    private Button Donar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaropa);

        Donar=findViewById(R.id.Donar);

       Donar.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this, Pantallarecogida.class);
                    startActivity(intent);

                }
        );
    }
}