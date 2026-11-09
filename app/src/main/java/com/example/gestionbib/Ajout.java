package com.example.gestionbib;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Ajout extends Activity {
    private EditText edTitre;
    private EditText edNbPage;
    private Button btnAjouter;
    private Button btnRetour;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        initialiser();
        ecouteurs();
    }

    private void initialiser() {

        edTitre = findViewById(R.id.edTitre);
        edNbPage = findViewById(R.id.edNbPage);
        btnAjouter = findViewById(R.id.btnAjouter);
        btnRetour = findViewById(R.id.btnRetour);
    }

    private void ecouteurs() {
        btnRetour.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        btnAjouter.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ajoutLivre();
            }
        });
    }

    private void ajoutLivre() {
        SQLiteBib b = null;
        SQLiteDatabase db = null;

        try {
            b = new SQLiteBib(getApplicationContext(), "bib.db", null, 1);
            db = b.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put("titre", edTitre.getText().toString().trim());
            cv.put("nbpage", Integer.parseInt(edNbPage.getText().toString()));

            db.insert("livre", null, cv);

            Toast.makeText(this, "Livre ajouté avec succès",
                    Toast.LENGTH_SHORT).show();

            edTitre.setText("");
            edNbPage.setText("");

        } catch (NumberFormatException e) {
            edNbPage.setError("Saisissez un nombre de pages valide");

        } catch (Exception e) {
            Toast.makeText(this, "Erreur lors de l'ajout du livre",
                    Toast.LENGTH_SHORT).show();

        } finally {
                db.close();
                b.close();
        }
    }
}
