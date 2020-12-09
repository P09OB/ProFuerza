package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Pantallarecogida extends AppCompatActivity {

    private Button donar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallarecogida);

        donar=findViewById(R.id.donar);

        donar.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this, Pantalladonacionrealizada.class);
                    startActivity(intent);

                }
        );
    }
}