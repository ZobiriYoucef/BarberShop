package com.example.barbershop.QuestionType;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.barbershop.R;
import com.github.clans.fab.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.HashMap;
import java.util.Map;


public class QuestionsCreature extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_creature);


    }
    //Create a button to attach the menu:
    ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.plus);
    FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
            .setContentView(icon)
            .build();
    //Create menu items:
    SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
    AddFloatingActionButton(itemBuilder,"AddQuestion",R.drawable.addquestion);
    AddFloatingActionButton(itemBuilder,"AddQuestionChoise",R.drawable.addquestionchoise);
    AddFloatingActionButton(itemBuilder,"AddQuestionRules",R.drawable.addquestionrules);
    //Create the menu with the items:
    FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
            .addSubActionView(subActionButton.get("AddQuestion"))
            .addSubActionView(subActionButton.get("AddQuestionChoise"))
            .addSubActionView(subActionButton.get("AddQuestionRules"))
            .attachTo(actionButton)
            .build();

    private final Map<String, SubActionButton> subActionButton = new HashMap<>();
    public void AddFloatingActionButton(SubActionButton.Builder itemBuilder,String buttonName,int ImageResource){
        FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(20, 20);
        ImageView itemIcon = new ImageView(this);
        itemIcon.setImageResource(ImageResource);
        SubActionButton button = itemBuilder.setContentView(itemIcon)
                .setTheme(3)
                .build();
        subActionButton.put(buttonName,button);
    }


    @Override
    public void onClick(View v) {

    }
}


