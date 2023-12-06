package com.example.testapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class user_profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        // Intent 전달된 데이터 가져오기
        nestedscrollview_adapter.User userData = getIntent().getParcelableExtra("user_data");

        // 가져온 데이터를 화면에 표시
        if (userData != null) {
            TextView nameTextView = findViewById(R.id.detail_username);
            TextView phoneNumberTextView = findViewById(R.id.detail_phone_number);

            nameTextView.setText(userData.getName());
            phoneNumberTextView.setText(userData.getPhoneNumber());
        }
    }
}