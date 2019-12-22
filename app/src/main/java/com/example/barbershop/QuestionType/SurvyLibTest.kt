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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survy_lib_test)
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
                Q1.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                "Autres" -> Q1A.id
                                else -> Q2.id
                            }
                        }
                )
        )

        task.setNavigationRule(
                Q8.id,
                NavigationRule.ConditionalDirectionStepNavigationRule(
                        resultToStepIdentifierMapper = { input ->
                            when (input) {
                                "Autres" -> Q8A.id
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
                                "Autres" -> Q7A.id
                                "Lorsque vous partiez au trajet"->Q8.id
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
                                "Autres" -> Q9A.id
                                "Selon le Kilométrage"->Q10.id
                                "Selon La période (durée)"->Q11.id
                                "Selon le niveau d'usure des pneus"->Q12.id
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
                                "Oui" -> Q13.id
                                "Non"->Q20A.id
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
                                "Autres" -> Q13A.id
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
                                "Autres" -> Q15A.id
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
                                "Autres" -> Q16A.id
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
                                "Autres" -> Q17A.id
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
                                "Autres" -> Q21A.id
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
                                "Oui" -> Q24.id
                                "Non" -> Q25.id
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
                                "Oui" -> Q26.id
                                "Non" -> Q27.id
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
                                "Autres" -> Q26A.id
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
                                "Autres" -> Q27A.id
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
                                "Autres" -> Q28A.id
                                else -> Q29.id
                            }
                        }
                )
        )



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
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3  ,questionResult[11])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q3A ,questionResult[12])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q4  ,questionResult[13])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q5  ,questionResult[14])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q6  ,questionResult[15])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q7  ,questionResult[16])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q7A ,questionResult[17])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q7B ,questionResult[18])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q8  ,questionResult[19])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q8A ,questionResult[20])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q9  ,questionResult[21])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q9A ,questionResult[22])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q10 ,questionResult[23])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q11 ,questionResult[24])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q12 ,questionResult[25])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q13 ,questionResult[26])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q13A,questionResult[27])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q14 ,questionResult[28])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q15 ,questionResult[29])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q15A,questionResult[30])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q16 ,questionResult[31])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q16A,questionResult[32])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q17 ,questionResult[33])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q17A,questionResult[34])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q18 ,questionResult[35])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q19 ,questionResult[36])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q19A,questionResult[37])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q20 ,questionResult[38])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q20A,questionResult[39])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q21 ,questionResult[40])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q21A,questionResult[41])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q22 ,questionResult[42])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q23 ,questionResult[43])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q24 ,questionResult[44])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q25 ,questionResult[45])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q26 ,questionResult[46])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q26A,questionResult[47])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q27 ,questionResult[48])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q27A,questionResult[49])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q28 ,questionResult[50])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q28A,questionResult[51])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q29 ,questionResult[52])
                values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q30 ,questionResult[53])

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
                themeColor = ContextCompat.getColor(this, R.color.cyan_normal),
                textColor = ContextCompat.getColor(this, R.color.cyan_text)
        )

        surveyView.start(task, configuration)
    }


    private fun setupSteps() {
        introStep = InstructionStep(
                title = this.resources.getString(R.string.SurveyTitle),
                text = this.resources.getString(R.string.SurveyDescription)
        )
        I1 = QuestionStep(
                title = "Nom d'enquêté",
                text = "",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        I2 = QuestionStep(
                title = "L’identificateur de l'équité",
                text = "Numéro de téléphone",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = "Please Enter Your Phone Number"
                )
        )
        I3 = QuestionStep(
                title = "Région",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Ouest"),
                                TextChoice("Centre"),
                                TextChoice("Est")
                        )
                )
        )
        I4 = QuestionStep(
                title = "Sexe",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Homme"),
                                TextChoice("Femme")
                        )
                )
        )
        I5 = QuestionStep(
                title = "Votre Age ?",
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = "Please Enter Your Age"
                )
        )
        I6 = QuestionStep(
                title = "Travaillez-vous ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Oui"),
                                TextChoice("Non")
                        )
                )
        )
        I7 = QuestionStep(
                title = "CSP",
                text = "quel est votre revenu Mensuel (NET)",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = "en DZD"
                )
        )
        Q1 = QuestionStep(
                title = "Quel type de véhicule possédez-vous ?",
                text = "is ok to choose more than one",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Touristique"),
                                TextChoice("SUV / 4x4"),
                                TextChoice("Utilitaire"),
                                TextChoice("Autres")
                        )
                )
        )
        Q1A = QuestionStep(
                title = "Autres type de véhicule",
                text = "SVP préciser le type de véhicule que vous possédez",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = "Super Car lol")
        )
        Q2 = QuestionStep(
                title = "Quelle est la marque de votre véhicule ?",
                text = "",
                answerFormat = AnswerFormat.ImageSelectorFormat(
                        numberOfColumns = 5,
                        defaultSelectedImagesIndices = listOf(1),
                        imageChoiceList = listOf(
                                ImageChoice(R.drawable.alfa),
                                ImageChoice(R.drawable.aston),
                                ImageChoice(R.drawable.audi),
                                ImageChoice(R.drawable.bentley),
                                ImageChoice(R.drawable.bmw),
                                ImageChoice(R.drawable.byd),
                                ImageChoice(R.drawable.chery),
                                ImageChoice(R.drawable.chevrolet),
                                ImageChoice(R.drawable.citron),
                                ImageChoice(R.drawable.dacia),
                                ImageChoice(R.drawable.daihatsu),
                                ImageChoice(R.drawable.dfm),
                                ImageChoice(R.drawable.dfsk),
                                ImageChoice(R.drawable.dodge),
                                ImageChoice(R.drawable.ferrari),
                                ImageChoice(R.drawable.fiat),
                                ImageChoice(R.drawable.ford),
                                ImageChoice(R.drawable.gmc),
                                ImageChoice(R.drawable.honda),
                                ImageChoice(R.drawable.hummer),
                                ImageChoice(R.drawable.hyundai),
                                ImageChoice(R.drawable.infiniti),
                                ImageChoice(R.drawable.isuzu),
                                ImageChoice(R.drawable.jaguar),
                                ImageChoice(R.drawable.jeep),
                                ImageChoice(R.drawable.kia),
                                ImageChoice(R.drawable.lancia),
                                ImageChoice(R.drawable.land),
                                ImageChoice(R.drawable.lexus),
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
                                ImageChoice(R.drawable.porsche),
                                ImageChoice(R.drawable.renault),
                                ImageChoice(R.drawable.saab),
                                ImageChoice(R.drawable.skoda),
                                ImageChoice(R.drawable.ssangyong),
                                ImageChoice(R.drawable.subaru),
                                ImageChoice(R.drawable.suzuki),
                                ImageChoice(R.drawable.toyota),
                                ImageChoice(R.drawable.volkswagen),
                                ImageChoice(R.drawable.volvo)
                        )
                )
        )
        Q3 = QuestionStep(
                title = "Quel est le model de ce véhicule ?",
                text = "",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q3A = QuestionStep(
                title = "c'est quoi la dimension de vous pneus",
                text = "",
                answerFormat = AnswerFormat.ValuePickerAnswerFormat(
                        choices = (14..22).toList().map { it.toString() },
                        defaultValue = 16.toString()
                )
        )
        Q4 = QuestionStep(
                title = "Année du véhicule ?",
                text = "",
                answerFormat = AnswerFormat.ValuePickerAnswerFormat(
                        choices = (2008..2018).toList().map { it.toString() },
                        defaultValue = 2010.toString()
                )
        )
        Q5 = QuestionStep(
                title = "Kilométrage actuel ?",
                text = "en mille Km x1000",
                answerFormat = AnswerFormat.ValuePickerAnswerFormat(
                        choices = (20..300).toList().map { it.toString() },
                        defaultValue = 70.toString()
                )
        )
        Q6 = QuestionStep(
                title = "En moyenne, Combien de Kilomètre voulez-vous par mois ?",
                text = "",
                answerFormat = AnswerFormat.ValuePickerAnswerFormat(
                        choices = (300..2000).toList().map { it.toString() },
                        defaultValue = 500.toString()
                )
        )
        Q7 = QuestionStep(
                title = "A quelle fréquence vérifiez-vous la pression de vos pneus ?",
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Par mois"),
                                TextChoice("Par semaine"),
                                TextChoice("Par jour"),
                                TextChoice("Lorsque vous partiez au trajet"),
                                TextChoice("Autres")
                        )
                )
        )
        Q7A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = "Super Car lol")
        )
        Q7B = QuestionStep(
                title = "combien de fois ?",
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = ""
                )
        )
        Q8 = QuestionStep(
                title = "Chez quel prestataire faites-vous la vérification de vos pneus ?",
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Vulcanisateurs"),
                                TextChoice("Garages mécaniques spécialisés"),
                                TextChoice("Concessionnaire (Agent Agréé)"),
                                TextChoice("Autres")
                        )
                )
        )
        Q8A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = "Super Car lol")
        )
        Q9 = QuestionStep(
                title = "A quelle fréquence changez-vous vos pneus ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Selon le Kilométrage"),
                                TextChoice("Selon La période (durée)"),
                                TextChoice("Selon le niveau d'usure des pneus"),
                                TextChoice("Autres")
                        )
                )
        )
        Q9A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q10 = QuestionStep(
                title = "Si le Kilométrage, combien ?",
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = "en Km"
                )
        )
        Q11 = QuestionStep(
                title = "Si la période, Combien ?",
                text = "par mois SPV",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = "Mois"
                )
        )
        Q12 = QuestionStep(
                title = "Avez-vous déjà changé vos pneus ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Oui"),
                                TextChoice("Non")
                        )
                )
        )
        Q13 = QuestionStep(
                title = "Pourquoi vous avez changé vous pneus ?",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Le pneu à éclater"),
                                TextChoice("Une bosse qui sort du pneu"),
                                TextChoice("Une coupure profonde sur le pneu"),
                                TextChoice("Vous devez ajouter de l'air dans l'un de vos pneus qutidianment"),
                                TextChoice("Une vibration dans la course du pneu"),
                                TextChoice("La bande de roulement est trop usée"),
                                TextChoice("Une vibration dans la course du pneu"),
                                TextChoice("l’âge: les pneus atteindre leur limite dans le temps"),
                                TextChoice("la saison: remplacé les anciens pneus par les pneus d'hiver"),
                                TextChoice("Autres")
                        )
                )
        )
        Q13A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q14 = QuestionStep(
                title = "Combien de pneus avez vous changez ?",
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
                title = "Est ce que vous avez l'habitude de changer votre pneus",
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("4 pneus à la fois"),
                                TextChoice("2 par 2"),
                                TextChoice("Chaque pneu selon état"),
                                TextChoice("Autres")
                        )
                )
        )
        Q15A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q16 = QuestionStep(
                title = "Avez-vous déjà changé vos pneus ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Michelin"),
                                TextChoice("Pirelli"),
                                TextChoice("Continental"),
                                TextChoice("Triangle"),
                                TextChoice("Bridge stone"),
                                TextChoice("Dunlop"),
                                TextChoice("Goodyear"),
                                TextChoice("Kumho"),
                                TextChoice("Hankook"),
                                TextChoice("Barum"),
                                TextChoice("Autres")

                        )
                )
        )
        Q16A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q17 = QuestionStep(
                title = "Quand vous l'avez changé, quelle est la marque que vous avez choisie ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Michelin"),
                                TextChoice("Pirelli"),
                                TextChoice("Continental"),
                                TextChoice("Triangle"),
                                TextChoice("Bridge stone"),
                                TextChoice("Dunlop"),
                                TextChoice("Goodyear"),
                                TextChoice("Kumho"),
                                TextChoice("Hankook"),
                                TextChoice("Barum"),
                                TextChoice("Autres")

                        )
                )
        )
        Q17A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q18 = QuestionStep(
                title = "Pourquoi avez-vous choisi cette marque ?",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q19 = QuestionStep(
                title = "Combien était le prix ?",
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = "ed DZD"
                )
        )
        Q19A = QuestionStep(
                title = "ce prix est pour combien de pneus ?",
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
                title = "Depuis quand ?",
                text = "par mois SPV",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = "Mois"
                )
        )
        Q20A = QuestionStep(
                title = "Si vous devez changer un pneus ou plus est ce que vous changer",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("seulement les pneus endommagés"),
                                TextChoice("4 pneus à la fois"),
                                TextChoice("2 par 2")
                        )
                )
        )
        Q21 = QuestionStep(
                title = "Quel critère important pour vous lors de l'achat d'un pneu ? ",
                text = "Possibilité de réponses Multiples",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Notoriété de la marque"),
                                TextChoice("Budget (prix)"),
                                TextChoice("Meilleure offre"),
                                TextChoice("Apparence - Sculpture (Dessein)"),
                                TextChoice("Meilleure offre"),
                                TextChoice("Disponibilité du produit"),
                                TextChoice("Même marque que l'OE"),
                                TextChoice("L’origine de pneu"),
                                TextChoice("Publicité"),
                                TextChoice("Autres")
                        )
                )
        )

        Q21A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )

        Q22 = QuestionStep(
                title = "Quel est votre budget pour l’achat d’un pneu ? ",
                text = "",
                answerFormat = AnswerFormat.IntegerAnswerFormat(
                        hint = "ed DZD"
                )
        )
        Q23 = QuestionStep(
                title = "Connaissez-vous la marque IRIS ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Oui"),
                                TextChoice("Non")
                        )
                )
        )
        Q24 = QuestionStep(
                title = "Savez-vous qu’IRIS produit des pneus en Algérie ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Oui"),
                                TextChoice("Non")
                        )
                )
        )
        Q25 = QuestionStep(
                title = "Si on vous dit qu’IRIS suit les normes internationales et européennes de la fabrication des pneus, Envisageriez-vous d’achetée des pneus IRIS ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Oui"),
                                TextChoice("Non")
                        )
                )
        )
        Q26 = QuestionStep(
                title = "Qu'est-ce qui vous motiverait à le faire ?",
                text = "Possibilité de réponses Multiples",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Prix moins cher"),
                                TextChoice("Sculpture (Dessein)"),
                                TextChoice("Offre MKT/service"),
                                TextChoice("Notoriété de la marque"),
                                TextChoice("Production local"),
                                TextChoice("Disponibilité"),
                                TextChoice("Autres")
                        )
                )
        )
        Q26A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q27 = QuestionStep(
                title = "Qu’est-ce qui vous empêcherait le faire ?",
                text = "Possibilité de réponses Multiples",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Attendre les critiques"),
                                TextChoice("Sculpture (Dessein)"),
                                TextChoice("Prix cher"),
                                TextChoice("Production local"),
                                TextChoice("Offre MKT/service"),
                                TextChoice("Autres")
                        )
                )
        )
        Q27A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q28 = QuestionStep(
                title = "quel(s) est (sont) pour vous le(s) facteur(s) important(s) qui vous inciterait (aient) à l'achat d'un pneu IRIS ?",
                text = "",
                answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Recommandation"),
                                TextChoice("Critiques positives"),
                                TextChoice("Technologie Européenne"),
                                TextChoice("Sculpture (Dessein)"),
                                TextChoice("Moins cher que les autres marques"),
                                TextChoice("Disponibilité"),
                                TextChoice("Autres")
                        )
                )
        )
        Q28A = QuestionStep(
                title = "Autres",
                text = "SVP préciser!!",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
        )
        Q29 = QuestionStep(
                title = "Si on vous dit qu’IRIS fait de l’exportation des pneus, envisageriez-vous d’achetée des pneus IRIS ?",
                text = "",
                answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        textChoices = listOf(
                                TextChoice("Oui"),
                                TextChoice("Non")
                        )
                )
        )
        Q30 = QuestionStep(
                title = "Quelle sont vos attentes de la part de marque IRIS ?",
                text = "",
                answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null)
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
                title = "Terminé",
                text = "Merci d'avoir répondu à ce questionnaire est d'avoir participera ce tirage au sort, je vous souhaite bonne chance",
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






