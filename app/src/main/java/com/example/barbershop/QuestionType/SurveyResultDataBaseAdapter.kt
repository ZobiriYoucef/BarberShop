package com.example.barbershop.QuestionType

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R
import com.example.barbershop.utils.FileUtils
import kotlinx.android.synthetic.main.list_item.view.*
import java.io.FileInputStream
import java.io.InputStream


class SurveyResultDataBaseAdapter(private val context: Context) :
        RecyclerView.Adapter<SurveyResultDataBaseAdapter.SurveyResultDataBaseViewHolder>() {

    private lateinit var finishedSurveyResultList:ArrayList<SurveyResultDataBaseModule>

    val TAG= SurveyResultDataBaseAdapter::class.java.name


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int
    ): SurveyResultDataBaseViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return SurveyResultDataBaseViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return   finishedSurveyResultList.size
    }

    override fun onBindViewHolder(holder: SurveyResultDataBaseViewHolder, position: Int) {
   val singleFinished=finishedSurveyResultList[position]

        holder.setDATA(
                position,
                singleFinished.I3,
                singleFinished.I4,
                singleFinished.I5,
                singleFinished.I6,
                singleFinished.I10
                )

        holder.setListener()
    }

    fun setFinishedSurveyResult(FinishedSurveyResult: ArrayList<SurveyResultDataBaseModule>) {
        finishedSurveyResultList=FinishedSurveyResult
        notifyDataSetChanged()
    }

   inner  class SurveyResultDataBaseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var pos=0

        fun setDATA(pos: Int,
                    nameOfInvestigator:String,
                    companyOfInvestigator:String,
                    jobOfInvestigator:String,
                    phone1OfInvestigator:String,
                    cardImagePathOfInvestigator:String){

            this.pos=pos

            itemView.NameOfInvestigator.text=nameOfInvestigator
            itemView.JobOfInvestigator.text=jobOfInvestigator
            itemView.tvCompanyName.text=companyOfInvestigator
            itemView.tvPhoneNumber.text=phone1OfInvestigator

            val uri = Uri.parse(cardImagePathOfInvestigator)
            val file = FileUtils.getFile(context, uri)
            val inputStream: InputStream = FileInputStream(file)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            itemView.ivCardOfInvestigator.setImageBitmap(bitmap)



        }

        fun setListener() {
            itemView.setOnClickListener {
            /*val dataBaseHelperClass=DataBaseHelperClass(context)
            val singleSurveyResult=DataManger.fetchASingleResponse(dataBaseHelperClass,finishedSurveyResultList[pos].id)

            Log.i(TAG,singleSurveyResult.toString())*/
            val intent=Intent(context,SingleSurveyResult::class.java)
                intent.putExtra(IrisTyres.DataBaseTableEntry.COLUMN_ID,finishedSurveyResultList[pos].id)
                (context as Activity).startActivityForResult(intent,2)
            }
        }
    }


}