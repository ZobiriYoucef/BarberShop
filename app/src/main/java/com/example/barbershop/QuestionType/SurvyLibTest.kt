package com.example.barbershop.QuestionType

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.barbershop.R
import com.quickbirdstudios.surveykit.*
import com.quickbirdstudios.surveykit.result.StepResult
import com.quickbirdstudios.surveykit.result.TaskResult
import com.quickbirdstudios.surveykit.steps.CompletionStep
import com.quickbirdstudios.surveykit.steps.InstructionStep
import com.quickbirdstudios.surveykit.steps.QuestionStep
import com.quickbirdstudios.surveykit.steps.Step
import com.quickbirdstudios.surveykit.survey.SurveyView
import com.shashank.sony.fancytoastlib.FancyToast
import java.util.*
import kotlin.collections.ArrayList

open class SurvyLibTest : AppCompatActivity() {
    protected lateinit var survey: SurveyView
    private lateinit var container: ViewGroup
    private lateinit var dataBaseHelper:DataBaseHelperClass

    lateinit var introStep: InstructionStep
    lateinit var I1: QuestionStep
    lateinit var I2: QuestionStep
    lateinit var I3: QuestionStep
    lateinit var I4: QuestionStep
    lateinit var I5: QuestionStep
    lateinit var I6: QuestionStep
    lateinit var I7: QuestionStep
    lateinit var Q1: QuestionStep
    lateinit var Q1A: QuestionStep
    lateinit var Q2: QuestionStep

    //Car Brand
    lateinit var Q2Audi         : QuestionStep
    lateinit var Q2Dacia        : QuestionStep
    lateinit var Q2Citron        : QuestionStep
    lateinit var Q2Bmw          : QuestionStep
    lateinit var Q2Chevrolet    : QuestionStep


    lateinit var Q3: QuestionStep
    lateinit var Q3A: QuestionStep
    lateinit var Q4: QuestionStep
    lateinit var Q5: QuestionStep
    lateinit var Q6: QuestionStep
    lateinit var Q7: QuestionStep
    lateinit var Q7A: QuestionStep
    lateinit var Q7B: QuestionStep
    lateinit var Q8: QuestionStep
    lateinit var Q8A: QuestionStep
    lateinit var Q9: QuestionStep
    lateinit var Q9A: QuestionStep
    lateinit var Q10: QuestionStep
    lateinit var Q11: QuestionStep
    lateinit var Q12: QuestionStep
    lateinit var Q13: QuestionStep
    lateinit var Q13A: QuestionStep
    lateinit var Q14: QuestionStep
    lateinit var Q15: QuestionStep
    lateinit var Q15A: QuestionStep
    lateinit var Q16: QuestionStep
    lateinit var Q16A: QuestionStep
    lateinit var Q17: QuestionStep
    lateinit var Q17A: QuestionStep
    lateinit var Q18: QuestionStep
    lateinit var Q19: QuestionStep
    lateinit var Q19A: QuestionStep
    lateinit var Q20: QuestionStep
    lateinit var Q20A: QuestionStep
    lateinit var Q21: QuestionStep
    lateinit var Q21A: QuestionStep
    lateinit var Q22: QuestionStep
    lateinit var Q23: QuestionStep
    lateinit var Q24: QuestionStep
    lateinit var Q25: QuestionStep
    lateinit var Q26: QuestionStep
    lateinit var Q26A: QuestionStep
    lateinit var Q27: QuestionStep
    lateinit var Q27A: QuestionStep
    lateinit var Q28: QuestionStep
    lateinit var Q28A: QuestionStep
    lateinit var Q29: QuestionStep
    lateinit var Q30: QuestionStep
    lateinit var completionStep: CompletionStep
    lateinit var allSteps: List<Step>

    lateinit var questionResult:ArrayList<String>
    lateinit var questionRID:ArrayList<String>
    lateinit var questionR:ArrayList<String>
    lateinit var questionIdCopy:ArrayList<String>

    lateinit var Temp:String

    //lateinit var Q2ModulList:List<TextChoice>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survy_lib_test)

        Temp= ""

        title = "ADD A NEW SURVEY"

        questionResult=ArrayList()
        questionR= ArrayList()
        questionRID= ArrayList()
        questionIdCopy=ArrayList()

        setupSteps()

