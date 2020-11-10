package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.androkado.bo.Article;
import com.example.androkado.dao.ArticleDao;

public class AjoutArticleActivity extends AppCompatActivity {

    /**
     * Attribut de la classe
     */
    Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_article);

         article = new Article();

    }

    public void insererBdd(View view){

        /**
         * méthode de récupération des valeurs saisies
         * puis attributions de cette valeur à
         * l'attribut de classe correspondant
         * Ajout du nom de l'article
         */
        EditText nom = (EditText) findViewById(R.id.editNewNom);
        String txtNom = nom.getText().toString();
        article.setNom(txtNom);

        //Ajout du prix
        EditText prix = (EditText) findViewById(R.id.editNewPrix);
        Float px = Float.parseFloat(prix.getText().toString());
        article.setPrix(px);

        //Ajout de la description
        EditText description = (EditText) findViewById(R.id.editNewDesc);
        String ds = description.getText().toString();
        article.setDescription(ds);

        //Ajout de la note
        EditText note = (EditText) findViewById(R.id.editNewNote);
        Float nt = Float.parseFloat(note.getText().toString());
        article.setNote(nt);

        //Ajout de l'URL
        EditText url = (EditText) findViewById(R.id.editNewUrl);
        article.setUrl(url.getText().toString());

        //Ajout de l'etat
        ToggleButton etat = findViewById(R.id.editNewEtat);
        Log.i("l'etat","Insert de : " + etat.isChecked());
        article.setEtat(etat.isChecked());

        /**
         * insertion de l'article en bdd
         */
        ArticleDao dao = new ArticleDao(this);
        long id = dao.insert(article);

    }

}