package com.example.ashish.speakingtree_android.Adapater;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ashish.speakingtree_android.Model.Satsang;
import com.example.ashish.speakingtree_android.R;
import com.example.ashish.speakingtree_android.networkmanager.NetworkUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ashish on 8/22/2016.
 */
public class VideoAdapter extends ArrayAdapter<Satsang> {
    public VideoAdapter(Context context, ArrayList<Satsang> artSatsang) {
        super(context, 0,artSatsang);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Satsang SatsangVideo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.videolist_items, parent, false);
        }

        ImageView imgmaster= (ImageView)convertView.findViewById(R.id.imageView);
        Picasso.with(getContext()).load(SatsangVideo.getBigimage()).into(imgmaster);
        imgmaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean networkstatus = NetworkUtil.getConnectivityStatusString(v.getContext());
                if(networkstatus==false)
                {
                    Toast.makeText(v.getContext(), "Not connected to Internet", Toast.LENGTH_LONG).show();
                    return;
                }
               if(SatsangVideo.getVideoFile()!=null && !SatsangVideo.getVideoFile().isEmpty() && !SatsangVideo.getVideoFile().equals("null"))

                {
                    Intent openVideo = new Intent(Intent.ACTION_VIEW, Uri.parse(SatsangVideo.getVideoFile()));
                    v.getContext().startActivity(openVideo);
                }
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
