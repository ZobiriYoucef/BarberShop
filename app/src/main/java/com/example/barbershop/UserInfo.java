package com.example.barbershop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInfo extends AppCompatActivity {

    @BindView(R.id.my_image_view)
    SimpleDraweeView myImageView;
    private TextView tvUserName;
    private ImageView IvUserImage;
    private TextView tvUserImageInfo;


    private void findViews() {
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        IvUserImage = (ImageView) findViewById(R.id.IvUserImage);
        tvUserImageInfo = (TextView) findViewById(R.id.tvUserImageInfo);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);

        findViews();

        Intent recivedIntentObject = getIntent();
        String recivedUserName = recivedIntentObject.getStringExtra("username");

        setTitle(recivedUserName + "Something");

        ParseQuery<ParseUser> User = ParseUser.getQuery();
        User.whereEqualTo("username", recivedUserName);
        User.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (objects != null && e == null) {
                    tvUserName.setText(objects.get(0).getUsername());
                    tvUserImageInfo.setText(objects.get(0).get("PictureInfo") + "");
                    ParseFile parseFilePicture = (ParseFile) objects.get(0).get("UserPicture");

                    //GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources()).build();
                    //hierarchy.setProgressBarImage(new ProgressBarDrawable());
                   // myImageView.setHierarchy(hierarchy);
                    myImageView.setImageURI(Uri.parse(parseFilePicture.getUrl()));


                    if (parseFilePicture == null) {

                    } else {
                        parseFilePicture.getDataInBackground(new GetDataCallback() {
                            @Override
                            public void done(byte[] data, ParseException e) {
                                if (data != null && e == null) {
                                    //We are going to conver the data to an image to put it in the image view:
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                                    IvUserImage.setImageBitmap(bitmap);
                                } else {
                                    FancyToast.makeText(UserInfo.this, e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                                }
                            }
                        });
                    }

                }
            }
        });

    }
}
