package com.example.barbershop.QuestionType;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.barbershop.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ListHolder;
import com.orhanobut.dialogplus.OnBackPressListener;
import com.orhanobut.dialogplus.OnCancelListener;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnDismissListener;
import com.orhanobut.dialogplus.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddQuestion extends AppCompatActivity {

    @BindView(R.id.floatingButton1)
    FloatingActionButton floatingButton1;
    @BindView(R.id.floatingButton2)
    FloatingActionButton floatingButton2;
    @BindView(R.id.menu)
    FloatingActionMenu floatingMenu;
    @BindView(R.id.list)
    ListView list;

    public ArrayAdapter QuestionTypeAdaptor;

    Questions questions = new Questions();

    ArrayList<SubjectData> subjectDataArrayList = new ArrayList<>();
    CustomAdapterForListWithImage customAdapterForListWithImage = new CustomAdapterForListWithImage(subjectDataArrayList, this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        ButterKnife.bind(this);


        QuestionTypeAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questions.QuestionTypeArrayList);

        //get the question list from the questions constractor

        //try to work with image in a listview
        subjectDataArrayList.add(new SubjectData("image1", R.drawable.plus));
        subjectDataArrayList.add(new SubjectData("image2", R.drawable.addquestion));
        list.setAdapter(customAdapterForListWithImage);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=subjectDataArrayList.get(i).SubjectName;
                Toast.makeText(AddQuestion.this, s, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.floatingButton1)
    public void onViewClicked() {
        DialogPlus dialog = DialogPlus.newDialog(this)

                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(DialogPlus dialog, Object item, View view, int position) {

                        String TypeOftheSelectedQuestion = subjectDataArrayList.get(position).SubjectName;
                        Toast.makeText(AddQuestion.this, TypeOftheSelectedQuestion, Toast.LENGTH_SHORT).show();
                        //questions.SelectedType=TypeOftheSelectedQuestion;
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
    }

}
