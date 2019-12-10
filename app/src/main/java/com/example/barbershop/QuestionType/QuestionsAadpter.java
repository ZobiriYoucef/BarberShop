package com.example.barbershop.QuestionType;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.barbershop.R;

import java.util.ArrayList;

public class QuestionsAadpter extends BaseAdapter {
    Context context;
    ArrayList<Questions> questionsArrayList;
    //String TypeOfQuestions;

    public QuestionsAadpter(Context context, ArrayList<Questions> questionsArrayList) {
        this.context = context;
        this.questionsArrayList = questionsArrayList;
        //TypeOfQuestions = typeOfQuestions;
    }

    @Override
    public int getCount() {
        return questionsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (questionsArrayList.size()==0) {
            return convertView;
        }else{
            Questions questions = questionsArrayList.get(position);
                switch (questions.getType()) {
                    case "Open":
                        LayoutInflater layoutInflater = LayoutInflater.from(context);
                        convertView = layoutInflater.inflate(R.layout.open_question_layout, null, true);
                        EditText etAQA = convertView.findViewById(R.id.etOQA);
                        TextView tvOQT = convertView.findViewById(R.id.tvOQT);

                        tvOQT.setText(questions.getQuestionText());


                        return convertView;
                    case "OneChoice":

                        break;

                    case "MultiChoice":

                        break;

                }
            }
            return convertView;
        }
    }

