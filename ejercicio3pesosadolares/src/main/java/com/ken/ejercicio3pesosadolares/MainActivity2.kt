//package com.ken.ejercicio3pesosadolares
//
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//
//class MainActivity2 : AppCompatActivity(), View.OnClickListener {
//
//    /**
//     * Variables globales que vamos a utilizar en varios metodos
//     */
//    private var inputPesos: EditText? = null
//    private var inputDolares: EditText? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        /**
//         * Obtenemos la referencia de las vistas que creamos mediante
//         * id's y tenemos que castearlas al tipo de vista que creamos
//         */
//        val btnConvertir = findViewById(R.id.btn_convertir) as Button
//        val btnConvertirPesos = findViewById(R.id.btn_convertir_a_pesos) as Button
//        inputPesos = findViewById(R.id.input_pesos) as EditText
//        inputDolares = findViewById(R.id.tv_dolares) as EditText
//
//
//        /**
//         * Agregamos escuchadores del evento del click
//         */
//        btnConvertir.setOnClickListener(this)
//        btnConvertirPesos.setOnClickListener(this)
//        btnConvertir.setOnClickListener(View.OnClickListener { Log.e("myLog","asda") })
//    }
//
//
//    /**
//     * Metodo que se ejecuta cuando el usuario da click en alguna vista
//     *
//     * @param view
//     */
//    override fun onClick(view: View) {
//
//        /**
//         * Vemos que tipo de vista es a la que le dio click
//         */
//        when (view.id) {
//        //convertiremos dolares a pesos
//            R.id.btn_convertir ->
//
//                if (!inputPesos!!.text.toString().isEmpty()) {
//                    val pesos = inputPesos!!.text.toString()
//                    val pesosDouble = java.lang.Double.parseDouble(pesos)
//                    val dollar = pesosDouble * 20.67098
//                    inputDolares!!.setText("" + dollar)
//                } else {
//                    Toast.makeText(this, "Señor usuario no se puede realizar su acción", Toast.LENGTH_LONG).show()
//                }
//
//            R.id.btn_convertir_a_pesos ->
//
//                if (!inputDolares!!.text.toString().isEmpty()) {
//                    val pesos = inputDolares!!.text.toString()
//
//                    val pesosDouble = java.lang.Double.parseDouble(pesos)
//                    val dollar = pesosDouble / 20.67098
//                    inputPesos!!.setText("" + dollar)
//                } else {
//                    Toast.makeText(this, "Señor usuario no se puede realizar su acción", Toast.LENGTH_LONG).show()
//                }
//        }
//
//
//    }
//
//
//    fun log(content: String) {
//        Log.d("myLog", content)
//    }
//}
