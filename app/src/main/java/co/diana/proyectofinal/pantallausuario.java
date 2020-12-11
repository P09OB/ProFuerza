package co.diana.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.diana.proyectofinal.Adapter.AdapterAceptados;
import co.diana.proyectofinal.Adapter.AdapterSolicitud;
import co.diana.proyectofinal.Clases.Solicitud;
import co.diana.proyectofinal.Clases.User;
import co.diana.proyectofinal.pantallas.Servicios;
import co.diana.proyectofinal.pantallas.donacionesRecogidas;

public class pantallausuario extends AppCompatActivity implements View.OnClickListener{

    private TextView textViewNombre;
    private TextView textViewCorreo;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private User usuarioactivo;
    private ListView listRegistro;
    private AdapterSolicitud adapterAceptados;
    private String idUser;
    private ImageView servicioButton, donacionButton, recogerButton, homeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallausuario);


        servicioButton = findViewById(R.id.serviciobutton);
        donacionButton = findViewById(R.id.donacionbutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        homeButton = findViewById(R.id.homeButton);
        listRegistro = findViewById(R.id.listRegistro);

        servicioButton.setOnClickListener(this);
        donacionButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);


        textViewNombre=findViewById(R.id.textViewNombre);
        textViewCorreo=findViewById(R.id.textViewCorreo);

        SharedPreferences pre = getSharedPreferences("Casillero", Context.MODE_PRIVATE);
        idUser = pre.getString("idUser","NO_ID_USER");

        database = FirebaseDatabase.getInstance();

        adapterAceptados = new AdapterSolicitud();
        listRegistro.setAdapter(adapterAceptados);
        loadData();


        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        database.getReference().child("users").child(auth.getCurrentUser().getUid()).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        usuarioactivo=dataSnapshot.getValue(User.class);
                        textViewNombre.setText(usuarioactivo.getNombre());
                        textViewCorreo.setText(usuarioactivo.getCorreo());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );

    }

    private void loadData() {

        database.getReference().child("solicitudes").child(idUser).child("registro").addListenerForSingleValueEvent(

                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot data) {

                        adapterAceptados.clear();
                        for(DataSnapshot child : data.getChildren()){
                            Solicitud sol = child.getValue(Solicitud.class);
                            adapterAceptados.addEmployee(sol);
                        }
                    }

                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                }
        );
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
