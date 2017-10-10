package com.ken.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CuartoFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";

    private String text;
    public String datoInicial;
    private OnFragment4InteractionListener mListener;
    private TextView tvText;



    public static CuartoFragment newInstance(String text) {
        //Creo una intancia de CuartoFragment
        CuartoFragment fragment = new CuartoFragment();
        //Creo el bundle que guardara los datos que guardare en mi fragmneto
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, text);
        //Asocio mi bundle a mi fragmento
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //obtengo los bundle de mi fragmento
            Bundle bundle = getArguments();
            //obtengo el texto que tenía guardado
            text = bundle.getString(ARG_PARAM1);
        }

    }

    public CuartoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Guardo en view el layout que estare utilizando en mi fragmento
        View view = inflater.inflate(R.layout.fragment_cuarto, container, false);
        //Obtengo una referencia de mi textview
        tvText = (TextView) view.findViewById(R.id.tv_fragment4);
        //le asigno el texto guardado al obtener el Bundle
        datoInicial = text + " wuju!!!";
        tvText.setText(datoInicial);

        //Referencio mi layout principal
        View rootLayout = view.findViewById(R.id.fragment4_root_layout);
        //Le agrego un escuchador de click al layout principal
        rootLayout.setOnClickListener(this);

        return view;
    }

    /**
     * Metrodo que se lanza cuando la actividad esta viunculada con el fragmento
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mListener = (OnFragment4InteractionListener) context;
        }

    }

    public String getDatoInicial() {
        return datoInicial;
    }

    public void setDatoInicial(String text) {
        tvText.setText(text);
    }

    @Override
    public void onClick(View view) {
        mListener.onFragment4Interaction("Holi!!");
    }


    public interface OnFragment4InteractionListener {

        public void onFragment4Interaction(String data);

    }

}
