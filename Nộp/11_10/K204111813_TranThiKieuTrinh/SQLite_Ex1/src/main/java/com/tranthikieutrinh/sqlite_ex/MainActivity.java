package com.tranthikieutrinh.sqlite_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tranthikieutrinh.models.Product;
import com.tranthikieutrinh.sqlite_ex.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Product> products;
    ArrayAdapter<Product> adapter;
    Product selectedProduct = null;
    public static SQLiteDatabase db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        copyDB();
        addEvents();
        registerForContextMenu(binding.lvProduct);

    }

    private void addEvents() {
       binding.lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               selectedProduct = (Product) adapter.getItem(i);

               return false;
           }
       });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        products = new ArrayList<>();

//        products.add(new Product(1,"Tiger",18000));
//        products.add(new Product(2,"Heniken",20000));

        db = openOrCreateDatabase(Utils.DB_Name,MODE_PRIVATE,null);
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utils.DB_TABLE_NAME,null);

//        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utils.DB_TABLE_NAME+ "WHERE ProductId > ?or ProductId =?", new String[]{"1","3"});

    //    Cursor cursor = db.query(Utils.DB_TABLE_NAME, null,"ProductId>?",new String[]{"2"},null,null,null);

//        Cursor cursor = db.query(Utils.DB_TABLE_NAME,null,null,null,null,null,null);



        while (cursor.moveToNext()){

            products.add(new Product(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2)));
        }
        cursor.close();

        adapter = new ArrayAdapter<Product>(MainActivity.this, android.R.layout.simple_list_item_1,products);

        binding.lvProduct.setAdapter(adapter);
    }

    private void copyDB() {
        File dbPath = getDatabasePath(Utils.DB_Name);
        if(!dbPath.exists()){
            //Copy data
           if(copyDBFromAssets()) {
               Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
           }
           else {
               Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
           }
        }

    }

    private boolean copyDBFromAssets() {
        String dbPath = getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX + Utils.DB_Name;

        try {
            InputStream inputStream = getAssets().open(Utils.DB_Name);
            File f = new File(getApplicationInfo().dataDir+ Utils.DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024];
            int lenght ;
            while ((lenght= inputStream.read(buffer))>0){

                outputStream.write(buffer,0,lenght);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    //------------MENU---------


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mn_Add){
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mn_Edit){

            Intent intent = new Intent(MainActivity.this,EditActivity.class);

            if(selectedProduct != null){
                intent.putExtra("productInf",selectedProduct);
                startActivity(intent);
            }
        }
        if(item.getItemId()==R.id.mn_Delete){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Xác nhận xóa!");
            builder.setMessage("Xác nhận xóa: "+selectedProduct.getProductName() + " ?");
            builder.setIcon(android.R.drawable.ic_delete);
            builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    int deletedRows = db.delete(Utils.DB_TABLE_NAME,Utils.COL_ID + "=?",
                            new String[]{String.valueOf(selectedProduct.getProductId())});
                    if(deletedRows>0){
                        Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    loadData();
                }
            });
            builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();


        }

        return super.onContextItemSelected(item);
    }
}