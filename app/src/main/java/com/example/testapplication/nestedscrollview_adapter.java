package com.example.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class nestedscrollview_adapter extends RecyclerView.Adapter<nestedscrollview_adapter.ViewHolder> {

    private Context context;
    private List<String> friendNames;

    public nestedscrollview_adapter(Context context, List<String> friendNames) {
        this.context = context;
        this.friendNames = friendNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nestedscrollview_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String friendName = friendNames.get(position);
        String phoneNumber = generateRandomPhoneNumber();

        holder.usernameTextView.setText(friendName);
        holder.phoneNumberTextView.setText(phoneNumber);
    }

    @Override
    public int getItemCount() {
        return friendNames.size();
    }

    private String generateRandomPhoneNumber() {
        // 임의의 전화번호 생성 로직을 추가 (예시로 간단한 랜덤 숫자 생성)
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("+82 ");
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImageView;
        TextView usernameTextView;
        TextView phoneNumberTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.icon_profile);
            usernameTextView = itemView.findViewById(R.id.username);
            phoneNumberTextView = itemView.findViewById(R.id.phone_number);
        }
    }
}
