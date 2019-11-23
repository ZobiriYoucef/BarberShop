package com.example.barbershop;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.barbershop.Answers.Answers;
import com.example.barbershop.QuestionType.Multiple_choice_CheckBox;

public class TabAdopter extends FragmentPagerAdapter {
    public TabAdopter( FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int tabposition) {
        switch (tabposition){
            case 0:
                return new Profile_Tab();

            case 1:
                return new User_Tab();

            case 2:
                return new Share_Tab();

            case 3:
                Answers answers= new Answers();
                answers.selectedAnswerList.add("zizo");
                answers.selectedAnswerList.add("zizvvo");
                answers.selectedAnswerList.add("zizqgheeo");
                answers.selectedAnswerList.add("156");
                return new Multiple_choice_CheckBox(answers.selectedAnswerList);

            case 4:
                Answers answers2= new Answers();
                answers2.selectedAnswerList.add("zr25");
                answers2.selectedAnswerList.add("fer");
                return new Multiple_choice_CheckBox(answers2.selectedAnswerList);


            default: return null;

        }

    }

    @Override
    public int getCount() {
        return 5;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Profile";
            case 1: return "User";
            case 2: return "Shared";
            case 3: return "answer 1";
            case 4: return "answer 2";
            default: return null;

        }


    }
}
