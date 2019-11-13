package com.example.barbershop;


import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.io.ByteArrayOutputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class Share_Tab extends Fragment implements View.OnClickListener {


    //Declare my varible
    private ImageView SharedimageView;
    private Button btnShareButton;
    private EditText etImageInfo;
    private ProgressDialog nDialog;

    // varible that check if the user have selected a img or not
    private Bitmap receivedImageBitmap;


    // the activity constructor
    public Share_Tab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // turn this line of code to View view =
        View view= inflater.inflate(R.layout.fragment_share__tab, container, false);
        SharedimageView=view.findViewById(R.id.ivSharedImage);
        btnShareButton=view.findViewById(R.id.btnShareImage);
        etImageInfo=view.findViewById(R.id.etImageInfo);
        // call onClick methodes
        SharedimageView.setOnClickListener(Share_Tab.this);
        btnShareButton.setOnClickListener(Share_Tab.this);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ivSharedImage:

                // check the permissions from the user
                if(Build.VERSION.SDK_INT >=23 && ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1000);
                }else {

                    // if we got the permissions we call the methoeds that get the image
                    getChosenImage();
                }

            break;
            case R.id.btnShareImage:

                // check we have selected a image
                if (receivedImageBitmap!=null) {
                    if (!isNotEmpty(etImageInfo)) {
                        FancyToast.makeText(getContext(), "Please enter some info about image", FancyToast.LENGTH_SHORT, FancyToast.WARNING, false).show();
                    } else {

                        //FancyToast.makeText(getContext(),"Please select a img before",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
                        // Creat an array to turn image to byte array
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        // Turn The image to an Array of byte
                        receivedImageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byte[] bytes = byteArrayOutputStream.toByteArray();

                        //the procedure of snd The image to the server
                        ParseFile parseFile = new ParseFile("img.png", bytes);
                        ParseUser parseUser=ParseUser.getCurrentUser();

                        parseUser.put("UserPicture", parseFile);
                        parseUser.put("PictureInfo", etImageInfo.getText().toString());

                        //The Loading ProgressDialog
                        nDialog = new ProgressDialog(getActivity());
                        nDialog.setMessage("msg");
                        nDialog.show();


                        //Save the data to the servers:
                        parseUser.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e != null) {
                                    FancyToast.makeText(getContext(), "Done!!", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
                                    nDialog.dismiss();
                                } else {
                                    FancyToast.makeText(getContext(), e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                                    nDialog.dismiss();
                                }

                            }
                        });


                    }
                }


            break;
        }
    }

    private void getChosenImage() {
        //FancyToast.makeText(getContext(),"",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();

        // here we are transfaring to the MediaStore lyout
   Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
   startActivityForResult(intent,2000);
    }



    // this methodes will be called automaticly when we ask for permissions
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // check if the requast are the same that are ben asked
        if (requestCode==1000){
            // check if the request has been accepted or not
            if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                getChosenImage();
            }
        }
    }


    // this methodes will be auto call after we try to selected a photo file or something
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //check if this are the result of that specific file whe the request code match
        if(requestCode==2000){
            // check if we got a result
            if(resultCode== Activity.RESULT_OK){
                //We will do somthing with the capture Image
                try{
                    // tri to capture a specific image and turn it to ImageView (one image)
                    Uri slectedImage=data.getData();
                    String[] filePathColoumn={MediaStore.Images.Media.DATA};

                    Cursor cursor=getActivity().getContentResolver().query(slectedImage,filePathColoumn,null,null,null);
                    cursor.moveToFirst();
                    int columnIndex=cursor.getColumnIndex(filePathColoumn[0]);
                    String picturePath =cursor.getString(columnIndex);
                    cursor.close();
                    receivedImageBitmap= BitmapFactory.decodeFile(picturePath);
                    SharedimageView.setImageBitmap(receivedImageBitmap);


                }catch(Exception e){

                }
            }else{
                // if we didn't select try again until we select a image
                getChosenImage();
            }
        }
    }

    private boolean isNotEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }
}
