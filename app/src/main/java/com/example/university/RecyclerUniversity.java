package com.example.university;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class RecyclerUniversity extends AppCompatActivity {
    RecyclerView rv_all, rv_favorite;

    String istanbul_name, ankara_name, hacitepe_name, on_dokuz_name, uludag_name, dokuz_eylul_name, gaziantep_name;
    String istanbul_city, ankara_city, hacitepe_city, on_dokuz_city, uludag_city, dokuz_eylul_city, gaziantep_city;
    String istanbul_level, ankara_level, hacitepe_level, on_dokuz_level, uludag_level, dokuz_eylul_level, gaziantep_level;
    String istanbul_language, ankara_language, hacitepe_language, on_dokuz_language, uludag_language, dokuz_eylul_language, gaziantep_language;
    String istanbul_desc, ankara_desc, hacitepe_desc, on_dokuz_desc, uludag_desc, dokuz_eylul_desc, gaziantep_desc;
    Drawable istanbul_logo, ankara_log, hacitepe_log, on_dokuz_log, uludag_log, dokuz_eylul_log, gaziantep_log;

    DbManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_university);
        db = new DbManager(this);
        db.openW();
        db.openR();


        istanbul_name = getResources().getString(R.string.istanbul_university_name);
        ankara_name = getResources().getString(R.string.ankara_university_name);
        hacitepe_name = getResources().getString(R.string.hacitepe_university_name);
        on_dokuz_name = getResources().getString(R.string.samsun_university_name);
        uludag_name = getResources().getString(R.string.uludag_university_name);
        dokuz_eylul_name = getResources().getString(R.string.dokuzeylul_university_name);
        gaziantep_name = getResources().getString(R.string.gaziante_university_name);

        istanbul_city = getResources().getString(R.string.istanbul_university_city);
        ankara_city = getResources().getString(R.string.ankara_university_city);
        hacitepe_city = getResources().getString(R.string.hacitepe_university_city);
        on_dokuz_city = getResources().getString(R.string.samsun_university_city);
        uludag_city = getResources().getString(R.string.uludag_university_city);
        dokuz_eylul_city = getResources().getString(R.string.dokuzeylul_university_city);
        gaziantep_city = getResources().getString(R.string.gaziante_university_city);

        istanbul_level = getResources().getString(R.string.istanbul_university_level);
        ankara_level = getResources().getString(R.string.ankara_university_level);
        hacitepe_level = getResources().getString(R.string.hacitepe_university_level);
        on_dokuz_level = getResources().getString(R.string.samsun_university_level);
        uludag_level = getResources().getString(R.string.uludag_university_level);
        dokuz_eylul_level = getResources().getString(R.string.dokuzeylul_university_level);
        gaziantep_level = getResources().getString(R.string.gaziante_university_level);

        istanbul_language = getResources().getString(R.string.istanbul_university_language);
        ankara_language = getResources().getString(R.string.ankara_university_language);
        hacitepe_language = getResources().getString(R.string.hacitepe_university_language);
        on_dokuz_language = getResources().getString(R.string.samsun_university_language);
        uludag_language = getResources().getString(R.string.uludag_university_language);
        dokuz_eylul_language = getResources().getString(R.string.dokuzeylul_university_language);
        gaziantep_language = getResources().getString(R.string.gaziante_university_language);

        istanbul_desc = getResources().getString(R.string.istanbul_university_language);
        ankara_desc = getResources().getString(R.string.ankara_university_desc);
        hacitepe_desc = getResources().getString(R.string.hacitepe_university_desc);
        on_dokuz_desc = getResources().getString(R.string.samsun_university_desc);
        uludag_desc = getResources().getString(R.string.uludag_university_desc);
        dokuz_eylul_desc = getResources().getString(R.string.dokuzeylul_university_desc);
        gaziantep_desc = getResources().getString(R.string.gaziante_university_desc);

        istanbul_logo = getResources().getDrawable(R.drawable.iu_istanbul_universitesi_logo);
        ankara_log = getResources().getDrawable(R.drawable.ankaralog);
        hacitepe_log = getResources().getDrawable(R.drawable.hacitebelog);
        on_dokuz_log = getResources().getDrawable(R.drawable.om__logo);
        uludag_log = getResources().getDrawable(R.drawable.uludaglogl);
        dokuz_eylul_log = getResources().getDrawable(R.drawable.dokuzeylollogo);
        gaziantep_log = getResources().getDrawable(R.drawable.gaziantelogo);


        rv_all = findViewById(R.id.recycler_view_all);
        rv_favorite = findViewById(R.id.recycler_view_favorite);

        University istanbul = new University(istanbul_name, istanbul_level, istanbul_city, istanbul_desc, istanbul_language, "2020-05-05", "2020-10-06", "http://www.googel.com");
        University ankara = new University(ankara_name, ankara_level, ankara_city, ankara_desc, ankara_language, "2020-05-05", "2020-10-06", "http://www.googel.com");
        University hacitepe = new University(hacitepe_name, hacitepe_level, hacitepe_city, hacitepe_desc, hacitepe_language, "2020-05-05", "2020-10-06", "http://www.googel.com");
        University on_dokuz = new University(on_dokuz_name, on_dokuz_level, on_dokuz_city, on_dokuz_desc, on_dokuz_language, "2020-05-05", "2020-10-06", "http://www.googel.com");
        University uludag = new University(uludag_name, uludag_level, uludag_city,  uludag_desc, uludag_language, "2020-05-05", "2020-10-06", "http://www.googel.com");
        University dokuz_eylul = new University(dokuz_eylul_name, dokuz_eylul_level, dokuz_eylul_city, dokuz_eylul_desc, dokuz_eylul_language, "2020-05-05", "2020-10-06", "http://www.googel.com");
        University gaziantep = new University(gaziantep_name, gaziantep_level, gaziantep_level, gaziantep_desc, gaziantep_language, "2020-05-05", "2020-10-06", "http://www.googel.com");


        db.insertToUniversity(istanbul);
        db.insertToUniversity(ankara);
        db.insertToUniversity(hacitepe);
        db.insertToUniversity(on_dokuz);
        db.insertToUniversity(uludag);
        db.insertToUniversity(dokuz_eylul);
        db.insertToUniversity(gaziantep);


        ArrayList<UniversityView> university = new ArrayList<>();
        Cursor c = db.fetchUniversity();
        String university_name;
            if(c.moveToFirst()){
                do{
                    university_name = c.getString(c.getColumnIndex(DbHelper.u_Name));
                    university.add(new UniversityView(university_name , istanbul_logo));
                    UniversityAdapter adapter = new UniversityAdapter(university, this);
                    RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
                    rv_all.setLayoutManager(lm);
                    rv_all.setAdapter(adapter);
                    rv_all.setHasFixedSize(true);
                }while (c.moveToNext());

                c.close();
                db.close();
            }

        /*
        UniversityAdapter adapters = new UniversityAdapter(us, this);
        RecyclerView.LayoutManager lms = new LinearLayoutManager(this);
        rv_favorite.setLayoutManager(lms);
        rv_favorite.setAdapter(adapters);
        rv_favorite.setHasFixedSize(true);
        */

    }

    //Menu operations
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.universitymenu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_all){
            rv_all.setVisibility(View.VISIBLE);
            rv_favorite.setVisibility(View.GONE);
        }
        else if(item.getItemId() == R.id.menu_favorite){
            rv_all.setVisibility(View.GONE);
            rv_favorite.setVisibility(View.VISIBLE);

        }
        return true;
    }


}
