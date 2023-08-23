package com.zeyad.medicalapp.data.source.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitClient {

    private final static String BASE_URL ="http://api.instant-ss.com/api/v1/";
    private static Retrofit retrofit;

    public static WebService getWebService(){

        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(WebService.class);

    }


}
