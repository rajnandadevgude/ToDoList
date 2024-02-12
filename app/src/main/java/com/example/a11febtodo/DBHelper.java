package com.example.a11febtodo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "todo_database";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TODO = "todo";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TEXT = "text";

    private static final String CREATE_TABLE_TODO = "CREATE TABLE " +
            TABLE_TODO + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TEXT + " TEXT" +
            ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(db);
    }

    public void insertTodo(String text) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEXT, text);
        db.insert(TABLE_TODO, null, values);
        db.close();
    }

    public List<String> getAllTodos() {
        List<String> todoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_TODO, null);
        if (cursor.moveToFirst()) {
            do {
                String text = cursor.getString(cursor.getColumnIndex(COLUMN_TEXT));
                todoList.add(text);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return todoList;
    }

    public void resetTodos() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO, null, null);
        db.close();
    }

    public void updateTodo(String s, String uText) {
    }

    public void deleteTodo(String s) {

    }
}
