package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.example.androkado.bo.Article;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AndroKado";
    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         article = new Article(
                "Croissant",
                0.80f,
                "La viennoiserie de françois le français",
                2.5f,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Pain_au_chocolat_Luc_Viatour.jpg/1200px-Pain_au_chocolat_Luc_Viatour.jpg",
                true);

        TextView titre = findViewById(R.id.editProduit);
        titre.setText(article.getNom());

        TextView prix = findViewById(R.id.editPrix);
        String tmp = String.valueOf(article.getPrix()) + "€";
        prix.setText(tmp);

        TextView description = findViewById(R.id.editDescription);
        description.setText(article.getDescription());

        RatingBar ratingView = findViewById(R.id.ratingBar);
        ratingView.setRating(article.getNote());

        ToggleButton acheteView = findViewById(R.id.etatButton);
        acheteView.setChecked(article.getEtat());
    }


    public void toActivityInfoUrl(View view){
        //permet de passer d'une activité à l'autre
        Intent intent = new Intent(this, InfoUrlActivity.class);
        intent.putExtra("payload", article);
        startActivity(intent);
        Log.i(TAG, "tu as bien cliqué sur l'url de l'article");
        Toast.makeText(this, article.getUrl(), Toast.LENGTH_LONG).show();
    }


    public void changeState(View view){

        ToggleButton acheteview = (ToggleButton) view;
        Log.i(TAG, "tu as bien changé l'état de l'article");
        article.setEtat(acheteview.isChecked());
    }

    @Override
    protected void onPause(){
        Log.i(TAG, "Nous sommes dans la fonction onPause");
        super.onPause();
    }

    @Override
    protected void onStop(){
        Log.i(TAG, "Nous sommes dans la fonction onStop côté première activité");
        super.onStop();
    }
}