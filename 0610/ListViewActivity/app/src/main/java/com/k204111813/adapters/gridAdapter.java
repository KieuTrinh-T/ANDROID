package com.k204111813.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.k204111813.listviewactivity.R;
import com.k204111813.models.Beer;

import java.util.List;

public class gridAdapter extends BaseAdapter {
    Activity activity;
    int layout;
    List<Beer> list_beers;

    //Constructor

    public gridAdapter(Activity activity, int layout, List<Beer> beers) {
        this.activity = activity;
        this.layout = layout;
        this.list_beers = beers;
    }

    @Override
    public int getCount() {
        return list_beers.size();
    }

    @Override
    public Object getItem(int i) {
        return list_beers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder view_holder;
        if(view == null)
        {
            view_holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.layout,null);
            view_holder.imv_Thumb = view.findViewById(R.id.imv_Thumb2);
            view_holder.txt_beerName = view.findViewById(R.id.txt_Name2);
            view_holder.txt_beerPrice=view.findViewById(R.id.txt_Price2);

            view.setTag(view_holder);
        }
        else{
            view_holder = (ViewHolder) view.getTag();
        }
        Beer beer = list_beers.get(i);
        view_holder.txt_beerName.setText(beer.getProductName());
        view_holder.txt_beerPrice.setText(String.valueOf(beer.getProductPrice()));
        view_holder.imv_Thumb.setImageResource(beer.getProductThumb());
        return view;
    }
    public static class ViewHolder{
        ImageView imv_Thumb;
        TextView txt_beerName, txt_beerPrice;

    }
}
