package com.example.gestionbib;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
    private Button btnAjout;
    private Button btnSuppression;
    private Button btnModification;
    private Button btnConsultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiser();
        ecouteurs();
    }

    private void initialiser() {
        btnAjout = findViewById(R.id.btnAjout);
        btnSuppression = findViewById(R.id.btnSuppression);
        btnModification = findViewById(R.id.btnModification);
        btnConsultation = findViewById(R.id.btnConsultation);
    }

    private void ecouteurs() {
        btnAjout.setOnClickListener(this);
        btnSuppression.setOnClickListener(this);
        btnModification.setOnClickListener(this);
        btnConsultation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i=null;
        if (view.getId() == R.id.btnAjout) {
            i = new Intent(MainActivity.this, Ajout.class);
        } else if (view.getId() == R.id.btnConsultation) {
            i = new Intent(MainActivity.this, Consultation.class);
        } else if (view.getId() == R.id.btnModification) {
            i = new Intent(MainActivity.this, Modification.class);
        } else if (view.getId() == R.id.btnSuppression) {
            i = new Intent(MainActivity.this, Suppression.class);
        }
        if (i != null) startActivity(i);
    }
}
