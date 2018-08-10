package com.zukuzuku.nextorbis.cinemahack;

/**
 * Created by Jakub on 10/08/2018.
 */

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MainService {
    @POST("/auth/login")
    Call<UserPOJO> loginUser(@Body HashMap<String, String> map);

    @GET("/cinema/nearby")
    Call<CinemaPOJO> getCinemas();
}
