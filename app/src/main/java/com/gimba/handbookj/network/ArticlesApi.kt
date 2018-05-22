package com.gimba.handbookj.network

import com.gimba.handbookj.database.model.Article
import com.gimba.handbookj.database.model.ArticleJsn
import retrofit2.Call
import retrofit2.http.GET


interface ArticlesApi{
    @GET("/articlesофмф/handbook/getAllArticles")
    fun getArticles(): Call<List<ArticleJsn>>
}