package com.example.barbershop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        findViews();
    }

    private ConstraintLayout constLayoutCreat;
    private EditText etFirstName;
    private TextView textView5;
    private TextView textView6;
    private EditText etLastName;
    private TextView textView7;
    private EditText etPhoneNumber;
    private TextView textView8;
    private EditText etJob;
    private TextView textView9;
    private EditText etPassword;
    private TextView textView10;
    private EditText etUserId;
    private Button btnLogIn;
    private Button btnCreatNew;
    private ParseObject Users =new ParseObject("UsersInfo");

    private void findViews() {
        constLayoutCreat = (ConstraintLayout)findViewById( R.id.constLayoutCreat );
        etFirstName = (EditText)findViewById( R.id.etFirstName );
        textView5 = (TextView)findViewById( R.id.textView5 );
        textView6 = (TextView)findViewById( R.id.textView6 );
        etLastName = (EditText)findViewById( R.id.etLastName );
        textView7 = (TextView)findViewById( R.id.textView7 );
        etPhoneNumber = (EditText)findViewById( R.id.etPhoneNumber );
        textView8 = (TextView)findViewById( R.id.textView8 );
        etJob = (EditText)findViewById( R.id.etJob );
        textView9 = (TextView)findViewById( R.id.textView9 );
        etPassword = (EditText)findViewById( R.id.etPassword );
        textView10 = (TextView)findViewById( R.id.textView10 );
        etUserId = (EditText)findViewById( R.id.etUserId );
        btnLogIn = (Button)findViewById( R.id.btnLogIn );
        btnCreatNew = (Button)findViewById( R.id.btnCreatNew );

        btnLogIn.setOnClickListener( this );
        btnCreatNew.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogIn:
                if(btnLogIn.getText().toString()=="Cancel"){
                btnCreatNew.setText("Creat a new profile");
                constLayoutCreat.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(this, "What the fuck happend here", Toast.LENGTH_SHORT).show();
                }
            break;

            case R.id.btnCreatNew:
           btnCreatNew.setText("Log In with new profile");
           btnLogIn.setText("Cancel");
           constLayoutCreat.setVisibility(View.VISIBLE);
            if(etFirstName.getText().toString()=="") FancyToast.makeText(this,"Plz Enter The First Name and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
            if(etLastName.getText().toString()=="") FancyToast.makeText(this,"Plz Enter The last Name and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
            if(etJob.getText().toString()=="") FancyToast.makeText(this,"Plz Enter The name of your job and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
            if(etPhoneNumber.getText().toString()=="") FancyToast.makeText(this,"Plz Enter your phone number and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                if(etPassword.getText().toString()=="") FancyToast.makeText(this,"Plz Enter a password and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                if(etUserId.getText().toString()=="") FancyToast.makeText(this,"Plz Enter an id and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
            if(etFirstName.getText().toString()!=""&&etLastName.getText().toString()!=""&&etJob.getText().toString()!=""&&etPhoneNumber.getText().toString()!=""&&etPassword.getText().toString()!=""&&etUserId.getText().toString()!=""){
                ParseUser parseUser = new ParseUser();
                parseUser.setUsername(etUserId.getText().toString());
                parseUser.setPassword(etPassword.getText().toString());
                PushToUsers(etFirstName);
                PushToUsers(etLastName);
                PushToUsers(etJob);
                PushToUsers(etPhoneNumber);
                PushToUsers(etUserId);
                PushToUsers(etPassword);

                parseUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            FancyToast.makeText(LogInActivity.this,"Great, you have successfully SignUp",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                            Users.saveInBackground();
                            Intent intent = new Intent(LogInActivity.this,ActivityAfterLogIn.class);
                            startActivity(intent);
                        }else{
                            FancyToast.makeText(LogInActivity.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                        }
                    }
                });




            }
            break;


        }


    }

    private void PushToUsers(EditText Et){
        Users.put(Et.getTag().toString(),Et.getText().toString());
    }


}
