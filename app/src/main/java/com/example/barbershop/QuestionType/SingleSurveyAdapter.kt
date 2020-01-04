package com.example.barbershop.QuestionType

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R

class SingleSurveyAdapter(val questionList:ArrayList<SingleQuestionResult>):RecyclerView.Adapter<SingleSurveyAdapter.ViewHolder>() {


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val SingleQuestionTextView=itemView.findViewById(R.id.SingleQuestionTextView) as TextView
        val SingleQuestionEditText=itemView.findViewById(R.id.SingleQuestionEditText) as EditText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  v=LayoutInflater.from(parent.context).inflate(R.layout.single_question,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return questionList.size //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val singleQuestionResult:SingleQuestionResult=questionList[position]
        holder.SingleQuestionTextView.text=singleQuestionResult.questionText
        holder.SingleQuestionEditText.setText(singleQuestionResult.questionResult)
    }
}