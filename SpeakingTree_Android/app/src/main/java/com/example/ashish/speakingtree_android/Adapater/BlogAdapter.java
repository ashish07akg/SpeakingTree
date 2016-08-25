package com.example.ashish.speakingtree_android.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.speakingtree_android.Model.Blog;
import com.example.ashish.speakingtree_android.R;
import com.example.ashish.speakingtree_android.networkmanager.NetworkUtil;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ashish on 8/23/2016.
 */
public class BlogAdapter extends ArrayAdapter<Blog> {
    public BlogAdapter(Context context, ArrayList<Blog> artBlog) {
        super(context, 0,artBlog);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Blog BlogList = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.blogitem_list, parent, false);
        }
        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.textViewBlogText);
        // Populate the data into the template view using the data object
        tvTitle.setText(BlogList.getDescription());
        ImageView imgmaster= (ImageView)convertView.findViewById(R.id.imageViewMaster);
        boolean networkstatus = NetworkUtil.getConnectivityStatusString(convertView.getContext());
        if(BlogList.getThumbnail()!=null && !BlogList.getThumbnail().isEmpty() && !BlogList.getThumbnail().equals("null")) {
            if (networkstatus == false) {
                Picasso.with(getContext()).load(BlogList.getThumbnail()).networkPolicy(NetworkPolicy.OFFLINE).into(imgmaster);
            } else {
                Picasso.with(getContext()).load(BlogList.getThumbnail()).into(imgmaster);
            }
        }
        // Return the completed view to render on screen
        return convertView;
    }
}

