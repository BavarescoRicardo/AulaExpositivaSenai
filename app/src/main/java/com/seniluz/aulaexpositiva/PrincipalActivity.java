package com.seniluz.aulaexpositiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void abrirTelaCalculadora(View v){
        Intent telaCalculadora = new Intent(this, Calculadora.class);
        startActivity(telaCalculadora);
    }

    public void abrirTelaSobre(View v){
        Intent telaCalculadora = new Intent(this, Sobre.class);
        startActivity(telaCalculadora);
    }

    public void abrirTelaAgenda(View v){
        Intent telaAgenda = new Intent(this, Agenda.class);
        startActivity(telaAgenda);
    }


}