package com.example.barbershop.QuestionType;

import java.util.ArrayList;

public class Questions {
    public int QuestionsNumber;
    public ArrayList<String> QuestionTypeArrayList;
    public String SelectedType;

    public Questions() {
        QuestionTypeArrayList = new ArrayList<>();
        QuestionTypeArrayList.add("Open");
        QuestionTypeArrayList.add("OneChoice");
        QuestionTypeArrayList.add("MultiChoice");
    }
}
