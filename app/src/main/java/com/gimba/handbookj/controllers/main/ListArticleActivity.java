package com.gimba.handbookj.controllers.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gimba.handbookj.database.model.Article;
import com.gimba.handbookj.R;
import com.gimba.handbookj.controllers.ListController;
import com.gimba.handbookj.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ListArticleActivity extends AppCompatActivity {
    private List<Article> articles;
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

        adapter = new ArticleAdapter(articles);
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(ListArticleActivity.this, "Clicked on me, sempai!", Toast.LENGTH_SHORT).show();
            }
        });

//        ListController listController = new ListController(this);
    }

    //something useless.
    private void initializeData() {
        articles = new ArrayList<>();
        Log.d("TAG in list activity","пошел за артиклями в бд, хз когда вернусь");
        articles = new ListController(this).getAllArticles();
        Log.d("TAG in list activity",articles.get(1).getName()+articles.get(1).getTags()+articles.get(1).getText());
    }

    private void fakeData(){
        articles = new ArrayList<>();
        articles.add(new Article(1, "Name", "tag", "text"));
        articles.add(new Article(2, "Name", "tag", "text"));
        articles.add(new Article(3, "Name", "tag", "text"));
        articles.add(new Article(4, "Name", "tag", "text"));
    }

}
