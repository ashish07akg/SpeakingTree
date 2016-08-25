package com.example.ashish.speakingtree_android.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.speakingtree_android.Model.Update;
import com.example.ashish.speakingtree_android.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ashish on 8/22/2016.
 */
public class masterUpdateAdapter extends ArrayAdapter<Update> {
    public masterUpdateAdapter(Context context, ArrayList<Update> masterupdate) {
        super(context,0, masterupdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Update UpdateMaster = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.master_items, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.textViewUpdateText);

        // Populate the data into the template view using the data object
        tvTitle.setText(UpdateMaster.getUpdatetext());

        ImageView imgmaster= (ImageView)convertView.findViewById(R.id.imageViewMaster);
        Picasso.with(getContext()).load(UpdateMaster.getThumbnail()).into(imgmaster);
        // Return the completed view to render on screen
        return convertView;
    }
}
