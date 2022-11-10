package com.example.app1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GVServiceAdapter extends ArrayAdapter<ServiceClass>{

    public GVServiceAdapter(@NonNull Context context, int resource) {
        super(context,0,resource);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customerView = convertView;
        if(customerView == null){
            customerView = LayoutInflater.from(getContext()).inflate(R.layout.service_item,parent,false);
        }
        ServiceClass service = getItem(position);
        ImageView imgService = customerView.findViewById(R.id.imgService);
        TextView txtService = customerView.findViewById(R.id.txtService);
        imgService.setImageResource(service.getImgid());
        txtService.setText(service.getService_name());
        return customerView;
    }
}


