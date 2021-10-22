package com.example.ordreraapp.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.R;

public class DrinksPage extends AppCompatActivity {
    String name, description, price;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_page);
    }

    public void P1(View view) {
        name = "Drink 1";
        description = "Drink 1";
        img = R.drawable.dr1;
        price = "8";
        GoToModel();
    }

    public void P2(View view) {
        name = "Drink 2";
        description = "Drink 2";
        img = R.drawable.dr2;
        price = "55";
        GoToModel();
    }

    public void P3(View view) {
        name = "Drink 3";
        description = "Drink 3";
        img = R.drawable.dr3;
        price = "10";
        GoToModel();

    }

    public void P4(View view) {
        name = "Drink 4";
        description = "Drink 4";
        img = R.drawable.dr5;
        price = "66";
        GoToModel();

    }

    public void GoToModel() {
        Intent intent = new Intent(this, ProductModel.class);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("img", img);
        intent.putExtra("description", description);
        startActivity(intent);
    }

}