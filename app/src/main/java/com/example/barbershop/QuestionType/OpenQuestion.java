package com.example.barbershop.QuestionType;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.barbershop.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class OpenQuestion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.OpenQuestionTextId)
    EditText OpenQuestionTextId;
    @BindView(R.id.spinnerTypeOfAnswerId)
    Spinner spinnerTypeOfAnswerId;
    @BindView(R.id.switch1)
    Switch switch1;
    @BindView(R.id.OpenValidateId)
    Button OpenValidateId;
    @BindView(R.id.OpenCancelId)
    Button OpenCancelId;

    private String TempType;

    Questions openQuestions=new Questions();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_question);
        ButterKnife.bind(this);


        Intent recivedIntentObject = getIntent();
        openQuestions.QuestionsNumber = recivedIntentObject.getIntExtra("NumberOfTheQuestion",0);



        spinnerTypeOfAnswerId.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("Text");
        categories.add("Number");
        categories.add("PhoneNumber");

        ArrayAdapter<String> SpinerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinnerTypeOfAnswerId.setAdapter(SpinerAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         TempType = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @OnClick(R.id.OpenValidateId)
    public void onOpenValidateIdClicked() {
        /*if(OpenQuestionTextId.getText().toString().equals("")){
            FancyToast.makeText(this,"Plz enter a Question text and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
            return;
        }*/

        /*if(TempType==null){
            FancyToast.makeText(this,"chose what type of answer you need and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
            return;
        }*/

        openQuestions.ExepectedAnswerType=TempType;

        openQuestions.numberOfAnswersChoice=1;

        openQuestions.answersChoice.add(OpenQuestionTextId.getText().toString()+"");

        openQuestions.isTheAnswerRequierd=switch1.isChecked();

        AddQuestion.questionsArrayList.add(openQuestions);

        new SweetAlertDialog(this)
                .setTitleText("You have Successfully Add a question")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        finish();
                    }
                })
                .show();

        //Toast.makeText(this, AddQuestion.questionsArrayList.size()+"", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.OpenCancelId)
    public void onOpenCancelIdClicked() {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this Question!")
                .setCancelText("No,cancel plx!")
                .setConfirmText("Yes,delete it!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        finish();
                    }
                })
                .show();
    }




}
