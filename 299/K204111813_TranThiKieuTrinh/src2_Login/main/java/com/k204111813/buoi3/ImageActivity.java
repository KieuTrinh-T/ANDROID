package com.k204111813.buoi3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.k204111813.buoi3.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity {
    ActivityImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addEvents();

    }
    private void addEvents() {
        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        binding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.imvImage.getTag()==null || binding.imvImage.getTag().equals("vit")){
                    binding.imvImage.setTag("matbam");
                    binding.imvImage.setImageResource(R.drawable.matbam);
                }
                else{
                    binding.imvImage.setTag("vit");
                    binding.imvImage.setImageResource(R.drawable.vit);
                }
            }
        });
    }
}