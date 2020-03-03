package com.example.barbershop.QuestionType

import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object IrisTyres {

    object DataBaseTableEntry : BaseColumns {
        const val TabName="SurveyDataTable"
        const val COLUMN_ID  = _ID
        const val COLUMN_I1  ="User"
        const val COLUMN_I2  ="Date"
        const val COLUMN_I3  ="Name"
        const val COLUMN_I4  ="Company"
        const val COLUMN_I5  ="Job"
        const val COLUMN_I6  ="Phone1"
        const val COLUMN_I7  ="Phone2"
        const val COLUMN_I8  ="Email"
        const val COLUMN_I9  ="Address"
        const val COLUMN_I10 ="CardImagePath"
        const val COLUMN_Q1  ="Category"
        const val COLUMN_Q2  ="CategoryOther"
        const val COLUMN_Q3  ="Interests"
        const val COLUMN_Q4  ="InterestsOther"
        const val COLUMN_Q5  ="Notes"
        const val COLUMN_Q6  ="Actions"
        const val COLUMN_Q7  ="ActionsOther"
        const val COLUMN_Q8  ="ExtraQ1"
        const val COLUMN_Q9  ="ExtraQ2"



        const val SQL_CREATE_ENTRIES =
                "CREATE TABLE $TabName (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "$COLUMN_I1   TEXT,"+
                        "$COLUMN_I2   TEXT,"+
                        "$COLUMN_I3   TEXT,"+
                        "$COLUMN_I4   TEXT,"+
                        "$COLUMN_I5   TEXT,"+
                        "$COLUMN_I6   TEXT,"+
                        "$COLUMN_I7   TEXT,"+
                        "$COLUMN_I8   TEXT,"+
                        "$COLUMN_I9   TEXT,"+
                        "$COLUMN_I10  TEXT,"+
                        "$COLUMN_Q1   TEXT,"+
                        "$COLUMN_Q2   TEXT,"+
                        "$COLUMN_Q3   TEXT,"+
                        "$COLUMN_Q4   TEXT,"+
                        "$COLUMN_Q5   TEXT,"+
                        "$COLUMN_Q6   TEXT,"+
                        "$COLUMN_Q7   TEXT,"+
                        "$COLUMN_Q8   TEXT,"+
                        "$COLUMN_Q9   TEXT)"

        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TabName"
    }
}