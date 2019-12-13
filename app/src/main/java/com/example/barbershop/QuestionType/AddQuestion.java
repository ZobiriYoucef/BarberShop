package com.example.barbershop.QuestionType;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.barbershop.R;
import com.google.android.material.internal.NavigationMenu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ListHolder;
import com.orhanobut.dialogplus.OnBackPressListener;
import com.orhanobut.dialogplus.OnCancelListener;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnDismissListener;
import com.orhanobut.dialogplus.OnItemClickListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;

public class AddQuestion extends AppCompatActivity {
    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.numberOfItemInArray)
    TextView numberOfItemInArray;

    //The List That Show Type Of Questions
    ArrayList<SubjectData> subjectDataArrayList = new ArrayList<>();
    CustomAdapterForListWithImage customAdapterForListWithImage = new CustomAdapterForListWithImage(subjectDataArrayList, this);

    private static ArrayList<Questions> questionsArrayList;
    private QuestionsAadpter questionsAadpter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        ButterKnife.bind(this);

        //Creating a shared preference:
        //SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);

        //try to work with image in a listView in the the center of the screen
        subjectDataArrayList.add(new SubjectData("Open", R.drawable.plus));
        subjectDataArrayList.add(new SubjectData("OneChoice", R.drawable.addquestion));
        subjectDataArrayList.add(new SubjectData("MultiChoice", R.drawable.addquestion));

        if(questionsArrayList==null){ questionsArrayList= new ArrayList<>(); }

        questionsAadpter=new QuestionsAadpter(AddQuestion.this, questionsArrayList);
        list.setAdapter(questionsAadpter);

        Intent intent=getIntent();
        Questions Openquestions=intent.getParcelableExtra("OpenQuestion");
        if(Openquestions!=null){
            questionsArrayList.add(Openquestions);
        }

        FabSpeedDial fabSpeedDial = findViewById(R.id.FabSpeedID);
        fabSpeedDial.setMenuListener(new SimpleMenuListenerAdapter() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                // TODO: Do something with yout menu items, or return false if you don't want to show them
                return true;
            }
            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_call:
                        //Text that display the number of item in the array
                        numberOfItemInArray.setText(questionsArrayList.size()+"");
                        DialogPlus dialog = DialogPlus.newDialog(AddQuestion.this)
                                .setOnItemClickListener(new OnItemClickListener() {
                                    @Override
                                    public void onItemClick(DialogPlus dialog, Object item, View view, int position) {

                                        String TypeOftheSelectedQuestion = subjectDataArrayList.get(position).SubjectName;
                                        Toast.makeText(AddQuestion.this, TypeOftheSelectedQuestion, Toast.LENGTH_SHORT).show();

                                        switch (TypeOftheSelectedQuestion) {

                                            case "Open":
                                                Intent intent = new Intent(AddQuestion.this, OpenQuestion.class);
                                                startActivity(intent);
                                                dialog.dismiss();
                                                break;

                                            case "OneChoice":

                                                break;

                                            case "MultiChoice":

                                                break;

                                        }

                                        dialog.dismiss();
                                    }
                                })

                                .setAdapter(customAdapterForListWithImage)

                                //global click listener to you dialog
                                .setOnClickListener(new OnClickListener() {
                                    @Override
                                    public void onClick(DialogPlus dialog, View view) {
                                        // dialog.dismiss();
                                    }
                                })

                                //set header
                                .setHeader(R.layout.types_of_questions_header)

                                //set footer
                                //.setFooter(R.layout.????)

                                //Dismiss listener
                                .setOnDismissListener(new OnDismissListener() {
                                    @Override
                                    public void onDismiss(DialogPlus dialog) {

                                    }
                                })

                                //set Cancel listener
                                .setOnCancelListener(new OnCancelListener() {
                                    @Override
                                    public void onCancel(DialogPlus dialog) {

                                    }
                                })

                                //set click bake listener
                                .setOnBackPressListener(new OnBackPressListener() {
                                    @Override
                                    public void onBackPressed(DialogPlus dialog) {

                                    }
                                })

                                //.setContentHolder(new ViewHolder(R.layout.types_of_questions))

                                .setContentHolder(new ListHolder())
                                .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                                .setGravity(Gravity.CENTER)
                                .setCancelable(true)
                                .setContentWidth(ViewGroup.LayoutParams.WRAP_CONTENT)  // or any custom width ie: 300
                                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                                .create();
                        dialog.show();
                        break;
                 }
                return true;
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        questionsAadpter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.SaveTheSurveyQuestionsItem:
                SharedPreferences  mPrefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(questionsArrayList);
                prefsEditor.putString("MyQuestionsArrayList", json);
                prefsEditor.apply();
                Toast.makeText(this, "Array has been saved", Toast.LENGTH_SHORT).show();
                break;

            case R.id.RetriveTheSurveyQuestionsItem:
                mPrefs = getPreferences(MODE_PRIVATE);
                gson = new Gson();
                json = mPrefs.getString("MyQuestionsArrayList", "");
                Type type = new TypeToken<List<Questions>>() {}.getType();
                questionsArrayList = gson.fromJson(json, type);
                questionsAadpter=new QuestionsAadpter(AddQuestion.this, questionsArrayList);
                list.setAdapter(questionsAadpter);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        SweetAlertDialog swt= new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        swt.setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this Survey!")
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
                    sweetAlertDialog.cancel();
                    questionsArrayList=null;
                    finish();
                    }
                })
                .show();
    }

}
