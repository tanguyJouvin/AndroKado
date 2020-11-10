package com.example.androkado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.androkado.bo.Article;
import com.example.androkado.contract.ArticleContract;

import java.util.ArrayList;
import java.util.List;

public class ArticleDao
{
    private SQLiteDatabase db;
    private BDDHelper helper;

    /**
     * il fait appel au bddHelper pour obtenir uneréférence vers une Bdd dans lequel il puisse écrire
     * @param context
     */
    public ArticleDao(Context context) {
        helper = new BDDHelper(context);
        db = helper.getWritableDatabase();
    }

    /**
     * méthode d'insertion des données
     * ContentValues , système clé-valeur : permettant d'ajout la valeur à la colonne crspdt en bdd
     * @param article
     * @return
     */
    public long insert(Article article)
    {
        ContentValues values = new ContentValues();
        values.put(ArticleContract.COL_NOM, article.getNom());
        values.put(ArticleContract.COL_PRIX, article.getPrix());
        values.put(ArticleContract.COL_DESCRIPTION, article.getDescription());
        values.put(ArticleContract.COL_NOTE, article.getNote());
        values.put(ArticleContract.COL_URL, article.getUrl());
        values.put(ArticleContract.COL_ETAT, article.getEtat()  ? 1 : 0);
        Log.i("Insert de : " + article, " et values insertion : " + values);
        return db.insert(ArticleContract.TABLE_NAME,null,values);
    }

    /**
     * Méthode de récupération d'un article
     */
    public Article get(long id)
    {
        Article article = null;

        Cursor cursor = db.query(
                ArticleContract.TABLE_NAME,
                new String[]{ArticleContract.COL_ID, ArticleContract.COL_NOM, ArticleContract.COL_PRIX,
                    ArticleContract.COL_DESCRIPTION, ArticleContract.COL_NOTE
                    , ArticleContract.COL_URL, ArticleContract.COL_ETAT},
                ArticleContract.COL_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if(cursor.moveToNext())
        {
            article = new Article();
            article.setId(cursor.getInt(cursor.getColumnIndex(ArticleContract.COL_ID.trim())));
            article.setNom(cursor.getString(cursor.getColumnIndex(ArticleContract.COL_NOM.trim())));
            article.setPrix(cursor.getFloat(cursor.getColumnIndex(ArticleContract.COL_PRIX.trim())));
            article.setDescription(cursor.getString(cursor.getColumnIndex(ArticleContract.COL_DESCRIPTION.trim())));
            article.setNote(cursor.getFloat(cursor.getColumnIndex(ArticleContract.COL_NOTE.trim())));
            article.setUrl(cursor.getString(cursor.getColumnIndex(ArticleContract.COL_URL.trim())));

            if(cursor.getInt(cursor.getColumnIndex(ArticleContract.COL_ETAT.trim())) == 1) {
                article.setEtat(true);
            } else {
                article.setEtat(false);
            }

        }
        return article;
    }

    public List<Article> get()
    {
        List<Article> resultat = new ArrayList<>();

        Cursor cursor = db.query(
                ArticleContract.TABLE_NAME,
                new String[]{ArticleContract.COL_ID, ArticleContract.COL_NOM, ArticleContract.COL_PRIX,
                        ArticleContract.COL_DESCRIPTION, ArticleContract.COL_NOTE
                        , ArticleContract.COL_URL, ArticleContract.COL_ETAT},
                null,
                null,
                null,
                null,
                null);
        while(cursor.moveToNext())
        {
           Article article = new Article();
            article.setId(cursor.getInt(cursor.getColumnIndex(ArticleContract.COL_ID.trim())));
            article.setNom(cursor.getString(cursor.getColumnIndex(ArticleContract.COL_NOM.trim())));
            article.setPrix(cursor.getFloat(cursor.getColumnIndex(ArticleContract.COL_PRIX.trim())));
            article.setDescription(cursor.getString(cursor.getColumnIndex(ArticleContract.COL_DESCRIPTION.trim())));
            article.setNote(cursor.getFloat(cursor.getColumnIndex(ArticleContract.COL_NOTE.trim())));
            article.setUrl(cursor.getString(cursor.getColumnIndex(ArticleContract.COL_URL.trim())));
            article.setEtat(cursor.getInt(cursor.getColumnIndex(ArticleContract.COL_ETAT.trim())) == 1);

            resultat.add(article);
        }
        return resultat;
    }

    public boolean update(Article article)
    {
        Log.i("MAJ", "Article UPDATE"  + article.toString());

        ContentValues cv  = new ContentValues();
        cv.put(ArticleContract.COL_NOM, article.getNom());
        cv.put(ArticleContract.COL_PRIX, article.getPrix());
        cv.put(ArticleContract.COL_DESCRIPTION, article.getDescription());
        cv.put(ArticleContract.COL_NOTE, article.getNote());
        cv.put(ArticleContract.COL_URL, article.getUrl());
        cv.put(ArticleContract.COL_ETAT, article.getEtat() ? 1 : 0);

        return db.update(ArticleContract.TABLE_NAME,cv,ArticleContract.COL_ID + "=?", new String[]{String.valueOf(article.getId())})>0;
    }

    public boolean delete(Article article)
    {
        return db.delete(ArticleContract.TABLE_NAME,ArticleContract.COL_ID + "=?", new String[]{String.valueOf(article.getId())})>0;
    }
}