        dataBaseHelper= DataBaseHelperClass(this)

        survey = findViewById(R.id.survey_view)
        container = findViewById(R.id.surveyContainer)

        setupSurvey(survey)




    }

    private fun setupSurvey(surveyView: SurveyView) {

        var task = NavigableOrderedTask(steps = allSteps)

        task.setNavigationRule(
                Q1.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q1A.id
                                else -> Q2.id
                            }
                        }
                )
        )
        task.setNavigationRule(
                I6.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.No) -> Q1.id
                                getString(R.string.Retierd)  -> Q1.id
                                else -> I7.id
                            }
                        }
                )
        )

        /* TODO : Complete The Car Brand Task Rules */
        task.setNavigationRule(
                Q2.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                "0" -> Q2Audi.id
                                "1" -> Q2Bmw.id
                                "4" -> Q2Chevrolet.id
                                "5" -> Q2Citron.id
                                "6" -> Q2Dacia.id
                                else -> Q3.id
                            }
                        }
                )
        )
        task.setNavigationRule(
                Q2Audi.id,
                NavigationRule.DirectStepNavigationRule(
                        destinationStepStepIdentifier = Q3A.id
                )
        )

        task.setNavigationRule(
                Q8.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q8A.id
                                else -> Q9.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q7.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q7A.id
                                getString(R.string.traget)->Q8.id
                                getString(R.string.deflated)->Q8.id
                                getString(R.string.vibration)->Q8.id
                                else -> Q7B.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q9.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q9A.id
                                getString(R.string.Mileage)->Q10.id
                                getString(R.string.duration)->Q11.id
                                getString(R.string.levelOfWear)->Q12.id
                                getString(R.string.ByTheSaison)->Q12.id
                                else -> null
                            }
                        }
                )
        )
        task.setNavigationRule(
                Q9A.id,
                NavigationRule.DirectStepNavigationRule(
                        destinationStepStepIdentifier = Q12.id
                )
        )

        task.setNavigationRule(
                Q10.id,
                NavigationRule.DirectStepNavigationRule(
                        destinationStepStepIdentifier = Q12.id
                )
        )

        task.setNavigationRule(
                Q12.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Yes) -> Q13.id
                                getString(R.string.No) ->Q20A.id
                                else -> null
                            }
                        }
                )
        )
        task.setNavigationRule(
                Q13.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others)-> Q13A.id
                                else -> Q14.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q15.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q15A.id
                                else -> Q16.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q16.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                               getString(R.string.Others) -> Q16A.id
                                else -> Q17.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q17.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q17A.id
                                else -> Q18.id
                            }
                        }
                )
        )
        task.setNavigationRule(
                Q20.id,
                NavigationRule.DirectStepNavigationRule(
                        destinationStepStepIdentifier = Q21.id
                )
        )

        task.setNavigationRule(
                Q21.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q21A.id
                                else -> Q22.id
                            }
                        }
                )
        )
        task.setNavigationRule(
                Q23.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                 getString(R.string.Yes) -> Q24.id
                                 getString(R.string.No)  -> Q25.id
                                else -> null
                            }
                        }
                )
        )
        task.setNavigationRule(
                Q25.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Yes) -> Q26.id
                                getString(R.string.No) -> Q27.id
                                else -> null
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q26.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q26A.id
                                else -> Q30.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q26A.id,
                NavigationRule.DirectStepNavigationRule(
                        destinationStepStepIdentifier = Q30.id
                )
        )

        task.setNavigationRule(
                Q27.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q27A.id
                                else -> Q28.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q28.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> Q28A.id
                                else -> Q29.id
                            }
                        }
                )
        )

        surveyView.onStepResult={step: Step?, stepResult: StepResult? ->
            if (step?.id==Q2.id && stepResult?.id==Q2.id){
                Toast.makeText(this@SurvyLibTest, stepResult.results[0].stringIdentifier, Toast.LENGTH_LONG).show()
                Temp=stepResult.results[0].stringIdentifier

            }
        }




        surveyView.onSurveyFinish = { taskResult: TaskResult, reason: FinishReason ->
            if (reason == FinishReason.Completed) {
                /*val intent = Intent(this, StartASurvey::class.java)
                intent.putExtra("TaskResult", taskResult)
                startActivity(intent)
                finish()
                container.removeAllViews()*/

                val taskIdentifier: TaskIdentifier =taskResult.id
                val taskStartDate: Date =taskResult.startDate
                val taskEndDate: Date =taskResult.endDate

                taskResult.results.forEach { stepResult ->
                    stepResult.results.forEach{questionResult->

                        questionR.add(questionResult.stringIdentifier)
                    }
                }

                taskResult.results.forEach { stepResult ->
                    questionRID.add(stepResult.id.id)
                }

                for (i in 0 until questionResult.size){
                    for(j in 0 until questionRID.size){
                        if (questionResult.get(i)==questionRID.get(j)){
                            questionResult.set(i,questionR.get(j))
                        }
                    }
                }

                for (i in 0 until questionResult.size){
                    for(j in 0 until questionIdCopy.size){
                        if (questionResult.get(i)==questionIdCopy.get(j)){
                            questionResult.set(i,"")
                        }
                    }
                }



                val db=dataBaseHelper.writableDatabase

                val values = ContentValues()

                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I1  ,questionResult[1])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I2  ,questionResult[2])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I3  ,questionResult[3])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I4  ,questionResult[4])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I5  ,questionResult[5])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I6  ,questionResult[6])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I7  ,questionResult[7])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q1  ,questionResult[8])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q1A ,questionResult[9])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q2  ,questionResult[10])

                // For The Car Brand
                when (Temp){
                    "0"->values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3  ,questionResult[11])
                    "1"->values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3  ,questionResult[12])
                    "4"-> values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3  ,questionResult[13])
                    "5"->values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3  ,questionResult[14])
                    "6"->values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3  ,questionResult[15])
                    else ->values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3  ,questionResult[16])
                }


                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3A ,questionResult[17])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q4  ,questionResult[18])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q5  ,questionResult[19])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q6  ,questionResult[20])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q7  ,questionResult[21])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q7A ,questionResult[22])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q7B ,questionResult[23])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q8  ,questionResult[24])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q8A ,questionResult[25])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q9  ,questionResult[26])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q9A ,questionResult[27])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q10 ,questionResult[28])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q11 ,questionResult[29])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q12 ,questionResult[30])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q13 ,questionResult[31])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q13A,questionResult[32])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q14 ,questionResult[33])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q15 ,questionResult[34])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q15A,questionResult[35])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q16 ,questionResult[36])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q16A,questionResult[37])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q17 ,questionResult[38])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q17A,questionResult[39])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q18 ,questionResult[40])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q19 ,questionResult[41])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q19A,questionResult[42])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q20 ,questionResult[43])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q20A,questionResult[44])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q21 ,questionResult[45])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q21A,questionResult[46])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q22 ,questionResult[47])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q23 ,questionResult[48])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q24 ,questionResult[49])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q25 ,questionResult[50])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q26 ,questionResult[51])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q26A,questionResult[52])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q27 ,questionResult[53])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q27A,questionResult[54])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q28 ,questionResult[55])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q28A,questionResult[56])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q29 ,questionResult[57])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q30 ,questionResult[58])

                val resultRowId=db.insert(IrisTyres.DataBaseTableEntry.TabName,null,values)

                setResult(Activity.RESULT_OK, Intent())

                FancyToast.makeText(this,resultRowId.toString(), FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show()
            }
            if (reason == FinishReason.Discarded){
                Toast.makeText(this@SurvyLibTest, "Discarded", Toast.LENGTH_LONG).show()
            }
            if (reason == FinishReason.Failed){
                Toast.makeText(this@SurvyLibTest, "Failed", Toast.LENGTH_LONG).show()
                finish()
            }
            if (reason == FinishReason.Saved) {
                Toast.makeText(this@SurvyLibTest, "Saved", Toast.LENGTH_LONG).show()
            }

            finish()
        }

        val configuration = SurveyTheme(
                themeColorDark = ContextCompat.getColor(this, R.color.black),
                themeColor = ContextCompat.getColor(this, R.color.Orange),
                textColor = ContextCompat.getColor(this, R.color.Orange)
        )

        surveyView.start(task, configuration)
    }


    private fun setupSteps() {
        introStep = InstructionStep(
                title = this.resources.getString(R.string.SurveyTitle),
                text = this.resources.getString(R.string.SurveyDescription)
        )
        I1 = QuestionStep(
                title = getString(R.string.NameOfInvestigator),
                text = "",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        I2 = QuestionStep(
                title = getString(R.string.EquityIdentifier),
                text = getString(R.string.PhoneNumber),
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.PlzEnterYOurPhoneNumber)
                )
        )
        I3 = QuestionStep(
                title = getString(R.string.Region),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.West)),
                                TextChoice(getString(R.string.Centre)),
                                TextChoice(getString(R.string.Est))
                        )
                )
        )
        I4 = QuestionStep(
                title = getString(R.string.Sex),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.Man)),
                                TextChoice(getString(R.string.Woman))
                        )
                )
        )
        I5 = QuestionStep(
                title = getString(R.string.YourAge),
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.PleaseEnterYourAge)
                )
        )
        I6 = QuestionStep(
                title = getString(R.string.DoYouWork),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.Yes)),
                                TextChoice(getString(R.string.No)) ,
                                TextChoice(getString(R.string.Retierd))
                        )
                )
        )
        I7 = QuestionStep(
                title = getString(R.string.CSP),
                text = getString(R.string.monthlyIncome),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.A)),
                                TextChoice(getString(R.string.B)),
                                TextChoice(getString(R.string.C)),
                                TextChoice(getString(R.string.D)))
                )
        )
        Q1 = QuestionStep(
                title = getString(R.string.typeofvehicle),
                text = getString(R.string.MultiChoose),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.Tourist)),
                                TextChoice(getString(R.string.SUV)),
                                TextChoice(getString(R.string.Utility)),
                                TextChoice(getString(R.string.Others))
                        )
                )
        )
        Q1A = QuestionStep(
                title = getString(R.string.OthersCarType),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5)
        )
        Q2 = QuestionStep(
                title = getString(R.string.WhatIsYourCarBrand),
                text = "",
                answerFormat = AnswerFormat.ImageSelectorFormat(
                        numberOfColumns = 5,
                        defaultSelectedImagesIndices= listOf(0),
                        imageChoiceList = listOf(
                                ImageChoice(R.drawable.audi),
                                ImageChoice(R.drawable.bmw),
                                ImageChoice(R.drawable.byd),
                                ImageChoice(R.drawable.chery),
                                ImageChoice(R.drawable.chevrolet),
                                ImageChoice(R.drawable.citron),
                                ImageChoice(R.drawable.dacia),
                                ImageChoice(R.drawable.daihatsu),
                                ImageChoice(R.drawable.dfm),
                                ImageChoice(R.drawable.dfsk),
                                ImageChoice(R.drawable.fiat),
                                ImageChoice(R.drawable.ford),
                                ImageChoice(R.drawable.hyundai),
                                ImageChoice(R.drawable.kia),
                                ImageChoice(R.drawable.land),
                                ImageChoice(R.drawable.lifan),
                                ImageChoice(R.drawable.mahindra),
                                ImageChoice(R.drawable.mazda),
                                ImageChoice(R.drawable.mercedes),
                                ImageChoice(R.drawable.mg),
                                ImageChoice(R.drawable.mini),
                                ImageChoice(R.drawable.mitsubishi),
                                ImageChoice(R.drawable.nissan),
                                ImageChoice(R.drawable.opel),
                                ImageChoice(R.drawable.peugeot),
                                ImageChoice(R.drawable.renault),
                                ImageChoice(R.drawable.seat),
                                ImageChoice(R.drawable.skoda),
                                ImageChoice(R.drawable.suzuki),
                                ImageChoice(R.drawable.toyota),
                                ImageChoice(R.drawable.volkswagen),
                                ImageChoice(R.drawable.other)
                        )
                )
        )


        /*TODO: Complete The car brand */
        // Cars Brand Fuck

        Q2Audi=QuestionStep(
                title = "Quel est le model de votre Audi",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices =CarBrand.AudiList)
                )

        Q2Bmw=QuestionStep(
                title = "Quel est le model de votre Audi",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices =CarBrand.BMWList)
        )

        Q2Chevrolet=QuestionStep(  //4
                title = "Quel est le model de votre Audi",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices =CarBrand.BMWList)
        )

        Q2Citron=QuestionStep( //5
                title = "Quel est le model de votre Audi",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices =CarBrand.BMWList)
        )

        Q2Dacia=QuestionStep( //6
                title = "Quel est le model de votre Audi",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices =CarBrand.BMWList)
        )






        Q3 = QuestionStep(
                title = getString(R.string.ModelOfTheCar),
                text = "",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q3A = QuestionStep(
                title = getString(R.string.RimSize),
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.RimExp)
                )
        )
        Q4 = QuestionStep(
                title = getString(R.string.Yearofthevehicle),
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.YearExp)
                )
        )
        Q5 = QuestionStep(
                title = getString(R.string.travelledmiles),
                text = getString(R.string.x1000Km),
                /*answerFormat = AnswerFormat.ValuePickerAnswerFormat(
                        choices = (20..300).toList().map { it.toString() },
                        defaultValue = 70.toString()
                )*/
                        answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.InKm)
                        )
        )
        Q6 = QuestionStep(
                title = getString(R.string.AverageMilesByMonth),
                text = "",
                /*answerFormat = AnswerFormat.ValuePickerAnswerFormat(
                        choices = (300..2000).toList().map { it.toString() },
                        defaultValue = 500.toString()
                )*/
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.InKm)
                )

        )
        Q7 = QuestionStep(
                title = getString(R.string.tirepressure),
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.ByMonth)),
                                TextChoice(getString(R.string.Byweek)),
                                TextChoice(getString(R.string.ByDay)),
                                TextChoice(getString(R.string.traget)),
                                TextChoice(getString(R.string.deflated)),
                                TextChoice(getString(R.string.vibration)) ,
                                TextChoice(getString(R.string.Others))
                        )
                )
        )
        Q7A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5)
        )
        Q7B = QuestionStep(
                title = getString(R.string.HowMany),
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = ""
                )
        )
        Q8 = QuestionStep(
                title = getString(R.string.TyresProvider),
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.Vulcanisateurs)),
                                TextChoice(getString(R.string.SpecializedMechanical)),
                                TextChoice(getString(R.string.AccreditedAgent)),
                                TextChoice(getString(R.string.Others))
                        )
                )
        )
        Q8A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5)
        )
        Q9 = QuestionStep(
                title = getString(R.string.ChangeYourTires),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.Mileage)),
                                TextChoice(getString(R.string.duration)),
                                TextChoice(getString(R.string.levelOfWear)),
                                TextChoice(getString(R.string.ByTheSaison)),
                                TextChoice(getString(R.string.Others))
                        )
                )
        )
        Q9A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q10 = QuestionStep(
                title = getString(R.string.IFmileage),
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.InKm)
                )
        )
        Q11 = QuestionStep(
                title = getString(R.string.IFperiod),
                text = getString(R.string.InMonth),
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.Month)
                )
        )
        Q12 = QuestionStep(
                title = getString(R.string.HaveYouChangedYourTires),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.Yes)),
                                TextChoice(getString(R.string.No))
                        )
                )
        )
        Q13 = QuestionStep(
                title = getString(R.string.WhyHaveYouChange),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.WhyChange1)),
                                TextChoice(getString(R.string.WhyChange2)),
                                TextChoice(getString(R.string.WhyChange3)),
                                TextChoice(getString(R.string.WhyChange4)),
                                TextChoice(getString(R.string.WhyChange5)),
                                TextChoice(getString(R.string.WhyChange6)),
                                TextChoice(getString(R.string.WhyChange7)),
                                TextChoice(getString(R.string.WhyChange8)),
                                TextChoice(getString(R.string.WhyChange9)),
                                TextChoice(getString(R.string.Others))
                        )
                )
        )
        Q13A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q14 = QuestionStep(
                title = getString(R.string.HowManyHaveYouChange),
                text = "",
                answerFormat = AnswerFormat.ScaleAnswerFormat(
                        minimumValue = 1,
                        maximumValue = 4,
                        minimumValueDescription = "",
                        maximumValueDescription = "",
                        step = 1f,
                        defaultValue = 4
                )
        )
        Q15 = QuestionStep(
                title = getString(R.string.HabitOfChange),
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.Habit1)),
                                TextChoice(getString(R.string.Habit2)),
                                TextChoice(getString(R.string.Habit3)),
                                TextChoice(getString(R.string.Others))
                        )
                )
        )
        Q15A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q16 = QuestionStep(
                title = getString(R.string.WhatWasFirstTyresBrand),
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.TyresBrand1)),
                                TextChoice(getString(R.string.TyresBrand2)),
                                TextChoice(getString(R.string.TyresBrand3)),
                                TextChoice(getString(R.string.TyresBrand4)),
                                TextChoice(getString(R.string.TyresBrand5)),
                                TextChoice(getString(R.string.TyresBrand6)),
                                TextChoice(getString(R.string.TyresBrand7)),
                                TextChoice(getString(R.string.TyresBrand8)),
                                TextChoice(getString(R.string.TyresBrand9)),
                                TextChoice(getString(R.string.TyresBrand10)),
                                TextChoice(getString(R.string.ChinisTyresBrand)),
                                TextChoice(getString(R.string.ForgetTyresBrand)),
                                TextChoice(getString(R.string.Others))

                        )
                )
        )
        Q16A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q17 = QuestionStep(
                title = getString(R.string.WhatWasSecondTyresBrand),
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.TyresBrand1)),
                                TextChoice(getString(R.string.TyresBrand2)),
                                TextChoice(getString(R.string.TyresBrand3)),
                                TextChoice(getString(R.string.TyresBrand4)),
                                TextChoice(getString(R.string.TyresBrand5)),
                                TextChoice(getString(R.string.TyresBrand6)),
                                TextChoice(getString(R.string.TyresBrand7)),
                                TextChoice(getString(R.string.TyresBrand8)),
                                TextChoice(getString(R.string.TyresBrand9)),
                                TextChoice(getString(R.string.TyresBrand10)),
                                TextChoice(getString(R.string.ChinisTyresBrand)),
                                TextChoice(getString(R.string.ForgetTyresBrand)),
                                TextChoice(getString(R.string.Others))
                        )
                )
        )
        Q17A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q18 = QuestionStep(
                title = getString(R.string.WhyThisTyresBrand),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.WhyThisTyresBrand0)),
                                TextChoice(getString(R.string.WhyThisTyresBrand1)),
                                TextChoice(getString(R.string.WhyThisTyresBrand2)),
                                TextChoice(getString(R.string.WhyThisTyresBrand3)),
                                TextChoice(getString(R.string.WhyThisTyresBrand4)),
                                TextChoice(getString(R.string.WhyThisTyresBrand5)),
                                TextChoice(getString(R.string.WhyThisTyresBrand6)),
                                TextChoice(getString(R.string.WhyThisTyresBrand7)),
                                TextChoice(getString(R.string.WhyThisTyresBrand8)),
                                TextChoice(getString(R.string.WhyThisTyresBrand9)),
                                TextChoice(getString(R.string.WhyThisTyresBrand10)),
                                TextChoice(getString(R.string.WhyThisTyresBrand11)),
                                TextChoice(getString(R.string.WhyThisTyresBrand12))
                        ))
        )
        Q19 = QuestionStep(
                title = getString(R.string.WhatWasThePrice),
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.InDZD)
                )
        )
        Q19A = QuestionStep(
                title = getString(R.string.ThisPriceIsForHowManyTyre),
                text = "",
                answerFormat = AnswerFormat.ScaleAnswerFormat(
                        minimumValue = 1,
                        maximumValue = 4,
                        minimumValueDescription = "",
                        maximumValueDescription = "",
                        step = 1f,
                        defaultValue = 1
                )
        )
        Q20 = QuestionStep(
                title = getString(R.string.sinceWhen),
                text = getString(R.string.InMonth),
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.Month)
                )
        )
        Q20A = QuestionStep(
                title = getString(R.string.IfYouHaveToChangeTyres),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.Habit1)),
                                TextChoice(getString(R.string.Habit2)),
                                TextChoice(getString(R.string.Habit3))
                        )
                )
        )

        Q21 = QuestionStep(
                title = getString(R.string.importantCriterion),
                text = getString(R.string.MultiChoose),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                               TextChoice(getString(R.string.WhyThisTyresBrand0)),
                               TextChoice(getString(R.string.WhyThisTyresBrand1)),
                               TextChoice(getString(R.string.WhyThisTyresBrand2)),
                               TextChoice(getString(R.string.WhyThisTyresBrand3)),
                               TextChoice(getString(R.string.WhyThisTyresBrand4)),
                               TextChoice(getString(R.string.WhyThisTyresBrand5)),
                               TextChoice(getString(R.string.WhyThisTyresBrand6)),
                               TextChoice(getString(R.string.WhyThisTyresBrand7)),
                               TextChoice(getString(R.string.WhyThisTyresBrand8)),
                               TextChoice(getString(R.string.WhyThisTyresBrand9)),
                               TextChoice(getString(R.string.WhyThisTyresBrand10)),
                               TextChoice(getString(R.string.WhyThisTyresBrand11)),
                               TextChoice(getString(R.string.WhyThisTyresBrand12)),
                               TextChoice(getString(R.string.Others))
                        )
                )
        )

        Q21A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )

        Q22 = QuestionStep(
                title = getString(R.string.budgetForBuying),
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = getString(R.string.InDZD)
                )
        )
        Q23 = QuestionStep(
                title = getString(R.string.DoYouKnowIris),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice( getString(R.string.Yes)),
                                TextChoice(getString(R.string.No))
                        )
                )
        )
        Q24 = QuestionStep(
                title = getString(R.string.DidYouKnowThatIrisProduces),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                 TextChoice( getString(R.string.Yes)),
                                 TextChoice(getString(R.string.No))
                        )
                )
        )
        Q25 = QuestionStep(
                title = getString(R.string.IfIrisFlowEuropeIso),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                 TextChoice( getString(R.string.Yes)), 
                                 TextChoice(getString(R.string.No))    
                        )
                )
        )
        Q26 = QuestionStep(
                title = getString(R.string.WhyIris),
                text = getString(R.string.MultiChoose),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.WhyIris1)  ),
                                TextChoice(getString(R.string.WhyIris2)   ),
                                TextChoice(getString(R.string.WhyIris3) ),
                                TextChoice(getString(R.string.WhyIris4)     ),
                                TextChoice(getString(R.string.WhyIris5)),
                                TextChoice(getString(R.string.WhyIris6)),
                                TextChoice(getString(R.string.WhyIris7)  ),
                                TextChoice(getString(R.string.WhyIris8)      ),
                                TextChoice(getString(R.string.Others)                          )
                        )
                )
        )

        Q26A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )

        Q27 = QuestionStep(
                title = getString(R.string.WhyNotIris),
                text = getString(R.string.MultiChoose),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.WhyNotIris1)),
                                TextChoice(getString(R.string.WhyNotIris2)),
                                TextChoice(getString(R.string.WhyNotIris3)),
                                TextChoice(getString(R.string.WhyNotIris4)),
                                TextChoice(getString(R.string.WhyNotIris5)),
                                TextChoice(getString(R.string.Others))
                        )
                )
        )

        Q27A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )

        Q28 = QuestionStep(
                title = getString(R.string.HowWeCanChangeYourMind),
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.HowWeCanChangeYourMind1)     ),
                                TextChoice(getString(R.string.HowWeCanChangeYourMind2)   ),
                                TextChoice(getString(R.string.HowWeCanChangeYourMind3)       ),
                                TextChoice(getString(R.string.HowWeCanChangeYourMind4) ),
                                TextChoice(getString(R.string.HowWeCanChangeYourMind5)     ),
                                TextChoice(getString(R.string.HowWeCanChangeYourMind6) ),
                                TextChoice(getString(R.string.HowWeCanChangeYourMind7) ),
                                TextChoice(getString(R.string.HowWeCanChangeYourMind8)  ),
                                TextChoice(getString(R.string.HowWeCanChangeYourMind9)  ),
                               TextChoice(getString(R.string.Others))
                        )
                )
        )

        Q28A = QuestionStep(
                title = getString(R.string.Others),
                text = getString(R.string.beSpecified),
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )

        Q29 = QuestionStep(
                title = getString(R.string.IfWeToldYouThatIrisExport),
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice( getString(R.string.Yes)),
                                TextChoice(getString(R.string.No))
                        )
                )
        )
        Q30 = QuestionStep(
                title = getString(R.string.expectationsFromIris),
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice(getString(R.string.expectationsFromIris1)   ),
                                TextChoice(getString(R.string.expectationsFromIris2)    ),
                                TextChoice(getString(R.string.expectationsFromIris3) ),
                                TextChoice(getString(R.string.expectationsFromIris4)    ),
                                TextChoice(getString(R.string.expectationsFromIris5)  ),
                                TextChoice(getString(R.string.expectationsFromIris6)  ),
                                TextChoice(getString(R.string.expectationsFromIris7)),
                                TextChoice(getString(R.string.expectationsFromIris8)   ),
                                TextChoice(getString(R.string.expectationsFromIris9) ),
                                TextChoice(getString(R.string.expectationsFromIris10)  ),
                                TextChoice(getString(R.string.expectationsFromIris11)    ),
                                TextChoice(getString(R.string.expectationsFromIris12)    ),
                                TextChoice(getString(R.string.expectationsFromIris13) ),
                                TextChoice(getString(R.string.expectationsFromIris14)   ),
                                TextChoice(getString(R.string.expectationsFromIris15)     ),
                                TextChoice(getString(R.string.expectationsFromIris16)   ),
                                TextChoice(getString(R.string.expectationsFromIris17) ),
                                TextChoice(getString(R.string.expectationsFromIris18) ),
                                TextChoice(getString(R.string.expectationsFromIris19)  ) ,
                                TextChoice(getString(R.string.expectationsFromIris20)  )
                        ))
        )
        /* QuestionStep(
                     title = this.resources.getString(R.string.date_picker_title),
                     text = this.resources.getString(R.string.date_picker_text),
                     isOptional = true,
                     answerFormat = AnswerFormat.DateAnswerFormat()
             ),
             QuestionStep(
                     title = this.resources.getString(R.string.time_picker_title),
                     text = this.resources.getString(R.string.time_picker_text),
                     isOptional = true,
                     answerFormat = AnswerFormat.TimeAnswerFormat()
             ),
             QuestionStep(
                     title = this.resources.getString(R.string.email_question_title),
                     text = this.resources.getString(R.string.email_question_text),
                     isOptional = true,
                     answerFormat = AnswerFormat.EmailAnswerFormat()
             ),
             QuestionStep(
                     title = this.resources.getString(R.string.image_selector_question_title),
                     text = this.resources.getString(R.string.image_selector_question_text),
                    // isOptional = true,
                     answerFormat = AnswerFormat.ImageSelectorFormat(
                             numberOfColumns = 4,
                             defaultSelectedImagesIndices = listOf(1),
                             imageChoiceList = listOf(
                                     ImageChoice(R.drawable.camera_icon),
                                     ImageChoice(R.drawable.check_state_icon),
                                     ImageChoice(R.drawable.addquestion),
                                     ImageChoice(R.drawable.addquestionchoise),
                                     ImageChoice(R.drawable.addquestionrules),
                                     ImageChoice(R.drawable.ic_account_circle_black_24dp)
                             )
                     )
             ),*/
        completionStep=CompletionStep(
                title = getString(R.string.EndOfSurvey),
                text = getString(R.string.EndOfSurveyText),
                buttonText = this.resources.getString(R.string.finish_question_submit)
        )

        allSteps= listOf(
           introStep,
            I1,
            I2,
            I3,
            I4,
             I5,
            I6,
            I7,
             Q1,
            Q1A,
             Q2,

                //Car Brand List
                 Q2Audi,
                 Q2Dacia,
                 Q2Citron,
                 Q2Bmw  ,
                 Q2Chevrolet ,

            Q3,
                Q3A,
             Q4,
                 Q5,
                 Q6,
                 Q7,
                 Q7A,
                 Q7B,
                Q8,
                 Q8A,
                Q9,
                 Q9A,
                 Q10,
                 Q11,
                 Q12,
                 Q13,
                Q13A,
                Q14,
                 Q15,
                Q15A,
                 Q16,
                 Q16A,
                 Q17,
                 Q17A,
                 Q18,
                 Q19,
                 Q19A,
                Q20,
                Q20A,
                 Q21,
                 Q21A,
                 Q22,
                 Q23,
                 Q24,
                 Q25,
                 Q26,
                 Q26A,
                 Q27,
                 Q27A,
                 Q28,
                 Q28A,
                 Q29,
                 Q30,
            completionStep
        )

        allSteps.forEach { Step->questionResult.add(Step.id.id)  }
        allSteps.forEach { Step->questionIdCopy.add(Step.id.id)  }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            survey.backPressed()
            true
        } else false
    }




}






