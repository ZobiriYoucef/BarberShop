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
import com.orhanobut.hawk.Hawk
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

        Hawk.init(this).build()

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

        val task = NavigableOrderedTask(steps = allSteps)

        task.setNavigationRule(
                I1.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> I2.id
                                else -> I3.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                I3.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> I4.id
                                else -> I5.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                I6.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                getString(R.string.Others) -> I7.id
                                else -> Q1.id
                            }
                        }
                )
        )

        /*task.setNavigationRule(
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
        )*/


        surveyView.onStepResult={step: Step?, stepResult: StepResult? ->
            /*if (step?.id==Q2.id && stepResult?.id==Q2.id){
                Toast.makeText(this@SurvyLibTest, stepResult.results[0].stringIdentifier, Toast.LENGTH_LONG).show()
                Temp=stepResult.results[0].stringIdentifier
            }*/
        }

        surveyView.onSurveyFinish = { taskResult: TaskResult, reason: FinishReason ->
            if (reason == FinishReason.Completed) {

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

                val h1:String=Hawk.get("I1")
                val h2:String=Hawk.get("I2")
                val h3:String=Hawk.get("I3")
                val h4:String=Hawk.get("I4")
                val h5:String=Hawk.get("I5")
                val h6:String=Hawk.get("I6")
                val h7:String=Hawk.get("I7")
                val h8:String=Hawk.get("I8")
                val h9:String=Hawk.get("I9")
                val h10:String=Hawk.get("I10")

                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I1  ,h1)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I2  ,h2)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I3  ,h3)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I4  ,h4)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I5  ,h5)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I6  ,h6)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I7  ,h7)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I8  ,h8)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I9  ,h9)
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_I10 ,h10)

                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q1 ,questionResult[1])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q2 ,questionResult[2])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3 ,questionResult[3])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q4 ,questionResult[4])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q5 ,questionResult[5])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q6 ,questionResult[6])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q7 ,questionResult[7])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q8 ,questionResult[8])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q9 ,questionResult[9])

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
                text = getString(R.string.MultiChoose),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Client"),
                                TextChoice("Invité"),
                                TextChoice("Exposant"),
                                TextChoice("Visiteur"),
                                TextChoice("Autres"))
                )
        )
        I2 = QuestionStep(
                title = getString(R.string.EquityIdentifier),
                text = "soyez plus précis s'il vous plaît",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5)
        )
        I3 = QuestionStep(
                title = getString(R.string.Region),
                text = getString(R.string.MultiChoose),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Documentation"),
                                TextChoice("Partenaria"),
                                TextChoice("Fournisseur"),
                                TextChoice("Publicité"),
                                TextChoice("Presentation"),
                                        TextChoice("Autres"))
                )
        )
        I4 = QuestionStep(
                title = getString(R.string.Sex),
                text = "",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5)
        )
        I5 = QuestionStep(
                title = getString(R.string.YourAge),
                text = "",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5)

        )

        I6 = QuestionStep(
                title = getString(R.string.DoYouWork),
                text = getString(R.string.MultiChoose),
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Client"),
                                TextChoice("Invité"),
                                TextChoice("Exposant"),
                                TextChoice("Visiteur"),
                       TextChoice("Autres")))
        )
        I7 = QuestionStep(
                title = getString(R.string.CSP),
                text ="soyez plus précis s'il vous plaît",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5)
        )
        Q1 = QuestionStep(
                title = "Potentiel",
                text = "Choose only one",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Super Hight"),
                                TextChoice("Hight"),
                                TextChoice("Medium"),
                                TextChoice("Low"),
                                TextChoice("To forget"))
                )
        )
        Q1A = QuestionStep(
                title = "Department"                                                                                          ,
                text ="Choose only one",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("commercial"),
                                TextChoice("marketing"),
                                TextChoice("communication"),
                                TextChoice("production")
                                )
                )
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






