/*
package com.gimba.handbookj

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.gimba.handbookj.network.ArticlesApi


public object MyRetrofit {
    internal var retrofit: Retrofit? = null
    private val baseUrl = "http://ilyaxabibullin.xyz"

    public fun getRetrofit(): Retrofit? {
        var interspector = HttpLoggingInterceptor()
        interspector.setLevel(HttpLoggingInterceptor.Level.BODY)
        var client = OkHttpClient.Builder().addInterceptor(interspector).build()

        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        return retrofit
    }
}
*/
