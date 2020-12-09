package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class Pantallarecogida extends AppCompatActivity {

    private Button donar;
    private EditText editTextDireccion;
    private EditText editTexthora;
    private EditText editTexthoramin;
    private EditText editTextMes;
    private EditText editTextDia;
    Intent intent;
    ArrayList<String>Seleccionados;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallarecogida);
        Seleccionados=new ArrayList<>();
        intent=getIntent();
        donar=findViewById(R.id.donar);
        editTextDireccion=findViewById(R.id.editTextDireccion);
        editTexthora=findViewById(R.id.editTexthora);
        editTexthoramin=findViewById(R.id.editTexthoramin);
        editTextMes=findViewById(R.id.editTextMes);
        editTextDia=findViewById(R.id.editTextDia);
        //Seleccionados=intent.getStringArrayListExtra("Seleccionado");
        Log.e("TAG", String.valueOf(intent.getStringArrayListExtra("Seleccionado")));
        database= FirebaseDatabase.getInstance();



        donar.setOnClickListener(
                (v)->{
                    if (editTextDia.getText().toString().isEmpty()||editTextDireccion.getText().toString().isEmpty()||editTexthoramin.getText().toString().isEmpty()||editTexthora.getText().toString().isEmpty()||editTextMes.getText().toString().isEmpty()){
                        Toast.makeText(this, "Por favor rellenar todos los campos", Toast.LENGTH_SHORT).show();
                    }else{
                        String horaentrega=editTexthora.getText().toString()+":"+editTexthoramin.getText().toString();
                        String fechadeentrega=editTextMes.getText().toString()+"/"+editTextDia.getText().toString();
                        String direccion=editTextDireccion.getText().toString();
                        String id= UUID.randomUUID().toString();
                        Ropa ropa= new Ropa("gg","Diana",id,"ropa",direccion,"en proceso",horaentrega,fechadeentrega);
                        database.getReference().child("donaciones").child("ropa").child(id).setValue(ropa);
                        for(int i=0;i<Seleccionados.size();i++){
                            database.getReference().child("donaciones").child("ropa").child(id).child(UUID.randomUUID().toString()).setValue(Seleccionados.get(i));
                        }

                        Intent intent= new Intent(this, Pantalladonacionrealizada.class);
                        startActivity(intent);
                    }

                }
        );
    }
}