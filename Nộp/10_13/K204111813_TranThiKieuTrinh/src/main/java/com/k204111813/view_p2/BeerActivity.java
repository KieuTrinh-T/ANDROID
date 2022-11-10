package com.k204111813.view_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.k204111813.adapters.BeerAdapter;
import com.k204111813.models.Beer;
import com.k204111813.view_p2.databinding.ActivityBeerBinding;

import java.util.ArrayList;

public class BeerActivity extends AppCompatActivity {
    ActivityBeerBinding binding;
    BeerAdapter adapter;
    ArrayList<Beer> beers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_beer);
        binding = ActivityBeerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();

    }

    private void loadData() {
        //Init Data
        beers = new ArrayList<>();
//        beers.add(new Beer(R.drawable.heineken,"Heniken",19000));
//        beers.add(new Beer(R.drawable.beer333, "Bia 333",17500));
//        beers.add(new Beer(R.drawable.hanoi,"Bia Ha Noi",19000));
//        beers.add(new Beer(R.drawable.larue, "Bia Larue",17500));
        beers.add(new Beer(R.drawable.tiger,"Tiger",19000));
//        beers.add(new Beer(R.drawable.saigon, "Bia Saigon",17500));

        //Init Adapter
        adapter = new BeerAdapter(BeerActivity.this,R.layout.item_list,beers);
        binding.lvBeer.setAdapter(adapter);

    }
}