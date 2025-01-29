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

public class admin_booking extends AppCompatActivity {

    Button btnback, btnupdate;
    EditText edtdate, edtarea, edtstartingtime, edtendingtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtdate = findViewById(R.id.edtdate);
        edtarea = findViewById(R.id.edtcity);
        edtstartingtime = findViewById(R.id.edtstarttime);
        edtendingtime = findViewById(R.id.edtendtime);
        btnback = findViewById(R.id.btnback);
        btnupdate = findViewById(R.id.btnupdate);

        //update the data
        btnupdate.setOnClickListener(view -> {
            Toast.makeText(admin_booking.this, "Data update", Toast.LENGTH_SHORT).show();
            edtdate.setText("");
            edtarea.setText("");
            edtstartingtime.setText("");
            edtendingtime.setText("");
        });

        //back to home page
        btnback.setOnClickListener(view -> {
            Intent intent = new Intent(admin_booking.this, admin.class);
            startActivity(intent);
        });
    }
}