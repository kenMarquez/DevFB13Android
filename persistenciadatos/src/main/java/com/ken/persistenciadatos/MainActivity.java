package com.ken.persistenciadatos;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

        saveUser();
        getUser();
//        saveSaludo();
//        printSaludo();
    }

    public void printSaludo() {
        SharedPreferences preferences = getSharedPreferences("Mis_preferencias", MODE_PRIVATE);
        String saludo = preferences.getString("saludo", "Saludo por primera vez");
        Log.d("log", saludo);
    }

    public void saveSaludo() {
        SharedPreferences preferences = getSharedPreferences("Mis_preferencias", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("saludo", "Hello World!!");
        editor.commit();
    }

    public void saveUser() {
        Realm realm = Realm.getDefaultInstance();

        int id = 2;

        Usuario user = new Usuario();
        user.setName("Carlos");
        user.setAge(28);
        user.setLastName("Gomez");
        user.setId(id);

        Cuenta cuenta = new Cuenta();
        cuenta.setCuenta("123123123");
        cuenta.setDeuda(0);
        cuenta.setSaldo(100000);
        cuenta.setUserKey(id);
        cuenta.setIdCuenta(2);

        user.setCuenta(cuenta);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

    }

    public void getUser() {
        Realm realm = Realm.getDefaultInstance();


        List<Usuario> usuarios = realm.where(Usuario.class).findAll();

        for (int i = 0; i < usuarios.size(); i++) {
            Log.d("log", usuarios.get(i).toString());
        }

    }


}
