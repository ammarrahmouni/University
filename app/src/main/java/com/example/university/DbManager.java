package com.example.university;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

import static com.example.university.DbHelper.University_Table;


public class DbManager {

    private  DbHelper dbHelper ;
    private  Context context;
    private  SQLiteDatabase database;

    public DbManager(Context c){context = c;}

    public DbManager openW() throws SQLException{
        dbHelper = new DbHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public DbManager openR() throws SQLException {
        dbHelper = new DbHelper(context);
        database = dbHelper.getReadableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }


    public boolean insertToPerson(Person p){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.p_Name , p.getName() );
        contentValues.put(DbHelper.p_Surname , p.getSurname() );
        contentValues.put(DbHelper.p_Email , p.getEmail() );
        contentValues.put(DbHelper.p_Password , p.getPassword() );
        long result = database.insert(DbHelper.Person_Table , null , contentValues);
        return result != -1;
    }



    public boolean insertToUniversity(University u){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.u_Name , u.getName() );
        contentValues.put(DbHelper.u_Level , u.getLevel() );
        contentValues.put(DbHelper.u_Description , u.getDescription() );
        contentValues.put(DbHelper.u_Language , u.getLanguage() );
        contentValues.put(DbHelper.u_DateStart , u.getDateStart());
        contentValues.put(DbHelper.u_DateEnd , u.getDateEnd());
        contentValues.put(DbHelper.u_Link , u.getLink() );
        long result = database.insert(University_Table , null , contentValues);
        return result != -1;
    }

    public boolean insertToFavorite(int p_Id , int u_Id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.p_Name , p_Id );
        contentValues.put(DbHelper.p_Surname , u_Id );
        long result =  database.insert(DbHelper.Favorite_Table , null , contentValues);
        return result != -1;
    }

    public boolean updatePerson(Person p){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.p_Name ,p.getName());
        contentValues.put(DbHelper.p_Surname , p.getSurname());
        contentValues.put(DbHelper.p_Email , p.getSurname());
        contentValues.put(DbHelper.p_Password , p.getPassword());
        int result = database.update(DbHelper.Person_Table , contentValues , DbHelper.p_Id
                + " = " + p.getId() , null);
        return result != 0;
    }


    public boolean updateUniversity(University u ){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.u_Name , u.getName());
        contentValues.put(DbHelper.u_Level , u.getLevel());
        contentValues.put(DbHelper.u_Description , u.getDescription());
        contentValues.put(DbHelper.u_Language, u.getLanguage());
        contentValues.put(DbHelper.u_DateStart , u.getDateStart());
        contentValues.put(DbHelper.u_DateEnd , u.getDateEnd());
        contentValues.put(DbHelper.u_Link ,u.getLink());
        int result = database.update(University_Table , contentValues ,
                DbHelper.u_Id + "=" + u.getId() , null);
        return result != 0;
}

    public boolean deletePerson(int id){
         int result =  database.delete(DbHelper.Person_Table , DbHelper.p_Id + "=" + id,
                 null);
         return result != 0;
    }

    public boolean deleteUniversity(int id){
        int result = database.delete(DbHelper.Person_Table , null + "=" + id
                , null);
        return result != 0;
    }

    public boolean deleteFavorite(int p_id ,int u_id){
        int result = database.delete(DbHelper.Favorite_Table , DbHelper.fp_Id + " = " + p_id + " AND "
                + DbHelper.fu_Id+" = "+u_id , null);
        return result != 0;
    }

    public Cursor fetchPerson() {
        String[] columns = new String[] { DbHelper.p_Id, DbHelper.p_Name, DbHelper.p_Surname,
                DbHelper.p_Email,DbHelper.p_Password};
        String selection = "SELECT * FROM";
        Cursor cursor = database.query(DbHelper.Person_Table, columns, selection, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchUniversity() {
        Cursor cursor = database.rawQuery("SELECT * FROM " + University_Table, null);
        if (cursor != null) {
            return cursor;
        }
        return null;
    }

    public Boolean fetchPassword(String email , String password){

        String where = DbHelper.p_Email + " = " +  "\'"  + email + "\'" + " AND " + dbHelper.p_Password +
                " = " +  "\'" + password + "\'"  ;
        String[] column = {DbHelper.p_Id , DbHelper.p_Name};


        Cursor c = database.query(dbHelper.Person_Table, column,where,null,null,
                null,null);


        if (c.getCount() <= 0) {
            c.close();
            return false;
        }

        c.close();
        return true;


    }
    public Boolean isItUser(String u){
        String where = dbHelper.p_Email + " = " + "\'" + u + "\'" ;
        String[] column = {dbHelper.p_Email};

        Cursor c = database.query(dbHelper.Person_Table , column , where ,null ,
                null , null , null);
        if(c.moveToFirst()){
            c.close();
            return true;
        }
        c.close();
        return false;
    }

    //public Cursor fetchFavorite() {


//    String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.SUBJECT, DatabaseHelper.DESC };


//    Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);


//    if (cursor != null) {


//        cursor.moveToFirst();


//    }


//    return cursor;


//}


}