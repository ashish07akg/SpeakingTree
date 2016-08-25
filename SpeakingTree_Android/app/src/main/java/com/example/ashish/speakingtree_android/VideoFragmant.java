package com.example.ashish.speakingtree_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ashish.speakingtree_android.Adapater.VideoAdapter;
import com.example.ashish.speakingtree_android.Model.Satsang;

import java.util.ArrayList;

/**
 * Created by Ashish on 8/10/2016.
 */
public class VideoFragmant extends Fragment  {

    ArrayList<Satsang> artSatsang=null;
    ListView lstVideo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.video_layout,null);
        Bundle bundle = getArguments();
        artSatsang = bundle.getParcelableArrayList("VideoList");
        Log.e("size", "size" + artSatsang.size());
        if (artSatsang != null) {

            // Create the adapter to convert the array to views
            VideoAdapter adapter = new VideoAdapter(getContext(),artSatsang);
// Attach the adapter to a ListView
            lstVideo = (ListView) view.findViewById(R.id.lstVideo);
            lstVideo.setAdapter(adapter);

        }
        return  view;
    }


}
