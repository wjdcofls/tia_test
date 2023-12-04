package com.example.testapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class nestedscrollview_adapter extends RecyclerView.Adapter<nestedscrollview_adapter.MyViewHolder> {

    private List<String> names;
    private List<String> phoneNumbers;

    public nestedscrollview_adapter(List<String> names, List<String> phoneNumbers) {
        this.names = names;
        this.phoneNumbers = phoneNumbers;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView phoneNumberTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.username);
            phoneNumberTextView = itemView.findViewById(R.id.phone_number);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nestedscrollview_adapter, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 데이터 바인딩 전에 유효성을 확인
        if (position < names.size() && position < phoneNumbers.size()) {
            // 데이터 바인딩
            holder.nameTextView.setText(names.get(position));
            holder.phoneNumberTextView.setText(phoneNumbers.get(position));
        }
    }


    @Override
    public int getItemCount() {
        return names.size();
    }
}
