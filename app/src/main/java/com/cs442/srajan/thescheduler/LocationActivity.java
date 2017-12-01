package com.cs442.srajan.thescheduler;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private LatLng am = new LatLng(41.836232, -87.627283);
    private LatLng cr = new LatLng(41.833141, -87.627169);
    private LatLng re = new LatLng(41.837213, -87.627139);
    private LatLng ls = new LatLng(41.838032, -87.627359);
    private LatLng ph = new LatLng(41.835425, -87.627125);
    private LatLng sh = new LatLng(41.834261, -87.627635);
    private LatLng sb = new LatLng(41.838668, -87.627373);
    private LatLng wh = new LatLng(41.835148, -87.627624);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(am));
        mMap.addMarker(new MarkerOptions().position(cr));
        mMap.addMarker(new MarkerOptions().position(re));
        mMap.addMarker(new MarkerOptions().position(ls));
        mMap.addMarker(new MarkerOptions().position(ph));
        mMap.addMarker(new MarkerOptions().position(sh));
        mMap.addMarker(new MarkerOptions().position(sb));
        mMap.addMarker(new MarkerOptions().position(wh));


        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(am, 17.0f));
    }
}
