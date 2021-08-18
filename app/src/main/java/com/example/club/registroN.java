package com.example.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class registroN extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_regninos);
    }

    public void reg (View view){
        Intent reg = new Intent(this, CRUD.class);
        startActivity(reg);
    }
}
