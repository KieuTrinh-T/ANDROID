package com.k204111813.activity_intent;

import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.k204111813.activity_intent.databinding.ActivityMainBinding;
import com.k204111813.models.Product;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
//    public static final int REQUEST_CODE = 1;
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Log.i("MainActivity","onCreate");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        launcher = registerForActivityResult(new ActivityResultContracts.
                        StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK && result.getData()!= null) {
                binding.txtResult.setText(String.valueOf(result.getData().getIntExtra("pow", 0)));
            }
        });


                addEvent();
    }

    private void addEvent() {
        binding.btnOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opening SunActivity#2
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });
        binding.btnOpenActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity3.class);
                startActivity(intent);
            }
        });
        binding.btnOpenActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open SubActivity 4 and send data
                Intent intent = new Intent(MainActivity.this,SubActivity4.class);

                //Attach data
                //Method 1: using putExtra
//                intent.putExtra("number",9);
//                intent.putExtra("grades",8.9f);
//                intent.putExtra("check", true);
//                intent.putExtra("say","Hellooo");
//
                //Method 2: Using Bundle
                Bundle bundle = new Bundle();
                bundle.putInt("num",6);
                bundle.putFloat("grades",8.5f);
                bundle.putBoolean("check",true);
                bundle.putString("say","hello");

                Product product = new Product("Heniken", 1000);

                bundle.putSerializable(Utils.PRODUCT_INF,product);

                //Tối ưu hơn với gửi object là bundle.Parcelable cần phải overide nhiều
                //bundle.putParcelable();

                intent.putExtra("myBundle",bundle);
                startActivity(intent);


            }
        });
        binding.btnOpenActivity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this,Sub5Activity.class);
                 intent.putExtra("number",binding.edtNumb.getText().toString());
//                 startActivityForResult(intent, REQUEST_CODE);
                launcher.launch(intent);

            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
//            int result = data.getIntExtra("pow",0);
//            binding.txtResult.setText(String.valueOf(result));
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity","onRestart");
    }
}