package com.ken.retrofit3.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ken.retrofit3.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ken on 28/02/17.
 */

public class ServiceGenerator {


    private static Gson gson = new GsonBuilder().create();

    private static Retrofit retrofit;


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL_GIT)
                    .addConverterFactory(GsonConverterFactory.create(gson));


    public static ApiClient createService() {
        if (retrofit == null) {
            retrofit = builder.build();
        }
        return retrofit.create(ApiClient.class);
    }


}
