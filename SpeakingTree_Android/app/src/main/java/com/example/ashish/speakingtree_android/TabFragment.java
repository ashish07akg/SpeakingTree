package com.example.ashish.speakingtree_android;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.ashish.speakingtree_android.Model.Article;
import com.example.ashish.speakingtree_android.Model.Blog;
import com.example.ashish.speakingtree_android.Model.Example;
import com.example.ashish.speakingtree_android.Model.Satsang;
import com.example.ashish.speakingtree_android.Model.Stpick;
import com.example.ashish.speakingtree_android.Model.Todwod;
import com.example.ashish.speakingtree_android.Model.Update;
import com.example.ashish.speakingtree_android.Utils.BaseFragment;
import com.example.ashish.speakingtree_android.Utils.CacheHomeData;
import com.example.ashish.speakingtree_android.http.ApiIdentifier;
import com.example.ashish.speakingtree_android.http.ApiResponse;
import com.example.ashish.speakingtree_android.networkmanager.NetworkUtil;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Ashish on 7/27/2015.
 */
public class TabFragment extends BaseFragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 6;
    Example value;
   private ProgressDialog progress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x = inflater.inflate(R.layout.tab_layout, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        /**
         *Set an Apater for the View Pager        */

        boolean networkstatus = NetworkUtil.getConnectivityStatusString(x.getContext());
        if(networkstatus==false)
        {
            GetOfflineHomeData();
        }
        else {
            getHomeData();
        }
        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */
        return x;
    }

private void GetOfflineHomeData()
{
    CacheHomeData offlinehomedata= CacheHomeData.getInstance(getContext());
    String getHomejson=offlinehomedata.GetData("HomeData");
    if (getHomejson == null || getHomejson.isEmpty()) {
        Toast.makeText(getContext(), "Not connected to Internet", Toast.LENGTH_LONG).show();
        return;
    } else {
        // handle the value
        Gson gson = new Gson();
        value = gson.fromJson(getHomejson.toString(), Example.class);
        Log.i("test", "size : " + value.getArticle().size());
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        Log.e("Success", getHomejson.toString());

    }
}

    private void getHomeData() {
        onLoaderStart();
        ApiResponse apiResponse = new ApiResponse(getContext(), ApiIdentifier.FIRST_API);
        apiResponse.setOnApiResponseListener(this);
        apiResponse.makeRequest();
    }

    private void SaveHomeData(String key, String value)
    {
        CacheHomeData offlinehomedata= CacheHomeData.getInstance(getContext());
        offlinehomedata.SaveData(key,value);
    }

    @Override
    public void onSuccess(Object response, int requestId) {
        super.onSuccess(response, requestId);
        switch (requestId) {
            case ApiIdentifier.FIRST_API:
                Gson gson = new Gson();
                value = gson.fromJson(response.toString(), Example.class);
                Log.i("test", "size : " + value.getArticle().size());
                viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
                Log.e("Success", response.toString());
                SaveHomeData("HomeData",response.toString());
                onLoaderDismiss();
                break;
        }
    }

    @Override
    public void onLoaderStart()
    {
        super.onLoaderStart();
        if(progress==null)
        {
            progress= new ProgressDialog(getContext());
            progress.setTitle("Loading");
            progress.setMessage("Please wait");
        }
        progress.show();
    }

    @Override
    public void onLoaderDismiss() {
super.onLoaderDismiss();
        if(progress!=null && progress.isShowing())
        {
            progress.dismiss();
        }
    }

    @Override
    public void onFailure(VolleyError error, int requestId) {
        super.onFailure(error, requestId);
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("SpeakingPics", new ArrayList<Stpick>(value.getStpicks()));

            bundle.putParcelableArrayList("TodoList",new ArrayList<Todwod>(value.getTodwod()));
            switch (position) {
                case 0:
                    SpeakingPicsFragment f = new SpeakingPicsFragment();
                    f.setArguments(bundle
                    );

                    tabLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            tabLayout.setupWithViewPager(viewPager);
                        }
                    });
                    return f;
                case 1:
                    Bundle Updatebundle = new Bundle();
                    Updatebundle.putParcelableArrayList("UpdateArray", new ArrayList<Update>(value.getUpdates()));
                    SocialFragment socialfragment= new SocialFragment();
                    socialfragment.setArguments(Updatebundle);
                   return  socialfragment;
                case 2:
                    Bundle Articlebundle = new Bundle();
                    Articlebundle.putParcelableArrayList("ArticleList", new ArrayList<Article>(value.getArticle()));
                    UpdatesFragment updatefragment= new UpdatesFragment();
                    updatefragment.setArguments(Articlebundle);
                    return  updatefragment;
                case 3:
                    Bundle Blogbundle = new Bundle();
                    Blogbundle.putParcelableArrayList("BlogList", new ArrayList<Blog>(value.getBlog()));
                    SpirtualBlogFragment Blogfragment= new SpirtualBlogFragment();
                    Blogfragment.setArguments(Blogbundle);
                    return  Blogfragment;
                   // return  new SpirtualBlogFragment();
                case 4:
                    return new SpirtualDiscussionFragmant();
                case 5:
                    Bundle Videobundle = new Bundle();
                    Videobundle.putParcelableArrayList("VideoList", new ArrayList<Satsang>(value.getSatsang()));
                    VideoFragmant videofragment= new VideoFragmant();
                    videofragment.setArguments(Videobundle);
                    return  videofragment;

            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Speaking tree pics";
                case 1:
                    return "Master update";
                case 2:
                    return "Spirtual article";
                case 3:
                    return "Spirtual blogs";
                case 4:
                   return "Spirtual discussions";
                case 5:
                    return "Video satsang";
            }
            return null;
        }


    }

}
