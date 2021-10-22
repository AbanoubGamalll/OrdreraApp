package com.example.ordreraapp.Card;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname = "Meals.db";
    Context context;
    private float TotalItemPrice;

    public DbManager(Context contextt) {
        super(contextt, dbname, null, 1);
        context = contextt;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table Meals(name text,price text,Quantity text,photo integer)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Meals");
        onCreate(db);
    }

    public void addOrder(String name, String price, String quantity, int photo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("price", price);
        cv.put("quantity", quantity);
        cv.put("photo", photo);
        long res = db.insert("Meals", null, cv);
    }

    public Cursor showOrders() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] rowDetails = {"name", "price", "Quantity", "photo"};
        Cursor row = db.query("Meals", rowDetails, null, null, null, null, null);
        if (row != null)
            row.moveToFirst();
        db.close();
        return row;
    }

    public ArrayList<FoodModel> showAllProduct() {
        TotalItemPrice = 0;
        ArrayList<FoodModel> model = new ArrayList<>();
        DbManager orders = new DbManager(context);
        Cursor c = orders.showOrders();
        while (!c.isAfterLast()) {
            float f = Float.valueOf(c.getString(1)) * Float.valueOf(c.getString(2));
            TotalItemPrice = TotalItemPrice + f;
            model.add(new FoodModel(c.getString(0),
                    c.getString(1)
                    , c.getString(2)
                    , c.getInt(3)));
            c.moveToNext();
        }
        setTotalItemPrice(TotalItemPrice);
        return model;
    }

    public float getTotalItemPrice() {
        return TotalItemPrice;
    }

    public void setTotalItemPrice(float totalItemPrice) {
        TotalItemPrice = totalItemPrice;
    }

    public void deleteOrder(String name) {
        DbManager orders = new DbManager(context);
        Cursor c = orders.showOrders();
        while (!c.isAfterLast()) {
            if (c.getString(0) == name) {
                break;
            } else
                c.moveToNext();
        }
        orders.close();
    }


}
