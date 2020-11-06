package com.example.androkado.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androkado.R;
import com.example.androkado.bo.Article;

import java.util.List;

/**
 * Cette classe permet de créer les views du Recycle view
 * RecycleAdapter.ViewHolder est défini à l'intérieur de la classe RecycleAdapter
 * */
public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder>
{

    //Permet de stocker les données à afficher
    private List<Article> mDataset;
    public OnClicSurUnItem action;

    /**
     * Constructeur qui attend les données à afficher en paramètre
     */

    public RecycleAdapter(List<Article> myDataset, OnClicSurUnItem activite) {
         mDataset = myDataset;
         action = activite;
    }

    //Crée un ViewHolder qui représente le fichier recyclerligne_layout.xml
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_cards, parent, false);
        //a la responsabilité de récupérer la màj de la vue
        ViewHolder vh = new ViewHolder(v, mDataset, action);
        return vh;
    }

    /**
     * Remplie la vue représentant une ligne
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).getNom());
        holder.mRatingView.setRating(mDataset.get(position).getNote());

    }

    /**
     * @return le nb de donnée à afficher
     */
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
