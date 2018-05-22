package com.gimba.handbookj.controllers.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gimba.handbookj.R;

/**
 * Created by gimba on 19.05.2018.
 */

public class ArticleActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_article);
        text = findViewById(R.id.text);
        

    }
}
