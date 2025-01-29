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

import com.example.covid_19.databinding.ActivityAdminBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class admin extends AppCompatActivity {

    CardView carbook, cardetails, carupdate, carcomplain;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.covid_19.databinding.ActivityAdminBinding binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarAdmin.toolbar);
        binding.appBarAdmin.toolbar.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).setAnchorView(R.id.toolbar).show());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow).setOpenableLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        carbook = findViewById(R.id.carbook);
        cardetails = findViewById(R.id.cardetails);
        carupdate = findViewById(R.id.carupdat);
        carcomplain = findViewById(R.id.carcomplain);
        carbook.setOnClickListener(view -> {
            Intent intent = new Intent(admin.this, admin_booking.class);
            startActivity(intent);
        });
        cardetails.setOnClickListener(view -> {
            Intent intent = new Intent(admin.this, admin_patient_details.class);
            startActivity(intent);
        });
        carupdate.setOnClickListener(view -> {
            Intent intent = new Intent(admin.this, admin_update.class);
            startActivity(intent);
        });
        carcomplain.setOnClickListener(view -> {
            Intent intent = new Intent(admin.this, admin_complain.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}