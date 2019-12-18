package com.example.university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UniversityDescription extends AppCompatActivity {
    TextView tv_uni_name, tv_uni_level, tv_uni_city_, tv_uni_language, tv_uni_start_date, tv_uni_end_date,
    tv_uni_description, tv_uni_link;
    FloatingActionButton btn_favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_description);

        Toolbar toolbar = findViewById(R.id.university_description_tool_bar);
        setSupportActionBar(toolbar);
        
        tv_uni_name = findViewById(R.id.university_description_tv_vname);
        tv_uni_level = findViewById(R.id.university_description_tv_vlevel);
        tv_uni_city_ = findViewById(R.id.university_description_tv_vcity);
        tv_uni_language = findViewById(R.id.university_description_tv_vlanguage);
        tv_uni_start_date = findViewById(R.id.university_description_tv_vdate_start);
        tv_uni_end_date  = findViewById(R.id.university_description_tv_vdate_end);
        tv_uni_description = findViewById(R.id.university_description_tv_vdescription);
        tv_uni_link  = findViewById(R.id.university_description_tv_vlink);
        btn_favorite = (FloatingActionButton) findViewById(R.id.university_description_btn_add);



        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
