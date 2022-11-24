package com.k204111813.tranthikieutrinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class ChooseServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_service);

        GridView gvService;
        GVServiceAdapter serviceAdapter;

        gvService = findViewById(R.id.gvService);
        serviceAdapter= new GVServiceAdapter(ChooseServiceActivity.this,R.layout.service_item);
        serviceAdapter.add(new ServiceClass("Khách sạn",R.drawable.hotel));
        serviceAdapter.add(new ServiceClass("Giặt ủi",R.drawable.laundry));
        serviceAdapter.add(new ServiceClass("Thức ăn nhanh",R.drawable.burger));
        serviceAdapter.add(new ServiceClass("Taxi",R.drawable.taxi));
        serviceAdapter.add(new ServiceClass("Vận chuyển",R.drawable.truck));
        gvService.setAdapter(serviceAdapter);
    }
}