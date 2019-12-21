package com.example.barbershop.QuestionType

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barbershop.R
import kotlinx.android.synthetic.main.activity_start_asurvey.*

class StartASurvey : AppCompatActivity(){

    private lateinit var dataBaseHelper:DataBaseHelperClass
    private val surveyResultDataBaseAdapter=SurveyResultDataBaseAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_asurvey)

        dataBaseHelper= DataBaseHelperClass(this)

        recyclerView.adapter=surveyResultDataBaseAdapter
        recyclerView.layoutManager=LinearLayoutManager(this)

        surveyResultDataBaseAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))


        fab.setOnClickListener {
            val GoToSurvyLibTest = Intent(this, SurvyLibTest::class.java)
            startActivityForResult(GoToSurvyLibTest, 1)
        }

       // val taskResult: TaskResult? = intent.getParcelableExtra("TaskResult")

        /*if(taskResult!=null){}*/

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
        surveyResultDataBaseAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
        }
    }


    }


