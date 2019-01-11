package com.example.topway.cyphercity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

public class ImageDetailActivity extends AppCompatActivity {
    private static final String TAG = "ImageDetailActivity";
   private ImageView imageView;
   private Button btnOk;
   private Button btnClose;
   private ProgressBar progressBar;
   private String uri=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail_activity);

        imageView=findViewById(R.id.imageDetailActivity);
        progressBar=findViewById(R.id.progressBar);
        Log.d(TAG, "onCreate: is it comming here");
        progressBar.setVisibility(View.VISIBLE);
        Intent intent=getIntent();
        uri=intent.getExtras().getString("URI");

        if (uri!=null){
            Picasso.with(this).load(uri).into(imageView);
            Log.d(TAG, "onCreate: What is the uri "+uri);
            progressBar.setVisibility(View.INVISIBLE);
        }


    }
    public void uploadData(View view){

    }
    public void cancelDialog(View view){

    }
}
