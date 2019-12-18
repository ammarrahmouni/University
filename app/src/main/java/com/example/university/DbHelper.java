package com.example.university;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


        //create database for the first time this is assumed as an alternative way to
        //build a database instead of build it on one of SQLite platforms

        //specify database name and store it in variable
        public static final String dBname = "login.db";

        //specify table name of person and store it
        public static final String Person_Table = "person";

        //the folowing are the columns names which will be attached to the one table
        public static final String p_Id = "p_Id";
        public static final String p_Name = "p_Name";
        public static final String p_Surname = "p_SurName";
        public static final String p_Email = "p_Email";
        public static final String p_Password = "p_Password";

        // University Table

        public static final String University_Table = "university";

        public static final String u_Id = "u_Id";
        public static final String u_Name = "u_Name";
        public static final String u_Description = "u_Description";
        public static final String u_Link = "u_Link";
        public static final String u_Language = "u_Language";
        public static final String u_Level = "u_Level";
        public static final String u_DateStart = "u_DateStart";
        public static final String u_DateEnd = "u_DateEnd";
        public static final String u_Logo = "u_Logo";
        public static final String u_city = "u_city";


        //Favorite Table

        public static final String Favorite_Table = "favorite";

        public static final String fp_Id = "fp_Id";
        public static final String fu_Id = "fu_Id";


        //store a SQLite query in variable to execute it later
        private static final String Creat_Person = "CREATE TABLE " + Person_Table + " (" + p_Id
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + p_Name + " TEXT NOT NULL," + p_Surname +
                " TEXT," +
                p_Email + " TEXT NOT NULL UNIQUE," + p_Password + " TEXT NOT NULL);";

        private static final String Creat_University = "CREATE TABLE " + University_Table + " (" + u_Id
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + u_Name + " TEXT NOT NULL," + u_Description +
                " TEXT," +  u_Link + " TEXT NOT NULL," + u_Language + " TEXT NOT NULL, "+ u_Level
                +" TEXT, " + u_DateStart +" TEXT, "+ u_DateEnd+" Text, " +u_Logo + " BLOB, " + u_city +" TEXT );";

        private static final String Creat_Favorit = "CREATE TABLE " + Favorite_Table + " (" + fp_Id
                + " INTEGER PRIMARY KEY , " + fu_Id + " INTEGER , " +
                "FOREIGN KEY (\"fp_Id\") REFERENCES \"person\" (\"p_Id\") , " +
                "FOREIGN KEY (\"fu_Id\") REFERENCES \"university\" (\"u_Id\")  );";


        public DbHelper(@Nullable Context context) {
            super(context ,dBname , null , 14);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Creat_Person);
            db.execSQL(Creat_University);
            db.execSQL(Creat_Favorit);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Person_Table);
            db.execSQL("DROP TABLE IF EXISTS " + University_Table);
            db.execSQL("DROP TABLE IF EXISTS " + Favorite_Table);
            onCreate(db);

        }

}
