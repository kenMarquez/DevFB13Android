package com.ken.retrofit2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ken on 27/02/17.
 */

public interface GithubService {


    @GET("users/{name}")
    Call<ResponseBody> getUserInfo(@Path("name") String userName);

    @GET("/users/{name}/repos")
    Call<ResponseBody> getUserRepos(@Path("name") String userName);

    @GET("api/v2/evolution-chain")
    Call<ResponseBody> getEvolutionChain(@Query("limit") String limit, @Query("offset") String offset);

}
