package com.example.videoalbum;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);

        TextView title = (TextView)findViewById(R.id.title);
        VideoView videoView = findViewById(R.id.video);

        Intent it = getIntent();

        String tag = it.getStringExtra("it_tag");//intent에서 tag 값을 가져옴

        Resources res = getResources(); //리소스 객체 생성

        int stringId;
        String mykey;

        stringId = res.getIdentifier("title"+tag,"string",getPackageName());//string.xml에서 id에 해당하는 tag값 가져옴
        mykey = res.getString(stringId);
        title.setText(mykey);

        stringId = res.getIdentifier("video"+tag,"string",getPackageName());
        mykey = res.getString(stringId);

        int id_video = res.getIdentifier(mykey,"raw",getPackageName());

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/" + id_video);

        videoView.setVideoURI(uri);//해당하는 비디오 준비
        videoView.start();

        MediaController mcontroller = new MediaController(this);//비디오를 컨트롤 할 수 있는 컨트롤러
        videoView.setMediaController(mcontroller);

    }

    public void closePicture(View v){
        finish();
    }
}
