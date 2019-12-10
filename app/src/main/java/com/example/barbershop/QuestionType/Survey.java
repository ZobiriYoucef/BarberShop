package com.example.barbershop.QuestionType;

import java.util.ArrayList;

public class Survey{
    public String SurveyName;
    public ArrayList<Questions> questionsArrayList;

    public Survey(String surveyName, ArrayList<Questions> questionsArrayList) {
        SurveyName = surveyName;
        this.questionsArrayList = questionsArrayList;
    }
}
