package com.ken.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private TextView tv;
    private EditText inputText;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciamos el textview de nuestra vista
        tv = (TextView) findViewById(R.id.tv_change_activity);

        inputText = (EditText) findViewById(R.id.input_text);

        layout = (LinearLayout) findViewById(R.id.layout_intent_implicito);


    }

    @Override
    protected void onStart() {
        super.onResume();

        //agregamos un escuchador para cuando el usuario deje precionado el boton
        //por un periodo largo.
        tv.setOnLongClickListener(this);

        //le agregamos el listener implementando la clase anonima
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escogerApp();
            }
        });
    }

    public void abrirStreetView() {
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=19.417681,-99.162301");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void hacerLlamada() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "5516851444"));
        startActivity(intent);
    }

    public void openLink() {
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


    public void escogerApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        intent.setType("text/plain");
        Intent chooser = Intent.createChooser(intent, "Escoge la aplicación que complemente " +
                "tu acción");


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }

    }


    @Override
    public boolean onLongClick(View view) {
        String text = inputText.getText().toString();

        //Configuramos nuestro intent para indicarle que actividad va a ejecutar
        Intent intent = new Intent(this, SegundaActivity.class);

        //agregamos parametros a nuestro intent para ser compartidos
        //con la otra actividad
        intent.putExtra(Constants.CLAVE_INTENT, text);
        intent.putExtra("saludo", "Hola como estas?");


        //ejecutamos el intent para que incie con la segunda actividad
        startActivity(intent);
        return false;
    }
}
