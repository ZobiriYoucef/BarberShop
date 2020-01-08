package com.example.barbershop.QuestionType

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R

class SingleSurveyAdapter(val context: Context,val questionList:ArrayList<SingleQuestionResult>,var updatedsingleQuestionResult:ArrayList<String>,var checkChange:Boolean):RecyclerView.Adapter<SingleSurveyAdapter.ViewHolder>() {


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
        holder.SingleQuestionEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                updatedsingleQuestionResult.set(position,p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(holder.SingleQuestionEditText.isFocused) {
                    //Toast.makeText(context,"wor from inside", Toast.LENGTH_LONG).show()
                    checkChange=true

                }
            }

        }  )
    }

    fun getSurveyDataCheckChange():Boolean{
        return this.checkChange
    }

    fun getupdatedsingleQuestionResult():ArrayList<String>{
        return this.updatedsingleQuestionResult
    }


}