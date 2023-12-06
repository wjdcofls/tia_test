package com.example.testapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class nestedscrollview_adapter extends RecyclerView.Adapter<nestedscrollview_adapter.MyViewHolder> {

    private List<String> names;
    private List<String> phoneNumbers;

    // 생성자!! 어댑터 객체를 생성할 때 외부에서 이름과 전화번호 목록을 받아서 내부의 리스트에 할당
    public nestedscrollview_adapter(List<String> names, List<String> phoneNumbers) {
        this.names = names;
        this.phoneNumbers = phoneNumbers;
    }

    // 뷰홀더 클래스
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView phoneNumberTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.username);
            phoneNumberTextView = itemView.findViewById(R.id.phone_number);

        }
    }

    // onCreateViewHolder: 뷰 홀더 객체를 생성하고 초기화하는 메서드
    // LayoutInflater를 사용하여 XML 레이아웃 파일을 뷰 객체로 인스턴스화하고, 그 객체를 뷰 홀더에 넘겨준다
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nestedscrollview_adapter, parent, false);
        return new MyViewHolder(v);
    }

    // onBindViewHolder: 뷰 홀더에 데이터를 바인딩하는 메서드
    //특정 위치(position)의 데이터를 가져와서 해당 위치에 대한 뷰 홀더의 뷰에 설정
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 데이터 바인딩 전에 유효성을 확인
        if (names != null && phoneNumbers != null &&
                position < names.size() && position < phoneNumbers.size()) {
            // 데이터 바인딩
            holder.nameTextView.setText(names.get(position));
            holder.phoneNumberTextView.setText(phoneNumbers.get(position));

            // 아이템 클릭 이벤트 리스너 설정
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 클릭한 아이템의 데이터를 다음 화면으로 전달
                    User clickedUser = new User(names.get(position), phoneNumbers.get(position));
                    Intent intent = new Intent(v.getContext(), user_profile.class);
                    intent.putExtra("user_data", clickedUser);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return names.size();
    }



    // User 클래스 정의
    public static class User implements Parcelable {
        private String name;
        private String phoneNumber;

        public User(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        // Parcelable 구현
        protected User(Parcel in) {
            name = in.readString();
            phoneNumber = in.readString();
        }

        public static final Creator<User> CREATOR = new Creator<User>() {
            @Override
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            @Override
            public User[] newArray(int size) {
                return new User[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(phoneNumber);
        }
    }

    private List<User> users;

    // User 객체 생성
    private List<User> generateUsers(List<String> names, List<String> phoneNumbers) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), phoneNumbers.get(i)));
        }
        return users;
    }
}
