package com.example.memories_collection;

import androidx.fragment.app.FragmentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;

import android.location.*;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdate;

import android.content.pm.PackageManager;
import android.util.Log;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;
import android.Manifest;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener, LocationListener {

    private GoogleMap mMap;
    LocationManager locationManager;
    double late, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //int percent = 0;
        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        //bar.setMax(100);
        //bar.setProgress(percent,true);
        //bar.setMin(0);
        findViewById(R.id.imageButton).setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},
                    1000);
        } else {
            locationStart();

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    1000, 50, this);

        }
    }

    private void locationStart() {

        // LocationManager インスタンス生成
        locationManager =
                (LocationManager) getSystemService(LOCATION_SERVICE);

        if (locationManager != null && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Log.d("debug", "location manager Enabled");
        } else {
            // GPSを設定するように促す
            Intent settingsIntent =
                    new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
            Log.d("debug", "not gpsEnable, startActivity");
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);

            Log.d("debug", "checkSelfPermission false");
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000, 50, this);

    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1000) {
            // 使用が許可された
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("debug", "checkSelfPermission true");

                locationStart();

            } else {
                // それでも拒否された時の対応
                Toast toast = Toast.makeText(this,
                        "これ以上なにもできません", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        /* API 29以降非推奨

        switch (status) {
            case LocationProvider.AVAILABLE:
                Log.d("debug", "LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                break;
        }
        */
    }

    @Override
    public void onLocationChanged(Location location) {
        late = location.getLatitude();

        lon = location.getLongitude();
        LatLng ecc = new LatLng(late, lon);
        mMap.addMarker(new MarkerOptions().position(ecc).title("Marker"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ecc));
        CameraUpdate cUpdate = CameraUpdateFactory.newLatLngZoom(
                new LatLng(late, lon), 12);

        mMap.moveCamera(cUpdate);

    }
    @Override
    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case R.id.imageButton:
                    //動作確認用、そのうち消す(マーカーを和歌山湾辺りに一つ増やすコード)
                    mMap.addMarker(new MarkerOptions().position(new LatLng(34, 135)).title("Markerrrrrrrrrrrrrrrr"));
                    //  設定画面を開く処理
                    //ナビゲーションドロワー

                    break;

                //多分戻るボタンとかもいる？
            }
        }
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

        Location location = new Location(LocationManager.GPS_PROVIDER);
        onLocationChanged(location);
        // Add a marker in ecc and move the camera
        LatLng ecc = new LatLng(late, lon);
        mMap.addMarker(new MarkerOptions().position(ecc).title("Marker"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ecc));
        CameraUpdate cUpdate = CameraUpdateFactory.newLatLngZoom(
                new LatLng(late, lon), 12);

        mMap.moveCamera(cUpdate);
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
