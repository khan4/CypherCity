package com.example.topway.cyphercity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;

public class FragmentDashBoard extends Fragment {

    private static final int PICK_IMAGE=101;
    private ImageView videoUpload;
    private ImageView imageUpload;
    private static final String TAG = "FragmentDashBoard";
    private Uri uri;

    public static Fragment getInstance(){
        return new FragmentDashBoard();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dash_board,container,false);

        videoUpload=view.findViewById(R.id.imageVideo);
        imageUpload=view.findViewById(R.id.imageView);

        imageUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                startActivityForResult(intent.createChooser(intent,"Pick Image"),PICK_IMAGE);

            }
        });
        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PICK_IMAGE && resultCode==RESULT_OK){
             uri=data.getData();
        }
    }


}
