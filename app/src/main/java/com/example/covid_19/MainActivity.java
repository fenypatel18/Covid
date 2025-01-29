package com.example.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Animation toanim, buttomanim;
    ImageView imag;
    TextView txtname, txtsub;
    private static final int splash_screen = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //animation
        toanim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        buttomanim = AnimationUtils.loadAnimation(this, R.anim.buttom_anim);

        imag = findViewById(R.id.imglogo);
        txtname = findViewById(R.id.txtname);
        txtsub = findViewById(R.id.txtsub);

        //assign annimation
        imag.setAnimation(toanim);
        txtname.setAnimation(buttomanim);
        txtsub.setAnimation(buttomanim);

        //call intend
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, selection.class);
            startActivity(intent);
            finish();
        }, splash_screen);
    }
}