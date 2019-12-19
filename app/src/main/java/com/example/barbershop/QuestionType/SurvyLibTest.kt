package com.example.barbershop.QuestionType

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.barbershop.R
import com.quickbirdstudios.surveykit.*
import com.quickbirdstudios.surveykit.result.TaskResult
import com.quickbirdstudios.surveykit.steps.CompletionStep
import com.quickbirdstudios.surveykit.steps.InstructionStep
import com.quickbirdstudios.surveykit.steps.QuestionStep
import com.quickbirdstudios.surveykit.survey.SurveyView

open class SurvyLibTest : AppCompatActivity() {
    protected lateinit var survey: SurveyView
    private lateinit var container: ViewGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survy_lib_test)

        // val surveyView = findViewById<SurveyView>(R.id.survey_view)
        survey = findViewById(R.id.survey_view)
        container = findViewById(R.id.surveyContainer)

        setupSurvey(survey)

    }

    private fun setupSurvey(surveyView: SurveyView) {
        val steps = listOf(
                InstructionStep(
                        title = this.resources.getString(R.string.SurveyTitle),
                        text = this.resources.getString(R.string.SurveyDescription)
                ),
                QuestionStep(
                        title = this.resources.getString(R.string.about_you_question_title),
                        text = this.resources.getString(R.string.about_you_question_text),
                        answerFormat = AnswerFormat.TextAnswerFormat(maxLines = 5, hintText = null), nextButton = "ttttt", isOptional = true
                ),
                QuestionStep(
                        title = this.resources.getString(R.string.how_old_title),
                        text = this.resources.getString(R.string.how_old_text),
                        isOptional = true,
                        answerFormat = AnswerFormat.IntegerAnswerFormat(
                                defaultValue = 25,
                                hint = this.resources.getString(R.string.how_old_hint)
                        )
                ),
                QuestionStep(
                        title = this.resources.getString(R.string.how_fat_question_title),
                        text = this.resources.getString(R.string.how_fat_question_text),
                        isOptional = true,
                        answerFormat = AnswerFormat.ScaleAnswerFormat(
                                minimumValue = 1,
                                maximumValue = 5,
                                minimumValueDescription = this.resources.getString(R.string.how_fat_min),
                                maximumValueDescription = this.resources.getString(R.string.how_fat_max),
                                step = 1f,
                                defaultValue = 3
                        )
                ),
                QuestionStep(
                        title = this.resources.getString(R.string.allergies_question_title),
                        text = this.resources.getString(R.string.allergies_question_text),
                        isOptional = true,
                        answerFormat = AnswerFormat.MultipleChoiceAnswerFormat(
                                textChoices = listOf(
                                        TextChoice(this.resources.getString(R.string.allergies_back_penicillin)),
                                        TextChoice(this.resources.getString(R.string.allergies_latex)),
                                        TextChoice(this.resources.getString(R.string.allergies_pet)),
                                        TextChoice(this.resources.getString(R.string.allergies_pollen))
                                )
                        )
                ),
                QuestionStep(
                        title = this.resources.getString(R.string.quit_or_continue_question_title),
                        text = this.resources.getString(R.string.quit_or_continue_question_text),
                        isOptional = true,
                        answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                                textChoices = listOf(
                                        TextChoice(this.resources.getString(R.string.yes)),
                                        TextChoice(this.resources.getString(R.string.no))
                                )
                        )
                ),
                QuestionStep(
                        title = this.resources.getString(R.string.boolean_example_title),
                        text = this.resources.getString(R.string.boolean_example_text),
                        isOptional = true,
                        answerFormat = AnswerFormat.BooleanAnswerFormat(
                                positiveAnswerText = this.resources.getString(R.string.how_fat_min),
                                negativeAnswerText = this.resources.getString(R.string.how_fat_max),
                                defaultValue = AnswerFormat.BooleanAnswerFormat.Result.NegativeAnswer
                        )
                ),
                QuestionStep(
                        title = this.resources.getString(R.string.value_picker_example_title),
                        text = this.resources.getString(R.string.value_picker_example_text),
                        isOptional = true,
                        answerFormat = AnswerFormat.ValuePickerAnswerFormat(
                                choices = (0..10).toList().map { it.toString() },
                                defaultValue = 5.toString()
                        )
                ),
                QuestionStep(
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
                ),
                CompletionStep(
                        title = this.resources.getString(R.string.finish_question_title),
                        text = this.resources.getString(R.string.finish_question_text),
                        buttonText = this.resources.getString(R.string.finish_question_submit)
                )
        )

        val task = NavigableOrderedTask(steps = steps)

        surveyView.onSurveyFinish = { taskResult: TaskResult, reason: FinishReason ->
            if (reason == FinishReason.Completed) {
                taskResult.results.forEach { stepResult ->
                    Log.e("ASDF", "answer ${stepResult.results.firstOrNull()}")
                    container.removeAllViews()
                }
            }
        }

        val configuration = SurveyTheme(
                themeColorDark = ContextCompat.getColor(this, R.color.black),
                themeColor = ContextCompat.getColor(this, R.color.cyan_normal),
                textColor = ContextCompat.getColor(this, R.color.cyan_text)
        )

        surveyView.start(task, configuration)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            survey.backPressed()
            true
        } else false
    }


}






