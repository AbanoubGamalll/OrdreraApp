package com.example.ordreraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class AboutUs_Activity extends AppCompatActivity {

    private Button previousbtn, nextbtn;
    private ImageSwitcher imgsw;
    private int[] images = {R.drawable.faxcel, R.drawable.george, R.drawable.abanoub, R.drawable.kiro, R.drawable.shady, R.drawable.marvel};
    private int position = 0;
    private TextSwitcher textSwitcher;
    private int Index = 0;
    private String[] row = {"Michael Magdy", "George Samy", "Abanoub Gamal", "Kerolos Nabil", "Shady Rafaat", "Marvel Samuel"};
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        previousbtn = (Button) findViewById(R.id.btnPrevious);
        nextbtn = (Button) findViewById(R.id.btnNext);
        imgsw = (ImageSwitcher) findViewById(R.id.imgSw);
        textSwitcher = findViewById(R.id.textSwitcher);
        imgsw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imgVw = new ImageView(AboutUs_Activity.this);
                imgVw.setImageResource(images[position]);
                return imgVw;
            }
        });
        imgsw.setInAnimation(this, android.R.anim.slide_in_left);
        imgsw.setOutAnimation(this, android.R.anim.slide_out_right);
        previousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position > 0)
                    position--;
                else if (position < 0)
                    position = 0;
                imgsw.setImageResource(images[position]);
                if (Index == row.length - row.length) {

                    textSwitcher.setText(row[0]);

                } else {
                    textSwitcher.setText(row[--Index]);
                }


            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < images.length)
                    position++;
                if (position >= images.length)
                    position = images.length - 1;
                imgsw.setImageResource(images[position]);


                if (Index == row.length - 1) {


                    textSwitcher.setText(row[row.length - 1]);


                } else {
                    textSwitcher.setText(row[++Index]);
                }
            }
        });
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(AboutUs_Activity.this);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(20);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }

        });
        textSwitcher.setText(row[Index]);
    }
}