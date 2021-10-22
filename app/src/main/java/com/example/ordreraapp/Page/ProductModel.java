package com.example.ordreraapp.Page;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.Card.DbManager;
import com.example.ordreraapp.R;

public class ProductModel extends AppCompatActivity {

    TextView Txt_Name, Txt_Prise, Txt_Num, Txt_description;
    ImageView imgmain;
    int num;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_model);

        /////////////////////
        num = 1;
        Txt_Name = findViewById(R.id.Txt_Name);
        Txt_Prise = findViewById(R.id.Txt_Prise);
        Txt_Num = findViewById(R.id.Txt_Num);
        Txt_description = findViewById(R.id.Txt_description);
        imgmain = findViewById(R.id.imgmain);
        /////////////////////
        bundle = getIntent().getExtras();
        Txt_Name.setText(bundle.getString("name"));
        Txt_Prise.setText(bundle.getString("price") + " $");
        Txt_description.setText(bundle.getString("description"));
        imgmain.setImageResource(bundle.getInt("img"));
    }

    public void AddToCard(View view) {
        DbManager db = new DbManager(this);
        db.addOrder(bundle.getString("name"), bundle.getString("price"), Txt_Num.getText().toString(), bundle.getInt("img"));
        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
    }

    public void plus(View view) {
        num++;
        Txt_Num.setText(String.valueOf(num));
    }

    public void minus(View view) {
        if (num == 1) {
            Toast.makeText(this, "Number should be at list 1", Toast.LENGTH_SHORT).show();
        } else {
            num--;
        }
        Txt_Num.setText(String.valueOf(num));
    }


}