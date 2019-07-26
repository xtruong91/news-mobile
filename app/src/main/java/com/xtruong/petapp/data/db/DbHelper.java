package com.xtruong.petapp.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.xtruong.petapp.data.db.model.notes.Notetbl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongtx on 7/26/2019
 */
public class DbHelper  extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Notetbl.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Notetbl.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertNote(String note) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Notetbl.COLUMN_NOTE, note);

        // insert row
        long id = db.insert(Notetbl.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }
    public Notetbl getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Notetbl.TABLE_NAME,
                new String[]{Notetbl.COLUMN_ID, Notetbl.COLUMN_NOTE, Notetbl.COLUMN_TIMESTAMP},
                Notetbl.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Notetbl note = new Notetbl(
                cursor.getInt(cursor.getColumnIndex(Notetbl.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Notetbl.COLUMN_NOTE)),
                cursor.getString(cursor.getColumnIndex(Notetbl.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }

    public List<Notetbl> getAllNotes() {
        List<Notetbl> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Notetbl.TABLE_NAME + " ORDER BY " +
                Notetbl.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Notetbl note = new Notetbl();
                note.setId(cursor.getInt(cursor.getColumnIndex(Notetbl.COLUMN_ID)));
                note.setNote(cursor.getString(cursor.getColumnIndex(Notetbl.COLUMN_NOTE)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Notetbl.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Notetbl.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(Notetbl note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Notetbl.COLUMN_NOTE, note.getNote());

        // updating row
        return db.update(Notetbl.TABLE_NAME, values, Notetbl.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public void deleteNote(Notetbl note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Notetbl.TABLE_NAME, Notetbl.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }
}
