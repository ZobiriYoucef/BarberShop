package com.example.barbershop.QuestionType

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.barbershop.R
import com.quickbirdstudios.surveykit.TaskIdentifier
import com.quickbirdstudios.surveykit.result.TaskResult
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_start_asurvey.*
import java.util.*
import kotlin.collections.ArrayList

class StartASurvey : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_asurvey)

        fab.setOnClickListener {
            val addEmployee = Intent(this, SurvyLibTest::class.java)
            startActivityForResult(addEmployee, 1)
        }

        val taskResult: TaskResult? = intent.getParcelableExtra("TaskResult")
        if (taskResult!=null){
            FancyToast.makeText(this, "work", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show()
            val questionresualt:ArrayList<String> = ArrayList()
            var taskIdentifier: TaskIdentifier =taskResult.id
            var taskStartDate: Date=taskResult.startDate
            var taskEndDate: Date=taskResult.endDate
                taskResult.results.forEach { stepResult ->stepResult.results.forEach{
                    questionresualt.add(it.stringIdentifier)
                }
                }

            FancyToast.makeText(this,taskIdentifier.id+"\n"+questionresualt.size, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show()
            }
            //val RQ1:String= taskResult.results[1].results[1].stringIdentifier
            //val RQ2:String= taskResult.results[2].results[2].stringIdentifier


        }


    }

    /*override fun onClick(p0: View?) {
       when (p0!!.id){
           R.id.fab -> {
               Toast.makeText(this,"work",Toast.LENGTH_LONG).show()
           }
       }
    }*/

