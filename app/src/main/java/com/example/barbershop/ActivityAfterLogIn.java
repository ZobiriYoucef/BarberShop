package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

public class ActivityAfterLogIn extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_log_in);
        btnLogOut=findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.btnLogOut):
                if (ParseUser.getCurrentUser()!=null){
                    ParseUser.getCurrentUser().logOut();
                    finish();
                }
                break;
        }
    }
}
