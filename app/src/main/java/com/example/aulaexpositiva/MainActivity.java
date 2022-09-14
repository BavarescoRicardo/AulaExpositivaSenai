package com.example.aulaexpositiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity<EditView> extends AppCompatActivity {

    private char simbolo = '+';
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        TextView txtResult = (TextView) findViewById(R.id.txtResult);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                TextView txtNum1 = (TextView) findViewById(R.id.txtNum1);
                TextView txtNum2 = (TextView) findViewById(R.id.txtNum2);
                double result = Double.parseDouble(txtNum1.getText().toString());
                switch (simbolo) {
                    case '+':
                        result += Double.parseDouble(txtNum2.getText().toString());
                        break;

                    case '-':
                        result -= Double.parseDouble(txtNum2.getText().toString());
                        break;

                    case '/':
                        result /= Double.parseDouble(txtNum2.getText().toString());
                        break;

                    case '*':
                        result *= Double.parseDouble(txtNum2.getText().toString());
                        break;

                    default:
                        break;
                }


                txtResult.setText(String.valueOf(result));
            }
        });
    }

    public void operadorDiminui(View v){
        TextView txtOperador = (TextView) findViewById(R.id.txtOpe);
        txtOperador.setText(" - ");
        simbolo = '-';
    }

    public void operadorSoma(View v){
        TextView txtOperador = (TextView) findViewById(R.id.txtOpe);
        txtOperador.setText(" + ");
        simbolo = '+';
    }

    public void operadorMultiplica(View v){
        TextView txtOperador = (TextView) findViewById(R.id.txtOpe);
        txtOperador.setText(" * ");
        simbolo = '*';
    }

    public void operadorDivide(View v){
        TextView txtOperador = (TextView) findViewById(R.id.txtOpe);
        txtOperador.setText(" / ");
        simbolo = '/';
    }
}