package com.example.barbershop.Answers;

import com.example.barbershop.QuestionType.Multiple_choice_CheckBox;

import java.util.ArrayList;
import java.util.List;

public class Answers {
    public ArrayList<String> selectedAnswerList;
    public List<Multiple_choice_CheckBox> multiple_choice_checkBoxes;

    public Answers()
    {
        selectedAnswerList = new ArrayList<>();
        multiple_choice_checkBoxes= new ArrayList<>();
    }

}
