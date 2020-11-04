package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.androkado.bo.Article;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);
//Je récupère l'intent de l'activité A avec la clé "article"
        Intent intent = getIntent();
        Article article = intent.getParcelableExtra("payload");

        TextView tv = findViewById(R.id.text_view_info_url);
        tv.setText(article.getUrl());
        Log.i("TAG", "Nous sommes dans la fonction onCreate côté seconde activité");
    }
}