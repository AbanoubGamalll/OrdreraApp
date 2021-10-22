package com.example.ordreraapp.FirstPage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordreraapp.R;

public class Registration_Activity extends AppCompatActivity {
    EditText firstname, lastname, email, pass, checkpass, phonenum;
//
//    FirebaseAuth auth;
//    FirebaseUser user;
//    DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firstname = findViewById(R.id.RfirstName);
        lastname = findViewById(R.id.RlastName);
        email = findViewById(R.id.RemailAddress);
        pass = findViewById(R.id.Rpassword);
        checkpass = findViewById(R.id.RchekPassword);
        phonenum = findViewById(R.id.Rphone);
//
//        auth = FirebaseAuth.getInstance();
//        myref = FirebaseDatabase.getInstance().getReference().child("Users");
//        user = auth.getCurrentUser();
    }

    public void BRegister(View view) {
        boolean check = true;
        if (firstname.getText().toString().trim().isEmpty())
            check = false;
        if (lastname.getText().toString().trim().isEmpty())
            check = false;
        if (email.getText().toString().trim().isEmpty()) {
            check = false;
        }
        if (pass.getText().toString().trim().isEmpty())
            check = false;
        if (!pass.getText().toString().equals(checkpass.getText().toString())) {
            Toast.makeText(getBaseContext(), "enter same two password ", Toast.LENGTH_SHORT).show();
            check = false;
        }
        if (phonenum.getText().toString().isEmpty())
            check = false;
//
//        if (check) {
//            auth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()) {
//                        DatabaseReference newuser = myref.child(user.getUid());
//                        newuser.child("Name").setValue(firstname.getText().toString() + " " + lastname.getText().toString());
//                        newuser.child("email").setValue(email.getText().toString());
//                        newuser.child("password").setValue(pass.getText().toString());
//                        newuser.child("phone").setValue(phonenum.getText().toString());
//
//                        Intent intent = new Intent(getBaseContext(), LoginPage.class);
//                        startActivity(intent);
//                        finish();
//                        Toast.makeText(registrationActivity.this, "Register success", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(registrationActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//
//        } else {
//            Toast.makeText(getBaseContext(), "Please Complete data", Toast.LENGTH_SHORT).show();
//        }
    }

}