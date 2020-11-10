package com.example.androkado.contract;

public class ArticleContract {
    /**
     * private int id;
     *     private String nom;
     *     private Float prix;
     *     private String description;
     *     private Float note;
     *     private String url;
     *     private Boolean etat;
     */

    public static final String TABLE_NAME = "articles";
    //CONSTANTES
    public static final String COL_ID = " id ";
    public static final String COL_NOM = " nom ";
    public static final String COL_PRIX = " prix ";
    public static final String COL_DESCRIPTION = " description ";
    public static final String COL_NOTE = " note ";
    public static final String COL_URL = " url ";
    public static final String COL_ETAT = " etat ";

    public static  final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + " ( " +
    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
    COL_NOM + " TEXT,"+
    COL_PRIX + " REAL,"+
    COL_DESCRIPTION + " TEXT,"+
    COL_NOTE + " REAL,"+
    COL_URL + " TEXT,"+
    COL_ETAT + " NUMERIC"+
            ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

}
