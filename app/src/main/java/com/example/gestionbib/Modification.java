package com.example.gestionbib;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Modification extends Activity {
    private Spinner spLivre;
    private EditText edTitre;
    private EditText edNbPage;
    private Button btnModifier;
    private Button btnRetour;
    private ArrayAdapter<Livre> adpLivre;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        initialiser();
        ecouteurs();
        remplir();
    }

    private void initialiser() {
        spLivre = findViewById(R.id.spLivre);
        edTitre = findViewById(R.id.edTitre);
        edNbPage = findViewById(R.id.edNbPage);
        btnModifier = findViewById(R.id.btnModifier);
        btnRetour = findViewById(R.id.btnRetour);
        adpLivre = new ArrayAdapter<Livre>(this, android.R.layout.simple_spinner_item,
                new java.util.ArrayList<Livre>());
        spLivre.setAdapter(adpLivre);
    }

    private void ecouteurs() {
        //Listener sur les boutons
        btnRetour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnModifier.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                modifielivre();
            }
        });

        spLivre.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                actualiser();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void remplir() {

    }

    protected void actualiser() {

    }

    protected void modifielivre() {

    }

}
