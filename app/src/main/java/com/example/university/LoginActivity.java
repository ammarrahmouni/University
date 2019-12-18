package com.example.university;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_email, et_password;
    Button btn_login, btn_signup;
    private DbManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email  = findViewById(R.id.login_et_username);
        et_password  = findViewById(R.id.login_et_password);
        btn_login    = findViewById(R.id.login_btn_log);
        btn_signup   = findViewById(R.id.login_btn_signup);
        db = new DbManager(this);
        db.openR();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                
                if(email.matches("")){
                    Toast.makeText(LoginActivity.this, "Do not leave the field empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!db.isItUser(email)){
                    Toast.makeText(LoginActivity.this, "There is no user registered with this email!", Toast.LENGTH_SHORT).show();

                }
                else if(!db.fetchPassword(email, password)){
                    Toast.makeText(LoginActivity.this, "Email and password does not match!", Toast.LENGTH_SHORT).show();
                    et_password.setText("");
                    et_password.requestFocus();
                }
                else if(db.fetchPassword(email, password)){
                    db.close();
                    startActivity(new Intent(LoginActivity.this, RecyclerUniversity.class));
                }
            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
