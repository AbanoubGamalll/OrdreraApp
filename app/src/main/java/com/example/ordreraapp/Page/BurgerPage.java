package com.example.ordreraapp.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.R;

public class BurgerPage extends AppCompatActivity {

    String name, description, price;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_page);
    }

    public void P1(View view) {
        name = "Burger1";
        description = "Burger 1";
        img = R.drawable.one;
        price = "8";
        GoToModel();
    }

    public void P2(View view) {
        name = "burger2";
        description = "Burger 2";
        img = R.drawable.two;
        price = "55";
        GoToModel();
    }

    public void P3(View view) {
        name = "burger3";
        description = "Burger 3";
        img = R.drawable.three;
        price = "10";
        GoToModel();
    }

    public void P4(View view) {
        name = "burger4";
        description = "Burger 4";
        img = R.drawable.four;
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