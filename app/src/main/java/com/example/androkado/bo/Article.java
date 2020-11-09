package com.example.androkado.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {

    private int id;
    private String nom;
    private Float prix;
    private String description;
    private Float note;
    private String url;
    private Boolean etat;

    //générer un constructeur vide
    public Article() {}

    //générer un constructeur vide sans id en paramètre !!! Jamais !!!
    public Article(String nom, Float prix, String description, Float note, String url, Boolean etat) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.note = note;
        this.url = url;
        this.etat = etat;
    }

    protected Article(Parcel in) {
        nom = in.readString();
        if (in.readByte() == 0) {
            prix = null;
        } else {
            prix = in.readFloat();
        }
        description = in.readString();
        if (in.readByte() == 0) {
            note = null;
        } else {
            note = in.readFloat();
        }
        url = in.readString();
        byte tmpEtat = in.readByte();
        etat = tmpEtat == 0 ? null : tmpEtat == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        if (prix == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(prix);
        }
        dest.writeString(description);
        if (note == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(note);
        }
        dest.writeString(url);
        dest.writeByte((byte) (etat == null ? 0 : etat ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Article{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", note=" + note +
                ", url='" + url + '\'' +
                ", etat=" + etat +
                '}';
    }

}
