package com.gimba.handbookj;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gimba.handbookj.Entitys.Article;
import com.gimba.handbookj.database.ArticleTable;

import java.util.ArrayList;
import java.util.List;

public class ListArticleActivity extends AppCompatActivity {
    private List<Article> articles;
    private RecyclerView rv;
    RVAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);
        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        Log.d("TAG in list activity","включился");


        ListController listController = new ListController(this);
        initializeData();
        initializeAdapter();


    }

    private void initializeAdapter() {
        adapter = new RVAdapter(articles);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RVAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                /*Log.d("TAG", "onItemClick position: " + position);*/
                Toast toast = Toast.makeText(getApplicationContext()," position "+position,Toast.LENGTH_SHORT);
            }
        });
    }

    private void initializeData() {
        articles = new ArrayList<>();
        Log.d("TAG in list activity","пошел за артиклями в бд, хз когда вернусь");
        articles = new ListController(this).getAllArticles();
        Log.d("TAG in list activity",articles.get(1).getName()+articles.get(1).getTags()+articles.get(1).getText());


    }
}
