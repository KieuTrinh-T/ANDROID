package com.tranthikieutrinh.imagedata;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tranthikieutrinh.imagedata.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BottomSheetDialog bottomSheetDialog;
    LinearLayout llOpenCamera, llOpenGallery;

    ActivityResultLauncher<Intent> launcher;

    String capture = null;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createBottomSheet();

        createDB();
        addEvents();
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->{
            if(result.getResultCode()==RESULT_OK && result.getData() != null){
                if(capture.equals("camera") ){

                Bitmap bitmap = (Bitmap)result.getData().getExtras().get("data");
                binding.imvPhoto.setImageBitmap(bitmap);
            }
                else if(capture.equals("gallery")){
                    Uri uri = result.getData().getData();

                    try {
                        InputStream inputStream = getContentResolver().openInputStream(uri);
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        binding.imvPhoto.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void createDB() {
        db = new DbHelper(MainActivity.this);

    }

    private void createBottomSheet() {
        if(bottomSheetDialog == null){
            View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet, null);
            llOpenCamera = view.findViewById(R.id.ll_OpenCamera);
            llOpenCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    capture = "camera";

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    launcher.launch(intent);

                    bottomSheetDialog.dismiss();
                }
            });
            llOpenGallery = view.findViewById(R.id.ll_OpenGallery);
            llOpenGallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    capture = "gallery";
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    launcher.launch(intent);
                    bottomSheetDialog.dismiss();
                }
            });
            bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(view);
        }

    }

    private void addEvents() {
        binding.btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog.show();
            }
        });
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertData(binding.edtName.getText().toString(),binding.edtDes.getText().toString(),
                        convertBitmapToByteArray());


            }
        });
    }

    private byte[] convertBitmapToByteArray() {
        BitmapDrawable drawable = (BitmapDrawable) binding.imvPhoto.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

        return outputStream.toByteArray();
    }
}