package com.example.barbershop.QuestionType

import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object IrisTyres {

    object DataBaseTableEntry : BaseColumns {
        const val TabName="SurveyDataTable"
        const val COLUMN_ID= _ID
        const val COLUMN_Q1="Q1"
        const val COLUMN_Q2="Q2"

        const val SQL_CREATE_ENTRIES =
                "CREATE TABLE $TabName (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "$COLUMN_Q1 TEXT, " +
                        "$COLUMN_Q2 TEXT)"

        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TabName"
    }
}