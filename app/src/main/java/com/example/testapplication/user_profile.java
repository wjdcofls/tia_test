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
        // getIntent(): 현재 액티비티에 전달된 Intent 객체를 가져오는 메서드
        // getParcelableExtra("user_data"): Intent에서 "user_data"라는 키로 전달된 Parcelable 객체를 추출합니다. Parcelable은 전체 객체를 Intent로 전달하기 위해 사용되는 인터페이스


        // 가져온 데이터를 화면에 표시
        if (userData != null) {
            TextView nameTextView = findViewById(R.id.detail_username);
            TextView phoneNumberTextView = findViewById(R.id.detail_phone_number);

            nameTextView.setText(userData.getName());
            // userData 객체에서 이름을 가져와 nameTextView에 설정
            phoneNumberTextView.setText(userData.getPhoneNumber());
            // userData 객체에서 전화번호를 가져와 phoneNumberTextView에 설정
        }
    }
}
// 이 코드는 Intent를 통해 전달된 Parcelable 객체에서 데이터를 추출하여 해당하는 TextView에 표시하는 역할