package com.example.ashish.speakingtree_android.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ashish.speakingtree_android.Model.Todwod;
import com.example.ashish.speakingtree_android.R;

import java.util.ArrayList;

/**
 * Created by Ashish on 8/16/2016.
 */
public class spAdapter extends ArrayAdapter<Todwod> {

    public spAdapter(Context context, ArrayList<Todwod> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Todwod user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spquotes_list_item, parent, false);
        }
        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
        TextView tvName = (TextView) convertView.findViewById(R.id.textViewMessageBody);
        TextView tvHome = (TextView) convertView.findViewById(R.id.textViewSMSSender);
        // Populate the data into the template view using the data object
        tvName.setText(user.getDescription());
        if(user.getContenttype()==17) {
            tvTitle.setText(user.getTitle());
            tvHome.setVisibility(View.GONE);
            tvTitle.setVisibility(View.VISIBLE);
        }
        else
        {
            tvHome.setText("Quote by "+user.getTitle() );
            tvTitle.setVisibility(View.GONE);
            tvHome.setVisibility(View.VISIBLE);
        }
        // Return the completed view to render on screen
        return convertView;
    }
}