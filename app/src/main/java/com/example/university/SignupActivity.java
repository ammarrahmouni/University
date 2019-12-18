package com.example.university;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {
    EditText et_name, et_surname, et_email, et_password, et_confirmpassword;
    Button btn_create;
    DbManager db;
    Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_name             = findViewById(R.id.signup_et_name);
        et_surname          = findViewById(R.id.signup_et_surname);
        et_email            = findViewById(R.id.signup_et_email);
        et_password         = findViewById(R.id.signup_et_password);
        et_confirmpassword  = findViewById(R.id.signup_et_confpassword);
        btn_create          = findViewById(R.id.signup_btn_create);
        db = new DbManager(this);
        db.openW();
        db.openR();

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String surname = et_surname.getText().toString();
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                String confPassword = et_confirmpassword.getText().toString();

                if(name.isEmpty() || et_name.length() < 3 || surname.isEmpty() || surname.length() < 3){
                    Toast.makeText(SignupActivity.this, "The name and surname must not be less than 3 letters!", Toast.LENGTH_SHORT).show();

                }

                else if(email.contains(" ")){
                    email.replaceAll("\\s+", "");
                }
                
                else if(!password.equals(confPassword)){
                    Toast.makeText(SignupActivity.this, "password does not match!", Toast.LENGTH_SHORT).show();
                    et_password.setText("");
                    et_confirmpassword.setText("");
                    et_password.requestFocus();
                }

                else if(password.length() < 6){
                    Toast.makeText(SignupActivity.this, "Password must not be less than 6 characters long!", Toast.LENGTH_SHORT).show();
                    et_password.setText("");
                }

                else{
                    person = new Person(name, surname, email, password);
                    boolean result =  db.insertToPerson(person);

                    if(result){
                        Toast.makeText(SignupActivity.this, "successfully registered", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(SignupActivity.this, "An error occurred during registration", Toast.LENGTH_SHORT).show();
                    }
                    db.close();
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                }

                
            }
        });

    }
}
