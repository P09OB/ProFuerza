package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pantalladinero extends AppCompatActivity {

    private Button Donar;
    private EditText editTextNombre;
    private EditText editTextNumero;
    private EditText editTextfecha1;
    private EditText editTextfecha2;
    private EditText editTextcvc;
    private TextView Dineromonto;
    private Bundle bundle=getIntent().getExtras();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladinero);

        int monto=bundle.getInt("monto",0);
        Donar=findViewById(R.id.Donar);
        editTextNombre=findViewById(R.id.editTextNombre);
        editTextNumero=findViewById(R.id.editTextNumero);
        editTextfecha1=findViewById(R.id.editTextfecha1);
        editTextfecha2=findViewById(R.id.editTextfecha2);
        editTextcvc=findViewById(R.id.editTextcvc);
        Dineromonto=findViewById(R.id.Dineromonto);

        Dineromonto.setText(monto);

        Donar.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this,Pantalladonacionrealizada.class);
                    startActivity(intent);

                }
        );
    }
}