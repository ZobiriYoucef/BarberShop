package com.example.barbershop.QuestionType

import android.content.ContentValues
import com.example.barbershop.QuestionType.IrisTyres.DataBaseTableEntry

object DataManger {
    fun fetchAllResults(dataBaseHelper:DataBaseHelperClass):ArrayList<SurveyResultDataBaseModule>{

        val surveyResultDataBaseModule=ArrayList<SurveyResultDataBaseModule>()

        val db=dataBaseHelper.readableDatabase

        val columns= arrayOf(
                DataBaseTableEntry.COLUMN_ID,
                DataBaseTableEntry.COLUMN_I1 ,
                DataBaseTableEntry.COLUMN_I2 ,
                DataBaseTableEntry.COLUMN_I3  ,
                DataBaseTableEntry.COLUMN_I4  ,
                DataBaseTableEntry.COLUMN_I5 ,
                DataBaseTableEntry.COLUMN_I6  ,
                DataBaseTableEntry.COLUMN_I7 ,
                DataBaseTableEntry.COLUMN_I8   ,
                DataBaseTableEntry.COLUMN_I9 ,
                DataBaseTableEntry.COLUMN_I10 ,
                DataBaseTableEntry.COLUMN_Q1 ,
                DataBaseTableEntry.COLUMN_Q2    ,
                DataBaseTableEntry.COLUMN_Q3   ,
                DataBaseTableEntry.COLUMN_Q4  ,
                DataBaseTableEntry.COLUMN_Q5   ,
                DataBaseTableEntry.COLUMN_Q6   ,
                DataBaseTableEntry.COLUMN_Q7   ,
                DataBaseTableEntry.COLUMN_Q8 ,
                DataBaseTableEntry.COLUMN_Q9
        )

        val queryCursorRsault=db.query(
                DataBaseTableEntry.TabName,
                columns,
                null,
                null,
                null,
                null,
                null)

        val idpos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_ID)
        val I1pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I1)
        val I2pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I2)
        val I3pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I3)
        val I4pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I4)
        val I5pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I5)
        val I6pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I6)
        val I7pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I7)
        val Q1pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I8)
        val Q1Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I9)
        val Q10Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I10)
        val Q2pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q1)
        val Q3pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q2)
        val Q3Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q3)
        val Q4pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q4)
        val Q5pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q5)
        val Q6pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q6)
        val Q7pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q7)
        val Q7Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q8)
        val Q7Bpos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q9)




        while (queryCursorRsault.moveToNext()){
            val id   =queryCursorRsault.getString(idpos)
            val rI1  =queryCursorRsault.getString(I1pos )
            val rI2  =queryCursorRsault.getString(I2pos )
            val rI3  =queryCursorRsault.getString(I3pos )
            val rI4  =queryCursorRsault.getString(I4pos )
            val rI5  =queryCursorRsault.getString(I5pos )
            val rI6  =queryCursorRsault.getString(I6pos )
            val rI7  =queryCursorRsault.getString(I7pos )
            val rQ1  =queryCursorRsault.getString(Q1pos )
            val rQ1A =queryCursorRsault.getString(Q1Apos)
            val rQ10A =queryCursorRsault.getString(Q10Apos)
            val rQ2  =queryCursorRsault.getString(Q2pos )
            val rQ3  =queryCursorRsault.getString(Q3pos )
            val rQ3A =queryCursorRsault.getString(Q3Apos)
            val rQ4  =queryCursorRsault.getString(Q4pos )
            val rQ5  =queryCursorRsault.getString(Q5pos )
            val rQ6  =queryCursorRsault.getString(Q6pos )
            val rQ7  =queryCursorRsault.getString(Q7pos )
            val rQ7A =queryCursorRsault.getString(Q7Apos)
            val rQ7B =queryCursorRsault.getString(Q7Bpos)

           
            surveyResultDataBaseModule.add(SurveyResultDataBaseModule(id,
                                                                      rI1,
                                                                      rI2,
                                                                      rI3,
                                                                      rI4,
                                                                      rI5,
                                                                      rI6,
                                                                      rI7,
                                                                      rQ1,
                                                                      rQ1A,
                                                                      rQ10A,
                                                                      rQ2,
                                                                      rQ3,
                                                                      rQ3A,
                                                                      rQ4,
                                                                      rQ5,
                                                                      rQ6,
                                                                      rQ7,
                                                                      rQ7A,
                                                                      rQ7B))

        }

        queryCursorRsault.close()

        return  surveyResultDataBaseModule
    }

    fun fetchASingleResponse(dataBaseHelper:DataBaseHelperClass,responseId:String ):SurveyResultDataBaseModule?{
        val db=dataBaseHelper.readableDatabase
        var fetchedResultModule :SurveyResultDataBaseModule? =null

        val columns= arrayOf(
                DataBaseTableEntry.COLUMN_ID,
                DataBaseTableEntry.COLUMN_I1 ,
                DataBaseTableEntry.COLUMN_I2 ,
                DataBaseTableEntry.COLUMN_I3  ,
                DataBaseTableEntry.COLUMN_I4  ,
                DataBaseTableEntry.COLUMN_I5 ,
                DataBaseTableEntry.COLUMN_I6  ,
                DataBaseTableEntry.COLUMN_I7 ,
                DataBaseTableEntry.COLUMN_I8   ,
                DataBaseTableEntry.COLUMN_I9 ,
                DataBaseTableEntry.COLUMN_I10 ,
                DataBaseTableEntry.COLUMN_Q1 ,
                DataBaseTableEntry.COLUMN_Q2    ,
                DataBaseTableEntry.COLUMN_Q3   ,
                DataBaseTableEntry.COLUMN_Q4  ,
                DataBaseTableEntry.COLUMN_Q5   ,
                DataBaseTableEntry.COLUMN_Q6   ,
                DataBaseTableEntry.COLUMN_Q7   ,
                DataBaseTableEntry.COLUMN_Q8 ,
                DataBaseTableEntry.COLUMN_Q9
        )

        val selection=DataBaseTableEntry.COLUMN_ID + " LIKE ? "
        val selectionArgs= arrayOf(responseId)

        val queryCursorRsault=db.query(
                DataBaseTableEntry.TabName,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null)

        val idpos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_ID)
        val I1pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I1)
        val I2pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I2)
        val I3pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I3)
        val I4pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I4)
        val I5pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I5)
        val I6pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I6)
        val I7pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I7)
        val Q1pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I8)
        val Q1Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I9)
        val Q10Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I10)
        val Q2pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q1)
        val Q3pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q2)
        val Q3Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q3)
        val Q4pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q4)
        val Q5pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q5)
        val Q6pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q6)
        val Q7pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q7)
        val Q7Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q8)
        val Q7Bpos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q9)

        while (queryCursorRsault.moveToNext()){
            val rI1  =queryCursorRsault.getString(I1pos )
            val rI2  =queryCursorRsault.getString(I2pos )
            val rI3  =queryCursorRsault.getString(I3pos )
            val rI4  =queryCursorRsault.getString(I4pos )
            val rI5  =queryCursorRsault.getString(I5pos )
            val rI6  =queryCursorRsault.getString(I6pos )
            val rI7  =queryCursorRsault.getString(I7pos )
            val rQ1  =queryCursorRsault.getString(Q1pos )
            val rQ1A =queryCursorRsault.getString(Q1Apos)
            val rQ10A =queryCursorRsault.getString(Q10Apos)
            val rQ2  =queryCursorRsault.getString(Q2pos )
            val rQ3  =queryCursorRsault.getString(Q3pos )
            val rQ3A =queryCursorRsault.getString(Q3Apos)
            val rQ4  =queryCursorRsault.getString(Q4pos )
            val rQ5  =queryCursorRsault.getString(Q5pos )
            val rQ6  =queryCursorRsault.getString(Q6pos )
            val rQ7  =queryCursorRsault.getString(Q7pos )
            val rQ7A =queryCursorRsault.getString(Q7Apos)
            val rQ7B =queryCursorRsault.getString(Q7Bpos)


            fetchedResultModule=SurveyResultDataBaseModule(responseId,
                                                            rI1,
                                                            rI2,
                                                            rI3,
                                                            rI4,
                                                            rI5,
                                                            rI6,
                                                            rI7,
                                                            rQ1,
                                                            rQ1A,
                                                            rQ10A,
                                                            rQ2,
                                                            rQ3,
                                                            rQ3A,
                                                            rQ4,
                                                            rQ5,
                                                            rQ6,
                                                            rQ7,
                                                            rQ7A,
                                                            rQ7B
                                                           )
        }

        queryCursorRsault.close()
        return fetchedResultModule




    }

    fun upDateASingleResponse(dataBaseHelper:DataBaseHelperClass,surveyResultDataBaseModule:SurveyResultDataBaseModule){
    val db=dataBaseHelper.writableDatabase

        val values = ContentValues()

        values.put(DataBaseTableEntry.COLUMN_I1 ,surveyResultDataBaseModule.I1  )
        values.put(DataBaseTableEntry.COLUMN_I2 ,surveyResultDataBaseModule.I2  )
        values.put(DataBaseTableEntry.COLUMN_I3 ,surveyResultDataBaseModule.I3  )
        values.put(DataBaseTableEntry.COLUMN_I4 ,surveyResultDataBaseModule.I4  )
        values.put(DataBaseTableEntry.COLUMN_I5 ,surveyResultDataBaseModule.I5  )
        values.put(DataBaseTableEntry.COLUMN_I6 ,surveyResultDataBaseModule.I6  )
        values.put(DataBaseTableEntry.COLUMN_I7 ,surveyResultDataBaseModule.I7  )
        values.put(DataBaseTableEntry.COLUMN_I8 ,surveyResultDataBaseModule.I8  )
        values.put(DataBaseTableEntry.COLUMN_I9 ,surveyResultDataBaseModule.I9  )
        values.put(DataBaseTableEntry.COLUMN_I1 ,surveyResultDataBaseModule.I10 )
        values.put(DataBaseTableEntry.COLUMN_Q1 ,surveyResultDataBaseModule.Q1  )
        values.put(DataBaseTableEntry.COLUMN_Q2 ,surveyResultDataBaseModule.Q2  )
        values.put(DataBaseTableEntry.COLUMN_Q3 ,surveyResultDataBaseModule.Q3  )
        values.put(DataBaseTableEntry.COLUMN_Q4 ,surveyResultDataBaseModule.Q4  )
        values.put(DataBaseTableEntry.COLUMN_Q5 ,surveyResultDataBaseModule.Q5  )
        values.put(DataBaseTableEntry.COLUMN_Q6 ,surveyResultDataBaseModule.Q6  )
        values.put(DataBaseTableEntry.COLUMN_Q7 ,surveyResultDataBaseModule.Q7  )
        values.put(DataBaseTableEntry.COLUMN_Q8 ,surveyResultDataBaseModule.Q8  )
        values.put(DataBaseTableEntry.COLUMN_Q9 ,surveyResultDataBaseModule.Q9  )



        val selection=DataBaseTableEntry.COLUMN_ID + " LIKE ? "
        val selectionArgs= arrayOf(surveyResultDataBaseModule.id)

        db.update(
                DataBaseTableEntry.TabName,
                values,
                selection,
                selectionArgs
        )

    }

    fun deleteASingleResponse(dataBaseHelper:DataBaseHelperClass,singleSurveyID:String):Int{
        val db=dataBaseHelper.writableDatabase

        val selection=DataBaseTableEntry.COLUMN_ID + " LIKE ? "

        val selectionArgs= arrayOf(singleSurveyID)

        return db.delete(DataBaseTableEntry.TabName,selection,selectionArgs)
    }
}