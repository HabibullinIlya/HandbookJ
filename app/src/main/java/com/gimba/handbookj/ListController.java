package com.gimba.handbookj;

import android.content.Context;

import com.gimba.handbookj.Entitys.*;
import com.gimba.handbookj.Entitys.Article;
import com.gimba.handbookj.database.ArticleController;

import java.util.List;

/**
 * Created by gimba on 16.05.2018.
 */

public class ListController {
    ArticleController articleController;
    Context contenxt;
    public ListController(Context mContext){
        contenxt = mContext;
        articleController = new ArticleController(mContext);
    }
    public List<Article> getAllArticles(){
        return articleController.getAllArticle();
    }
    public boolean testDataInsert(Article article){
        return articleController.saveArticleData(article);
    }
}
