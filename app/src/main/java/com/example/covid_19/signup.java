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

public class signup extends AppCompatActivity {

    TextInputLayout txtfname, txtuname, txtemail, txtpnum, txtpass;
    Button btnsignup, btnallready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtfname = findViewById(R.id.txtfname);
        txtuname = findViewById(R.id.txtuname);
        txtemail = findViewById(R.id.txtemail);
        txtpnum = findViewById(R.id.txtpnum);
        txtpass = findViewById(R.id.txtpass);
        btnsignup = findViewById(R.id.btnsingup);
        btnallready = findViewById(R.id.btlalready);
        //calling the methosde when user doesn't enter value
        btnsignup.setOnClickListener(this::registerUser);
        btnallready.setOnClickListener(view -> {
            Intent intent = new Intent(signup.this, Admin_login.class);
            startActivity(intent);
        });
    }

    private Boolean validateName() {
        String val = Objects.requireNonNull(txtfname.getEditText()).getText().toString();
        if (val.isEmpty()) {
            txtfname.setError("field cannot be empty");
            return false;
        } else {
            txtfname.setError(null);
            return true;
        }
    }

    private Boolean validateuserName() {
        String val = Objects.requireNonNull(txtuname.getEditText()).getText().toString();
        if (val.isEmpty()) {
            txtuname.setError("field cannnot be empty");
            return false;
        } else {
            txtuname.setError(null);
            return true;
        }
    }

    private Boolean validateemail() {
        String val = Objects.requireNonNull(txtemail.getEditText()).getText().toString();

        if (val.isEmpty()) {
            txtemail.setError("field cannnot be empty");
            return false;
        } else {
            txtemail.setError(null);
            return true;
        }
    }

    private Boolean validatepnum() {
        String val = Objects.requireNonNull(txtpnum.getEditText()).getText().toString();

        if (val.isEmpty()) {
            txtpnum.setError("field cannnot be empty");
            return false;
        } else {
            txtpnum.setError(null);
            return true;
        }
    }

    private Boolean validatepass() {
        String val = Objects.requireNonNull(txtpass.getEditText()).getText().toString();

        if (val.isEmpty()) {
            txtpass.setError("field cannnot be empty");
            return false;
        } else {
            txtpass.setError(null);
            return true;
        }
    }

    public void registerUser(View view) {
        if (!validateName() | !validateuserName() | !validateemail() | !validatepnum() | !validatepass()) {
            return;
        }
    }
}


