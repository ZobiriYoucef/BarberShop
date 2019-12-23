package com.example.barbershop;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.barbershop.QuestionType.AddQuestion;
import com.example.barbershop.QuestionType.AllQuestionActivity;
import com.example.barbershop.QuestionType.StartASurvey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.parse.ParseInstallation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.goToAddQuestion)
    Button goToAddQuestion;

    private EditText Name, LastName, Job;
    private Button Sand, btnGetDataFromSurver, GoToTheActivityLayout, vvv,goToSurveyLabTest;
    private ConstraintLayout constraintLayout;
    private AnimationDrawable animationDrawable;
    private LottieAnimationView mLottie;
    private TextView TheObjectList;
    private String Thelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ParseInstallation.getCurrentInstallation().saveInBackground();

        Fresco.initialize(this);


        // hide keyborde on the start
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        Name = findViewById(R.id.etName);
        LastName = findViewById(R.id.etLastName);
        Job = findViewById(R.id.etJob);

        Sand = findViewById(R.id.btnSand);
        btnGetDataFromSurver = findViewById(R.id.btnGetDataFromSurver);
        GoToTheActivityLayout = findViewById(R.id.btnGoToTheActivityLayout);


        Sand.setOnClickListener(this);
        btnGetDataFromSurver.setOnClickListener(this);
        GoToTheActivityLayout.setOnClickListener(this);

        goToAddQuestion.setOnClickListener(this);

        //Animation background
        constraintLayout = findViewById(R.id.consLayout1);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        //Animation mLottie
        mLottie = findViewById(R.id.loading_view);

        TheObjectList = findViewById(R.id.tvTheList);

        vvv = findViewById(R.id.xxx);
        vvv.setOnClickListener(this);

        goToSurveyLabTest=findViewById(R.id.goToSurveyLabTest);
        goToSurveyLabTest.setOnClickListener(this);

        /*animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();*/


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.btnSand:
                try {
                    //Keybord
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(constraintLayout.getWindowToken(), 0);

                    //StartAnimation
                    mLottie.playAnimation();

                    //Creat a new Class:
                    ParseObject Person = new ParseObject("Person");
                    Person.put("Name", Name.getText().toString());
                    Person.put("LastName", LastName.getText().toString());
                    Person.put("Job", Job.getText().toString());

                    //Save In Background
                    Person.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                mLottie.cancelAnimation();
                                FancyToast.makeText(MainActivity.this, "The Person object is save successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                            } else
                                FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();

                        }
                    });


                } catch (Exception e) {
                    FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                }
                break;*/

            /*case R.id.btnGetDataFromSurver:
                try {
                    TheObjectList.setText("");

                    //by a specific Single code:

                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Person");
                parseQuery.getInBackground("cFVIkm463K", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if (object!=null && e==null){
                            FancyToast.makeText(MainActivity.this,object.get("Name").toString(),FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                        }
                    }
                });


                    // listPars.
                    ParseQuery<ParseObject> listPars = ParseQuery.getQuery("Person");
                    listPars.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> objects, ParseException e) {

                            if (e == null && objects.size() > 0) {
                                for (ParseObject listPars : objects) {
                                    Thelist = Thelist + listPars.get("Name").toString() + "\n";
                                }
                                FancyToast.makeText(MainActivity.this, Thelist, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                            } else
                                FancyToast.makeText(MainActivity.this, "error", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                        }
                    });

                } catch (Exception e) {
                    FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                }
                break;*/

            case R.id.btnGoToTheActivityLayout:
                try {
                    Intent intentToLogInActivity = new Intent(MainActivity.this, LogInActivity.class);
                    startActivity(intentToLogInActivity);

                } catch (Exception e) {

                }

            case R.id.xxx: {
                Intent intentToAllQuestionActivity = new Intent(MainActivity.this, AllQuestionActivity.class);
                startActivity(intentToAllQuestionActivity);
                break;
            }
            case R.id.goToAddQuestion: {
                Intent intentToAddQuestion = new Intent(MainActivity.this, AddQuestion.class);
                startActivity(intentToAddQuestion);
                break;
            }
            case R.id.goToSurveyLabTest: {
                Intent intentToGoToSurveyLabTest = new Intent(MainActivity.this, StartASurvey.class);
                startActivity(intentToGoToSurveyLabTest);
                break;
            }

        }
    }
}
