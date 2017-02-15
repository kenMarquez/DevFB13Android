package com.ken.quizapp.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ken.quizapp.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {


    private final String title;
    private TextView tvFalse;
    private TextView tvTrue;
    public int respuesta = -1;

    public QuestionFragment() {
        title = "";
    }

    @SuppressLint("ValidFragment")
    public QuestionFragment(String title) {
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * Inflamos el layout que vamos a utilizar y lo asignamos a la variable view
         */
        View view = inflater.inflate(R.layout.fragment_question, container, false);


        /**
         * Referenciamos el titulo de la pregunta
         */
        TextView tvTitle = (TextView) view.findViewById(R.id.question_tv_title);

        tvTitle.setText(title);

        /**
         * Referenciamos las vistas de false y true
         */
        tvFalse = (TextView) view.findViewById(R.id.question_tv_false);
        tvTrue = (TextView) view.findViewById(R.id.question_tv_true);

        /**
         * Asignamos escuchadores a los botones de false y true
         */
        tvFalse.setOnClickListener(this);
        tvTrue.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        /**
         * Swich de las vistas que asignamos el escuchador
         */
        switch (view.getId()) {

            case R.id.question_tv_false:
                respuesta = 0;
                tvTrue.setBackgroundResource(R.color.btn_unselected);
                tvFalse.setBackgroundResource(R.color.btn_selected);
                break;
            case R.id.question_tv_true:
                respuesta = 1;
                tvTrue.setBackgroundResource(R.color.btn_selected);
                tvFalse.setBackgroundResource(R.color.btn_unselected);
                break;
        }
    }
}
