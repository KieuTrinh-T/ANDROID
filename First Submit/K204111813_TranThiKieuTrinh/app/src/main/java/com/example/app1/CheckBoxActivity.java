package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Button;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox chkNetflix,chkFPT,chkYouTube;
    TextView txtOutput;
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        linkView();
        addEvent();
    }

    private void linkView() {
        chkNetflix = findViewById(R.id.chk_Netflix);
        chkFPT = findViewById(R.id.chk_FPT);
        chkYouTube = findViewById(R.id.chk_YouTube);
        txtOutput = findViewById(R.id.txt_Output);
        btnConfirm = findViewById(R.id.btn_Confirm);
    }

    private void addEvent() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = "Bạn đã chọn: ";

                if(chkNetflix.isChecked()){
                    output += chkNetflix.getText().toString();
                }
                if(chkFPT.isChecked() ){
                    output += ", " + chkFPT.getText().toString();
                }
                if(chkYouTube.isChecked()){
                    output += ", " + chkYouTube.getText().toString();
                }


            }
        });
    }
}