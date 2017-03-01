package com.ken.retrofit3.data;

import com.ken.retrofit3.models.Repo;
import com.ken.retrofit3.models.UserCreated;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ken on 28/02/17.
 */

public interface ApiClient {

    @FormUrlEncoded
    @POST("api/v1/users/")
    Call<ResponseBody> createUser(@Field("apaterno") String apaterno,
                                  @Field("amaterno") String aMaterno,
                                  @Field("email") String email,
                                  @Field("nombre") String nombre);


    @FormUrlEncoded
    @POST("api/v1/users/")
    Call<UserCreated> createUserGson(@Field("apaterno") String apaterno,
                                     @Field("amaterno") String aMaterno,
                                     @Field("email") String email,
                                     @Field("nombre") String nombre);

    @GET("/users/kenMarquez/repos")
    Call<List<Repo>> getRepos();

}
