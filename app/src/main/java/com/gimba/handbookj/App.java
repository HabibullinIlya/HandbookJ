package com.gimba.handbookj;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gimba on 19.05.2018.
 */

public class App extends Application {
    private static Retrofit retrofit = null;
    private static String baseUrl ="http://ilyaxabibullin.xyz/";
    @Override
    public void onCreate() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        super.onCreate();

    }
    public static Retrofit getRetrofit(){return retrofit;}
}
