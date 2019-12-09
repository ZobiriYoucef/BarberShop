package com.example.barbershop.QuestionType;

import java.util.ArrayList;

public class Questions {
    public String QuestionsProfile;

    public String SelectedType;

    public int QuestionsNumber;

    public String ExepectedAnswerType;

    public int numberOfAnswersChoice;

    public ArrayList<String> answersChoice=new ArrayList<>();
    public Boolean isTheAnswerRequierd;


    public Questions() {
        isTheAnswerRequierd=false;
    }
}
