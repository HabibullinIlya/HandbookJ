package com.gimba.handbookj.database.model;

/**
 * Created by gimba on 16.05.2018.
 */

public class Article {
    private int IdArticle;
    private String Name;
    private String Tags;
    private String Text;

    public Article() {
    }

    public Article(int idArticle, String name, String tags, String text) {
        IdArticle = idArticle;
        Name = name;
        Tags = tags;
        Text = text;
    }
    public Article(String name, String tags, String text) {//this constructor using for test add data in DB

        Name = name;
        Tags = tags;
        Text = text;
    }

    public int getIdArticle() {
        return IdArticle;
    }

    public void setIdArticle(int idArticle) {
        IdArticle = idArticle;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
