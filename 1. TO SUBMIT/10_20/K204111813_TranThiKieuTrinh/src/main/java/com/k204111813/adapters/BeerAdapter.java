package com.k204111813.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k204111813.gridviewactivity.R;
import com.k204111813.models.Beer;

import java.util.List;

public class BeerAdapter extends BaseAdapter {
    Activity activity;
    int layout;
    List<Beer> beers;
    //Constructor

    public BeerAdapter(Activity activity, int layout, List<Beer> beers) {
        this.activity = activity;
        this.layout = layout;
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
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.layout,null);
            holder.beerThumb = view.findViewById(R.id.imv_Thumb);
            holder.beerName = view.findViewById(R.id.txt_Name);
            holder.beerPrice = view.findViewById(R.id.txt_Price);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        Beer beer = beers.get(i);
        holder.beerThumb.setImageResource(beer.getThumb());
        holder.beerName.setText(beer.getName());
        holder.beerPrice.setText(String.valueOf(beer.getPrice()));

        return view;
    }
    public static class ViewHolder{
        ImageView beerThumb;
        TextView beerName, beerPrice;

    }
}
