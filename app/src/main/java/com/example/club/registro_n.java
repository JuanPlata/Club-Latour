package com.example.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class registro_n extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_regninos);
    }

    public void siguientevista (View view){
        Intent siguinetevista = new Intent(this, CRUD.class);
        startActivity(siguinetevista);
    }
}
