package com.example.barbershop.QuestionType

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barbershop.R
import com.quickbirdstudios.surveykit.TaskIdentifier
import com.quickbirdstudios.surveykit.result.TaskResult
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_start_asurvey.*
import java.util.*
import kotlin.collections.ArrayList

class StartASurvey : AppCompatActivity(){

    private val surveyResultDataBaseAdapter=SurveyResultDataBaseAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_asurvey)

        val dataBaseHelper= DataBaseHelperClass(this)

        recyclerView.adapter=surveyResultDataBaseAdapter
        recyclerView.layoutManager=LinearLayoutManager(this)

        surveyResultDataBaseAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))

        fab.setOnClickListener {
            val addEmployee = Intent(this, SurvyLibTest::class.java)
            startActivityForResult(addEmployee, 1)
            finish()
        }

        val taskResult: TaskResult? = intent.getParcelableExtra("TaskResult")

        if(taskResult!=null){
            val questionresualt:ArrayList<String> = ArrayList()

            val taskIdentifier: TaskIdentifier =taskResult.id
            val taskStartDate: Date =taskResult.startDate
            val taskEndDate: Date =taskResult.endDate

            taskResult.results.forEach { stepResult ->stepResult.results.forEach{
                questionresualt.add(it.stringIdentifier)
            }
            }

            val db=dataBaseHelper.writableDatabase

            val values = ContentValues()

            values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q1,questionresualt[1])
            values.put(IrisTyres.DataBaseTableEntry.COLUMN_Q2,questionresualt[2])

            val resultRowId=db?.insert(IrisTyres.DataBaseTableEntry.TabName,null,values)

            setResult(Activity.RESULT_OK, Intent())

            FancyToast.makeText(this,resultRowId.toString(), FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show()

        }

    }


    }

    /*override fun onClick(p0: View?) {
       when (p0!!.id){
           R.id.fab -> {
               Toast.makeText(this,"work",Toast.LENGTH_LONG).show()
           }
       }
    }*/

