package com.example.android.mpougatsa;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    GoogleMap googleMap;
    MapFragment mapFragment;
    double lat = 40.6278952;
    double lng = 22.9492576;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap gMap) {
        googleMap = gMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Edit the following as per you needs
        googleMap.setTrafficEnabled(true);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        //

        LatLng placeLocation = new LatLng(lat, lng); //Make them global
        googleMap.addMarker(new MarkerOptions().position(placeLocation)
                .title("MPOUGATSA GIANNIS"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(placeLocation));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(20), 1000, null);
    }

    public void facebook(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/%CE%9C%CE%A0%CE%9F%CE%A5%CE%93%CE%91%CE%A4%CE%A3%CE%91-%CE%93%CE%99%CE%91%CE%9D%CE%9D%CE%97%CE%A3-127839470252/"));
        startActivity(browserIntent);
    }

    public void twitter(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/explore/locations/9452563/"));
        startActivity(browserIntent);
    }

    public void google(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bougatsagiannis.com/"));
        startActivity(browserIntent);
    }
}
