package com.k204111813.gridviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.k204111813.adapters.BeerAdapter;
import com.k204111813.gridviewactivity.databinding.ActivityMainBinding;
import com.k204111813.models.Beer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    ArrayList<Beer> beers;
    BeerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      loadData();

        addEvents();
    }

   public void loadData() {

        // Init list
//        beers = new ArrayList<>();
//        beers.add(new Beer(R.drawable.heineken,"Heniken", 19000.0));
//        beers.add(new Beer(R.drawable.beer333, "Bia 333", 17500.0));
//        beers.add(new Beer(R.drawable.hanoi,"Bia Ha Noi", 19000.0));
//        beers.add(new Beer(R.drawable.larue, "Bia Larue", 17500.0));
//        beers.add(new Beer(R.drawable.tiger,"Tiger", 19000.0));
//        beers.add(new Beer(R.drawable.saigon, "Bia Saigon", 17500.0));
//

       //Use lass list
       beers = (ArrayList<Beer>) MainActivity.listBeers();

       adapter = new BeerAdapter(MainActivity.this,R.layout.item_list,beers);
        binding.gvBeer.setAdapter(adapter);
  }

    private void addEvents() {


        //Click on button
        binding.btnToSimpleGridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open SimpleGridviewActivity
                Intent intent = new Intent(MainActivity.this, SimpleGridviewActivity.class);
                startActivity(intent);
            }
        });

        binding.gvBeer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Beer beer = beers.get(i);
                Intent intent = new Intent(MainActivity.this, BeerDetailActivity.class);


                //Put each attribute of beer to intent
//                Bundle bundle = new Bundle();
//                bundle.putString("name", beer.getName());
//                bundle.putDouble("price", beer.getPrice());
//                bundle.putInt("thumb", beer.getThumb());
//                intent.putExtra("beer", bundle);

                //Put beer index to intent
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });

    }
    public static List<Beer> listBeers(){
        ArrayList<Beer> beers = new ArrayList<>();
        beers.add(new Beer(R.drawable.heineken,"Heniken", 19000.0));
        beers.add(new Beer(R.drawable.beer333, "Bia 333", 17500.0));
        beers.add(new Beer(R.drawable.hanoi,"Bia Ha Noi", 19000.0));
        beers.add(new Beer(R.drawable.larue, "Bia Larue", 17500.0));
        beers.add(new Beer(R.drawable.tiger,"Tiger", 19000.0));
        beers.add(new Beer(R.drawable.saigon, "Bia Saigon", 17500.0));
        return beers;
    }
}