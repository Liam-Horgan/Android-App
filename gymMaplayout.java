package com.example.user.googlemaps;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng ulGym = new LatLng(52.6737, 8.5651);
        mMap.addMarker(new MarkerOptions().position(ulGym).title("UL gym"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ulGym));
        LatLng groveIslandGym = new LatLng(52.6686, 8.6162);
        mMap.addMarker(new MarkerOptions().position(groveIslandGym).title("Grove Island gym"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(groveIslandGym));
        LatLng jjbGym = new LatLng(52.6789, 8.5461162);
        mMap.addMarker(new MarkerOptions().position(jjbGym).title("JJB gym"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jjbGym));
        LatLng strandHotelGym = new LatLng(52.6662, 8.6320);
        mMap.addMarker(new MarkerOptions().position(strandHotelGym).title("Strand Hotel gym"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(strandHotelGym));
        LatLng dominatorGym = new LatLng(52.6625, 8.6174);
        mMap.addMarker(new MarkerOptions().position(dominatorGym).title("Dominator gym"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dominatorGym));
        LatLng castletroyParkGym = new LatLng(52.6670, 8.5769);
        mMap.addMarker(new MarkerOptions().position(dominatorGym).title("Castletroy Park gym"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(castletroyParkGym));
        
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
    }
}
