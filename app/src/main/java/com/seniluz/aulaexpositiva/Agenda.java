package com.seniluz.aulaexpositiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.*;

public class Agenda extends AppCompatActivity {
    SQLiteDatabase db = null;

    public void abrirBanco(){
        try {
            db = openOrCreateDatabase("bdAgenda", MODE_PRIVATE, null);
        }catch (Exception ex){
            Toast.makeText(this, "Erro ao criar ou abrir o banco de dados", Toast.LENGTH_LONG).show();
        }finally {
            Toast.makeText(this, "Banco ok", Toast.LENGTH_SHORT).show();
        }
    }

    public void abrirTabela(){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS agendaEvento(idagenda INTEGER PRIMARY KEY, titulo TEXT, descricao TEXT, dataevento TEXT);");
        }catch (Exception e){
            Toast.makeText(this, "Erro ao criar tabela de dados", Toast.LENGTH_LONG).show();
        }finally {
            Toast.makeText(this, "Tabela okei", Toast.LENGTH_SHORT).show();
        }
    }

    TextView txtTitulo, txtDescricao;
    TextView dataEvento;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        txtTitulo = (TextView) findViewById(R.id.txtTituloAgenda);
        txtDescricao = (TextView) findViewById(R.id.txtDescricaoAgenda);
        dataEvento = (TextView) findViewById(R.id.txtDataAgenda);

        abrirBanco();
        abrirTabela();
        fecharBanco();
    }

    public void btnVoltar(View v){
        this.finish();
    }

    public void fecharBanco(){
        db.close();
    }

    public void gravarDados(View v){
        String dadosAgendaTitulo,dadosAgendaDescricao,dadosAgendaData;
        try {
            // Recuperar dados da tela
            dadosAgendaTitulo = txtTitulo.getText().toString();
            dadosAgendaDescricao = txtDescricao.getText().toString();
            dadosAgendaData = dataEvento.getText().toString();
            abrirBanco();
            Toast.makeText(this, "dados: "+dadosAgendaTitulo + dadosAgendaDescricao + dadosAgendaData, Toast.LENGTH_LONG).show();

            db.execSQL("INSERT INTO agendaEvento (titulo,descricao, dataevento) VALUES('"+dadosAgendaTitulo+"', '"+dadosAgendaDescricao+"', '"+dadosAgendaData+"')");

        }catch (Exception ex){
            Toast.makeText(this, "Erro ao inserir.  "+ex.getMessage(), Toast.LENGTH_LONG).show();
        }finally {
            Toast.makeText(this, "Inserção okei", Toast.LENGTH_LONG).show();
        }

        fecharBanco();
    }

    public void abrirTelaConsultaAgenda(View v){
        Intent telaConsultaAgenda = new Intent(this, ConsultaAgenda.class);
        startActivity(telaConsultaAgenda);
    }
}