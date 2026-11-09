package com.example.gestionbib;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Suppression extends Activity {
    private Spinner spLivre;
    private Button btnSupprimer;
    private Button btnRetour;
    private ArrayAdapter<Livre> adpLivre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppression);
        initialiser();
        ecouteurs();
        remplir();
    }

    private void initialiser() {
        spLivre =findViewById(R.id.spLivre);
        btnSupprimer = findViewById(R.id.btnSupprimer);
        btnRetour = findViewById(R.id.btnRetour);
        adpLivre = new ArrayAdapter<Livre>(this, android.R.layout.simple_spinner_item,
                new java.util.ArrayList<Livre>());
        spLivre.setAdapter(adpLivre);
    }

    private void ecouteurs() {
        btnSupprimer.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                supprimelivre();
            }
        });
        btnRetour.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    private void remplir() {

    }

    protected void supprimelivre() {

    }
}
