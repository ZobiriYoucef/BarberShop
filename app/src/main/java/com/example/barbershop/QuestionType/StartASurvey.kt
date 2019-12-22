package com.example.barbershop.QuestionType

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barbershop.R
import kotlinx.android.synthetic.main.activity_start_asurvey.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException


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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.surveymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun checkExternalStoragePermission() {
        val permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para leer.")
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 225)
        } else {
            Log.i("Mensaje", "Se tiene permiso para leer!")
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.SaveTheSurveyDataBase ->{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    checkExternalStoragePermission()
                }
                try {
                    val backupDB = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "IRISTYRESBDD_backup.db") // for example "my_data_backup.db"
                    val currentDB: File = applicationContext.getDatabasePath("IRISTYRESBDD.db") //databaseName=your current application database name, for example "my_data.db"
                    if (currentDB.exists()) {
                        val fis = FileInputStream(currentDB)
                        val fos = FileOutputStream(backupDB)
                        fos.getChannel().transferFrom(fis.getChannel(), 0, fis.getChannel().size())
                        // or fis.getChannel().transferTo(0, fis.getChannel().size(), fos.getChannel());
                        fis.close()
                        fos.close()
                        Log.i("Database successfully", " copied to download folder")
                        Toast.makeText(this,"Database successfully copied to download folder",Toast.LENGTH_LONG).show()
                        return true
                    } else Log.i("Copying Database", " fail, database not found")
                } catch (e: IOException) {
                    Log.d("Copying Database", "fail, reason:", e)
                    Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()

                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    }


