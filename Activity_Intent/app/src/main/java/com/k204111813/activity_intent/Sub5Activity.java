package com.k204111813.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.k204111813.activity_intent.databinding.ActivitySub5Binding;

public class Sub5Activity extends AppCompatActivity {
    ActivitySub5Binding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sub5);

        binding = ActivitySub5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        addEvent();
    }

    private void getData() {
        intent = getIntent();
        binding.txtNumb.setText(intent.getStringExtra("number"));

    }

    private void addEvent() {
        binding.btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numb = Integer.parseInt(binding.txtNumb.getText().toString()) ;
                int pow = numb * numb;
                intent.putExtra("pow",pow);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}