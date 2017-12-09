package com.example.apoorva.marker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    boolean map_ready;
    GoogleMap m_map;
    static final CameraPosition defaultLoc = CameraPosition.builder().target(new LatLng(40.757680,-73.984176)).zoom(17).tilt(0).build();
    //Markers showing various theatres in times square,USA
    MarkerOptions theatreDistrict;
    MarkerOptions belascoTheatre;
    MarkerOptions palacetheatre;
    MarkerOptions minskoffTheatre;
    MarkerOptions barrymoreTheatre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Giving the properties to the marker
        theatreDistrict = new MarkerOptions().position(new LatLng(40.75909,-73.985195)).title("Theatre district").icon(BitmapDescriptorFactory.fromResource(R.drawable.th));
        belascoTheatre =  new MarkerOptions().position(new LatLng(40.756823,-73.983779)).title("Belasco Theatre").icon(BitmapDescriptorFactory.fromResource(R.drawable.th));
        palacetheatre = new MarkerOptions().position(new LatLng(40.759082,-73.984519)).title("Palace Theatre").icon(BitmapDescriptorFactory.fromResource(R.drawable.th));
        minskoffTheatre = new MarkerOptions().position(new LatLng(40.758017,-73.986000)).title("Minskoff Theatre").icon(BitmapDescriptorFactory.fromResource(R.drawable.th));
        barrymoreTheatre = new MarkerOptions().position(new LatLng(40.760374,-73.986204)).title("Barrymore Theatre").icon(BitmapDescriptorFactory.fromResource(R.drawable.th));
        MapFragment fragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap map)
    {
        m_map = map;
        map_ready = true;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        //Adding the marker to the map
        m_map.addMarker(palacetheatre);
        m_map.addMarker(belascoTheatre);
        m_map.addMarker(minskoffTheatre);
        m_map.addMarker(barrymoreTheatre);
        m_map.addMarker(theatreDistrict);
        //This can add a circle around a particular latLng:: m_map.addCircle(new CircleOptions().center(new LatLng(40.757680,-73.984176)).radius(100).fillColor(Color.argb(30,0,200,0)).strokeColor(Color.GREEN));
        //Map starts from this default location
        fly_to(defaultLoc);
    }
    private void fly_to(CameraPosition target)
    {
        //The path is shown as animation
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target),10000,null);
    }

}
