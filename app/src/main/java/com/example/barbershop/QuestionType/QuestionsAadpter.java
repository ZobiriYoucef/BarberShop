package com.example.barbershop.QuestionType;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class QuestionsAadpter extends BaseAdapter {
    Context context;
    ArrayList<Questions> questionsArrayList=new ArrayList<>();
    String TypeOfQuestions;

    public QuestionsAadpter(Context context, ArrayList<Questions> questionsArrayList, String typeOfQuestions) {
        this.context = context;
        this.questionsArrayList = questionsArrayList;
        TypeOfQuestions = typeOfQuestions;
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
        Questions questions=questionsArrayList.get(position);
        switch (questions.SelectedType){
            case "Open":

                break;

            case "OneChoice":

                break;

            case "MultiChoice":

                break;

        }




        return null;
    }
}
