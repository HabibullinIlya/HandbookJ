package com.gimba.handbookj.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.gimba.handbookj.Entitys.Article;

import java.util.ArrayList;
import java.util.List;


public class SqliteHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME ="articlesDB";


    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ArticleTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + ArticleTable.TABLE_NAME);
        onCreate(db);
    }


    public Article getArticle(String name){
        Article article;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {
                ArticleTable.COL_NAME_ARTICLE,
                ArticleTable.COL_TEXT
        };
        String selection = ArticleTable.COL_NAME_ARTICLE + "=?";
        String[] args = {name};
        Cursor cursor = db.query(ArticleTable.TABLE_NAME,columns,selection,args,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            article = new Article();

            article.setName(cursor.getString(0));
            article.setTags(cursor.getString(1));
            article.setText(cursor.getString(2));
            return article;
        }
        else {
            Log.d("SQLITEHELPER","такого нет");
        }
        return null;
    }
    public List<Article> getAllArticle(){
        List<Article> articles = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {
                ArticleTable.ID,
                ArticleTable.COL_NAME_ARTICLE,
                ArticleTable.COL_TEXT,
                ArticleTable.COL_TAGS_ARTICLE
        };
        Cursor cursor = db.query(ArticleTable.TABLE_NAME,columns,null,null,null,null,null);
        Log.d("count cursor",String.valueOf(cursor.getCount()));
        int n = cursor.getCount();
        Log.d("n", String.valueOf(n));
        for(int i = 0;i<n;i++){
            //Log.d("TAG sqlite helper", cursor.getString(1));
            cursor.moveToFirst();
            articles.add(new Article(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(3),
                    cursor.getString(2)));
            cursor.moveToNext();
        }
        if(!articles.isEmpty()){
            return articles;
        }else{
            return null;
        }
    }
    public boolean insertArticle(String table, ContentValues content){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table,null,content);
        if(result == 1){
            Log.d("TAG","failed on save data");
            return false;
        }
        else{
            Log.d("TAG","save data successful");
            return true;
        }
    }

}

