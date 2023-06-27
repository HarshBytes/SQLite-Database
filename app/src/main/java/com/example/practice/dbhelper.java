package com.example.practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="StudentsDB";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="students_table";
    private static final String KEY_ID="enrollment";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_COURSE="course";
    private static final String KEY_DOB="DOB";


    public dbhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"("+ KEY_ID +" INTEGER PRIMARY KEY ,"+ KEY_NAME +" TEXT , "+ KEY_EMAIL +" TEXT , "+ KEY_COURSE +" TEXT , "+ KEY_DOB + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addstudents(String textName, String textEmail, String textID, String textCourse, String textDOB) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID,textID);
        values.put(KEY_NAME,textName);
        values.put(KEY_EMAIL,textEmail);
        values.put(KEY_COURSE,textCourse);
        values.put(KEY_DOB,textDOB);
        db.insert(TABLE_NAME,null,values);
    }
    public ArrayList<Datamodel_Student> viewStudent(){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        ArrayList<Datamodel_Student> arrayList=new ArrayList<>();
        while (cursor.moveToNext()){
            Datamodel_Student model=new Datamodel_Student();
            model.Enrollment=cursor.getString(0);
            model.Name=cursor.getString(1);
            model.Email=cursor.getString(2);
            model.Course=cursor.getString(3);
            model.Birthdate=cursor.getString(4);
            arrayList.add(model);
        }
        return arrayList;
    }
    public boolean deleteStudent(String studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = KEY_ID + " = ?";
        String[] whereArgs = {String.valueOf(studentId)};
        int rowsDeleted = db.delete(TABLE_NAME, whereClause, whereArgs);
        return rowsDeleted > 0;
    }

}
