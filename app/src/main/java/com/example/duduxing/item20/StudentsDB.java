package com.example.duduxing.item20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class StudentsDB extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "STUDENTS.db";
    private final static int DATABASE_VERSION = 1;
    private final static String TABLE_NAME = "students_table";
    public final static String STUDENT_ID = "student_id";
    public final static String STUDENT_NAME = "student_name";
    public final static String STUDENT_AGE = "student_age";

    public StudentsDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + STUDENT_ID + " INTEGER primary key autoincrement, " + STUDENT_NAME + " text, " + STUDENT_AGE + " text);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public Cursor select() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }

    public long insert(String name, String age) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_NAME, name);
        contentValues.put(STUDENT_AGE, age);
        long row = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return row;
    }

    public void delete(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String where = STUDENT_ID + " = ?";
        String[] whereValue = { Integer.toString(id) };
        sqLiteDatabase.delete(TABLE_NAME, where, whereValue);
    }

    public void update(int id, String name, String age) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String where = STUDENT_ID + " = ?";
        String[] whereValue = { Integer.toString(id) };
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_NAME, name);
        contentValues.put(STUDENT_AGE, age);
        sqLiteDatabase.update(TABLE_NAME, contentValues, where, whereValue);
    }
}
