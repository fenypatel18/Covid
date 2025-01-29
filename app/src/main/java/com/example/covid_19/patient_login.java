package com.example.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class patient_login extends AppCompatActivity {

    Button btnsign, btnlog;
    TextInputLayout txtluser, txtlpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtluser = findViewById(R.id.txtluser);
        txtlpass = findViewById(R.id.txtlpass);
        btnsign = findViewById(R.id.btnsign);
        btnlog = findViewById(R.id.btnlog);

        btnsign.setOnClickListener(view -> {
            Intent intent = new Intent(patient_login.this, signup.class);
            startActivity(intent);
        });

        btnlog.setOnClickListener(this::onClick);
    }

    private Boolean valpass() {
        String val = Objects.requireNonNull(txtlpass.getEditText()).getText().toString();
        if (val.isEmpty()) {
            txtlpass.setError("Field cannot be empty");
            return false;
        } else {
            txtlpass.setError(null);
            return true;
        }
    }

    private Boolean valuser() {
        String val = Objects.requireNonNull(txtluser.getEditText()).getText().toString();

        if (val.isEmpty()) {
            txtluser.setError("Field cannot be empty");
            return false;
        } else {
            txtluser.setError(null);
            return true;
        }
    }

    private boolean isUser() {
        return !(!valuser() | !valpass()); // Validation failed
    }

    private void onClick(View view) {
        if (isUser()) {
            Intent intent = new Intent(patient_login.this, User_patient.class);
            startActivity(intent);
        }
    }
}