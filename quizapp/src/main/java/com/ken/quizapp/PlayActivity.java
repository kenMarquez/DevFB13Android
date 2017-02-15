package com.ken.quizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ken.quizapp.fragments.QuestionFragment;
import com.ken.quizapp.models.Question;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Lista que contendra las preguntas del quiz
     */
    private List<Question> questions = new ArrayList<>();
    private QuestionFragment questionFragment;

    private int questionPosition;


    private int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play);

        /**
         * Inicializa las vistas
         */
        initViews();

        /**
         * Incializamos las preguntas
         */
        initQuestions();

        //Creamos el fragment con el que iniciará mi Activity y le asignamos la pregunta inicial.
        questionFragment = new QuestionFragment(questions.get(questionPosition).getTitle());

        //Ponemos nuestro fragmento en el FrameLayout
        changeFragment(questionFragment);

    }

    /**
     * Inicializamos la lista de preguntas con sus respuestas correctas
     */
    private void initQuestions() {

        questions.add(new Question("¿En Java un arreglo tiene un tamaño definido?", 1));
        questions.add(new Question("¿Un árbol binario puede tener mas de dos hijos?", 0));
        questions.add(new Question("¿Git es un sistema de control de versiones?", 1));
        questions.add(new Question("¿Java no es un lenguaje tipado?", 0));
        questions.add(new Question("¿RelativeLayout organiza sus elementos uno después de otro?", 0));

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

        //Obtenemos la respuesta del puntaje
        int respuesta = questionFragment.respuesta;

        //Válidamos que halla escogido alguna respuesta
        if (respuesta != -1) {

            //Verificamos que la posición
            if (respuesta == questions.get(questionPosition).getAnswer()) {
                correctAnswer++;
            }
        }


        /**
         * Verificamos si vamos en la última posición de nuestra
         * lista de preguntas , si es el caso mostramos el puntaje
         * de otro modo avanzamos a la siguiente pregunta
         */
        if (questionPosition == questions.size() - 1) {


            //Mostramos el puntaje
            Toast.makeText(this, "Tu puntaje es : " + correctAnswer + " de " + questions.size(), Toast.LENGTH_SHORT).show();
        } else {

            questionPosition++;

            //Creamos el fragment con el que iniciará mi Activity y le asignamos la pregunta inicial.
            questionFragment = new QuestionFragment(questions.get(questionPosition).getTitle());
            changeFragment(questionFragment);
        }
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
