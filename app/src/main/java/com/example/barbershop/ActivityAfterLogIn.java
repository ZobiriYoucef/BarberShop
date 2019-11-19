package com.example.barbershop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.io.ByteArrayOutputStream;

import github.chenupt.springindicator.SpringIndicator;

public class ActivityAfterLogIn extends AppCompatActivity implements View.OnClickListener {



    private AppBarLayout appBarLayout;

    private androidx.appcompat.widget.Toolbar myToolBar;

    //private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdopter tabAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_log_in);

        setTitle("Title");
        findViews();
    }


    @Override
    public void onClick(View v) {

    }


    private void findViews() {
        appBarLayout = (AppBarLayout)findViewById( R.id.appBarLayout );

        myToolBar = findViewById( R.id.myToolBar );
        setSupportActionBar(myToolBar);

        viewPager=findViewById( R.id.viewPager );

        tabAdopter =new TabAdopter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdopter);

        //tabLayout = findViewById( R.id.tabLayout );
        //tabLayout.setupWithViewPager(viewPager,false);
    }


    //Creat the menu:


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);


        return super.onCreateOptionsMenu(menu);
    }

    // To select something from the menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.postImageItem:


                // check the permissions from the user
                if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(ActivityAfterLogIn.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3000);
                } else {

                    // if we got the permissions we call the methoeds that get the image
                    CaptureImage();
                }

            break;

            case R.id.LogOutUser:
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Are you sure you want to logout?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ParseUser.getCurrentUser().logOut();
                                    finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }catch (Exception e){
                    FancyToast.makeText(this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                }
        }
        return super.onOptionsItemSelected(item);
    }


    // this methodes will be called automaticly when we ask for permissions
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // check if the requast are the same that are ben asked
        if (requestCode==3000){
            // check if the request has been accepted or not
            if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                CaptureImage();
            }
        }
    }

    private void CaptureImage() {

        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,4000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==4000 && resultCode==RESULT_OK && data!=null){
            try {
                Uri captureImage=data.getData();
                Bitmap bitmapCaptureImage= MediaStore.Images.Media.getBitmap(this.getContentResolver(),captureImage);
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                bitmapCaptureImage.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
                byte[] bytes =byteArrayOutputStream.toByteArray();

            }catch (Exception e){
                FancyToast.makeText(this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
            }

        }
    }

    //OnBackPressed
}
