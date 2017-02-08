package com.ken.ejercicio3pesosadolares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Variables globales que vamos a utilizar en varios metodos
     */
    private EditText inputPesos;
    private EditText inputDolares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Obtenemos la referencia de las vistas que creamos mediante
         * id's y tenemos que castearlas al tipo de vista que creamos
         */
        Button btnConvertir = (Button) findViewById(R.id.btn_convertir);
        Button btnConvertirPesos = (Button) findViewById(R.id.btn_convertir_a_pesos);
        inputPesos = (EditText) findViewById(R.id.input_pesos);
        inputDolares = (EditText) findViewById(R.id.tv_dolares);


        /**
         * Agregamos escuchadores del evento del click
         */
        btnConvertir.setOnClickListener(this);
        btnConvertirPesos.setOnClickListener(this);
    }


    /**
     * Metodo que se ejecuta cuando el usuario da click en alguna vista
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        /**
         *  Vemos que tipo de vista es a la que le dio click
         */
        switch (view.getId()) {
            //convertiremos dolares a pesos
            case R.id.btn_convertir:

                if (!inputPesos.getText().toString().isEmpty()) {
                    String pesos = inputPesos.getText().toString();
                    double pesosDouble = Double.parseDouble(pesos);
                    double dollar = pesosDouble * 20.67098;
                    inputDolares.setText("" + dollar);
                } else {
                    Toast.makeText(this, "Señor usuario no se puede realizar su acción", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_convertir_a_pesos:

                if (!inputDolares.getText().toString().isEmpty()) {
                    String pesos = inputDolares.getText().toString();

                    double pesosDouble = Double.parseDouble(pesos);
                    double dollar = pesosDouble / 20.67098;
                    inputPesos.setText("" + dollar);
                } else {
                    Toast.makeText(this, "Señor usuario no se puede realizar su acción", Toast.LENGTH_LONG).show();
                }
                break;
        }


    }


    public void log(String content) {
        Log.d("myLog", content);
    }
}
