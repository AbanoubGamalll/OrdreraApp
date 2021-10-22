package com.example.ordreraapp.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.AboutUs_Activity;
import com.example.ordreraapp.Card.ListCard_Activity;
import com.example.ordreraapp.FirstPage.SplashScreen;
import com.example.ordreraapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePage_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigation();
    }

    public void BurgerView(View view) {
        startActivity(new Intent(getBaseContext(), BurgerPage.class));
    }

    public void PizzaView(View view) {
        startActivity(new Intent(getBaseContext(), PizzaPage.class));
    }

    public void DrinksView(View view) {
        startActivity(new Intent(getBaseContext(), DrinksPage.class));
    }

    public void DessertsView(View view) {
        startActivity(new Intent(getBaseContext(), DessertPage.class));
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout LogoutBtn = findViewById(R.id.LogoutBtn);
        LinearLayout aboutusBtn = findViewById(R.id.aboutus);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ListCard_Activity.class));
            }
        });
        aboutusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AboutUs_Activity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), HomePage_Activity.class));
                finish();
            }
        });
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SplashScreen.class));
                finish();
            }
        });
    }
}