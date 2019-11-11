package com.example.barbershop;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.parse.LogInCallback;
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
        setTitle("Sign Up");
        if(ParseUser.getCurrentUser()!=null){
           // ParseUser.getCurrentUser().logOut();
            SwitchToProfiles();
        }
        clearAll((ViewGroup) findViewById(R.id.constLayoutMain));

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    private ConstraintLayout constLayoutCreat,constLayoutMain;
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



    ProgressDialog progressDialog;


    private void findViews() {
        constLayoutCreat = (ConstraintLayout)findViewById( R.id.constLayoutCreat );
        constLayoutMain=(ConstraintLayout)findViewById( R.id.constLayoutMain );
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

        //Enter Key
        etPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
            if(keyCode==KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN){
                if(btnCreatNew.getText().toString().equals("SignUp")) onClick(btnLogIn);else onClick(btnCreatNew);
            }
                return false;
            }
        });

        btnLogIn.setOnClickListener( this );
        btnCreatNew.setOnClickListener( this );
        constLayoutMain.setOnClickListener(this);
        constLayoutCreat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogIn:
                HideKeyBord();
                if(btnLogIn.getText().toString()!="Cancel"){
                    if (isNotEmpty(etUserId)&& isNotEmpty(etPassword)) {
                        progressDialog =new ProgressDialog(this);
                        progressDialog.setMessage("Log In "+etUserId.getText().toString());
                        progressDialog.show();
                        ParseUser.logInInBackground(etUserId.getText().toString(), etPassword.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if(user!=null && e==null){

                                    SwitchToProfiles();

                                    progressDialog.dismiss();
                                    FancyToast.makeText(LogInActivity.this,"You have successfully login "+user.getUsername(),FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();

                                }else  {
                                    progressDialog.dismiss();
                                    FancyToast.makeText(LogInActivity.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();

                                }
                            }

                        });

                    }else  FancyToast.makeText(LogInActivity.this,"Please Check your UserName or your PassWord",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();

                }else{
                clearAll((ViewGroup) findViewById(R.id.constLayoutMain));
                constLayoutCreat.setVisibility(View.INVISIBLE);
                btnCreatNew.setText("SignUp");
                btnLogIn.setText("LogIn");

                }
            break;

            case R.id.btnCreatNew:
                HideKeyBord();
                if(btnCreatNew.getText().toString().toLowerCase().equals("signup")){
                    btnLogIn.setText("Cancel");
                    constLayoutCreat.setVisibility(View.VISIBLE);
                    btnCreatNew.setText("Finishing SignUp");
                    break;
                }
                if(btnCreatNew.getText().toString()=="Finishing SignUp"){

                    if(etFirstName.getText().toString().isEmpty()) {
                        FancyToast.makeText(this,"Plz Enter The First Name and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                        break;
                    }
                    if(etLastName.getText().toString().isEmpty()){
                        FancyToast.makeText(this,"Plz Enter The last Name and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                    break;
                    }
                    if(etPhoneNumber.getText().toString().isEmpty()) {
                        FancyToast.makeText(this,"Plz Enter your phone number and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                        break;
                    }
                    if(etJob.getText().toString().isEmpty()){
                        FancyToast.makeText(this,"Plz Enter The name of your job and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                    break;
                    }
                    if(etPassword.getText().toString().isEmpty()){
                        FancyToast.makeText(this,"Plz Enter a password and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                    break;
                    }
                    if(etUserId.getText().toString().isEmpty()){
                        FancyToast.makeText(this,"Plz Enter an id and try again",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                    break;
                    }

                        final ParseUser parseUser = new ParseUser();
                        parseUser.setUsername(etUserId.getText().toString());
                        parseUser.setPassword(etPassword.getText().toString());
                        PushToUsers(etFirstName);
                        PushToUsers(etLastName);
                        PushToUsers(etJob);
                        PushToUsers(etPhoneNumber);
                        PushToUsers(etUserId);
                        PushToUsers(etPassword);

                        progressDialog =new ProgressDialog(this);
                        progressDialog.setMessage("Sign In "+etUserId.getText().toString());
                        progressDialog.show();
                        parseUser.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if(e==null){

                                    Users.saveInBackground();

                                    SwitchToProfiles();

                                    progressDialog.dismiss();
                                    FancyToast.makeText(LogInActivity.this,"Great, you have successfully SignUp "+ parseUser.getUsername(),FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();

                                }else{
                                    progressDialog.dismiss();
                                    FancyToast.makeText(LogInActivity.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();

                                }
                            }
                        });




                    } break;

            case R.id.constLayoutMain:
                rootLayoutTapped(constLayoutMain);
                break;

            case R.id.constLayoutCreat:
                rootLayoutTapped((constLayoutCreat));
                break;
        }


    }

    private void PushToUsers(EditText Et){
        Users.put(Et.getTag().toString(),Et.getText().toString());
    }

    public void clearAll(ViewGroup root) {
        for (int i = 0, j = root.getChildCount(); i < j; i++) {
            View view = root.getChildAt(i);
            /*if (view instanceof ViewGroup) {
                clearAll((ViewGroup) view);
                continue;
            }*/
            if (view instanceof EditText) {
                ((EditText) view).setText("");
                continue;
            }
        }
    }

    private boolean isNotEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }

    private void HideKeyBord(){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(constLayoutMain.getWindowToken(), 0);
    }

    public void rootLayoutTapped(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }

    private void SwitchToProfiles(){
        Intent intent = new Intent(LogInActivity.this,ActivityAfterLogIn.class);
        startActivity(intent);
    }

}
