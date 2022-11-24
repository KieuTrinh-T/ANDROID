package com.tranthikieutrinh.sqlite_ex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
    public void openEditDialog(Product p){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_edit_product);

        EditText edtName, edtPrice;
        Button btnSave, btnCancel;

        edtName = dialog.findViewById(R.id.edt_Name);
        edtName.setText(p.getProductName());
        edtPrice = dialog.findViewById(R.id.edt_Price);
        edtPrice.setText(String.valueOf(p.getProductPrice()));

        btnSave = dialog.findViewById(R.id.btn_Save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                db.execSql("UPDATE "+ DataBaseHelper.TBL_NAME + " SET " + DataBaseHelper.COL_NAME + " = '"+edtName.getText()+"', "
                        + DataBaseHelper.COL_PRICE + " = " + Double.parseDouble(edtPrice.getText().toString()) + " WHERE " + DataBaseHelper.COL_ID + " = " + p.getProductId());
                loadData();
                dialog.dismiss();

            }

        });

        btnCancel = dialog.findViewById(R.id.btn_Cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
    public void deleteItem(Product p ){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_delete_comfirm);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Xác nhận xóa");
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setMessage("Bạn có muốn xóa sp: " + p.getProductName() + "?");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.execSql("DELETE FROM " + DataBaseHelper.TBL_NAME + " WHERE " + DataBaseHelper.COL_ID + " = "
                        + p.getProductId());
                loadData();
                dialog.dismiss();
            }
        });
        builder.create().show();




//        EditText edtName, edtPrice;
//        Button btnDelete, btnCancel;
//
//        edtName = dialog.findViewById(R.id.edt_Name);
//        edtName.setText(p.getProductName());
//        edtPrice = dialog.findViewById(R.id.edt_Price);
//        edtPrice.setText(String.valueOf(p.getProductPrice()));
//
//        btnDelete = dialog.findViewById(R.id.imv_Delete);
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                db.execSql("DELETE FROM " + DataBaseHelper.TBL_NAME + " WHERE " + DataBaseHelper.COL_ID + " = "
//                + p.getProductId());
//                loadData();
//
//                dialog.dismiss();
//            }
//        });


    }

}