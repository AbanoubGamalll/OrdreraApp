package com.example.ordreraapp.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.R;

public class DessertPage extends AppCompatActivity {
    String name, description, price;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_page);
    }


    public void P1(View view) {
        name = "Dessert 1";
        description = "Dessert 1";
        img = R.drawable.d1;
        price = "8";
        GoToModel();
    }

    public void P2(View view) {
        name = "Dessert 2";
        description = "des dessert2";
        img = R.drawable.d2;
        price = "55";
        GoToModel();
    }

    public void P3(View view) {
        name = "Dessert 3";
        description = "Dessert 3";
        img = R.drawable.d3;
        price = "10";
        GoToModel();

    }

    public void P4(View view) {
        name = "dessert4";
        description = "des dessert4";
        img = R.drawable.d4;
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