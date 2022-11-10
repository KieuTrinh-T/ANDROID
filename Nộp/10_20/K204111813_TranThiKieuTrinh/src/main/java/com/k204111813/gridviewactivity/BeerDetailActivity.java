package com.k204111813.gridviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.k204111813.gridviewactivity.databinding.ActivityBeerDetailBinding;
import com.k204111813.models.Beer;

import java.util.ArrayList;
import java.util.List;

public class BeerDetailActivity extends AppCompatActivity {

    ActivityBeerDetailBinding binding;
    List<Beer> beers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBeerDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {


        // Get bundle of each attribute
//        Intent intent = getIntent();
//        Bundle bundle = intent.getBundleExtra("beer");
//        int thumb = bundle.getInt("thumb");
//        String name = bundle.getString("name");
//        Double price = bundle.getDouble("price");
//
//        binding.imvBeer.setImageResource(thumb);
//        binding.txtDetailName.setText(name);
//        binding.txtDetailPrice.setText(price+"");

        // Init líst
          beers = (ArrayList<Beer>) MainActivity.listBeers();

        // Get object
        int index = getIntent().getIntExtra("index",0);
        Beer beer = beers.get(index);

        //Binding data
        binding.imvBeer.setImageResource(beer.getThumb());
        binding.txtDetailName.setText(beer.getName());
        binding.txtDetailPrice.setText(beer.getPrice()+"");




        //Click on button
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeerDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}