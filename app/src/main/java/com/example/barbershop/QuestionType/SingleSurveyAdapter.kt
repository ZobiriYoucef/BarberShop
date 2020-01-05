package com.example.barbershop.QuestionType

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R

class SingleSurveyAdapter(val questionList:ArrayList<SingleQuestionResult>,context: Context):RecyclerView.Adapter<SingleSurveyAdapter.ViewHolder>() {


    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

        override fun afterTextChanged(editable: Editable) {
           Toast.makeText(context,"1225",Toast.LENGTH_LONG).show()
        }
    }



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
        if(holder.SingleQuestionEditText.isFocused){
            holder.SingleQuestionEditText.addTextChangedListener(textWatcher)
        }
    }
}