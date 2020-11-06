package com.example.androkado.adapter;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.androkado.R;
import com.example.androkado.bo.Article;
import java.util.List;

//Fournit une référence aux vues pour chaque élément de données
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    //Chaque élément contient seulment une textView
    public TextView mTextView;
    public RatingBar mRatingView;
    //Permet de stocker les données à afficher
    private List<Article> mDataset;
    public OnClicSurUnItem action;

    public  ViewHolder(View v, List<Article> data, OnClicSurUnItem activite)
    {
        super(v);
        //mTextView = v.findViewById(R.id.text_info);
        mTextView = v.findViewById(R.id.tv_info_card);
        mRatingView = v.findViewById(R.id.ratingBar_card);
        mDataset = data;
        action = activite;
        //On implémente un listener
        v.setOnClickListener(this);
    }

    /**
     * Action réalisée lors d'un clic sur un élément du RecyclerView.
     */
    @Override
    public void onClick(View v) {
        int position = this.getAdapterPosition();
        //rend l'élément Article x de la liste
        action.onInteraction(mDataset.get(position));
    }
}
