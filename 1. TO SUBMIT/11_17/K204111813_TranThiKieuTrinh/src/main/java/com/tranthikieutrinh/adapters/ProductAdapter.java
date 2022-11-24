package com.tranthikieutrinh.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tranthikieutrinh.models.Product;
import com.tranthikieutrinh.sqlite_ex2.MainActivity;
import com.tranthikieutrinh.sqlite_ex2.R;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    MainActivity activity;
    int item_layout;
    List<Product> products;

    public ProductAdapter(MainActivity activity, int item_layout, List<Product> products) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.products = products;
    }



    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
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
            view = inflater.inflate(item_layout,null);

            holder.txtProductInf = view.findViewById(R.id.txt_ProductInf);
            holder.imvDelete = view.findViewById(R.id.imv_Delete);
            holder.imvEdit = view.findViewById(R.id.imv_Edit);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        Product product = products.get(i);
        holder.txtProductInf.setText(product.getProductName()+ " - "+product.getProductPrice());

        holder.imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Update Data
            }
        });

        holder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Delete


            }
        });

        return view;
    }

    public static class ViewHolder{
        TextView txtProductInf;
        ImageView imvEdit, imvDelete;
    }

}
