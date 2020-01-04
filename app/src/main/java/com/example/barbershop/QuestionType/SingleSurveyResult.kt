package com.example.barbershop.QuestionType

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barbershop.R
import kotlinx.android.synthetic.main.activity_single_survey_result.*

class SingleSurveyResult : AppCompatActivity() {
   lateinit var dataBaseHelperClass: DataBaseHelperClass

    var singleSurveyID:String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_survey_result)
        val singleQuestionResultList=ArrayList<SingleQuestionResult>()
        val singleSurveyAdapter=SingleSurveyAdapter(singleQuestionResultList)

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
                if (singleSurveyResult.Q1A!=""){
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.OthersCarType),singleSurveyResult.Q1A))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatIsYourCarBrand),singleSurveyResult.Q2))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.ModelOfTheCar),singleSurveyResult.Q3))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.RimSize),singleSurveyResult.Q3A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Yearofthevehicle),singleSurveyResult.Q4))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.travelledmiles),singleSurveyResult.Q5))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.AverageMilesByMonth),singleSurveyResult.Q6))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.tirepressure),singleSurveyResult.Q7))
                if (singleSurveyResult.Q7A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q7A))
                }
                if (singleSurveyResult.Q7B!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowMany),singleSurveyResult.Q7B))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.TyresProvider),singleSurveyResult.Q8))
                if (singleSurveyResult.Q8A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowMany),singleSurveyResult.Q8A))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.ChangeYourTires),singleSurveyResult.Q9))
                if (singleSurveyResult.Q9A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q9A))
                }
                if (singleSurveyResult.Q10!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IFmileage),singleSurveyResult.Q10))
                }
                if (singleSurveyResult.Q11!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IFperiod),singleSurveyResult.Q11))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HaveYouChangedYourTires),singleSurveyResult.Q12))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhyHaveYouChange),singleSurveyResult.Q13))
                if (singleSurveyResult.Q13A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q13A))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowManyHaveYouChange),singleSurveyResult.Q14))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HabitOfChange),singleSurveyResult.Q15))
                if (singleSurveyResult.Q15A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q15A))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatWasFirstTyresBrand),singleSurveyResult.Q16))
                if (singleSurveyResult.Q16A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q16A))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatWasSecondTyresBrand),singleSurveyResult.Q17))
                if (singleSurveyResult.Q17A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q17A))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhyThisTyresBrand),singleSurveyResult.Q18))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhatWasThePrice),singleSurveyResult.Q19))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.ThisPriceIsForHowManyTyre),singleSurveyResult.Q19A))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.sinceWhen),singleSurveyResult.Q20))
                if (singleSurveyResult.Q20A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IfYouHaveToChangeTyres),singleSurveyResult.Q20A))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.importantCriterion),singleSurveyResult.Q21))
                if (singleSurveyResult.Q21A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q21A))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.budgetForBuying),singleSurveyResult.Q22))
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.DoYouKnowIris),singleSurveyResult.Q23))
                if (singleSurveyResult.Q24!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.DidYouKnowThatIrisProduces),singleSurveyResult.Q24))
                }
                if (singleSurveyResult.Q25!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IfIrisFlowEuropeIso),singleSurveyResult.Q25))
                }
                if (singleSurveyResult.Q26!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhyIris),singleSurveyResult.Q26))
                }
                if (singleSurveyResult.Q26A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q26A))
                }
                if (singleSurveyResult.Q27!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.WhyNotIris),singleSurveyResult.Q27))
                }
                if (singleSurveyResult.Q27A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q27A))
                }
                if (singleSurveyResult.Q28!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.HowWeCanChangeYourMind),singleSurveyResult.Q28))
                }
                if (singleSurveyResult.Q28A!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.Others),singleSurveyResult.Q28A))
                }
                if (singleSurveyResult.Q29!=""){
                    singleQuestionResultList.add(SingleQuestionResult(getString(R.string.IfWeToldYouThatIrisExport),singleSurveyResult.Q29))
                }
                singleQuestionResultList.add(SingleQuestionResult(getString(R.string.expectationsFromIris),singleSurveyResult.Q30))

            }
        }

        SingleSurveyRecyclerView.layoutManager= LinearLayoutManager(this)
        SingleSurveyRecyclerView.adapter=singleSurveyAdapter

    }
}
