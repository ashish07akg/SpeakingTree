package com.example.ashish.speakingtree_android.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.speakingtree_android.Model.Article;
import com.example.ashish.speakingtree_android.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ashish on 8/22/2016.
 */
public class ArticleAdapter extends ArrayAdapter<Article> {
    public ArticleAdapter(Context context, ArrayList<Article> articleArray) {
        super(context, 0,articleArray);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Article ArticleList = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.articlelist_items, parent, false);
        }
        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.textViewUpdateText);
        // Populate the data into the template view using the data object
        tvTitle.setText(ArticleList.getDescription());
        ImageView imgmaster= (ImageView)convertView.findViewById(R.id.imageViewMaster);
            Picasso.with(getContext()).load(ArticleList.getThumbnail()).into(imgmaster);



        // Return the completed view to render on screen
        return convertView;
    }
}
