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

        //얘도 생성자! 뷰홀더 객체가 만들어질 때 호출된다. 각 뷰홀더 객체는 itemView라는 뷰를 기반으로 만들어진다
        public MyViewHolder(View itemView) {
            super(itemView);   //부모 클래스인 RecyclerView.ViewHolder의 생성자를 호출한다. 이렇게 해야 부모 클래스의 초기화가 진행되어 해당 뷰홀더 객체가 올바르게 생성된다.
            nameTextView = itemView.findViewById(R.id.username);
            phoneNumberTextView = itemView.findViewById(R.id.phone_number);
            //itemView에서 R.id.username으로 지정된 ID를 가진 TextView를 찾아서 nameTextView에 할당합니다. 이 TextView는 리사이클러뷰의 각 아이템에 이름을 표시하는데 사용됩니다.
            //itemView에서 R.id.phone_number으로 지정된 ID를 가진 TextView를 찾아서 phoneNumberTextView에 할당합니다. 이 TextView는 리사이클러뷰의 각 아이템에 전화번호를 표시하는데 사용됩니다.
        }
        //즉, MyViewHolder는 리사이클러뷰의 각 아이템에 대한 뷰들을 담고 있는 객체로, 해당 뷰들은 itemView에서 찾아서 할당합니다. 이렇게 찾은 뷰들은 나중에 onBindViewHolder 메서드에서 데이터를 설정할 때 사용됩니다.
    }


    // onCreateViewHolder: 뷰 홀더 객체를 생성하고 초기화하는 메서드
    // (LayoutInflater를 사용하여) XML 레이아웃 파일로 정의된 뷰를 실제 뷰 객체로 만들어서 뷰홀더에 넘겨준다
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nestedscrollview_adapter, parent, false);
        // LayoutInflater는 XML 레이아웃 파일을 실제 뷰 객체로 만들어주는 역할을 한다.
        // from(parent.getContext())는 부모 뷰의 컨텍스트를 가져와서 LayoutInflater 객체를 생성
        // inflate 메서드를 사용하여 XML 레이아웃 파일(nestedscrollview_adapter.xml)을 뷰 객체로 만듭니다.
        // 이 때, 두 번째 파라미터인 parent는 부모 뷰 그룹이며, 세 번째 파라미터인 false는 인플레이션된 뷰를 즉시 부모에 추가하지 않음을 의미합니다. 리사이클러뷰는 이미 부모에 추가되어 있으므로, false를 사용합니다.
        return new MyViewHolder(v);
    }   // XML 레이아웃 파일을 실제 View 객체로 인스턴스화하는 과정이다. inflate 함수는 XML 레이아웃 파일을 읽어서 그 레이아웃에 정의된 뷰 계층 구조를 만들고, 최종적으로 그것을 부모 ViewGroup에 추가합니다.
        // nestedscrollview_adapter.xml 레이아웃 파일을 읽어서 실제 View 객체로 만들어내고, 그것을 MyViewHolder 객체에 담아 반환하는 역할을 한다
        // 이렇게 생성된 뷰는 리사이클러뷰에서 하나의 아이템을 표현하는 뷰홀더에 연결된다


    // onBindViewHolder: 뷰 홀더에 데이터를 바인딩하는 메서드
    //특정 위치(position)의 데이터를 가져와서 해당 위치에 대한 뷰 홀더의 뷰에 설정
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // MyViewHolder holder: 현재 아이템의 뷰 홀더 객체. 여기서 holder.nameTextView 및 holder.phoneNumberTextView 등을 통해 아이템의 뷰를 조작할 수 있다.
        // MyViewHolder는 리사이클러뷰에서 각 아이템의 뷰들을 담고 있는 애

        // 데이터 바인딩 전에 유효성을 확인
        if (names != null && phoneNumbers != null &&
                position < names.size() && position < phoneNumbers.size()) {

            // 데이터 바인딩
            holder.nameTextView.setText(names.get(position));   // 현재 아이템의 이름을 설정
            holder.phoneNumberTextView.setText(phoneNumbers.get(position));  // 현재 아이템의 전화번호를 설정

            // 아이템 클릭 이벤트 리스너 설정
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 클릭한 아이템의 데이터를 가지고 다음 화면으로 이동
                    User clickedUser = new User(names.get(position), phoneNumbers.get(position));
                    // 클릭한 아이템의 위치(position)를 사용하여 해당 위치의 이름과 전화번호를 가져와서 User 클래스의 객체를 생성. 이 객체는 클릭한 아이템의 데이터를 담고있다.
                    Intent intent = new Intent(v.getContext(), user_profile.class);
                    // v.getContext()를 통해 현재 컨텍스트(화면)를 가져온다
                    intent.putExtra("user_data", clickedUser);
                    // 다음 화면으로 전달할 데이터를 추가합니다. "user_data"라는 키로 clickedUser 객체를 전달해준다
                    v.getContext().startActivity(intent);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return names.size();
    }



    // User class -> 이름과 전화번호를 저장하는 클래스
    // parcelable을 구현하여 데이터를 다른 액티비티로 전달할 수 있다.
    public static class User implements Parcelable {
        private String name;
        private String phoneNumber;

        public User(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        //Getter method
        // getName과 getPhoneNumber 메서드는 외부에서 객체의 멤버 변수에 접근하기 위한 게터 메서드
        public String getName() {
            return name;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }

        // Parcelable 구현
        //readString메서드를 사용하여 Parcel에서 문자열을 읽어와서 name과 phoneNumber에 할당
        protected User(Parcel in) {
            name = in.readString();
            phoneNumber = in.readString();
        }

        //Creator 인터페이스를 구현하여 Parcelable 객체를 만들거임
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

        //describeContents 메서드는 부가 데이터의 정도를 나타냅니다. 대부분의 경우 0을 반환하며, 다른 값은 사용되지 않습니다.
        @Override
        public int describeContents() {
            return 0;
        }

        // writeToParcel 메서드는 객체의 데이터를 Parcel에 쓰는 역할
        // writeString 메서드를 사용하여 name과 phoneNumber을 Parcel에 쓰고 있다
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(phoneNumber);
        }
    }
}
