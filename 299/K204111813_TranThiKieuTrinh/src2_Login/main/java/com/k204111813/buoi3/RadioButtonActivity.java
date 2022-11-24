package com.k204111813.buoi3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.k204111813.buoi3.databinding.ActivityCheckBoxBinding;
import com.k204111813.buoi3.databinding.ActivityRadioButtonBinding;

public class RadioButtonActivity extends AppCompatActivity {


    ActivityRadioButtonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        binding = ActivityRadioButtonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addEvents();
    }

    private void addEvents() {
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = "";
//                if(binding.radTuongDoiTot.isChecked())
//                    output = binding.radTuongDoiTot.getText().toString();
//                else if(binding.radRatTot.isChecked())
//                    output = binding.radRatTot.getText().toString();
//                else if(binding.radTot.isChecked())
//                    output = binding.radTot.getText().toString();
//                else if(binding.radTuyetVoi.isChecked())
//                    output = binding.radTuyetVoi.getText().toString();
                    int checkedButtonID = binding.rdgRadio.getCheckedRadioButtonId();
                    if(checkedButtonID>0){
                        RadioButton checked = findViewById(checkedButtonID);
                        output = checked.getText().toString();
                        binding.txtOutput.setText(output);
                    }

            }
        });

    }
}