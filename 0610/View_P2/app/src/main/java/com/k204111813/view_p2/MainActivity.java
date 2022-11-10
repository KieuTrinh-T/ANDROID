package com.k204111813.view_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.k204111813.view_p2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    String[] drinks = {"Coca","Pepsi","Sting","Soju","Strongbow", "Tiger", "Heniken","TAO MEO TONIC","MAMMOTH PASSION","Vodka", "Cucumber","Rosemary syrup","Mint leaves",
    "homemade syrup","Lime juice","Orange juice","Maraschino","Campari","Gin","Rosemary syrup"};
    ArrayAdapter<String>adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, drinks);
        binding.lvDrinks.setAdapter(adapter);

    }

}