package com.example.pepcorn.retrofitHelper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiFetch {

    @GET("106984")
    Call<APIDataModal> getApiData();
}
