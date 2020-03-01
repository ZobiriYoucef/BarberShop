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
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UsePhoneCamera extends AppCompatActivity {

    private static final int CAMERA_ACTION_PICK_REQUEST_CODE = 610;
    private static final int PICK_IMAGE_GALLERY_REQUEST_CODE = 609;
    public static final int CAMERA_STORAGE_REQUEST_CODE = 611;
    public static final int ONLY_CAMERA_REQUEST_CODE = 612;
    public static final int ONLY_STORAGE_REQUEST_CODE = 613;

    Context context= UsePhoneCamera.this;
    ImageView imageView;
    Button BtnCap,BtnScan;
    TextView ScannedText;
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
            List<FirebaseVisionText.Line> lines = blocks.get(i).getLines();

            for (int j = 0; j < lines.size(); j++) {
                List<FirebaseVisionText.Element> elements = lines.get(j).getElements();

                for (int k = 0; k < elements.size(); k++) {

                }
            }
        }
        String text="";
        for(FirebaseVisionText.TextBlock textBlock:texts.getTextBlocks()){
            text = text+"/n"+ textBlock.getText();
            showToast(text);
        }
        ScannResualt=text;

    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
