package com.example.testapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int click = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn_1 = findViewById(R.id.btn1);
        TextView tv_1 = findViewById(R.id.tv1);
        LinearLayout layout_1 = findViewById(R.id.layout1);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click++;
                if(click % 2 == 1) {
                    tv_1.setText(getString(R.string.color_main));
                    btn_1.setTextColor(Color.WHITE);
                    btn_1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.main));
//                  btn_1.setBackgroundColor(Color.parseColor("#172760"));
                } else {
                    tv_1.setText(getString(R.string.color_grey));
                    btn_1.setTextColor(Color.BLACK);
                    btn_1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                }
            }
        });
        
        layout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_1.setText(getString(R.string.main_default_textView));
                btn_1.setTextColor(Color.BLACK);
                btn_1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            }
        });

        Button btn_2 = findViewById(R.id.btn2);

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(MainActivity.this, edit_text.class);
                Intent intent = new Intent(getApplicationContext(), edit_text.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
