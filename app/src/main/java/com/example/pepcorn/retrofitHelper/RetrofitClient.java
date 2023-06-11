package com.example.pepcorn.retrofitHelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient retrofitClient;

    private final Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mfapi.in/mf/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
            if(retrofitClient == null){
                retrofitClient = new RetrofitClient();
                return retrofitClient;
            }
            return retrofitClient;
    }

    public ApiFetch getApi(){
        return retrofit.create(ApiFetch.class);
    }
}
