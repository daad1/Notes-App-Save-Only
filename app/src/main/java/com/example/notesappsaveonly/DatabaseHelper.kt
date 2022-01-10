package com.example.notesappsaveonly

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,"notes.db",null,1){

    private val sqliteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {

        if (db != null){
            db.execSQL("create table notes(note text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun saveNoteData(note: String){
        val contentValues = ContentValues()
        contentValues.put("note",note)
        sqliteDatabase.insert("notes",null,contentValues)
    }
}