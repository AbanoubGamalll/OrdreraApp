package com.example.ordreraapp.Card;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordreraapp.R;

import java.util.ArrayList;

public class ListCard_Activity extends AppCompatActivity {
    float ItemTotal, deliveryServes, tax, Totall;
    DbManager db;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_card);

        recyclerViewCard = findViewById(R.id.cardRecyclerView);
        db = new DbManager(this);

        CardRecyclerView();


    }

    private void prices() {
        deliveryServes = 10;
        tax = (float) 0.2 * db.showAllProduct().size();
        ///
        ItemTotal = db.getTotalItemPrice();
        ///
        Totall = deliveryServes + tax + ItemTotal;
        ////////////////////////////////////////////////
        TextView txt_itemtotal = findViewById(R.id.txt_itemtotal);
        txt_itemtotal.setText(String.valueOf(ItemTotal));

        TextView txt_Delevary = findViewById(R.id.txt_Delevary);
        txt_Delevary.setText(String.valueOf(deliveryServes));

        TextView txtTax = findViewById(R.id.txtTax);
        txtTax.setText(String.valueOf(tax));

        TextView txtTotal = findViewById(R.id.txtTotal);
        txtTotal.setText(String.valueOf(Totall));

    }

    private void CardRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewCard.setLayoutManager(linearLayoutManager);
        ////////////////////
        ArrayList<FoodModel> foodModels = db.showAllProduct();
        ////////////////////
        adapter = new ListCardAdaptor(foodModels);
        recyclerViewCard.setAdapter(adapter);
        prices();
    }
}