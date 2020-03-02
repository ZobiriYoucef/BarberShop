package com.example.barbershop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.barbershop.utils.FileUtils;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
import com.google.i18n.phonenumbers.PhoneNumberMatch;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UsePhoneCamera extends AppCompatActivity {

    private static final int CAMERA_ACTION_PICK_REQUEST_CODE = 610;
    private static final int PICK_IMAGE_GALLERY_REQUEST_CODE = 609;
    public static final int CAMERA_STORAGE_REQUEST_CODE = 611;
    public static final int ONLY_CAMERA_REQUEST_CODE = 612;
    public static final int ONLY_STORAGE_REQUEST_CODE = 613;

    Context context= UsePhoneCamera.this;
    ImageView imageView;
    Button BtnCap,BtnScan;
    TextView ScannedText,tvname,tvemail,tvphone,tvphone2,tvWebsite,tvAdrress,tvJob,tvCompany;
    Bitmap bitmapUsedForScanne;
    String ScannResualt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_phone_camera);
        imageView=findViewById(R.id.imageViewCam);
        BtnCap= findViewById(R.id.BtnCaptureImage);
        BtnScan=findViewById(R.id.BtnScanneCard);
        ScannedText=findViewById(R.id.tvScannedText);
        tvname=findViewById(R.id.tvNameOCR);
        tvemail=findViewById(R.id.TvEmailOCR);
        tvphone=findViewById(R.id.TvPhoneOCR);
        tvphone2=findViewById(R.id.TvPhoneOCR2);
        tvWebsite=findViewById(R.id.tvWebsite);
        tvAdrress=findViewById(R.id.tvAdrress);
        tvJob    =findViewById(R.id.tvJob);
        tvCompany=findViewById(R.id.tvCompany);


        BtnCap.setOnClickListener(v -> {
            try {
                openCamera();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        BtnScan.setOnClickListener(v->{
            if(bitmapUsedForScanne!=null){
                runTextRecognition(bitmapUsedForScanne);
                if(ScannResualt!=null){
                    ScannedText.setText(ScannResualt);
                }

            }
        });

        tvphone.setText("");

    }

    private void openCamera() throws IOException {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = getImageFile(); // 1
        Uri uri;
        uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID.concat(".provider"), file);
        pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri); // 4
        startActivityForResult(pictureIntent, CAMERA_ACTION_PICK_REQUEST_CODE);
    }


    String currentPhotoPath = "";

    private File getImageFile() throws IOException {
        String imageFileName = "JPEG_" + System.currentTimeMillis() + "_";
        File storageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DCIM
                ), "Camera"
        );
        System.out.println(storageDir.getAbsolutePath());
        if (storageDir.exists())
            System.out.println("File exists");
        else
            System.out.println("File not exists");
        File file = File.createTempFile(
                imageFileName, ".jpg", storageDir
        );
        currentPhotoPath = "file:" + file.getAbsolutePath();
        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_ACTION_PICK_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri uri = Uri.parse(currentPhotoPath);
            openCropActivity(uri, uri);
        } else if (requestCode == UCrop.REQUEST_CROP && resultCode == RESULT_OK) {
            Uri uri = UCrop.getOutput(data);
            try {
                showImage(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private void openCropActivity(Uri sourceUri, Uri destinationUri) {
        UCrop.of(sourceUri, destinationUri)
                .withMaxResultSize(3600, 2000)
                .withAspectRatio(16, 9)
                .start((AppCompatActivity) context);
    }

    private void showImage(Uri imageUri) throws FileNotFoundException {
        File file = FileUtils.getFile(context, imageUri);
        InputStream inputStream = new FileInputStream(file);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        imageView.setImageBitmap(bitmap);
        bitmapUsedForScanne=bitmap;
    }

    private void runTextRecognition(Bitmap Functionbitmap) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(Functionbitmap);
        FirebaseVisionTextRecognizer recognizer = FirebaseVision.getInstance().getOnDeviceTextRecognizer();
        BtnScan.setEnabled(false);
        recognizer.processImage(image)
                .addOnSuccessListener(
                        texts -> {
                            BtnScan.setEnabled(true);
                            processTextRecognitionResult(texts);

                        })
                .addOnFailureListener(
                        e -> {
                            // Task failed with an exception
                            BtnScan.setEnabled(true);
                            e.printStackTrace();
                        });
    }

    private void processTextRecognitionResult(FirebaseVisionText texts) {
        List<FirebaseVisionText.TextBlock> blocks = texts.getTextBlocks();
        if (blocks.size() == 0) {
            showToast("No text found");
            return;
        }
        for (int i = 0; i < blocks.size(); i++) {
            //showToast(blocks.get(i).getText());
            List<FirebaseVisionText.Line> lines = blocks.get(i).getLines();
            for (int j = 0; j < lines.size(); j++) {
                if(lines.get(j).getText().matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]") || lines.get(j).getText().startsWith("www") || lines.get(j).getText().contains("Website") || lines.get(j).getText().contains("www")){
                    tvWebsite.setText(lines.get(j).getText());
                }
                // .[A-Z].[^@$#/-<>!]+

                if(lines.get(j).getText().matches("[a-zA-z]+([ '-][a-zA-Z]+)*")){
                    if(lines.get(j).getElements().size()==2){
                    tvname.setText(lines.get(j).getText());
                    }
                }

                if(lines.get(j).getText().matches("^.[A-Z].[^@$#/-<>!]+")){
                    if(lines.get(j).getElements().size()==1){
                        tvCompany.setText(lines.get(j).getText());
                    }
                }

                if(lines.get(j).getText().matches("[a-zA-z]+([ '-][a-zA-Z]+)*")){
                    if(lines.get(j).getText()!=tvname.getText()&& lines.get(j).getText()!=tvCompany.getText() && lines.get(j).getElements().size()>1){
                        tvJob.setText(lines.get(j).getText());
                    }

                }

                if(lines.get(j).getText().contains("Address:") || lines.get(j).getText().contains("Address") || lines.get(j).getText().contains("Address :")  || lines.get(j).getText().contains("Address : ")|| lines.get(j).getText().contains("Cité") || lines.get(j).getText().contains("Rue") || lines.get(j).getText().contains("Alger") || lines.get(j).getText().contains("Algérie") || lines.get(j).getText().contains("Hai") || lines.get(j).getText().contains("R.N")|| lines.get(j).getText().contains("R.N.")|| lines.get(j).getText().contains("Avenue")|| lines.get(j).getText().contains("Road")){
                    String line1=lines.get(j).getText();
                    String line2="";
                    if(j+1<lines.size()){
                         line2=lines.get(j+1).getText();
                    }
                    tvAdrress.setText(line1+"\n"+line2);
                }

                List<FirebaseVisionText.Element> elements = lines.get(j).getElements();
                for (int k = 0; k < elements.size(); k++) {

                }
            }
        }

        //Full Text
        String text="";
        for(FirebaseVisionText.TextBlock textBlock:texts.getTextBlocks()){
            text = text+ "\n" + textBlock.getText();
        }
        ScannedText.setText(text);


        tvemail.setText(parseEmail(text));


        ArrayList<String> phoneNumbers = parseResults(text);
        if(phoneNumbers.size()==0){
            for (int i = 0; i < blocks.size(); i++) {
                List<FirebaseVisionText.Line> lines = blocks.get(i).getLines();
                for (int j = 0; j < lines.size(); j++) {
                   if(lines.get(j).getText().contains("Tél") || lines.get(j).getText().contains("Tel") ||  lines.get(j).getText().contains("Fax") || lines.get(j).getText().contains("Tél:") || lines.get(j).getText().contains("Fax:") || lines.get(j).getText().contains("Tel/Fax:") || lines.get(j).getText().contains("Mob:")){
                       String str =lines.get(j).getText();
                       str=str.replaceAll("[^\\d.]", "");
                       tvphone.setText(str);
                    }
                }
            }
            if(tvphone.getText()=="") {
                tvphone.setText("Error");
            }

        }
        if(phoneNumbers.size()==1){
                    try {
                        tvphone.setText(phoneNumbers.get(0));
                    }catch(IndexOutOfBoundsException e){
                        e.printStackTrace();
                        Toast.makeText(UsePhoneCamera.this, "There is no text!", Toast.LENGTH_SHORT).show();
                    }
        }
        if(phoneNumbers.size()==2){
                try {
                    tvphone.setText(phoneNumbers.get(0));
                    tvphone2.setText(phoneNumbers.get(1));
                }catch(IndexOutOfBoundsException e){
                    e.printStackTrace();
                    Toast.makeText(UsePhoneCamera.this, "There is no text!", Toast.LENGTH_SHORT).show();
                }
        }

        }




    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void extractName(String str){
        System.out.println("Getting the Name");
        final String NAME_REGEX = "^([A-Z]([a-z]*|\\.) *){1,2}([A-Z][a-z]+-?)+$";
        Pattern p = Pattern.compile(NAME_REGEX, Pattern.MULTILINE);
        Matcher m =  p.matcher(str);
        if(m.find()){
            System.out.println(m.group());
            tvname.setText(m.group());
        }
    }


    public void extractEmail(String str) {
        System.out.println("Getting the email");
        final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern p = Pattern.compile(EMAIL_REGEX, Pattern.MULTILINE);
        Matcher m = p.matcher(str);   // get a matcher object
        if(m.find()){
            System.out.println(m.group());
            tvemail.setText(m.group());
        }
    }

    public void extractPhone(String str){
        System.out.println("Getting Phone Number");
        final String PHONE_REGEX="(?:^|\\D)(\\d{3})[)\\-. ]*?(\\d{3})[\\-. ]*?(\\d{4})(?:$|\\D)";
        Pattern p = Pattern.compile(PHONE_REGEX, Pattern.MULTILINE);
        Matcher m = p.matcher(str);   // get a matcher object
        if(m.find()){
            System.out.println(m.group());
            tvphone.setText(m.group());
        }
    }

    // Methode use to parse phone number
    private ArrayList<String> parseResults(String bCardText) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Iterable<PhoneNumberMatch> numberMatches = phoneNumberUtil.findNumbers(bCardText, Locale.getDefault().getCountry());
        ArrayList<String> data = new ArrayList<>();
        for(PhoneNumberMatch number : numberMatches){
            String s = number.rawString();
            data.add(s);
        }
        return data;
    }

    //Hold to try
    private String parseEmail(String results) {
        Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(results);
        String parsedEmail = "Error";
        while (m.find()) {
            parsedEmail = m.group();
        }
        return parsedEmail;
    }



}
