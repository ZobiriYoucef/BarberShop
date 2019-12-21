package com.example.barbershop.QuestionType

import com.example.barbershop.QuestionType.IrisTyres.DataBaseTableEntry

object DataManger {
    fun fetchAllResults(dataBaseHelper:DataBaseHelperClass):ArrayList<SurveyResultDataBaseModule>{

        val surveyResultDataBaseModule=ArrayList<SurveyResultDataBaseModule>()

        val db=dataBaseHelper.readableDatabase

        val columns= arrayOf(
                DataBaseTableEntry.COLUMN_ID,
                DataBaseTableEntry.COLUMN_Q1,
                DataBaseTableEntry.COLUMN_Q2
        )

        val queryCursorRsault=db.query(
                DataBaseTableEntry.TabName,
                columns,
                null,
                null,
                null,
                null,
                null)

        val idpos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_ID)
        val q1pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q1)
        val q2pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q2)

        while (queryCursorRsault.moveToNext()){
            val id=queryCursorRsault.getString(idpos)
            val rq1=queryCursorRsault.getString(q1pos)
            val rq2=queryCursorRsault.getString(q2pos)

            surveyResultDataBaseModule.add(SurveyResultDataBaseModule(id,rq1,rq2))
        }

        queryCursorRsault.close()

        return  surveyResultDataBaseModule
    }
}