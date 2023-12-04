package com.example.testapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class edit_text extends AppCompatActivity {

    void hideKeyboard(View view)
    {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (view != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text);

        Button btn_3 = findViewById(R.id.btn3);
        EditText et2 = findViewById(R.id.et2);
        ImageView iconEyeOpen = findViewById(R.id.icon_eye_open);
        ImageView iconEyeClose = findViewById(R.id.icon_eye_closed);


        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayout layout2 = findViewById(R.id.layout_focusout);
        EditText et_1 = findViewById(R.id.et1);


        //Logcat
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count){}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String inputValue = charSequence.toString();
                Log.d("input_test", "Keyboard Input: " + inputValue);
            }

            @Override
            public void afterTextChanged(Editable editable){}
        });


        // eye-watching
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                if (charSequence.length() > 0) {
                    iconEyeOpen.setVisibility(View.VISIBLE);
                } else {
                    iconEyeOpen.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });


        iconEyeOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 마스킹 해제
                et2.setTransformationMethod(null);
                isPasswordVisible = true;
                iconEyeOpen.setVisibility(View.INVISIBLE);
                iconEyeClose.setVisibility(View.VISIBLE);
                et2.setSelection(et2.length());
            }
        });

        iconEyeClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다시 마스킹 처리
                et2.setTransformationMethod(new PasswordTransformationMethod());
                isPasswordVisible = false;
                iconEyeOpen.setVisibility(View.VISIBLE);
                iconEyeClose.setVisibility(View.INVISIBLE);
                et2.setSelection(et2.length());
            }
        });

        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), nestedscrollview.class);
                startActivity(intent);
            }
        });
    }
}
