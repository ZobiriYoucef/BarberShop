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
                singleQuestionResultList.add(SingleQuestionResult("Prise en charge par",singleSurveyResult.I1))
                singleQuestionResultList.add(SingleQuestionResult("Date",singleSurveyResult.I2))
                singleQuestionResultList.add(SingleQuestionResult("Nom et Prénom",singleSurveyResult.I3))
                singleQuestionResultList.add(SingleQuestionResult("Société",singleSurveyResult.I4))
                singleQuestionResultList.add(SingleQuestionResult("Fonction",singleSurveyResult.I5))
                singleQuestionResultList.add(SingleQuestionResult("Tél 1" ,singleSurveyResult.I6))
                singleQuestionResultList.add(SingleQuestionResult("Tél 2",singleSurveyResult.I7))
                singleQuestionResultList.add(SingleQuestionResult("E-mail",singleSurveyResult.Q8))
                singleQuestionResultList.add(SingleQuestionResult("Address",singleSurveyResult.I9))
                singleQuestionResultList.add(SingleQuestionResult("Image path PLZ don't modifier ",singleSurveyResult.I10))
                singleQuestionResultList.add(SingleQuestionResult("Catégorie",singleSurveyResult.Q1))
                singleQuestionResultList.add(SingleQuestionResult("Autres Catégorie",singleSurveyResult.Q2))
                singleQuestionResultList.add(SingleQuestionResult("Interss",singleSurveyResult.Q3))
                singleQuestionResultList.add(SingleQuestionResult("Other Interes",singleSurveyResult.Q4))
                singleQuestionResultList.add(SingleQuestionResult("Notes",singleSurveyResult.Q5))
                singleQuestionResultList.add(SingleQuestionResult("Actions",singleSurveyResult.Q6))
                singleQuestionResultList.add(SingleQuestionResult("Other Actions",singleSurveyResult.Q7))
                singleQuestionResultList.add(SingleQuestionResult("Potentiel",singleSurveyResult.Q8))
                singleQuestionResultList.add(SingleQuestionResult("Department",singleSurveyResult.Q9))
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
