package com.tranthikieutrinh.implicitintent_ex;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.tranthikieutrinh.implicitintent_ex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();


        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
            if(result.getResultCode()==RESULT_OK && result.getData() != null){
                Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                binding.imvPhoto.setImageBitmap(bitmap);
            }
                });

    }

    private void addEvents() {
        binding.btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel: " + binding.edtPhoneNumber.getText().toString());
                intent.setData(uri);

                startActivity(intent);
            }
        });
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel: " + binding.edtPhoneNumber.getText().toString());
                intent.setData(uri);

                startActivity(intent);
            }
        });
        binding.btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivity(intent);
                launcher.launch(intent);
            }

        });
    }
}