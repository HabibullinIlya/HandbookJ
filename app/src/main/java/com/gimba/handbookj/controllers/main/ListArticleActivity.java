package com.gimba.handbookj.controllers.main;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gimba.handbookj.App;

import com.gimba.handbookj.database.model.Article;
import com.gimba.handbookj.R;
import com.gimba.handbookj.controllers.ListController;
import com.gimba.handbookj.database.model.ArticleJsn;
import com.gimba.handbookj.network.ArticlesApi;
import com.gimba.handbookj.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListArticleActivity extends AppCompatActivity {
    private List<ArticleJsn> articles;
    private RecyclerView rv;
    ArticleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));

        Log.d("TAG in list activity","включился");

        //set fake data.

        fakeData();
        App.getRetrofit().create(ArticlesApi.class).getArticles().enqueue(new Callback<List<ArticleJsn>>() {
            @Override
            public void onResponse(Call<List<ArticleJsn>> call, Response<List<ArticleJsn>> response) {
                articles = response.body();
                adapter = new ArticleAdapter(articles);
                rv.setAdapter(adapter);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        Toast.makeText(ListArticleActivity.this, "Clicked on me, sempai!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<ArticleJsn>> call, Throwable t) {

            }
        });
        ;
        //initializeData();




//        ListController listController = new ListController(this);
    }

    //something useless.
    /*private void initializeData() {
        articles = new ArrayList<>();
        Log.d("TAG in list activity","пошел за артиклями в бд, хз когда вернусь");
        ListController lc = new ListController(this);
        if(lc.getAllArticles() ==null){
            Toast toast = Toast.makeText(this,"null",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            articles = new ListController(this).getAllArticles();
        }

        //Log.d("TAG in list activity",articles.get(1).getName()+articles.get(1).getTags()+articles.get(1).getText());
    }*/

    private void fakeData(){
        articles = new ArrayList<>();
        articles.add(new ArticleJsn(1, "", "", ""));

    }


}
