package com.example.askandsolve;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/signup/")
    Call<Void> signup(@Body User user);

    @POST("/login/")
    Call<LoginResponse> login(@Body User user);
}
