package com.k204111813.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.k204111813.adapters.beerAdapter;
import com.k204111813.listviewactivity.databinding.ActivityMainBinding;
import com.k204111813.models.Beer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    beerAdapter adapter;
    ArrayList<Beer> beers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        beers = new ArrayList<>();
        beers.add(new Beer(R.drawable.heineken,"Heniken",19000));
        beers.add(new Beer(R.drawable.beer333, "Bia 333",17500));
        beers.add(new Beer(R.drawable.hanoi,"Bia Ha Noi",19000));
        beers.add(new Beer(R.drawable.larue, "Bia Larue",17500));
        beers.add(new Beer(R.drawable.tiger,"Tiger",19000));
        beers.add(new Beer(R.drawable.saigon, "Bia Saigon",17500));

        adapter = new beerAdapter(MainActivity.this,R.layout.item_list,beers);
        binding.lvBeer.setAdapter(adapter);
    }
}