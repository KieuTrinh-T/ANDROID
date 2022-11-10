package com.tranthikieutrinh.sqlite_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Binder;
import android.os.Bundle;

import com.tranthikieutrinh.sqlite_ex2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createDB();
    }

    private void createDB() {
        db = new DataBaseHelper(MainActivity.this);
        db.createSampleData();
    }

}