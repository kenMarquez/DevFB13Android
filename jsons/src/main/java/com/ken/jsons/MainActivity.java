package com.ken.jsons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String, String> map = new HashMap<>();


        map.put("name", "Omar");
        map.put("lastName", "Gutierrez");
        map.put("age", "22");
        map.put("sex", "masculino");


        JSONObject jsonObject = new JSONObject(map);
        try {
            String name = jsonObject.getString("name");

            Log.d("name", name);
            Log.d("log", jsonObject.toString());
        } catch (JSONException e) {

            e.printStackTrace();
        }




        Log.e("log", getString(R.string.json2));

        try {
            JSONObject jsonObject1 = new JSONObject(getString(R.string.json1));
            JSONObject jsonObject2 = new JSONObject(getString(R.string.json2));
            JSONObject jsonObject3 = new JSONObject(getString(R.string.json3));
            JSONObject jsonObject4 = new JSONObject(getString(R.string.json4));

            Log.e("log", jsonObject1.toString(3));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }





}
