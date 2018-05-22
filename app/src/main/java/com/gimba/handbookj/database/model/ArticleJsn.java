package com.gimba.handbookj.database.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gimba on 19.05.2018.
 */

public class ArticleJsn {

    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("article_text")
    @Expose
    private String articleText;
    @SerializedName("name_acticle")
    @Expose
    private String nameActicle;
    @SerializedName("id")
    @Expose
    private Integer id;

    public ArticleJsn(Integer id,String nameActicle,String tags, String articleText) {
        this.tags = tags;
        this.articleText = articleText;
        this.nameActicle = nameActicle;
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getNameActicle() {
        return nameActicle;
    }

    public void setNameActicle(String nameActicle) {
        this.nameActicle = nameActicle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
