package com.example.testapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.nestedscrollview_adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class nestedscrollview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nestedscrollview);

        // RecyclerView 초기화
        RecyclerView recyclerView1 = findViewById(R.id.recyclerViewNewFriends);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerViewFriends);

        // LinearLayoutManager 설정 (리스트 형태로 아이템을 배치하기 위함)
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);

        // 랜덤한 이름과 전화번호 생성
        List<String> names = generateNames();
        List<String> phoneNumbers = generatePhoneNumbers();

        // 어댑터 생성
        nestedscrollview_adapter adapter1 = new nestedscrollview_adapter(names, phoneNumbers);
        nestedscrollview_adapter adapter2 = new nestedscrollview_adapter(names, phoneNumbers);

        // RecyclerView에 어댑터 설정
        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
    }

    // 랜덤한 전화번호 생성
    private List<String> generatePhoneNumbers() {
        List<String> phoneNumbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < generateNames().size(); i++) {
            // 랜덤 전화번호 생성 (010-4자리숫자-4자리숫자 형식)  random.nextInt(9000)은 0 이상 8999 이하의 난수를 생성
            phoneNumbers.add("010-" +
                    String.format("%04d", random.nextInt(9000) + 1000) + "-" +
                    String.format("%04d", random.nextInt(9000) + 1000));
        }

        return phoneNumbers;
    }


    // 랜덤한 이름 생성
    private List<String> generateNames() {
        return new ArrayList<>(Arrays.asList("house", "jellyfish", "wizard", "xylophone", "*개발", "!기획관리", "~솔루션", "#시스템",
                "@R&D", "apple", "balloon", "cake", "dog", "egg", "flamingo", "grape", "house", "icecream",
                "kite", "lemon", "nose", "mouse", "pig", "orange", "rabbit", "queen", "zebra", "yo-wassup",
                "violin", "umbrella", "tomato", "sun"));
    }
}

// 리사이클러 뷰와 어댑터, 그리ㄱ 데이터를 생성하는 부분이 핵심