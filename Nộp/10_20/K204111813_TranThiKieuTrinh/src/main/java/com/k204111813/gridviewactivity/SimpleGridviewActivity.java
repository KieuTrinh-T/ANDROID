package com.k204111813.gridviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.k204111813.gridviewactivity.databinding.ActivitySimpleGridviewBinding;

import java.util.ArrayList;

public class SimpleGridviewActivity extends AppCompatActivity {
    ActivitySimpleGridviewBinding binding;
    String[] list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_simple_gridview);
        binding = ActivitySimpleGridviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        list = getResources().getStringArray(R.array.dsSP);
        adapter = new ArrayAdapter<String>(SimpleGridviewActivity.this, android.R.layout.simple_list_item_1,list);
        binding.grSimpleGridview.setAdapter(adapter);

        //Click on button
        binding.btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SimpleGridviewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}