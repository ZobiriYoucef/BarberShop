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
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.typeofvehicle),singleSurveyResult.Q8))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.OthersCarType),singleSurveyResult.I9))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.OthersCarType),singleSurveyResult.I10))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatIsYourCarBrand),singleSurveyResult.Q1))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.ModelOfTheCar),singleSurveyResult.Q2))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.RimSize),singleSurveyResult.Q3))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Yearofthevehicle),singleSurveyResult.Q4))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.travelledmiles),singleSurveyResult.Q5))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.AverageMilesByMonth),singleSurveyResult.Q6))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.tirepressure),singleSurveyResult.Q7))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q8))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowMany),singleSurveyResult.Q9))
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
                                    finish()}
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE)
                    }
                    .setCancelClickListener { sDialog ->
                        sDialog.dismiss()
                        finish()
                    }
                    .show()


        }else{
            finish()
        }
    }

    fun saveUpdatedSingleSurveyResult(updatedValueString:ArrayList<String>){

        val updatedSurveyModul=SurveyResultDataBaseModule(
                id = singleSurveyID!!,
               I1  = updatedValueString[0],
               I2  = updatedValueString[1],
               I3  = updatedValueString[2],
               I4  = updatedValueString[3],
               I5  = updatedValueString[4],
               I6  = updatedValueString[5],
               I7  = updatedValueString[6],
               I8  = updatedValueString[7],
               I9  = updatedValueString[8],
               I10 =  updatedValueString[9],
               Q1  =  updatedValueString[10],
               Q2  = updatedValueString[11],
               Q3  =  updatedValueString[12],
               Q4  =  updatedValueString[13],
               Q5  =  updatedValueString[14],
               Q6  =  updatedValueString[15],
               Q7  = updatedValueString[16],
               Q8  = updatedValueString[17],
               Q9  =  updatedValueString[18]
        )

        DataManger.upDateASingleResponse(dataBaseHelperClass,updatedSurveyModul)
    }


}
