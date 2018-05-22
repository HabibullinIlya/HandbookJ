package com.gimba.handbookj.controllers.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gimba.handbookj.R;
import com.gimba.handbookj.database.model.Article;
import com.gimba.handbookj.database.model.ArticleJsn;
import com.gimba.handbookj.utils.OnItemClickListener;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnItemClickListener onItemClickListener;
    private List<ArticleJsn> articleList;

    public ArticleAdapter(List<ArticleJsn> articleList) {
        this.articleList = articleList;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ArticleVH(v);
    }


    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ArticleVH articleVH = (ArticleVH) holder;
        articleVH.articleHeader.setText(articleList.get(position).getNameActicle());
        articleVH.articleText.setText(articleList.get(position).getTags());
    }

    private class ArticleVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        TextView articleHeader;
        TextView articleText;
        //ImageView articleImage;

        public ArticleVH(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            articleHeader = itemView.findViewById(R.id.article_name);
            articleText = itemView.findViewById(R.id.article_tags);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(getAdapterPosition(), view);
        }
    }
}
