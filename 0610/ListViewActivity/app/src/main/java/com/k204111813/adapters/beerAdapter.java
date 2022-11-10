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
import java.util.zip.Inflater;

public class beerAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Beer> beers;


    //Constructor


    public beerAdapter(Activity activity, int item_layout, List<Beer> beers) {
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
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout,null);

            //Link Views
            holder.imvThumb = view.findViewById(R.id.imv_Thumb);
            holder.txtName = view.findViewById(R.id.txt_Name);
            holder.txtPrice = view.findViewById(R.id.txt_Price);

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
