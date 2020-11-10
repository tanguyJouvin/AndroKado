package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.androkado.adapter.OnClicSurUnItem;
import com.example.androkado.adapter.RecycleAdapter;
import com.example.androkado.bo.Article;
import com.example.androkado.dao.ArticleDao;

import java.util.ArrayList;
import java.util.List;

public class ListeArticleActivity extends AppCompatActivity implements OnClicSurUnItem<Article> {

    /**
     * Attributs de classe
     */
    private static final String TAG = "AndroKado";
    private List<Article> articles;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArticleDao dao ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_article);

        //Pour que l'écran affiche l'action bar
        Toolbar myToolBar = findViewById(R.id.toolbar_liste);
        setSupportActionBar(myToolBar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //mise en place du recycler view
        mRecyclerView = findViewById(R.id.my_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //à l'ouverture  de l'appli récupère les articles de la base de donnée
        dao = new ArticleDao(this);
        Boolean isTrie = getSharedPreferences("configuration", MODE_PRIVATE).getBoolean("triactif", false);
        articles = dao.get();
        Article unArticle = new Article();
        unArticle = dao.get(26);
        Log.i("recup d'un article"," on reucp un article qui est : " + unArticle);
        //Création de l'adaptateur
        mAdapter = new RecycleAdapter(articles, this);
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

    /**
     * Affiche les boutons du menu en bas de l'écran
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mon_menu, menu);
        return true;
    }

    /**
     * Ajoute les actions de navigation
     * aux boutons configurer et ajouter
     * @return booléen
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bouton_configurer: {
                Intent intent = new Intent(this, ConfigurationActivity.class);
                startActivity(intent);
            }
            case R.id.bouton_add: {
                Intent intent = new Intent(this, AjoutArticleActivity.class);
                startActivity(intent);
            }
        }
        return true;
    }


}