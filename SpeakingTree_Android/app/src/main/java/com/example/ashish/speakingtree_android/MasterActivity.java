package com.example.ashish.speakingtree_android;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.GridView;

import com.example.ashish.speakingtree_android.Adapater.MasterGuruAdapter;
import com.example.ashish.speakingtree_android.Model.MasterModel;
import com.example.ashish.speakingtree_android.Model.MasterUser;
import com.example.ashish.speakingtree_android.Utils.AppToast;
import com.example.ashish.speakingtree_android.http.ApiIdentifier;
import com.example.ashish.speakingtree_android.http.CustomAsyncTask;
import com.example.ashish.speakingtree_android.http.OnAsyncTaskHandler;
import com.example.ashish.speakingtree_android.http.UrlConfiq;
import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MasterActivity extends AppCompatActivity implements OnAsyncTaskHandler {

    String strMasterUrl;
    GridView grdviewMaster;
    // HOLD THE URL TO MAKE THE API CALL TO
    private String URL;
    // STORE THE PAGING URL
    private String pagingURL;
    // FLAG FOR CURRENT PAGE
    int current_page = 1;
    // BOOLEAN TO CHECK IF NEW FEEDS ARE LOADING
    Boolean loadingMore = true;
    Boolean stopLoadingData = false;
    int previousTotal = 0;
    MasterModel objMasterList=null;
    ArrayList<MasterUser> masterlist= new ArrayList<MasterUser>();
    private SwipeRefreshLayout swipeContainer;
    Boolean isRefresh=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        grdviewMaster = (GridView) findViewById(R.id.gridViewMaster);
        // ONSCROLLLISTENER

        ParseMasterJson(current_page);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                current_page=1;
                isRefresh=false;
                ParseMasterJson(current_page);
                loadingMore = false;
                previousTotal=0;
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        grdviewMaster.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if(loadingMore)
                {
                    if(totalItemCount > previousTotal)
                    {
                        loadingMore =false;
                        previousTotal = totalItemCount;
                        current_page++;
                    }
                }
                if(!loadingMore && (totalItemCount - visibleItemCount) <= (firstVisibleItem))
                {
                    ParseMasterJson(current_page + 1);
                    loadingMore = true;
                }
            }
        });


    }

    public void ParseMasterJson(int page) {

        // http://www.speakingtree.in/app/userlist.php?page=1&type=masterlist&limit=30&filter=justjoined
        loadingMore=true;
        strMasterUrl = String.format(UrlConfiq.MasterListUrl, page, "masterlist", 20, "justjoined");
        if (!strMasterUrl.isEmpty() && strMasterUrl != null) {
            try {
                URL urlToRequest = new URL(strMasterUrl);
                CustomAsyncTask asyncTask = new CustomAsyncTask(this, ApiIdentifier.MASTER_API,this.isRefresh);
                asyncTask.setOnAsyncTaskHandler(this);
                asyncTask.execute(urlToRequest);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onSuccess(int requestId, String response) {
        Log.e("Success: ", response.toString());
        Gson objGson = new Gson();
        MasterGuruAdapter adapter = null;
        if (!response.isEmpty() && response != null) {
            if(isRefresh==false){
                masterlist.clear();
            }
          objMasterList  = objGson.fromJson(response.toString(), MasterModel.class);
            if (objMasterList != null) {
              masterlist.addAll(objMasterList.getUser());
                if (grdviewMaster.getAdapter() == null) {
                    adapter = new MasterGuruAdapter(this, masterlist);
                    grdviewMaster.setAdapter(adapter);
                } else {
                    adapter = (MasterGuruAdapter) grdviewMaster.getAdapter();
                    adapter.notifyDataSetChanged();
                }

            } else {
                AppToast.showToast(this, "Server Problem");
            }
        }

        loadingMore=true;
        swipeContainer.setRefreshing(false);
        isRefresh=true;
    }

    @Override
    public void onFailure(int requestId, String response) {
        loadingMore=false;
        swipeContainer.setRefreshing(false);


    }


}
