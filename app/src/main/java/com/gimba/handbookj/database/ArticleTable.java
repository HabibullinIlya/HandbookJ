package com.gimba.handbookj.database;


/**
 * Created by gimba on 08.05.2018.
 */


public class ArticleTable {
    public static final String TABLE_NAME = "articles";
    public static final String ID = "articles_id";
    public static final String COL_NAME_ARTICLE = "header";
    public static final String COL_TAGS_ARTICLE = "tags";
    public static final String COL_TEXT = "text";
    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + ID
            + " integer primary key," + COL_NAME_ARTICLE + " text,"+COL_TAGS_ARTICLE+" text," + COL_TEXT + " text" + ")";

}

