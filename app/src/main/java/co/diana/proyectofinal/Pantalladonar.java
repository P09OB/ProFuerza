package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pantalladonar extends AppCompatActivity {


    private EditText editTextmonto;
    private Button Donar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladonar);

        Donar=findViewById(R.id.Donar);
        editTextmonto=findViewById(R.id.editTextmonto);


        Donar.setOnClickListener(
                (v)->{
                    if (editTextmonto.getText().toString().isEmpty()){
                        Toast.makeText(this, "Escriba el monto de su donacion", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(this, Pantalladinero.class);
                        intent.putExtra("monto", Integer.parseInt(editTextmonto.getText().toString()));
                        startActivity(intent);
                    }

                }
        );


    }
}