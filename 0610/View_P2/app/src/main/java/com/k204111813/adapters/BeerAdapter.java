package com.k204111813.adapters;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k204111813.models.Beer;
import com.k204111813.view_p2.R;

import java.util.List;
import java.util.zip.Inflater;

public class BeerAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Beer> beers;

    //Constructor


    public BeerAdapter(Activity activity, int item_layout, List<Beer> beers) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.beers = beers;
    }

    @Override
    public int getCount() {
        return beers.size();
    }

    @Override
    public Object getItem(int i) {
        return beers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Link views and binding data

        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            //Inflater inflater = activity.getLayoutInflater(Context.);
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout,null);

            //Link views
            holder.imvThumb = view.findViewById(R.id.imvPhoto);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtPrice = view.findViewById(R.id.txtPrice);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        Beer beer = beers.get(i);
        holder.imvThumb.setImageResource(beer.getProductThumb());
        holder.txtName.setText(beer.getProductName());
        holder.txtPrice.setText(String.valueOf(beer.getProductPrice()));

        return view;
    }
    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtPrice;
    }
}
