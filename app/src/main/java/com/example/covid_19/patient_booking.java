package com.example.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class patient_booking extends AppCompatActivity {

    Button btnback, btnupdate;
    EditText edtname, edtstate, edtcity, edtage, edtdate, edtdose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtname = findViewById(R.id.edtname);
        edtstate = findViewById(R.id.edtstate);
        edtcity = findViewById(R.id.edtcity);
        edtage = findViewById(R.id.edtage);
        edtdate = findViewById(R.id.edtdate);
        edtdose = findViewById(R.id.edtdose);
        btnback = findViewById(R.id.btnback);
        btnupdate = findViewById(R.id.btnupdate);
        //update the data
        btnupdate.setOnClickListener(view -> {
            Toast.makeText(patient_booking.this, "Slot is booked ", Toast.LENGTH_SHORT).show();
            edtdate.setText("");
            edtname.setText("");
            edtstate.setText("");
            edtcity.setText("");
            edtage.setText("");
            edtdose.setText("");
        });
        //back to home page
        btnback.setOnClickListener(view -> {
            Intent intent = new Intent(patient_booking.this, User_patient.class);
            startActivity(intent);
        });
    }
}