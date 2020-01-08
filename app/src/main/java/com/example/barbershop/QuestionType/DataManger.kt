package com.example.barbershop.QuestionType

import android.content.ContentValues
import com.example.barbershop.QuestionType.IrisTyres.DataBaseTableEntry

object DataManger {
    fun fetchAllResults(dataBaseHelper:DataBaseHelperClass):ArrayList<SurveyResultDataBaseModule>{

        val surveyResultDataBaseModule=ArrayList<SurveyResultDataBaseModule>()

        val db=dataBaseHelper.readableDatabase

        val columns= arrayOf(
                DataBaseTableEntry.COLUMN_ID,
                DataBaseTableEntry.COLUMN_I1,
                DataBaseTableEntry.COLUMN_I2,
                DataBaseTableEntry.COLUMN_I3 ,
                DataBaseTableEntry.COLUMN_I4 ,
                DataBaseTableEntry.COLUMN_I5,
                DataBaseTableEntry.COLUMN_I6 ,
                DataBaseTableEntry.COLUMN_I7,
                DataBaseTableEntry.COLUMN_Q1  ,
                DataBaseTableEntry.COLUMN_Q1A ,
                DataBaseTableEntry.COLUMN_Q2  ,
                DataBaseTableEntry.COLUMN_Q3   ,
                DataBaseTableEntry.COLUMN_Q3A  ,
                DataBaseTableEntry.COLUMN_Q4  ,
                DataBaseTableEntry.COLUMN_Q5   ,
                DataBaseTableEntry.COLUMN_Q6  ,
                DataBaseTableEntry.COLUMN_Q7  ,
                DataBaseTableEntry.COLUMN_Q7A ,
                DataBaseTableEntry.COLUMN_Q7B ,
                DataBaseTableEntry.COLUMN_Q8   ,
                DataBaseTableEntry.COLUMN_Q8A  ,
                DataBaseTableEntry.COLUMN_Q9  ,
                DataBaseTableEntry.COLUMN_Q9A  ,
                DataBaseTableEntry.COLUMN_Q10 ,
                DataBaseTableEntry.COLUMN_Q11  ,
                DataBaseTableEntry.COLUMN_Q12  ,
                DataBaseTableEntry.COLUMN_Q13  ,
                DataBaseTableEntry.COLUMN_Q13A  ,
                DataBaseTableEntry.COLUMN_Q14   ,
                DataBaseTableEntry.COLUMN_Q15  ,
                DataBaseTableEntry.COLUMN_Q15A  ,
                DataBaseTableEntry.COLUMN_Q16  ,
                DataBaseTableEntry.COLUMN_Q16A  ,
                DataBaseTableEntry.COLUMN_Q17   ,
                DataBaseTableEntry.COLUMN_Q17A  ,
                DataBaseTableEntry.COLUMN_Q18    ,
                DataBaseTableEntry.COLUMN_Q19    ,
                DataBaseTableEntry.COLUMN_Q19A  ,
                DataBaseTableEntry.COLUMN_Q20    ,
                DataBaseTableEntry.COLUMN_Q20A  ,
                DataBaseTableEntry.COLUMN_Q21  ,
                DataBaseTableEntry.COLUMN_Q21A ,
                DataBaseTableEntry.COLUMN_Q22  ,
                DataBaseTableEntry.COLUMN_Q23   ,
                DataBaseTableEntry.COLUMN_Q24   ,
                DataBaseTableEntry.COLUMN_Q25  ,
                DataBaseTableEntry.COLUMN_Q26   ,
                DataBaseTableEntry.COLUMN_Q26A ,
                DataBaseTableEntry.COLUMN_Q27   ,
                DataBaseTableEntry.COLUMN_Q27A  ,
                DataBaseTableEntry.COLUMN_Q28   ,
                DataBaseTableEntry.COLUMN_Q28A   ,
                DataBaseTableEntry.COLUMN_Q29    ,
                DataBaseTableEntry.COLUMN_Q30
        )

        val queryCursorRsault=db.query(
                DataBaseTableEntry.TabName,
                columns,
                null,
                null,
                null,
                null,
                null)

        val idpos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_ID  )
        val I1pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I1  )
        val I2pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I2  )
        val I3pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I3  )
        val I4pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I4  )
        val I5pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I5  )
        val I6pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I6  )
        val I7pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I7  )
        val Q1pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q1  )
        val Q1Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q1A )
        val Q2pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q2  )
        val Q3pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q3  )
        val Q3Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q3A )
        val Q4pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q4  )
        val Q5pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q5  )
        val Q6pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q6  )
        val Q7pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q7  )
        val Q7Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q7A )
        val Q7Bpos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q7B )
        val Q8pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q8  )
        val Q8Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q8A )
        val Q9pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q9  )
        val Q9Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q9A )
        val Q10pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q10 )
        val Q11pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q11 )
        val Q12pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q12 )
        val Q13pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q13 )
        val Q13Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q13A)
        val Q14pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q14 )
        val Q15pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q15 )
        val Q15Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q15A)
        val Q16pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q16 )
        val Q16Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q16A)
        val Q17pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q17 )
        val Q17Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q17A)
        val Q18pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q18 )
        val Q19pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q19 )
        val Q19Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q19A)
        val Q20pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q20 )
        val Q20Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q20A)
        val Q21pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q21 )
        val Q21Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q21A)
        val Q22pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q22 )
        val Q23pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q23 )
        val Q24pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q24 )
        val Q25pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q25 )
        val Q26pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q26 )
        val Q26Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q26A)
        val Q27pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q27 )
        val Q27Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q27A)
        val Q28pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q28 )
        val Q28Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q28A)
        val Q29pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q29 )
        val Q30pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q30 )



        while (queryCursorRsault.moveToNext()){
            val id =queryCursorRsault.getString(idpos)
            val rI1  =queryCursorRsault.getString(I1pos )
            val rI2  =queryCursorRsault.getString(I2pos )
            val rI3  =queryCursorRsault.getString(I3pos )
            val rI4  =queryCursorRsault.getString(I4pos )
            val rI5  =queryCursorRsault.getString(I5pos )
            val rI6  =queryCursorRsault.getString(I6pos )
            val rI7  =queryCursorRsault.getString(I7pos )
            val rQ1  =queryCursorRsault.getString(Q1pos )
            val rQ1A =queryCursorRsault.getString(Q1Apos)
            val rQ2  =queryCursorRsault.getString(Q2pos )
            val rQ3  =queryCursorRsault.getString(Q3pos )
            val rQ3A =queryCursorRsault.getString(Q3Apos)
            val rQ4  =queryCursorRsault.getString(Q4pos )
            val rQ5  =queryCursorRsault.getString(Q5pos )
            val rQ6  =queryCursorRsault.getString(Q6pos )
            val rQ7  =queryCursorRsault.getString(Q7pos )
            val rQ7A =queryCursorRsault.getString(Q7Apos)
            val rQ7B =queryCursorRsault.getString(Q7Bpos)
            val rQ8  =queryCursorRsault.getString(Q8pos )
            val rQ8A =queryCursorRsault.getString(Q8Apos)
            val rQ9  =queryCursorRsault.getString(Q9pos )
            val rQ9A =queryCursorRsault.getString(Q9Apos)
            val rQ10 =queryCursorRsault.getString(Q10pos)
            val rQ11 =queryCursorRsault.getString(Q11pos)
            val rQ12 =queryCursorRsault.getString(Q12pos)
            val rQ13 =queryCursorRsault.getString(Q13pos)
            val rQ13A=queryCursorRsault.getString(Q13Apos)
            val rQ14 =queryCursorRsault.getString(Q14pos)
            val rQ15 =queryCursorRsault.getString(Q15pos)
            val rQ15A=queryCursorRsault.getString(Q15Apos)
            val rQ16 =queryCursorRsault.getString(Q16pos)
            val rQ16A=queryCursorRsault.getString(Q16Apos)
            val rQ17 =queryCursorRsault.getString(Q17pos)
            val rQ17A=queryCursorRsault.getString(Q17Apos)
            val rQ18 =queryCursorRsault.getString(Q18pos)
            val rQ19 =queryCursorRsault.getString(Q19pos)
            val rQ19A=queryCursorRsault.getString(Q19Apos)
            val rQ20 =queryCursorRsault.getString(Q20pos)
            val rQ20A=queryCursorRsault.getString(Q20Apos)
            val rQ21 =queryCursorRsault.getString(Q21pos)
            val rQ21A=queryCursorRsault.getString(Q21Apos)
            val rQ22 =queryCursorRsault.getString(Q22pos)
            val rQ23 =queryCursorRsault.getString(Q23pos)
            val rQ24 =queryCursorRsault.getString(Q24pos)
            val rQ25 =queryCursorRsault.getString(Q25pos)
            val rQ26 =queryCursorRsault.getString(Q26pos)
            val rQ26A=queryCursorRsault.getString(Q26Apos)
            val rQ27 =queryCursorRsault.getString(Q27pos)
            val rQ27A=queryCursorRsault.getString(Q27Apos)
            val rQ28 =queryCursorRsault.getString(Q28pos)
            val rQ28A=queryCursorRsault.getString(Q28Apos)
            val rQ29 =queryCursorRsault.getString(Q29pos)
            val rQ30 =queryCursorRsault.getString(Q30pos)

           
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
                                                                      rQ2,
                                                                      rQ3,
                                                                      rQ3A,
                                                                      rQ4,
                                                                      rQ5,
                                                                      rQ6,
                                                                      rQ7,
                                                                      rQ7A,
                                                                      rQ7B,
                                                                      rQ8,
                                                                      rQ8A,
                                                                      rQ9,
                                                                      rQ9A,
                                                                      rQ10,
                                                                      rQ11,
                                                                      rQ12,
                                                                      rQ13,
                                                                      rQ13A,
                                                                      rQ14,
                                                                      rQ15,
                                                                      rQ15A,
                                                                      rQ16,
                                                                      rQ16A,
                                                                      rQ17,
                                                                      rQ17A,
                                                                      rQ18,
                                                                      rQ19,
                                                                      rQ19A,
                                                                      rQ20,
                                                                      rQ20A,
                                                                      rQ21,
                                                                      rQ21A,
                                                                      rQ22,
                                                                      rQ23,
                                                                      rQ24,
                                                                      rQ25,
                                                                      rQ26,
                                                                      rQ26A,
                                                                      rQ27,
                                                                      rQ27A,
                                                                      rQ28,
                                                                      rQ28A,
                                                                      rQ29,
                                                                      rQ30))

        }

        queryCursorRsault.close()

        return  surveyResultDataBaseModule
    }

    fun fetchASingleResponse(dataBaseHelper:DataBaseHelperClass,responseId:String ):SurveyResultDataBaseModule?{
        val db=dataBaseHelper.readableDatabase
        var fetchedResultModule :SurveyResultDataBaseModule? =null

        val columns= arrayOf(
                DataBaseTableEntry.COLUMN_ID,
                DataBaseTableEntry.COLUMN_I1,
                DataBaseTableEntry.COLUMN_I2,
                DataBaseTableEntry.COLUMN_I3 ,
                DataBaseTableEntry.COLUMN_I4 ,
                DataBaseTableEntry.COLUMN_I5,
                DataBaseTableEntry.COLUMN_I6 ,
                DataBaseTableEntry.COLUMN_I7,
                DataBaseTableEntry.COLUMN_Q1  ,
                DataBaseTableEntry.COLUMN_Q1A ,
                DataBaseTableEntry.COLUMN_Q2  ,
                DataBaseTableEntry.COLUMN_Q3   ,
                DataBaseTableEntry.COLUMN_Q3A  ,
                DataBaseTableEntry.COLUMN_Q4  ,
                DataBaseTableEntry.COLUMN_Q5   ,
                DataBaseTableEntry.COLUMN_Q6  ,
                DataBaseTableEntry.COLUMN_Q7  ,
                DataBaseTableEntry.COLUMN_Q7A ,
                DataBaseTableEntry.COLUMN_Q7B ,
                DataBaseTableEntry.COLUMN_Q8   ,
                DataBaseTableEntry.COLUMN_Q8A  ,
                DataBaseTableEntry.COLUMN_Q9  ,
                DataBaseTableEntry.COLUMN_Q9A  ,
                DataBaseTableEntry.COLUMN_Q10 ,
                DataBaseTableEntry.COLUMN_Q11  ,
                DataBaseTableEntry.COLUMN_Q12  ,
                DataBaseTableEntry.COLUMN_Q13  ,
                DataBaseTableEntry.COLUMN_Q13A  ,
                DataBaseTableEntry.COLUMN_Q14   ,
                DataBaseTableEntry.COLUMN_Q15  ,
                DataBaseTableEntry.COLUMN_Q15A  ,
                DataBaseTableEntry.COLUMN_Q16  ,
                DataBaseTableEntry.COLUMN_Q16A  ,
                DataBaseTableEntry.COLUMN_Q17   ,
                DataBaseTableEntry.COLUMN_Q17A  ,
                DataBaseTableEntry.COLUMN_Q18    ,
                DataBaseTableEntry.COLUMN_Q19    ,
                DataBaseTableEntry.COLUMN_Q19A  ,
                DataBaseTableEntry.COLUMN_Q20    ,
                DataBaseTableEntry.COLUMN_Q20A  ,
                DataBaseTableEntry.COLUMN_Q21  ,
                DataBaseTableEntry.COLUMN_Q21A ,
                DataBaseTableEntry.COLUMN_Q22  ,
                DataBaseTableEntry.COLUMN_Q23   ,
                DataBaseTableEntry.COLUMN_Q24   ,
                DataBaseTableEntry.COLUMN_Q25  ,
                DataBaseTableEntry.COLUMN_Q26   ,
                DataBaseTableEntry.COLUMN_Q26A ,
                DataBaseTableEntry.COLUMN_Q27   ,
                DataBaseTableEntry.COLUMN_Q27A  ,
                DataBaseTableEntry.COLUMN_Q28   ,
                DataBaseTableEntry.COLUMN_Q28A   ,
                DataBaseTableEntry.COLUMN_Q29    ,
                DataBaseTableEntry.COLUMN_Q30
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

        val I1pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I1  )
        val I2pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I2  )
        val I3pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I3  )
        val I4pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I4  )
        val I5pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I5  )
        val I6pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I6  )
        val I7pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_I7  )
        val Q1pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q1  )
        val Q1Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q1A )
        val Q2pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q2  )
        val Q3pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q3  )
        val Q3Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q3A )
        val Q4pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q4  )
        val Q5pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q5  )
        val Q6pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q6  )
        val Q7pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q7  )
        val Q7Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q7A )
        val Q7Bpos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q7B )
        val Q8pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q8  )
        val Q8Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q8A )
        val Q9pos =queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q9  )
        val Q9Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q9A )
        val Q10pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q10 )
        val Q11pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q11 )
        val Q12pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q12 )
        val Q13pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q13 )
        val Q13Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q13A)
        val Q14pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q14 )
        val Q15pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q15 )
        val Q15Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q15A)
        val Q16pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q16 )
        val Q16Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q16A)
        val Q17pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q17 )
        val Q17Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q17A)
        val Q18pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q18 )
        val Q19pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q19 )
        val Q19Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q19A)
        val Q20pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q20 )
        val Q20Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q20A)
        val Q21pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q21 )
        val Q21Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q21A)
        val Q22pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q22 )
        val Q23pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q23 )
        val Q24pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q24 )
        val Q25pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q25 )
        val Q26pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q26 )
        val Q26Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q26A)
        val Q27pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q27 )
        val Q27Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q27A)
        val Q28pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q28 )
        val Q28Apos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q28A)
        val Q29pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q29 )
        val Q30pos=queryCursorRsault.getColumnIndex(DataBaseTableEntry.COLUMN_Q30 )

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
            val rQ2  =queryCursorRsault.getString(Q2pos )
            val rQ3  =queryCursorRsault.getString(Q3pos )
            val rQ3A =queryCursorRsault.getString(Q3Apos)
            val rQ4  =queryCursorRsault.getString(Q4pos )
            val rQ5  =queryCursorRsault.getString(Q5pos )
            val rQ6  =queryCursorRsault.getString(Q6pos )
            val rQ7  =queryCursorRsault.getString(Q7pos )
            val rQ7A =queryCursorRsault.getString(Q7Apos)
            val rQ7B =queryCursorRsault.getString(Q7Bpos)
            val rQ8  =queryCursorRsault.getString(Q8pos )
            val rQ8A =queryCursorRsault.getString(Q8Apos)
            val rQ9  =queryCursorRsault.getString(Q9pos )
            val rQ9A =queryCursorRsault.getString(Q9Apos)
            val rQ10 =queryCursorRsault.getString(Q10pos)
            val rQ11 =queryCursorRsault.getString(Q11pos)
            val rQ12 =queryCursorRsault.getString(Q12pos)
            val rQ13 =queryCursorRsault.getString(Q13pos)
            val rQ13A=queryCursorRsault.getString(Q13Apos)
            val rQ14 =queryCursorRsault.getString(Q14pos)
            val rQ15 =queryCursorRsault.getString(Q15pos)
            val rQ15A=queryCursorRsault.getString(Q15Apos)
            val rQ16 =queryCursorRsault.getString(Q16pos)
            val rQ16A=queryCursorRsault.getString(Q16Apos)
            val rQ17 =queryCursorRsault.getString(Q17pos)
            val rQ17A=queryCursorRsault.getString(Q17Apos)
            val rQ18 =queryCursorRsault.getString(Q18pos)
            val rQ19 =queryCursorRsault.getString(Q19pos)
            val rQ19A=queryCursorRsault.getString(Q19Apos)
            val rQ20 =queryCursorRsault.getString(Q20pos)
            val rQ20A=queryCursorRsault.getString(Q20Apos)
            val rQ21 =queryCursorRsault.getString(Q21pos)
            val rQ21A=queryCursorRsault.getString(Q21Apos)
            val rQ22 =queryCursorRsault.getString(Q22pos)
            val rQ23 =queryCursorRsault.getString(Q23pos)
            val rQ24 =queryCursorRsault.getString(Q24pos)
            val rQ25 =queryCursorRsault.getString(Q25pos)
            val rQ26 =queryCursorRsault.getString(Q26pos)
            val rQ26A=queryCursorRsault.getString(Q26Apos)
            val rQ27 =queryCursorRsault.getString(Q27pos)
            val rQ27A=queryCursorRsault.getString(Q27Apos)
            val rQ28 =queryCursorRsault.getString(Q28pos)
            val rQ28A=queryCursorRsault.getString(Q28Apos)
            val rQ29 =queryCursorRsault.getString(Q29pos)
            val rQ30 =queryCursorRsault.getString(Q30pos)


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
                                                            rQ2,
                                                            rQ3,
                                                            rQ3A,
                                                            rQ4,
                                                            rQ5,
                                                            rQ6,
                                                            rQ7,
                                                            rQ7A,
                                                            rQ7B,
                                                            rQ8,
                                                            rQ8A,
                                                            rQ9,
                                                            rQ9A,
                                                            rQ10,
                                                            rQ11,
                                                            rQ12,
                                                            rQ13,
                                                            rQ13A,
                                                            rQ14,
                                                            rQ15,
                                                            rQ15A,
                                                            rQ16,
                                                            rQ16A,
                                                            rQ17,
                                                            rQ17A,
                                                            rQ18,
                                                            rQ19,
                                                            rQ19A,
                                                            rQ20,
                                                            rQ20A,
                                                            rQ21,
                                                            rQ21A,
                                                            rQ22,
                                                            rQ23,
                                                            rQ24,
                                                            rQ25,
                                                            rQ26,
                                                            rQ26A,
                                                            rQ27,
                                                            rQ27A,
                                                            rQ28,
                                                            rQ28A,
                                                            rQ29,
                                                            rQ30)
        }

        queryCursorRsault.close()
        return fetchedResultModule




    }

    fun upDateASingleResponse(dataBaseHelper:DataBaseHelperClass,surveyResultDataBaseModule:SurveyResultDataBaseModule){
    val db=dataBaseHelper.writableDatabase

        val values = ContentValues()

        values.put(DataBaseTableEntry.COLUMN_I1  ,surveyResultDataBaseModule.I1  )
        values.put(DataBaseTableEntry.COLUMN_I2  ,surveyResultDataBaseModule.I2  )
        values.put(DataBaseTableEntry.COLUMN_I3  ,surveyResultDataBaseModule.I3  )
        values.put(DataBaseTableEntry.COLUMN_I4  ,surveyResultDataBaseModule.I4  )
        values.put(DataBaseTableEntry.COLUMN_I5  ,surveyResultDataBaseModule.I5  )
        values.put(DataBaseTableEntry.COLUMN_I6  ,surveyResultDataBaseModule.I6  )
        values.put(DataBaseTableEntry.COLUMN_I7  ,surveyResultDataBaseModule.I7  )
        values.put(DataBaseTableEntry.COLUMN_Q1  ,surveyResultDataBaseModule.Q1  )
        values.put(DataBaseTableEntry.COLUMN_Q1A ,surveyResultDataBaseModule.Q1A )
        values.put(DataBaseTableEntry.COLUMN_Q2  ,surveyResultDataBaseModule.Q2  )
        values.put(DataBaseTableEntry.COLUMN_Q3  ,surveyResultDataBaseModule.Q3  )
        values.put(DataBaseTableEntry.COLUMN_Q3A ,surveyResultDataBaseModule.Q3A )
        values.put(DataBaseTableEntry.COLUMN_Q4  ,surveyResultDataBaseModule.Q4  )
        values.put(DataBaseTableEntry.COLUMN_Q5  ,surveyResultDataBaseModule.Q5  )
        values.put(DataBaseTableEntry.COLUMN_Q6  ,surveyResultDataBaseModule.Q6  )
        values.put(DataBaseTableEntry.COLUMN_Q7  ,surveyResultDataBaseModule.Q7  )
        values.put(DataBaseTableEntry.COLUMN_Q7A ,surveyResultDataBaseModule.Q7A )
        values.put(DataBaseTableEntry.COLUMN_Q7B ,surveyResultDataBaseModule.Q7B )
        values.put(DataBaseTableEntry.COLUMN_Q8  ,surveyResultDataBaseModule.Q8  )
        values.put(DataBaseTableEntry.COLUMN_Q8A ,surveyResultDataBaseModule.Q8A )
        values.put(DataBaseTableEntry.COLUMN_Q9  ,surveyResultDataBaseModule.Q9  )
        values.put(DataBaseTableEntry.COLUMN_Q9A ,surveyResultDataBaseModule.Q9A )
        values.put(DataBaseTableEntry.COLUMN_Q10 ,surveyResultDataBaseModule.Q10 )
        values.put(DataBaseTableEntry.COLUMN_Q11 ,surveyResultDataBaseModule.Q11 )
        values.put(DataBaseTableEntry.COLUMN_Q12 ,surveyResultDataBaseModule.Q12 )
        values.put(DataBaseTableEntry.COLUMN_Q13 ,surveyResultDataBaseModule.Q13 )
        values.put(DataBaseTableEntry.COLUMN_Q13A,surveyResultDataBaseModule.Q13A)
        values.put(DataBaseTableEntry.COLUMN_Q14 ,surveyResultDataBaseModule.Q14 )
        values.put(DataBaseTableEntry.COLUMN_Q15 ,surveyResultDataBaseModule.Q15 )
        values.put(DataBaseTableEntry.COLUMN_Q15A,surveyResultDataBaseModule.Q15A)
        values.put(DataBaseTableEntry.COLUMN_Q16 ,surveyResultDataBaseModule.Q16 )
        values.put(DataBaseTableEntry.COLUMN_Q16A,surveyResultDataBaseModule.Q16A)
        values.put(DataBaseTableEntry.COLUMN_Q17 ,surveyResultDataBaseModule.Q17 )
        values.put(DataBaseTableEntry.COLUMN_Q17A,surveyResultDataBaseModule.Q17A)
        values.put(DataBaseTableEntry.COLUMN_Q18 ,surveyResultDataBaseModule.Q18 )
        values.put(DataBaseTableEntry.COLUMN_Q19 ,surveyResultDataBaseModule.Q19 )
        values.put(DataBaseTableEntry.COLUMN_Q19A,surveyResultDataBaseModule.Q19A)
        values.put(DataBaseTableEntry.COLUMN_Q20 ,surveyResultDataBaseModule.Q20 )
        values.put(DataBaseTableEntry.COLUMN_Q20A,surveyResultDataBaseModule.Q20A)
        values.put(DataBaseTableEntry.COLUMN_Q21 ,surveyResultDataBaseModule.Q21 )
        values.put(DataBaseTableEntry.COLUMN_Q21A,surveyResultDataBaseModule.Q21A)
        values.put(DataBaseTableEntry.COLUMN_Q22 ,surveyResultDataBaseModule.Q22 )
        values.put(DataBaseTableEntry.COLUMN_Q23 ,surveyResultDataBaseModule.Q23 )
        values.put(DataBaseTableEntry.COLUMN_Q24 ,surveyResultDataBaseModule.Q24 )
        values.put(DataBaseTableEntry.COLUMN_Q25 ,surveyResultDataBaseModule.Q25 )
        values.put(DataBaseTableEntry.COLUMN_Q26 ,surveyResultDataBaseModule.Q26 )
        values.put(DataBaseTableEntry.COLUMN_Q26A,surveyResultDataBaseModule.Q26A)
        values.put(DataBaseTableEntry.COLUMN_Q27 ,surveyResultDataBaseModule.Q27 )
        values.put(DataBaseTableEntry.COLUMN_Q27A,surveyResultDataBaseModule.Q27A)
        values.put(DataBaseTableEntry.COLUMN_Q28 ,surveyResultDataBaseModule.Q28 )
        values.put(DataBaseTableEntry.COLUMN_Q28A,surveyResultDataBaseModule.Q28A)
        values.put(DataBaseTableEntry.COLUMN_Q29 ,surveyResultDataBaseModule.Q29 )
        values.put(DataBaseTableEntry.COLUMN_Q30 ,surveyResultDataBaseModule.Q30 )


        val selection=DataBaseTableEntry.COLUMN_ID + " LIKE ? "
        val selectionArgs= arrayOf(surveyResultDataBaseModule.id)

        db.update(
                DataBaseTableEntry.TabName,
                values,
                selection,
                selectionArgs
        )

    }
}