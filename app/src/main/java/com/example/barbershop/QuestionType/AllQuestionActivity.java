package com.example.barbershop.QuestionType;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.barbershop.Answers.Answers;
import com.example.barbershop.MainActivity;
import com.example.barbershop.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllQuestionActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.allQuestionsFragmentQuestionTextId)
    TextView allQuestionsFragmentQuestionTextId;
    @BindView(R.id.fragmentContainerId1)
    FrameLayout fragmentContainerId1;
    @BindView(R.id.fragmentContainerId2)
    FrameLayout fragmentContainerId2;
    @BindView(R.id.button2)
    Button GoToCreatQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_question);
        ButterKnife.bind(this);

        allQuestionsFragmentQuestionTextId.setText("test");

        Answers answers3 = new Answers();
        answers3.selectedAnswerList.add("xxxxxx");
        answers3.selectedAnswerList.add("fffffffff");

        addNewFragment(fragmentContainerId1, new Multiple_choice_CheckBox(answers3.selectedAnswerList));
        allQuestionsFragmentQuestionTextId.setOnClickListener(this);
        GoToCreatQuestions.setOnClickListener(this);

    }

    public void addNewFragment(FrameLayout frameLayout, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(frameLayout.getId(), fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.allQuestionsFragmentQuestionTextId:
                Answers answers4 = new Answers();
                answers4.selectedAnswerList.add("595");
                answers4.selectedAnswerList.add("sssssf");
                answers4.selectedAnswerList.add("qqqqqqqqqqqqq");
                addNewFragment(fragmentContainerId2, new Multiple_choice_CheckBox(answers4.selectedAnswerList));
                break;

            case R.id.button2:
               Intent intent = new Intent(AllQuestionActivity.this, QuestionsCreature.class);
               startActivity(intent);
               break;
        }
    }
}
