package com.example.covid_19;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class selection extends AppCompatActivity {

    CardView cardoc;
    CardView carpai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //doctor click event
        cardoc = findViewById(R.id.doccar);
        cardoc.setOnClickListener(view -> {
            Intent intent = new Intent(selection.this, Admin_login.class);
            startActivity(intent);

        });

        //paitent click event
        carpai = findViewById(R.id.carpai);
        carpai.setOnClickListener(view -> {
            Intent intent = new Intent(selection.this, patient_login.class);
            startActivity(intent);

        });
    }
}