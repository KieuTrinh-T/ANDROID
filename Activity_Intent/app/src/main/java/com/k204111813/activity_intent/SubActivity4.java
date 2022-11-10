package com.k204111813.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.k204111813.activity_intent.databinding.ActivitySub4Binding;
import com.k204111813.models.Product;

public class SubActivity4 extends AppCompatActivity {
    ActivitySub4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_sub4);
        binding = ActivitySub4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        //Get data
        //method 1:
//        int numb = intent.getIntExtra("number",0);
//        float grade = intent.getFloatExtra("grades",0.0f);
//        boolean check = intent.getBooleanExtra("check",false);
//        String say = intent.getStringExtra("say");
//        binding.txtContent.setText("Num: "+numb + "\n"
//                +"grades: "+grade + "\n"
//                +"check: "+check + "\n"
//                +"say: "+say + "\n");

        //Method 2:
        Bundle bundle = intent.getBundleExtra("myBundle");
        int num = bundle.getInt("num",0);
        float grade = bundle.getFloat("grade",0.0f);
        boolean check = bundle.getBoolean("check",false);
        String say = bundle.getString("say");
        Product p = (Product) bundle.getSerializable(Utils.PRODUCT_INF);

        binding.txtContent.setText("Num: "+num + "\n"
               +"grades: "+grade + "\n"
               +"check: "+check + "\n"
               +"say: "+say + "\n"
        +"Product: "+p.getProductName()+", " + p.getProductPrice() + "\n");
    }
}