package com.example.ashish.speakingtree_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.ashish.speakingtree_android.Utils.AppLocationService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapactivity extends AppCompatActivity {

    private GoogleMap mgoogleMap;
    // GPSTracker class
    AppLocationService mGps;
    Marker mMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapactivity);
        if (mgoogleMap == null) {
            mgoogleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            // check if map is created successfully or not
            if (mgoogleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
            } else {

                mGps = new AppLocationService(this);
                // check if GPS enabled
                if (mGps.canGetLocation()) {
                    final double latitude = mGps.getLatitude();
                    double longitude = mGps.getLongitude();
                   drawMarker(latitude,longitude);
                    mgoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                        @Override
                        public void onMapClick(LatLng latLng) {
                            Log.d("Map","Map clicked");
                            mMarker.remove();
                            drawMarker(latLng.latitude,latLng.longitude);
                        }
                    });

                } else {
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    mGps.showSettingsAlert();
                }

            }
        }
    }

    public void drawMarker(double lat,double Long){
        mgoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, Long), 12.0f));
        mMarker = mgoogleMap.addMarker(new MarkerOptions().position(new LatLng(lat, Long)).title("Current Location"));
        mMarker.showInfoWindow();
    }

}
