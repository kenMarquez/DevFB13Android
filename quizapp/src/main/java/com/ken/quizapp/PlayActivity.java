package com.ken.quizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ken.quizapp.fragments.QuestionFragment;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        /**
         * Inicializa las vistas
         */
        initViews();

        //Creamos el fragment con el que iniciará mi Activity
        QuestionFragment questionFragment = new QuestionFragment();

        //Ponemos nuestro fragmento en el FrameLayout
        changeFragment(questionFragment);
    }

    /**
     * Metodo útilizado para configurar todas  las vistas de mi layout
     */
    private void initViews() {

        View view = findViewById(R.id.quiz_img_arrow_right);
        view.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

    }

    public void changeFragment(Fragment fragment) {
        /**
         *Obtengo el FragmentManaget que me ayuda con las transacciones
         *que necesite hacer con mis fragmentos
         */
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

}
