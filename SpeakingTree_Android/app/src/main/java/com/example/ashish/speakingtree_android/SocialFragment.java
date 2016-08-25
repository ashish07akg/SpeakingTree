package com.example.ashish.speakingtree_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ashish.speakingtree_android.Adapater.masterUpdateAdapter;
import com.example.ashish.speakingtree_android.Model.Update;

import java.util.ArrayList;

/**
 * Created by Ratan on 7/29/2015.
 */
public class SocialFragment extends Fragment {

    ArrayList<Update> Updatelist=null;
    ListView lstmaterUpdate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.social_layout, null);
        Bundle bundle = getArguments();
        Updatelist = bundle.getParcelableArrayList("UpdateArray");
        Log.e("size", "size" + Updatelist.size());
        if (Updatelist != null) {

            // Create the adapter to convert the array to views
            masterUpdateAdapter adapter = new masterUpdateAdapter(getContext(),Updatelist);
// Attach the adapter to a ListView
            lstmaterUpdate = (ListView) view.findViewById(R.id.lstMasterUpdate);
            lstmaterUpdate.setAdapter(adapter);
        }
        return  view;
    }


}
