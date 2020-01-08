package com.example.barbershop.QuestionType

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.barbershop.R
import kotlinx.android.synthetic.main.activity_single_survey_result.*

class SingleSurveyResult : AppCompatActivity() {
   lateinit var dataBaseHelperClass: DataBaseHelperClass
    var checkChange:Boolean=false
    var singleSurveyID:String? =null

    val updatedsingleQuestionResult=ArrayList<String>()

    val singleQuestionResultList=ArrayList<SingleQuestionResult>()
    val singleSurveyAdapter=SingleSurveyAdapter(this,singleQuestionResultList,updatedsingleQuestionResult,checkChange)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_survey_result)


        dataBaseHelperClass= DataBaseHelperClass(this)


        val bundle=intent.extras
        bundle?.let {
            singleSurveyID= it.getString(IrisTyres.DataBaseTableEntry.COLUMN_ID)
            val singleSurveyResult=DataManger.fetchASingleResponse(dataBaseHelperClass,singleSurveyID!!)

            singleSurveyResult?.let {
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.NameOfInvestigator),singleSurveyResult.I1))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.EquityIdentifier),singleSurveyResult.I2))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Region),singleSurveyResult.I3))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Sex),singleSurveyResult.I4))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.YourAge),singleSurveyResult.I5))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.DoYouWork),singleSurveyResult.I6))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.CSP),singleSurveyResult.I7))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.typeofvehicle),singleSurveyResult.Q1))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.OthersCarType),singleSurveyResult.Q1A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatIsYourCarBrand),singleSurveyResult.Q2))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.ModelOfTheCar),singleSurveyResult.Q3))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.RimSize),singleSurveyResult.Q3A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Yearofthevehicle),singleSurveyResult.Q4))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.travelledmiles),singleSurveyResult.Q5))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.AverageMilesByMonth),singleSurveyResult.Q6))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.tirepressure),singleSurveyResult.Q7))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q7A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowMany),singleSurveyResult.Q7B))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.TyresProvider),singleSurveyResult.Q8))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowMany),singleSurveyResult.Q8A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.ChangeYourTires),singleSurveyResult.Q9))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q9A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IFmileage),singleSurveyResult.Q10))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IFperiod),singleSurveyResult.Q11))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HaveYouChangedYourTires),singleSurveyResult.Q12))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhyHaveYouChange),singleSurveyResult.Q13))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q13A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowManyHaveYouChange),singleSurveyResult.Q14))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HabitOfChange),singleSurveyResult.Q15))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q15A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatWasFirstTyresBrand),singleSurveyResult.Q16))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q16A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatWasSecondTyresBrand),singleSurveyResult.Q17))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q17A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhyThisTyresBrand),singleSurveyResult.Q18))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatWasThePrice),singleSurveyResult.Q19))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.ThisPriceIsForHowManyTyre),singleSurveyResult.Q19A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.sinceWhen),singleSurveyResult.Q20))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IfYouHaveToChangeTyres),singleSurveyResult.Q20A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.importantCriterion),singleSurveyResult.Q21))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q21A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.budgetForBuying),singleSurveyResult.Q22))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.DoYouKnowIris),singleSurveyResult.Q23))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.DidYouKnowThatIrisProduces),singleSurveyResult.Q24))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IfIrisFlowEuropeIso),singleSurveyResult.Q25))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhyIris),singleSurveyResult.Q26))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q26A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhyNotIris),singleSurveyResult.Q27))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q27A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowWeCanChangeYourMind),singleSurveyResult.Q28))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q28A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IfWeToldYouThatIrisExport),singleSurveyResult.Q29))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.expectationsFromIris),singleSurveyResult.Q30))
            }
        }

        singleQuestionResultList?.let {
            for (item in singleQuestionResultList){
                updatedsingleQuestionResult.add(item.questionResult)
            }
        }

        SingleSurveyRecyclerView.layoutManager= LinearLayoutManager(this)
        SingleSurveyRecyclerView.adapter=singleSurveyAdapter
    }

    override fun onBackPressed() {
        if(singleSurveyAdapter.getSurveyDataCheckChange()) {
            //Toast.makeText(this,singleSurveyAdapter.getupdatedsingleQuestionResult().toString(), Toast.LENGTH_LONG).show()

            SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Answers changes was detected")
                    .setContentText("Won't be able to recover this changes!")
                    .setConfirmText("Yes,save it!")
                    .setCancelText("No,cancel plx!")
                    .setConfirmClickListener { sDialog ->

                        saveUpdatedSingleSurveyResult(singleSurveyAdapter.getupdatedsingleQuestionResult())
                        sDialog
                                .setTitleText("Successfully Saved")
                                .setContentText("Your Modification to the Survey Answers has ben successfully saved")
                                .setConfirmText("OK")
                                .showCancelButton(false)
                                .setConfirmClickListener{ sDialog ->
                                    sDialog.dismissWithAnimation()
                                    setResult(Activity.RESULT_OK, Intent())
                                    super.onBackPressed()}
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE)
                    }
                    .setCancelClickListener { sDialog ->
                        sDialog.dismiss()
                        super.onBackPressed()
                    }
                    .show()


        }else{
            super.onBackPressed()
        }
    }

    fun saveUpdatedSingleSurveyResult(updatedValueString:ArrayList<String>){

        val updatedSurveyModul=SurveyResultDataBaseModule(
                id = singleSurveyID!!,
                I1 = updatedValueString[0],
                I2 = updatedValueString[1],
                I3 = updatedValueString[2],
                I4 = updatedValueString[3],
                I5 = updatedValueString[4],
                I6 = updatedValueString[5],
                I7 = updatedValueString[6],
                Q1 = updatedValueString[7],
               Q1A = updatedValueString[8],
               Q2 =  updatedValueString[9],
               Q3 =  updatedValueString[10],
               Q3A = updatedValueString[11],
               Q4 =  updatedValueString[12],
               Q5 =  updatedValueString[13],
               Q6 =  updatedValueString[14],
               Q7 =  updatedValueString[15],
               Q7A = updatedValueString[16],
               Q7B = updatedValueString[17],
               Q8 =  updatedValueString[18],
               Q8A = updatedValueString[19],
               Q9 =  updatedValueString[20],
               Q9A = updatedValueString[21],
               Q10 = updatedValueString[22],
               Q11 = updatedValueString[23],
               Q12 = updatedValueString[24],
               Q13 = updatedValueString[25],
               Q13A =updatedValueString[26],
               Q14 = updatedValueString[27],
               Q15 = updatedValueString[28],
               Q15A =updatedValueString[29],
               Q16 = updatedValueString[30],
               Q16A =updatedValueString[31],
               Q17 = updatedValueString[32],
               Q17A =updatedValueString[33],
               Q18 = updatedValueString[34],
               Q19 = updatedValueString[35],
               Q19A =updatedValueString[36],
               Q20 = updatedValueString[37],
               Q20A =updatedValueString[38],
               Q21 = updatedValueString[39],
               Q21A =updatedValueString[40],
               Q22 = updatedValueString[41],
               Q23 = updatedValueString[42],
               Q24 = updatedValueString[43],
               Q25 = updatedValueString[44],
               Q26 = updatedValueString[45],
               Q26A =updatedValueString[46],
               Q27 = updatedValueString[47],
               Q27A =updatedValueString[48],
               Q28 = updatedValueString[49],
               Q28A =updatedValueString[50],
               Q29 = updatedValueString[51],
               Q30 = updatedValueString[52]
        )

        DataManger.upDateASingleResponse(dataBaseHelperClass,updatedSurveyModul)
    }


}
