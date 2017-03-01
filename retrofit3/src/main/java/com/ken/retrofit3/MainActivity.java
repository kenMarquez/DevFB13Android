package com.ken.retrofit3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.ken.retrofit3.data.ApiClient;
import com.ken.retrofit3.data.ServiceGenerator;
import com.ken.retrofit3.models.Car;
import com.ken.retrofit3.models.Repo;
import com.ken.retrofit3.models.UserCreated;
import com.ken.retrofit3.utils.Constants;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRepos();
    }


    public void objectToJson() {
        Gson gson = new Gson();

        Car car = new Car();
        car.setBrand("Rover");
        car.setDoors(5);

        String json = gson.toJson(car);

        Log.d(Constants.LOG_NAME, json);
    }


    public void jsonToObject() {
        String json = "{\"brand_name\":\"Jeep\",\"doors\": 3,\"key\":\"value\"}";

        Gson gson = new Gson();

        Car car = gson.fromJson(json, Car.class);

        Log.d(Constants.LOG_NAME, car.toString());
    }


    public void createUserPost() {

        //Obtenemos una instancia de Retrofit
        ApiClient apiClient = ServiceGenerator.createService();

        //Hacemos la solicitud para crear un nuevo usuario
        apiClient.createUser("Marquez", "Alvarado", "s@devf.mx", "Ken")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            int statusCode = response.code();
                            //Verificamos que la respuesta halla sido exitosa
                            if (statusCode == 200 || statusCode == 201) {
                                Log.d("log", response.code() + "");
                                Log.d("log", response.message());
                                Log.d("log", response.body().string());
                            } else {
                                Log.d("log", "Hubo un error");
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("log", t.getMessage());
                    }
                });
    }


    public void createUserPostGson() {
        //Obtenemos una instancia de Retrofit
        ApiClient apiClient = ServiceGenerator.createService();

        //Hacemos la solicitud para crear un nuevo usuario
        apiClient.createUserGson("Marquez", "Alvarado", "saadaknjkd@devf.mx", "Ken")
                .enqueue(new Callback<UserCreated>() {
                    @Override
                    public void onResponse(Call<UserCreated> call, Response<UserCreated> response) {
                        int statusCode = response.code();
                        //Verificamos que la respuesta halla sido exitosa
                        if (statusCode == 200 || statusCode == 201) {
                            UserCreated user = response.body();
                            Log.d(Constants.LOG_NAME, user.toString());
                        } else {
                            Log.d("log", "Hubo un error");
                        }

                    }

                    @Override
                    public void onFailure(Call<UserCreated> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    public void getRepos() {

        //Obtenemos una instancia de Retrofit
        ApiClient apiClient = ServiceGenerator.createService();

        //Hacemos la solicitud para crear un nuevo usuario
        apiClient.getRepos().enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> body = response.body();
                for (int i = 0; i < body.size(); i++) {
                    Log.d(Constants.LOG_NAME, body.get(i).toString());
                }


            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
