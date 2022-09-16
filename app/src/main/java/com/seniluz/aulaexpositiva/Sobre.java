package com.seniluz.aulaexpositiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
    }

    public void abrirTelaPrincipal(View v){
        Intent telaCalculadora = new Intent(this, PrincipalActivity.class);
        startActivity(telaCalculadora);
    }

    public void abrirTelaProjetos(View v){
        Intent telaProjetos = new Intent(this, Projetos.class);
        startActivity(telaProjetos);
    }

}