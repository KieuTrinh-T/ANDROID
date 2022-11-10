package com.k204111813.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.k204111813.adapters.beerAdapter;
import com.k204111813.adapters.gridAdapter;
import com.k204111813.listviewactivity.databinding.ActivityGridViewBinding;
import com.k204111813.listviewactivity.databinding.ActivityMainBinding;
import com.k204111813.models.Beer;

import java.util.ArrayList;
import java.util.List;


public class GridViewActivity extends AppCompatActivity {
    ActivityGridViewBinding binding;
    ArrayList<Beer> beers;
    gridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_grid_view);
        binding = ActivityGridViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();
    }

    private void addEvent() {
        beers = new ArrayList<>();
        beers.add(new Beer(R.drawable.heineken,"Heniken",19000));
        beers.add(new Beer(R.drawable.beer333, "Bia 333",17500));
        beers.add(new Beer(R.drawable.hanoi,"Bia Ha Noi",19000));
        beers.add(new Beer(R.drawable.larue, "Bia Larue",17500));
        beers.add(new Beer(R.drawable.tiger,"Tiger",19000));
        beers.add(new Beer(R.drawable.saigon, "Bia Saigon",17500));

        adapter = new gridAdapter(GridViewActivity.this,R.layout.item_grv,beers);
        binding.grvBeer.setAdapter(adapter);
    }
}