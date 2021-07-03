package com.example.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void Logear (View view){
        Intent Logear = new Intent(this, vista2.class);
        startActivity(Logear);
    }

    public void Registrar (View view){
        Intent Registrar = new Intent(this, registro.class);
        startActivity(Registrar);
    }

}
