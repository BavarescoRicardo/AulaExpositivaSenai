package com.seniluz.aulaexpositiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Projetos extends AppCompatActivity {

    private Button btnLista;
    private TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projetos);

        btnLista = findViewById(R.id.btnListarProj);
        txtResultado = findViewById(R.id.txtResultProj);

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask task = new MyTask();
                String urlApi = "https://api.github.com/users/Valhala23/repos";
                task.execute(urlApi);
            }
        });
    }

    class MyTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            StringBuffer buffer = null;

            try {
                URL url = new URL(stringUrl);
                HttpURLConnection conexao = (HttpURLConnection)url.openConnection();

                inputStream = conexao.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader reader = new BufferedReader(inputStreamReader);
                String linha = "";
                buffer = new StringBuffer();

                while ((linha = reader.readLine()) != null){
                    buffer.append(linha);

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            String repositorio = "";
            try {
                JSONObject jsonObject = null;
                JSONArray jsonArray = new JSONArray(s);

                for(int i = 0; i<jsonArray.length(); i++){
                    jsonObject = jsonArray.getJSONObject(i);

                    repositorio += jsonObject.getString("name") + "\r\n";
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            txtResultado.setText(repositorio);
        }
    }
}