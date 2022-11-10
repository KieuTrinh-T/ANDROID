package com.k204111813.view_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.k204111813.models.Product;
import com.k204111813.view_p2.databinding.ActivityFoodBinding;
import com.k204111813.view_p2.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;
    ArrayAdapter<Product> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAdapter();
        addEvent();


    }

    private void initAdapter() {
        adapter = new ArrayAdapter<Product>(ProductActivity.this, android.R.layout.simple_list_item_1);
        binding.lvProducts.setAdapter(adapter);

    }

    private void addEvent() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.edtName.getText().toString();
                String color = binding.edtColor.getText().toString();
                Product p = new Product(name,color);
                adapter.add(p);
            }
        });
        //OnItemClick
        binding.lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = adapter.getItem(i);
                Toast.makeText(ProductActivity.this,p.getProductName()+" "+p.getProductColor(),Toast.LENGTH_SHORT).show();
                binding.edtName.setText(p.getProductName()+"1");
                binding.edtColor.setText(p.getProductColor()+"1");
            }
        });
        //OnItemLongClick
        binding.lvProducts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               Product p = adapter.getItem(i);
               adapter.remove(p);
               return true;

            }
        });
    }
}