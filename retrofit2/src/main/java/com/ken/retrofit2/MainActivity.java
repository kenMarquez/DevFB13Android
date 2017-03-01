package com.ken.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView tvRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRepos = (TextView) findViewById(R.id.tv_response);
        tvRepos.setText("");



//        getReposUserName("kenMarquez");

        getEvolutionChange();
    }

    public void getEvolutionChange() {
        //Configuración básica de nuestro objeto Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/")
                .build();

        GithubService service = retrofit.create(GithubService.class);

        service.getEvolutionChain("3", "10").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("log", response.message());
                    Log.d("log", response.code() + "");
                    Log.d("log", response.body().string());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void getReposUserName(String userName) {

        //Configuración básica de nuestro objeto Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        GithubService service = retrofit.create(GithubService.class);

        service.getUserRepos(userName).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String body = response.body().string();
                    JSONArray jsonArray = new JSONArray(body);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        tvRepos.append(jsonArray.getJSONObject(i).getString("name") + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }


    public void getDataGithub() {

        //Configuración básica de nuestro objeto Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        GithubService service = retrofit.create(GithubService.class);

        service.getUserInfo("carlosgomezmx").enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("log", "" + response.code());
                try {

                    String body = response.body().string();
                    Log.d("log", body);

                    JSONObject jsonObject = new JSONObject(body);

                    Log.d("log", jsonObject.getString("name"));


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("log", t.getMessage());
            }
        });


    }


}
