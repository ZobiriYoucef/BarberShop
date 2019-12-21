package com.example.barbershop.QuestionType

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R
import kotlinx.android.synthetic.main.list_item.view.*


class SurveyResultDataBaseAdapter(private val context: Context?) :
        RecyclerView.Adapter<SurveyResultDataBaseAdapter.SurveyResultDataBaseViewHolder>() {

    private lateinit var finishedSurveyResultList:ArrayList<SurveyResultDataBaseModule>

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
        holder.setDATA(singleFinished.Q1,singleFinished.Q2)
    }

    fun setFinishedSurveyResult(FinishedSurveyResult: ArrayList<SurveyResultDataBaseModule>) {
        finishedSurveyResultList=FinishedSurveyResult
        notifyDataSetChanged()
    }

    class SurveyResultDataBaseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun setDATA(nameOfInvestigator:String,phoneNumberOfInvestigator:String){
            itemView.NameOfInvestigator.text=nameOfInvestigator
            itemView.PhoneNumberOfInvestigator.text=phoneNumberOfInvestigator
        }
    }


}