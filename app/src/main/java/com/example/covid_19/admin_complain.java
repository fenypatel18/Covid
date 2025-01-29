package com.example.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class admin_complain extends AppCompatActivity {

    Button btnback, btnsub;
    TextInputEditText txtcomplain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_complain);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtcomplain = findViewById(R.id.txtcomplain);
        btnback = findViewById(R.id.btnback);
        btnsub = findViewById(R.id.btnsub);
        btnsub.setOnClickListener(view -> {
            txtcomplain.setText(" ");
            Toast.makeText(admin_complain.this, "Complain registered.", Toast.LENGTH_SHORT).show();
        });
        btnback.setOnClickListener(view -> {
            Intent intent = new Intent(admin_complain.this, admin.class);
            startActivity(intent);
        });
    }
}