package com.example.androkado.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.androkado.contract.ArticleContract;

public class BDDHelper extends SQLiteOpenHelper
{
    private final static int VERSION = 2;
    private final static  String BDD_NAME = "demonstration.db";
    private static final String TAG = "BDDHELPER";

    /**
     * VERSION -> vérifie si SQLite va mettre à jour la bdd avec la fonction onUpgrade
     * @param context
     */
    public BDDHelper(@Nullable Context context) {
        super(context, BDD_NAME, null, VERSION);
    }

    /**
     * Creation de la table Article
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        Log.i(TAG, "Passage dans le onCreate");
        sqLiteDatabase.execSQL(ArticleContract.CREATE_TABLE);
    }

    /**
     * Si on veut mettre à jour la bdd
     * @param sqLiteDatabase
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        Log.i(TAG, "Passage dans le onUpgrade");
        sqLiteDatabase.execSQL(ArticleContract.DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}
