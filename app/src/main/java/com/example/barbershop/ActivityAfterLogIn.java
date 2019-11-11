package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.parse.ParseUser;

public class ActivityAfterLogIn extends AppCompatActivity implements View.OnClickListener {



    private AppBarLayout appBarLayout;

    private androidx.appcompat.widget.Toolbar myToolBar;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdopter tabAdopter;

    private Button btnLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_log_in);
        setTitle("Title");
        findViews();
        //btnLogOut=findViewById(R.id.btnLogOut);
        //btnLogOut.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        /*switch (v.getId()){
            case(R.id.btnLogOut):
                if (ParseUser.getCurrentUser()!=null){
                    ParseUser.getCurrentUser().logOut();
                    finish();
                }
                break;
        }*/
    }


    private void findViews() {
        appBarLayout = (AppBarLayout)findViewById( R.id.appBarLayout );

        myToolBar = findViewById( R.id.myToolBar );
        setSupportActionBar(myToolBar);

        viewPager=findViewById( R.id.viewPager );
        tabAdopter =new TabAdopter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdopter);

        tabLayout = findViewById( R.id.tabLayout );
        tabLayout.setupWithViewPager(viewPager,false);
    }

}
