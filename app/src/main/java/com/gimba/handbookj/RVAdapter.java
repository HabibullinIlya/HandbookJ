package com.gimba.handbookj;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gimba.handbookj.Entitys.Article;

import java.util.List;

/**
 * Created by gimba on 09.05.2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ArticleViewHolder> {

    private  ClickListener clickListener;
    public  class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cv;
        TextView articleHeader;
        TextView articleText;
        //ImageView articleImage;
        ArticleViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            articleHeader = (TextView)itemView.findViewById(R.id.article_name);
            articleText = (TextView)itemView.findViewById(R.id.article_tags);
            cv.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }


    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public interface ClickListener {
        void onItemClick(int position, View v);

    }

    List<Article> articles;
    RVAdapter(List<Article> articles){
        this.articles = articles;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ArticleViewHolder avh = new ArticleViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int i) {
        holder.articleHeader.setText(articles.get(i).getName());
        holder.articleText.setText(articles.get(i).getTags());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

}
