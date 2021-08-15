package com.example.club;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.club.model.Persona;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CRUD extends AppCompatActivity {
    private List<Persona> listPerson = new ArrayList<Persona>();
    ArrayAdapter<Persona> arrayAdapterPersona;

    EditText nomP, appP, alturaP, edadP, actividadP;
    ListView listV_personas;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Persona personaSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_r_u_d);

        nomP = findViewById(R.id.txt_nombrePersona);
        appP = findViewById(R.id.txt_appPersona);
        alturaP = findViewById(R.id.txt_alturaPersona);
        edadP = findViewById(R.id.txt_edadPersona);
        actividadP = findViewById(R.id.txt_actividadPersona);

        listV_personas = findViewById(R.id.lv_datosPersonas);
        inicializarFirebase();
        listarDatos();

        listV_personas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personaSelected = (Persona) parent.getItemAtPosition(position);
                nomP.setText(personaSelected.getNombre());
                appP.setText(personaSelected.getApellido());
                alturaP.setText(personaSelected.getAltura());
                edadP.setText(personaSelected.getEdad());
                actividadP.setText(personaSelected.getActividad());
            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String nombre = nomP.getText().toString();
        String apellido = appP.getText().toString();
        String altura = alturaP.getText().toString();
        String edad = edadP.getText().toString();
        String actividad = actividadP.getText().toString();


        switch (item.getItemId()){
            case R.id.icon_add:{

                if (nombre.equals("")||apellido.equals("")||altura.equals("")||edad.equals("")||actividad.equals("")){
                    validacion();
                }
                else {
                    Persona p = new Persona();
                    p.setUid(UUID.randomUUID().toString());
                    p.setNombre(nombre);
                    p.setApellido(apellido);
                    p.setAltura(altura);
                    p.setEdad(edad);
                    p.setActividad(actividad);
                    //databaseReference.setValue("Niño");
                    databaseReference.child("Registro de Niños").child(p.getUid()).setValue(p);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
                    limpiarCajas();
                }
                break;
            }
            case R.id.icon_save:{
                Persona p = new Persona();
                p.setUid(personaSelected.getUid());
                p.setNombre(nomP.getText().toString().trim());
                p.setApellido(appP.getText().toString().trim());
                p.setAltura(alturaP.getText().toString().trim());
                p.setEdad(edadP.getText().toString().trim());
                p.setActividad(actividadP.getText().toString().trim());
                databaseReference.child("Registro de Niños").child(p.getUid()).setValue(p);
                Toast.makeText(this,"Actualizado", Toast.LENGTH_LONG).show();
                limpiarCajas();
                break;
            }
            case R.id.icon_delete:{
                Persona p = new Persona();
                p.setUid(personaSelected.getUid());
                databaseReference.child("Registro de Niños").child(p.getUid()).removeValue();
                Toast.makeText(this,"Eliminado", Toast.LENGTH_LONG).show();
                limpiarCajas();
                break;
            }
            default:break;
        }

        return true;
    }


    private void listarDatos() {
        databaseReference.child("Registro de Niños").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPerson.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Persona p = objSnaptshot.getValue(Persona.class);
                    listPerson.add(p);

                    arrayAdapterPersona = new ArrayAdapter<Persona>(CRUD.this, android.R.layout.simple_list_item_1, listPerson);
                    listV_personas.setAdapter(arrayAdapterPersona);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void limpiarCajas() {
        nomP.setText("");
        appP.setText("");
        alturaP.setText("");
        edadP.setText("");
        actividadP.setText("");
    }


    private void validacion() {
        String nombre = nomP.getText().toString();
        String apellido = appP.getText().toString();
        String altura = alturaP.getText().toString();
        String edad = edadP.getText().toString();
        String actividad = actividadP.getText().toString();
        if (nombre.equals("")){
            nomP.setError("Required");
        }
        else if (apellido.equals("")){
            appP.setError("Required");
        }
        else if (altura.equals("")){
            alturaP.setError("Required");
        }
        else if (edad.equals("")){
            edadP.setError("Required");
        }
        else if (actividad.equals("")){
            actividadP.setError("Required");
        }
    }



}