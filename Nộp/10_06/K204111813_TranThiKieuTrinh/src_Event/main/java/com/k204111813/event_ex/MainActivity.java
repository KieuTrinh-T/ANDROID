package com.k204111813.event_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.k204111813.event_ex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //Nạp giao diện
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        addEvent();
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        //Activity as Listener
        public void onClick(View view) {
            if(view.getId()==R.id.btnVar1){
                Toast.makeText(MainActivity.this, "Variable as Listener 1", Toast.LENGTH_LONG).show();
            }
            else if(view.equals(binding.btnVar2))
                Toast.makeText(MainActivity.this, "Variable as Listener 2", Toast.LENGTH_SHORT).show();
        }

    };
    //Explicit
    class myOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view.equals(binding.btnExplicitClass1)){
                Toast.makeText(MainActivity.this, "Explicit Class1", Toast.LENGTH_SHORT).show();
            }
            else if(view.equals(binding.btnExplicitClass2)){
                Toast.makeText(MainActivity.this, "Explicit Class2", Toast.LENGTH_SHORT).show();
            }

        }
    };

    private void addEvent() {
        //Anonymous Listener
        binding.btnAnonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Anonymous", Toast.LENGTH_LONG).show();
            }
        });
        //Variable as Listener
        binding.btnVar1.setOnClickListener(onClickListener);
        binding.btnVar2.setOnClickListener(onClickListener);
        //Activity as Listener
        binding.btnAct1.setOnClickListener(this);//this là MainActivity có kế thừa onClick
        binding.btnAct2.setOnClickListener(this);
        //Explicit Class
        binding.btnExplicitClass1.setOnClickListener(new myOnClickListener());
        binding.btnExplicitClass2.setOnClickListener(new myOnClickListener());

    }

    public void showToast(View view) {
//        context là màn hình muốn hiển thị thông báo
        Toast.makeText(MainActivity.this, "OnClick", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        if(view.equals(binding.btnAct1)){
            Toast.makeText(this, "Activity as Listener 1", Toast.LENGTH_SHORT).show();
        }

        else if(view.equals(binding.btnAct2)){
            Toast.makeText(this, "Activity as Listener 2", Toast.LENGTH_SHORT).show();
        }
            
    }
}