package com.example.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.covid_19.databinding.ActivityUserPatientBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class User_patient extends AppCompatActivity {

    CardView carbook, cardetails, carupdate, carcomplain;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.covid_19.databinding.ActivityUserPatientBinding binding = ActivityUserPatientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarUserPatient.toolbar);
        binding.appBarUserPatient.toolbar.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.toolbar).show());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_patient);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        carbook = findViewById(R.id.carbook);
        cardetails = findViewById(R.id.cardetails);
        carupdate = findViewById(R.id.carupdat);
        carcomplain = findViewById(R.id.carcomplain);
        carbook.setOnClickListener(view -> {
            Intent intent = new Intent(User_patient.this, patient_booking.class);
            startActivity(intent);
        });

        cardetails.setOnClickListener(view -> {
            Intent intent = new Intent(User_patient.this, patient_certificate.class);
            startActivity(intent);
        });
        carupdate.setOnClickListener(view -> {
            Intent intent = new Intent(User_patient.this, patient_update.class);
            startActivity(intent);
        });
        carcomplain.setOnClickListener(view -> {
            Intent intent = new Intent(User_patient.this, admin_complain.class);
            startActivity(intent);
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_patient, menu);
        return true;
    }


    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_patient);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}