package com.example.barbershop.QuestionType;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.barbershop.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class QuestionsCreature extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @BindView(R.id.ListViewID)
    ListView ListViewID;
    private ArrayList<String> stringArrayList;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_creature);
        ButterKnife.bind(this);

        //initialise:
        stringArrayList = new ArrayList<>();
        arrayAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_checked, stringArrayList);
        ListViewID.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        ListViewID.setOnItemClickListener(this);

        /*ParseUser parseUser =ParseUser.getCurrentUser();
        parseUser.put("TeamWith",null);*/


        // mange the flowing user(The teammate)
        try{
            ParseQuery<ParseUser> query= ParseUser.getQuery();
            query.whereNotEqualTo("username",ParseUser.getCurrentUser().getUsername());
            query.findInBackground(new FindCallback<ParseUser>() {
                @Override
                public void done(List<ParseUser> objects, ParseException e) {
                    if (objects.size()>0 && e == null){
                        for(ParseUser User:objects){
                            stringArrayList.add(User.getUsername());
                        }
                    }
                    ListViewID.setAdapter(arrayAdapter);
                    for(String TeamMate:stringArrayList){
                        if(ParseUser.getCurrentUser().getList("TeamWith")!=null) {

                            if (ParseUser.getCurrentUser().getList("TeamWith").contains(TeamMate)) {
                                ListViewID.setItemChecked(stringArrayList.indexOf(TeamMate), true);
                            }

                        }
                    }
                }
            });

        }catch (Exception e){

        }

        List TeamWithList=ParseUser.getCurrentUser().getList("TeamWith");

        for(Object Teammate:TeamWithList){


        }



    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CheckedTextView checkedTextView =(CheckedTextView) view;
        List TeamWithList=ParseUser.getCurrentUser().getList("TeamWith");
        if(checkedTextView.isChecked()){
            if(TeamWithList.contains(stringArrayList.get(position))){
                Toast.makeText(this, "You are ready team with: "+ stringArrayList.get(position), Toast.LENGTH_SHORT).show();
            }else {
                ParseUser.getCurrentUser().add("TeamWith", stringArrayList.get(position));
                Toast.makeText(this, stringArrayList.get(position) + " is checked", Toast.LENGTH_SHORT).show();
            }
        } else{
            TeamWithList.remove(stringArrayList.get(position));
            ParseUser.getCurrentUser().put("TeamWith",TeamWithList);
            Toast.makeText(this, stringArrayList.get(position)+" is inchecked", Toast.LENGTH_SHORT).show();
        }

        ParseUser.getCurrentUser().saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    Toast.makeText(QuestionsCreature.this, "The object has been save", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_teammate_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}


