package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseInstallation;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class UserInfo extends AppCompatActivity {

    private TextView tvUserName;
    private ImageView IvUserImage;
    private TextView tvUserImageInfo;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2019-11-14 15:59:28 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        tvUserName = (TextView)findViewById( R.id.tvUserName );
        IvUserImage = (ImageView)findViewById( R.id.IvUserImage );
        tvUserImageInfo = (TextView)findViewById( R.id.tvUserImageInfo );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        findViews();

        Intent recivedIntentObject = getIntent();
        String recivedUserName=recivedIntentObject.getStringExtra("username");

        setTitle(recivedUserName+"Something");

        ParseQuery<ParseUser> User= ParseUser.getQuery();
        User.whereEqualTo("username",recivedUserName);
        User.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
            if(objects!=null && e==null){
                tvUserName.setText(objects.get(0).getUsername());
                tvUserImageInfo.setText(objects.get(0).get("PictureInfo") +"");
                ParseFile parseFilePicture = (ParseFile) objects.get(0).get("UserPicture");
                parseFilePicture.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        if(data!=null && e==null){
                           //We are going to conver the data to an image to put it in the image view:
                            Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);

                        }else{
                            FancyToast.makeText(UserInfo.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                        }
                    }
                });
                IvUserImage.setImageResource(objects.get(0).);
            }
            }
        });

    }
}
