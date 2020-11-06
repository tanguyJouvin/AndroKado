package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;


import com.example.androkado.adapter.OnClicSurUnItem;
import com.example.androkado.adapter.RecycleAdapter;
import com.example.androkado.bo.Article;

import java.util.ArrayList;

public class ListeArticleActivity extends AppCompatActivity implements OnClicSurUnItem<Article> {

    private static final String TAG = "AndroKado";
    private ArrayList<Article> infos;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_article);

        Toolbar myToolBar = findViewById(R.id.toolbar_liste);
        //Pour que l'écran utilise l'action bar
        setSupportActionBar(myToolBar);

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        infos = new ArrayList<Article>();
        infos.add(new Article("Croissant", 0.80f, "Un croissant est une viennoiserie à base d'une pâte levée feuilletée spécifique, la pâte à croissant, qui comporte de la levure et une proportion importante de beurre. ",
                2.5f, "https://assets.afcdn.com/recipe/20100120/33166_w2048h1536c1cx256cy192.webp", true));
        infos.add(new Article("Pain au chocolat", 1.20f, "peut se prononcer couque au chocolat et n'est pas une chocolatine",
                5.4f, "https://assets.afcdn.com/recipe/20181107/83668_w314h314c1.webp", true));
        infos.add(new Article("Pain au raisin", 2.45f, "a veille, faites gonfler les raisins secs dans un bol d'eau. Préparez la pâte feuilletée en mélangeant dans un grand saladier la farine tamisée, le sucre et le sel. Diluez la levure en incorporant un peu d'eau tiède. Quand la levure est diluée, rajoutez à nouveau de l'eau tiède pour la lisser, en mélangeant au fouet. Creusez un puits au centre de la farine et ajoutez la levure au milieu.",
                8.4f, "https://assets.afcdn.com/recipe/20131024/5810_w700h500c1cx1872cy2443.webp", true));
        infos.add(new Article("Scone", 0.60f, "La viennoiserie de roger l'anglais",
                1.2f, "https://assets.afcdn.com/recipe/20140221/13165_w314h314c1.webp", true));

        //Création de l'adaptateur
        mAdapter = new RecycleAdapter(infos, this);
        //lier l'adapter au recycle View
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onInteraction(Article article) {
        //permet de passer d'une activité à l'autre
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("article_selectionne", article);
        startActivity(intent);
        Log.i(TAG, "tu as bien cliqué sur l'article");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mon_menu, menu);
        return true;
    }
}