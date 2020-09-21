package com.example.videoalbum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayVideo(View v){
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);
        String tag = (String) layout.getTag();

        Toast.makeText(this, "클릭한 비디오 : " + tag, Toast.LENGTH_LONG).show();//클릭 시에 토스트메시지 띄우기

        Intent it = new Intent(this, Video.class);//Intent를 이용한 Video 클래스 호출
        it.putExtra("it_tag",tag);//tag값을 전달
        startActivity(it);//Video 클래스 실행
    }
}
