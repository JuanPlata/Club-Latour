package com.example.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class dashboards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_dash);
    }

    public void registroNinos (View view){
        Intent registroNinos = new Intent(this, registroN.class);
        startActivity(registroNinos);
    }

}