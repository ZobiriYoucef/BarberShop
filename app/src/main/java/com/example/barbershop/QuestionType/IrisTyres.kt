package com.example.barbershop.QuestionType

import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object IrisTyres {

    object DataBaseTableEntry : BaseColumns {
        const val TabName="SurveyDataTable"
        const val COLUMN_ID  = _ID
        const val COLUMN_I1  ="I1"
        const val COLUMN_I2  ="I2"
        const val COLUMN_I3  ="I3"
        const val COLUMN_I4  ="I4"
        const val COLUMN_I5  ="I5"
        const val COLUMN_I6  ="I6"
        const val COLUMN_I7  ="I7"
        const val COLUMN_Q1  ="Q1"
        const val COLUMN_Q1A ="Q1A"
        const val COLUMN_Q2  ="Q2"
        const val COLUMN_Q3  ="Q3"
        const val COLUMN_Q3A ="Q3A"
        const val COLUMN_Q4  ="Q4"
        const val COLUMN_Q5  ="Q5"
        const val COLUMN_Q6  ="Q6"
        const val COLUMN_Q7  ="Q7"
        const val COLUMN_Q7A ="Q7A"
        const val COLUMN_Q7B ="Q7B"
        const val COLUMN_Q8  ="Q8"
        const val COLUMN_Q8A ="Q8A"
        const val COLUMN_Q9  ="Q9"
        const val COLUMN_Q9A ="Q9A"
        const val COLUMN_Q10 ="Q10"
        const val COLUMN_Q11 ="Q11"
        const val COLUMN_Q12 ="Q12"
        const val COLUMN_Q13 ="Q13"
        const val COLUMN_Q13A="Q13A"
        const val COLUMN_Q14 ="Q14"
        const val COLUMN_Q15 ="Q15"
        const val COLUMN_Q15A="Q15A"
        const val COLUMN_Q16 ="Q16"
        const val COLUMN_Q16A="Q16A"
        const val COLUMN_Q17 ="Q17"
        const val COLUMN_Q17A="Q17A"
        const val COLUMN_Q18 ="Q18"
        const val COLUMN_Q19 ="Q19"
        const val COLUMN_Q19A="Q19A"
        const val COLUMN_Q20 ="Q20"
        const val COLUMN_Q20A="Q20A"
        const val COLUMN_Q21 ="Q21"
        const val COLUMN_Q21A="Q21A"
        const val COLUMN_Q22 ="Q22"
        const val COLUMN_Q23 ="Q23"
        const val COLUMN_Q24 ="Q24"
        const val COLUMN_Q25 ="Q25"
        const val COLUMN_Q26 ="Q26"
        const val COLUMN_Q26A="Q26A"
        const val COLUMN_Q27 ="Q27"
        const val COLUMN_Q27A="Q27A"
        const val COLUMN_Q28 ="Q28"
        const val COLUMN_Q28A="Q28A"
        const val COLUMN_Q29 ="Q29"
        const val COLUMN_Q30 ="Q30"


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
                        "$COLUMN_Q1   TEXT,"+
                        "$COLUMN_Q1A  TEXT,"+
                        "$COLUMN_Q2   TEXT,"+
                        "$COLUMN_Q3   TEXT,"+
                        "$COLUMN_Q3A  TEXT,"+
                        "$COLUMN_Q4   TEXT,"+
                        "$COLUMN_Q5   TEXT,"+
                        "$COLUMN_Q6   TEXT,"+
                        "$COLUMN_Q7   TEXT,"+
                        "$COLUMN_Q7A  TEXT,"+
                        "$COLUMN_Q7B  TEXT,"+
                        "$COLUMN_Q8   TEXT,"+
                        "$COLUMN_Q8A  TEXT,"+
                        "$COLUMN_Q9   TEXT,"+
                        "$COLUMN_Q9A  TEXT,"+
                        "$COLUMN_Q10  TEXT,"+
                        "$COLUMN_Q11  TEXT,"+
                        "$COLUMN_Q12  TEXT,"+
                        "$COLUMN_Q13  TEXT,"+
                        "$COLUMN_Q13A TEXT,"+
                        "$COLUMN_Q14  TEXT,"+
                        "$COLUMN_Q15  TEXT,"+
                        "$COLUMN_Q15A TEXT,"+
                        "$COLUMN_Q16  TEXT,"+
                        "$COLUMN_Q16A TEXT,"+
                        "$COLUMN_Q17  TEXT,"+
                        "$COLUMN_Q17A TEXT,"+
                        "$COLUMN_Q18  TEXT,"+
                        "$COLUMN_Q19  TEXT,"+
                        "$COLUMN_Q19A TEXT,"+
                        "$COLUMN_Q20  TEXT,"+
                        "$COLUMN_Q20A TEXT,"+
                        "$COLUMN_Q21  TEXT,"+
                        "$COLUMN_Q21A TEXT,"+
                        "$COLUMN_Q22  TEXT,"+
                        "$COLUMN_Q23  TEXT,"+
                        "$COLUMN_Q24  TEXT,"+
                        "$COLUMN_Q25  TEXT,"+
                        "$COLUMN_Q26  TEXT,"+
                        "$COLUMN_Q26A TEXT,"+
                        "$COLUMN_Q27  TEXT,"+
                        "$COLUMN_Q27A TEXT,"+
                        "$COLUMN_Q28  TEXT,"+
                        "$COLUMN_Q28A TEXT,"+
                        "$COLUMN_Q29  TEXT,"+
                        "$COLUMN_Q30  TEXT)"

        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TabName"
    }
}