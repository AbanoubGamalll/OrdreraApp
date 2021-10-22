package com.example.ordreraapp.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.R;

public class PizzaPage extends AppCompatActivity {
    String name, description, price;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_page);
    }

    public void P1(View view) {
        name = "Pizza 1";
        description = "Pizza 1";
        img = R.drawable.p1;
        price = "8";
        GoToModel();
    }

    public void P2(View view) {
        name = "Pizza 2";
        description = "Pizza 2";
        img = R.drawable.p2;
        price = "55";
        GoToModel();
    }

    public void P3(View view) {
        name = "Pizza 3";
        description = "Pizza 3";
        img = R.drawable.pizza1;
        price = "10";
        GoToModel();

    }

    public void P4(View view) {
        name = "Pizza 4";
        description = "Pizza 4";
        img = R.drawable.pizza1;
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