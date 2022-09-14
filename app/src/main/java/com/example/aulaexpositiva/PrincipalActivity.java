package com.example.aulaexpositiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void abrirTelaCalculadora(View v){
        Intent telaCalculadora = new Intent(this, MainActivity.class);
        startActivity(telaCalculadora);
    }

    public void abrirTelaSobre(View v){
        Intent telaCalculadora = new Intent(this, Sobre.class);
        startActivity(telaCalculadora);
    }



}