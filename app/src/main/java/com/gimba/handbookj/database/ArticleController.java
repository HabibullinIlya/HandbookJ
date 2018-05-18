package com.gimba.handbookj.database;


import android.content.ContentValues;
import android.content.Context;

import com.gimba.handbookj.database.model.Article;

import java.util.List;


/**
 * Created by gimba on 08.05.2018.
 */


public class ArticleController {
    Context contenxt;
    SqliteHelper sqliteHelper;
    public ArticleController(Context contenxt){
        this.contenxt = contenxt;
        sqliteHelper  = new SqliteHelper(contenxt);
    }
    public Article getArticle(String name){
        return sqliteHelper.getArticle(name);
    }
    public List<Article> getAllArticle(){
        return sqliteHelper.getAllArticle();
    }
    public boolean saveArticleData(Article article){
        ContentValues cv = new ContentValues();
        cv.put(ArticleTable.COL_NAME_ARTICLE,article.getName());
        cv.put(ArticleTable.COL_TAGS_ARTICLE,article.getTags());
        cv.put(ArticleTable.COL_TEXT,article.getText());
        return sqliteHelper.insertArticle(ArticleTable.TABLE_NAME,cv);
    }
}

