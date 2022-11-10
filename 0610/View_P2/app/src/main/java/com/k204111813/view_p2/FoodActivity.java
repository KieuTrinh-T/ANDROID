package com.k204111813.view_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.k204111813.view_p2.databinding.ActivityFoodBinding;

public class FoodActivity extends AppCompatActivity {
    ActivityFoodBinding binding;
    ArrayAdapter<String> adapter;
    String[] foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_food);
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        //Method 1:
//        adapter = new ArrayAdapter<String>(FoodActivity.this, android.R.layout.simple_list_item_1);
//        foods = getResources().getStringArray(R.array.food_list);
//        adapter.addAll(foods);
//
        //Method 2:
        foods = getResources().getStringArray(R.array.food_list);
        adapter = new ArrayAdapter<String>(FoodActivity.this, android.R.layout.simple_list_item_1,foods);

        binding.lvFoods.setAdapter(adapter);
    }

}