package com.seniluz.aulaexpositiva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.*;

public class ConsultaAgenda extends AppCompatActivity {
    SQLiteDatabase db = null;
    Cursor cursor = null;

    TextView txtTitulo, txtDescricao;
    TextView dataEvento;

    public void abrirBanco(){
        try {
            db = openOrCreateDatabase("bdAgenda", MODE_PRIVATE, null);
        }catch (Exception ex){
            Toast.makeText(this, "Erro ao criar ou abrir o banco de dados", Toast.LENGTH_LONG).show();
        }finally {
            Toast.makeText(this, "Banco ok", Toast.LENGTH_SHORT).show();
        }
    }

    public void fecharBanco(){
        db.close();
    }

    @SuppressLint("Range")
    public void listarDados(){
        Toast.makeText(this, "Inicio consulta", Toast.LENGTH_SHORT).show();
        try {
            abrirBanco();
            cursor = db.query("agendaEvento", new String[]{"titulo", "descricao", "dataevento"},
                    null, null, null, null, null, null);
        }catch (Exception e){
            Toast.makeText(this, "Erro ao ler os dados", Toast.LENGTH_LONG).show();
        }finally {
            cursor.moveToFirst();
            mostrarDados();
        }
        fecharBanco();
    }

    @SuppressLint("Range")
    public void mostrarDados(){
        if (cursor.getCount() > 0) {
            try {
                txtTitulo.setText(cursor.getString(cursor.getColumnIndex("titulo")));
                txtDescricao.setText(cursor.getString(cursor.getColumnIndex("descricao")));
                dataEvento.setText(cursor.getString(cursor.getColumnIndex("dataevento")));

            }catch (Exception ex){
                Toast.makeText(this, "Erro ao listar dados", Toast.LENGTH_LONG).show();
            }finally {
                Toast.makeText(this, "Sucesso na consulta", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_agenda);

        txtTitulo = (TextView) findViewById(R.id.txtTituloConsultaAgenda);
        txtDescricao = (TextView) findViewById(R.id.txtDescricaoConsultaAgenda);
        dataEvento = (TextView) findViewById(R.id.txtDataConsultaAgenda);
        listarDados();
    }

    public void btnProx(View v){
        cursor.moveToNext();
        mostrarDados();
    }

    public void btnAnt(View v){
        cursor.moveToPrevious();
        mostrarDados();
    }

    public void btnVoltar(View v){
        this.finish();
    }
}