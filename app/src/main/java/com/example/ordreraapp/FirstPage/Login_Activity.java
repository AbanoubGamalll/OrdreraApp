package com.example.ordreraapp.FirstPage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.Page.HomePage_Activity;
import com.example.ordreraapp.R;

public class Login_Activity extends AppCompatActivity {

    boolean pressTwiceToExit = false;
    EditText txtemail, txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtemail = findViewById(R.id.Lemail);
        txtpass = findViewById(R.id.Lpassword);
        ////////////////////////////////////
        openNewActivity();
        rememberMeFunction();
        /////////////////////////////////////
    }


    void openNewActivity() {
        createAccountFunction();
        imagebutton();
        //forget_passwordFunction();
    }

    private void imagebutton() {
        ImageView imageView = findViewById(R.id.imagebutton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), HomePage_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void rememberMeFunction() {
        CheckBox cb_rememberMe = findViewById(R.id.cb_rememberMe);
        SharedPreferences sharedPreferences = getSharedPreferences("rememberMe", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        cb_rememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.getBoolean("bool", false)) {
                    editor.putString("userName", txtemail.getText().toString().trim());
                    editor.putString("password", txtpass.getText().toString());
                    editor.putBoolean("bool", false);
                    editor.apply();
                    Toast.makeText(getBaseContext(), "Data Is Saved", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("userName", "");
                    editor.putString("password", "");
                    editor.putBoolean("bool", true);
                    editor.apply();
                    Toast.makeText(getBaseContext(), "Data Is NOT Saved", Toast.LENGTH_SHORT).show();
                }
            }

        });
        txtemail.setText(sharedPreferences.getString("userName", ""));
        txtpass.setText(sharedPreferences.getString("password", ""));
        cb_rememberMe.setChecked(!sharedPreferences.getBoolean("bool", false));

    }

    private void createAccountFunction() {
        TextView createAccount = findViewById(R.id.createAccount);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "create account", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), Registration_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialogFunction();
    }

    void AlertDialogFunction() {
        AlertDialog.Builder buildAlertDialog = new AlertDialog.Builder(this);

        //buildAlertDialog.setIcon(R.drawable.icon);
        buildAlertDialog.setTitle("EXIT");
        buildAlertDialog.setMessage("Do you wand exit ?");

        buildAlertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Toast.makeText(getBaseContext(), "Good Bye", Toast.LENGTH_SHORT).show();
            }
        });

        buildAlertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        buildAlertDialog.create();
        buildAlertDialog.show();
    }


    public void login(View view) {
        Intent Igotomenu = new Intent(getApplicationContext(), HomePage_Activity.class);
        startActivity(Igotomenu);
        finish();
        /*
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (!txtemail.getText().toString().isEmpty() && !txtpass.getText().toString().isEmpty()) {
            auth.signInWithEmailAndPassword(txtemail.getText().toString(), txtpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent Igotomenu = new Intent(getApplicationContext(), swichMain.class);
                        startActivity(Igotomenu);
                        finish();
                    } else {
                        Toast.makeText(getBaseContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(getBaseContext(), "Complete Data", Toast.LENGTH_SHORT).show();
        }
        */
    }


}