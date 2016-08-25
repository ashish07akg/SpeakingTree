package com.example.ashish.speakingtree_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ashish.speakingtree_android.Adapater.ArticleAdapter;
import com.example.ashish.speakingtree_android.Model.Article;

import java.util.ArrayList;

/**
 * Created by Ratan on 7/29/2015.
 */
public class UpdatesFragment extends Fragment {

    ArrayList<Article> artList=null;
    ListView lstArticle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.updates_layout,null);
        Bundle bundle = getArguments();
        artList = bundle.getParcelableArrayList("ArticleList");
        Log.e("size", "size" + artList.size());
        if (artList != null) {

            // Create the adapter to convert the array to views
            ArticleAdapter adapter = new ArticleAdapter(getContext(),artList);
// Attach the adapter to a ListView
            lstArticle = (ListView) view.findViewById(R.id.lstArticle);
            lstArticle.setAdapter(adapter);
        }
        return  view;

    }
}
