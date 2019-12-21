package com.example.barbershop.QuestionType

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelperClass(context: Context?)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(IrisTyres.DataBaseTableEntry.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(IrisTyres.DataBaseTableEntry.SQL_DROP_TABLE)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }

    companion object{
        const val DATABASE_NAME="IRISTYRESBDD.db"
        const val DATABASE_VERSION=1
    }
}