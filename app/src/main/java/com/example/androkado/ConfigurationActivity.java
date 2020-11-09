package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.androkado.bo.Article;

public class ConfigurationActivity extends AppCompatActivity {
    private Article article;
    Switch switchTri;
    EditText prixParDefaut;

    private String fileName = "preferences";
    private String CLETRI = "triactif";
    private String CLEPRIX = "prixpardefaut";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        switchTri = findViewById(R.id.switch_tri);
        prixParDefaut = findViewById(R.id.textPrix);

        //récupère les valeurs du SharedPreferences :

        SharedPreferences sp = getSharedPreferences(fileName, MODE_PRIVATE);
        boolean prefTri = sp.getBoolean(CLETRI, false);
        switchTri.setChecked(prefTri);

        String prefPrix = sp.getString(CLEPRIX, "");
        prixParDefaut.setText(prefPrix);

    }

    public void enregistrer(View view){
        //récupérer la valeur de edit text et switch
        boolean valeurSwitchTri = switchTri.isChecked();
        String valeurPxDefaut = prixParDefaut.getText().toString();

        SharedPreferences sp = getSharedPreferences(fileName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(CLETRI, valeurSwitchTri);
        editor.putString(CLEPRIX, valeurPxDefaut);
        editor.commit();// ou plus récent editor.apply();
    }

}