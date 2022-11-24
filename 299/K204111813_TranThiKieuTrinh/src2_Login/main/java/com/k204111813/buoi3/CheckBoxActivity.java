package com.k204111813.buoi3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.k204111813.buoi3.databinding.ActivityCheckBoxBinding;

public class CheckBoxActivity extends AppCompatActivity {

    ActivityCheckBoxBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        binding = ActivityCheckBoxBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addEvents();

    }

    private void addEvents() {
        binding.btnConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String result = "";
                if (binding.chkNetflix.isChecked()) {
                    result += binding.chkNetflix.getText() + ", ";
                }
                if (binding.chkYouTube.isChecked()) {
                    result += binding.chkYouTube.getText() + ", ";
                }
                if (binding.chkFPTPlay.isChecked())
                    result += binding.chkFPTPlay.getText() + ", ";
                result = result.replaceAll(", $", "");
                result = "Bạn đã chọn: " + result;
                binding.txtResult.setText(result);
            }

        });
    }
}