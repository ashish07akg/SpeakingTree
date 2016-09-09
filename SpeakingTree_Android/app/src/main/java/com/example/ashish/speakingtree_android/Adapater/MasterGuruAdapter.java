package com.example.ashish.speakingtree_android.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.speakingtree_android.Model.MasterUser;
import com.example.ashish.speakingtree_android.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ashish on 8/26/2016.
 */
public class MasterGuruAdapter extends BaseAdapter {

    private Context context;
    private final List<MasterUser> masterValues;
    public MasterGuruAdapter(Context context, List<MasterUser> masterlist){
        this.context = context;
        this.masterValues = masterlist;
    }

    @Override
    public int getCount() {
        if(masterValues == null || masterValues.isEmpty() )return 0;
        return masterValues.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolder;
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.masterlist_items, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.grid_item_image);
            viewHolder.txtMasterName=(TextView)convertView.findViewById(R.id.txtMastername);
            viewHolder.txtFollweCount=(TextView)convertView.findViewById(R.id.txtFollwercount);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolderItem) convertView.getTag();
        }
        MasterUser masterValueItem = masterValues.get(position);
      String strlastname=   masterValueItem.getLname().equals(null) ?"" :masterValueItem.getLname();
        viewHolder.txtMasterName.setText(masterValueItem.getFname().equals(null) ? "" :masterValueItem.getFname() +" "+ strlastname);
        viewHolder.txtFollweCount.setText(masterValueItem.getFollowers().equals(null)? "0":masterValueItem.getFollowers() +" "+"Followers");
        Picasso.with(convertView.getContext()).load(masterValueItem.getThumbnail()).into(viewHolder.imageView);
        return convertView ;
    }

    static class ViewHolderItem {
        ImageView imageView;
        TextView txtMasterName;
        TextView txtFollweCount;
    }
}
