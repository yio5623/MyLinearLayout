package com.example.galleryexample01;

import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Picture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_title = (TextView)findViewById(R.id.title);
        TextView tv_author = (TextView)findViewById(R.id.artist);
        ImageView iv_picture = (ImageView)findViewById(R.id.picture);

        Intent it = getIntent();

        String tag = it.getStringExtra("it_tag");

        Resources res = getResources();

        int id_title =res.getIdentifier("title" + tag, "string", getPackageName());

        String title = res.getString(id_title);
        tv_title.setText(title);

        int id_author =res.getIdentifier("title" + tag, "string", getPackageName());

        String author = res.getString(id_title);
        tv_author.setText(author);
    }
}
