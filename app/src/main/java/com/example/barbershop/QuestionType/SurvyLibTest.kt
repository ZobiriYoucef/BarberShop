package com.example.barbershop.QuestionType

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

import com.example.barbershop.R
import com.quickbirdstudios.surveykit.AnswerFormat
import com.quickbirdstudios.surveykit.FinishReason
import com.quickbirdstudios.surveykit.OrderedTask
import com.quickbirdstudios.surveykit.SurveyTheme
import com.quickbirdstudios.surveykit.result.TaskResult
import com.quickbirdstudios.surveykit.steps.CompletionStep
import com.quickbirdstudios.surveykit.steps.InstructionStep
import com.quickbirdstudios.surveykit.steps.QuestionStep
import com.quickbirdstudios.surveykit.survey.SurveyView

open class SurvyLibTest : AppCompatActivity() {
    protected lateinit var surveyView: SurveyView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survy_lib_test)

        // val surveyView = findViewById<SurveyView>(R.id.survey_view)
        surveyView = findViewById(R.id.survey_view)

        val q1=QuestionStep(
                title = R.string.about_you_question_title,
                text = R.string.about_you_question_text,
                answerFormat = AnswerFormat.TextAnswerFormat(
                        multipleLines = true,
                        maximumLength = 100
                )
        )

        val q2=QuestionStep(R.string.about_you_question_title,R.string.TQ1T,R.string.next,answerFormat =AnswerFormat.TextAnswerFormat(multipleLines = true,
                maximumLength = 100) )

        val steps = listOf(InstructionStep(
                title = R.string.SurveyTitle,
                text = R.string.SurveyDescription,
                buttonText = R.string.intro_start
        ),q1, q2,CompletionStep(
                title = R.string.finish_question_title,
                text = R.string.finish_question_text,
                buttonText = R.string.finish_question_submit
        ))

        val task = OrderedTask(steps = steps)

        surveyView.onSurveyFinish = { taskResult: TaskResult, reason: FinishReason ->
            if (reason == FinishReason.Completed) {
                taskResult.results.forEach { stepResult ->
                    Log.e("logTag", "answer ${stepResult.results.firstOrNull()}")
                }
            }
        }

        val configuration = SurveyTheme(
                themeColorDark = ContextCompat.getColor(this@SurvyLibTest, R.color.black),
                themeColor = ContextCompat.getColor(this@SurvyLibTest, R.color.cyan_normal),
                textColor = ContextCompat.getColor(this@SurvyLibTest, R.color.cyan_text)
        )

        surveyView.start(task, configuration)
    }



}
