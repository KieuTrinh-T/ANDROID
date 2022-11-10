package com.tranthikieutrinh.sqlite_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tranthikieutrinh.models.Product;
import com.tranthikieutrinh.sqlite_ex.databinding.ActivityEditBinding;

public class EditActivity extends AppCompatActivity {

    ActivityEditBinding binding;
    Product p=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit);
        binding = ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getData();
        addEvents();
    }


    private void getData() {
        Intent intent = getIntent();
        p = (Product) intent.getSerializableExtra("productInf");
        binding.edtName.setText(p.getProductName());
        binding.ediPrice.setText(String.valueOf(p.getProductPrice()));

    }
    private void addEvents() {
        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(Utils.COL_NAME,binding.edtName.getText().toString());
                values.put(Utils.COL_PRICE,Double.parseDouble(binding.ediPrice.getText().toString()));
                int updatedRows = MainActivity.db.update(Utils.DB_TABLE_NAME,values,
                        Utils.COL_ID+"=?",new String[]{String.valueOf(p.getProductId())});
                if(updatedRows>0){
                    Toast.makeText(EditActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}