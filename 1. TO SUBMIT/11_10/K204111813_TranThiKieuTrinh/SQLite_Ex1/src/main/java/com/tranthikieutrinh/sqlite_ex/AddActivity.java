package com.tranthikieutrinh.sqlite_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.Toast;

import com.tranthikieutrinh.sqlite_ex.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert data into DB

                String name = binding.edtName.getText().toString();
                double price;
                try{
                    price = Double.parseDouble (binding.ediPrice.getText().toString());
                    ContentValues values = new ContentValues();
                    values.put(Utils.COL_NAME,name);
                    values.put(Utils.COL_PRICE,price);
                    long numOfRows = MainActivity.db.insert(Utils.DB_TABLE_NAME,null,values);

                    if(numOfRows>0){
                        Toast.makeText(AddActivity.this,"Success", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(AddActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(AddActivity.this, "Price must be a number ", Toast.LENGTH_SHORT).show();
                    binding.ediPrice.getText().clear();
                    binding.ediPrice.requestFocus();
                }


            }
        });
    }

}