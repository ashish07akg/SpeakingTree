package com.example.ashish.speakingtree_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ashish.speakingtree_android.Adapater.spAdapter;
import com.example.ashish.speakingtree_android.Model.Stpick;
import com.example.ashish.speakingtree_android.Model.Todwod;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ashish .
 */
public class SpeakingPicsFragment extends Fragment implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4;
    ImageView imageView;
    ListView listView;
     ArrayList<Stpick> art=null;
    ArrayList<Todwod> spList=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.speakingtree_pics, null);
        LayoutInflater infalter= LayoutInflater.from(getContext());
        // Attach the adapter to a ListView
        listView = (ListView) view.findViewById(R.id.lstquotes);
       View myview= infalter.inflate(R.layout.listheader,listView,false);
        Bundle bundle = getArguments();
        art = bundle.getParcelableArrayList("SpeakingPics");
        Log.e("size", "size" + art.size());
        spList=bundle.getParcelableArrayList("TodoList");
        spAdapter adapter = new spAdapter(getContext(),spList);
        listView.addHeaderView(myview);;
        listView.setAdapter(adapter);
        Log.e("TodoList","ToDoSize"+spList.size());
        if (art != null) {
            btn1 = (Button) myview.findViewById(R.id.button1);
            btn1.setText(art.get(0).getTitle());
            btn2 = (Button) myview.findViewById(R.id.button2);
            btn2.setText(art.get(1).getTitle());
            btn3 = (Button) myview.findViewById(R.id.button3);
            btn3.setText(art.get(2).getTitle());
            btn4 = (Button) myview.findViewById(R.id.button4);
            btn4.setText(art.get(3).getTitle());
            imageView = (ImageView) myview.findViewById(R.id.imageView);
            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
            btn4.setOnClickListener(this);

       }
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                DisplayImage(art,0);
                break;
            case R.id.button2:
                DisplayImage(art,1);
                break;
            case R.id.button3:
                DisplayImage(art,2);
                break;
            case R.id.button4:
                DisplayImage(art,3);

                break;
            default:
                break;
        }
    }

    public void DisplayImage(ArrayList<Stpick> artArray, int number) {
        Picasso.with(getContext())
                .load(artArray.get(number).getBigimage())
                .into(imageView);
    }


}




