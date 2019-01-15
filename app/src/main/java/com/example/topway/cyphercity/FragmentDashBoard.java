package com.example.topway.cyphercity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.topway.cyphercity.FirebaseDatabase.EntityImageVideo;
import com.example.topway.cyphercity.FirebaseDatabase.FirebaseUtil;
import com.example.topway.cyphercity.FirebaseDatabase.FirebaseViewModel;
import com.example.topway.cyphercity.RecyclerViewDirectory.MainAdapter;
import com.example.topway.cyphercity.dummyPojo.Dummy;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class FragmentDashBoard extends Fragment {

    private ArrayList<Object> object=new ArrayList<>();
    private ImageView videoUpload;
    private ImageView imageUpload;
    private static final String TAG = "FragmentDashBoard";
    private Uri uri;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    public static Fragment getInstance(){
        return new FragmentDashBoard();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FirebaseUtil.getFirebaseUtil("Talent");
        View view=inflater.inflate(R.layout.fragment_dash_board,container,false);

        videoUpload=view.findViewById(R.id.imageVideo);
        imageUpload=view.findViewById(R.id.imageView);

        recyclerView=view.findViewById(R.id.recyclerView);
        adapter=new MainAdapter(getContext(),getObject());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        FirebaseViewModel viewModel=ViewModelProviders.of(this).get(FirebaseViewModel.class);
        LiveData<DataSnapshot> livedata=viewModel.getSnapShotliveData();
        livedata.observe(this, new Observer<DataSnapshot>() {
            @Override
            public void onChanged(@Nullable DataSnapshot dataSnapshot) {

            }
        });


        imageUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),ImageDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
       private ArrayList<Object> getObject(){
        object.add(getEntityImageVideo());
        object.add(getHorizontaldummyData().get(0));
        return object;
    }

    public static ArrayList<Dummy> getHorizontaldummyData(){
        ArrayList<Dummy> list=new ArrayList<>();
        list.add(new Dummy(R.drawable.comment,"Comment"));
        list.add(new Dummy(R.drawable.like,"like"));
        list.add(new Dummy(R.drawable.backgrond,"background"));
        list.add(new Dummy(R.drawable.image_upload,"Image Upload"));
        list.add(new Dummy(R.drawable.comment,"comment"));
        list.add(new Dummy(R.drawable.like,"like"));
        Log.d(TAG, "getHorizontaldummyData: What is the size of dummy "+list.size());
        return list;
    }
    public static ArrayList<EntityImageVideo> getEntityImageVideo(){
        Log.d(TAG, "getEntityImageVideo: Size of the arraylist"+FirebaseUtil.getArrayList().size());
        return FirebaseUtil.getArrayList();
    }
  //  Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
  //              intent.setType("image/jpeg");
  //              intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
  //  startActivityForResult(intent.createChooser(intent,"Pick Image"),PICK_IMAGE);
}
