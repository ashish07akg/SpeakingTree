package com.example.ashish.speakingtree_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ashish.speakingtree_android.Adapater.BlogAdapter;
import com.example.ashish.speakingtree_android.Model.Blog;

import java.util.ArrayList;

/**
 * Created by Ashish on 8/10/2016.
 */
public class SpirtualBlogFragment extends Fragment {

   ArrayList<Blog> blogList=null;
    ListView lstBlog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.spirtualblog_layout,null);
        Bundle bundle = getArguments();
        blogList = bundle.getParcelableArrayList("BlogList");
        Log.e("size", "size" + blogList.size());
        if (blogList != null) {
            // Create the adapter to convert the array to views
            BlogAdapter adapter = new BlogAdapter(getContext(),blogList);
// Attach the adapter to a ListView
            lstBlog = (ListView) view.findViewById(R.id.lstBlogs);
            lstBlog.setAdapter(adapter);
        }
        return  view;
    }
}
