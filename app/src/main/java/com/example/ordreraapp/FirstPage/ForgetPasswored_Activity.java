package com.example.ordreraapp.FirstPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.R;

public class ForgetPasswored_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_passwored);
        //open login
        Button sendcode = findViewById(R.id.sendcode);
        sendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "check your account", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), Login_Activity.class);
                startActivity(intent);
            }
        });
    }
}