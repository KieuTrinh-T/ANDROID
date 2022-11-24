package com.tranthikieutrinh.sqlite_ex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Binder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.tranthikieutrinh.adapters.ProductAdapter;
import com.tranthikieutrinh.models.Product;
import com.tranthikieutrinh.sqlite_ex2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DataBaseHelper db;

    ProductAdapter adapter;
    ArrayList<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createDB();
        loadData();
    }

    private void loadData() {
        products = new ArrayList<>();

        Cursor c = db.getData("SELECT * FROM "+ DataBaseHelper.TBL_NAME );

        while (c.moveToNext()){
            products.add(new Product(c.getInt(0),c.getString(1),c.getDouble(2)));
        }

        c.close();
        adapter = new ProductAdapter(MainActivity.this,R.layout.item_list,products);
        binding.lvProduct.setAdapter(adapter);


    }

    private void createDB() {
        db = new DataBaseHelper(MainActivity.this);
        db.createSampleData();
    }

    //-----MENU---------


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mn_Add){
            //Open dialog

            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.dialog_add_product);

            Button btnSave = dialog.findViewById(R.id.btn_Save);
            EditText edtName = dialog.findViewById(R.id.edt_Name);
            EditText edtPrice = dialog.findViewById(R.id.edt_Price);
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.execSql("INSERT INTO "+ DataBaseHelper.TBL_NAME + " VALUES(null, '"+
                            edtName.getText().toString() + "', "+
                            Double.parseDouble(edtPrice.getText().toString())+")");

                    loadData();
                    dialog.dismiss();

                }
            });
            Button btnCancel = dialog.findViewById(R.id.btn_Cancel);
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();

                }
            });

            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}