package com.ken.toolbarexample;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mi app");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_accion1:
                Toast.makeText(MainActivity.this, "Pickeaste el menu 1", Toast.LENGTH_SHORT).show();

                break;

            case R.id.menu_accion2:

                //Obtenemos la vista root para configurar nuestro snackbar
                final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                        .findViewById(android.R.id.content)).getChildAt(0);

                //Mostramos nuestro snackbar
                Snackbar.make(viewGroup, "Pickeaste el menu 2", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.menu_accion3:
                //Obtenemos la vista root para configurar nuestro snackbar
                final ViewGroup rootView = (ViewGroup) ((ViewGroup) this
                        .findViewById(android.R.id.content)).getChildAt(0);

                //Mostramos nuestro snackbar
                Snackbar snackbar = Snackbar
                        .make(rootView, "Mensaje borrado", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(rootView, "Mensaje ha sido restaurado", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();

                break;

            case android.R.id.home:
                super.onBackPressed();
                break;

        }

        return true;
    }
}
