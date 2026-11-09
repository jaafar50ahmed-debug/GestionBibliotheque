package com.example.gestionbib;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Consultation extends Activity {

    private ListView lstLivre;
    private Button btnRetour;
    private ArrayAdapter<Livre> adpLivre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);

        initialiser();
        ecouteurs();
        remplir();
    }

    private void initialiser() {
        lstLivre = findViewById(R.id.lstLivre);
        btnRetour = findViewById(R.id.btnRetour);

        adpLivre = new ArrayAdapter<Livre>(
                this,
                android.R.layout.simple_list_item_1,
                new java.util.ArrayList<Livre>());

        lstLivre.setAdapter(adpLivre);
    }

    private void ecouteurs() {

        btnRetour.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void remplir() {

        SQLiteBib b = new SQLiteBib(this, "bib.db", null, 1);
        SQLiteDatabase db = b.getReadableDatabase();

        Cursor c = db.query(
                "livre",
                new String[]{"id", "titre", "nbpage"},
                "",
                null,
                null,
                null,
                null);

        adpLivre.clear();

        while (c.moveToNext()) {

            int id = c.getInt(0);
            String titre = c.getString(1);
            int nbpage = c.getInt(2);

            Livre l = new Livre(id, titre, nbpage);

            adpLivre.add(l);
        }

        c.close();
        db.close();
        b.close();

        adpLivre.notifyDataSetChanged();
    }
}