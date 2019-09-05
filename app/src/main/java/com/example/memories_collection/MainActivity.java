package com.example.memories_collection;

import androidx.fragment.app.FragmentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.*;
import android.os.Bundle;
import android.view.View;
import android.content.*;

import java.io.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.Marker;
import android.content.pm.PackageManager;
import android.util.Log;
import android.content.Intent;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener, LocationListener {

    private GoogleMap mMap;
    LocationManager locationManager;
    //late...緯度,lon...経度
    double late, lon;
    Marker marker;
    int mark = 0;
    int coin;
    int Step = 0;
    //総合歩数からコイン獲得に使用済みの歩数をマイナスした数値
    int Step2 = 0;
    //コイン獲得回数
    int StepClear;
    int needWalk = 100;
    //位置情報保存の間隔
    int info = 0;
    //日付管理
    int dat;
    Date d1;
    DateFormat form = new SimpleDateFormat("yyyy/MM/dd 00:00:00");
    SharedPreferences data1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        data1 = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        int ItemInt = data1.getInt("UNLOCK_ITEM", 0);
        if (ItemInt > 20) {
            needWalk -= (ItemInt - 20);
        }
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
        coin = data1.getInt("COIN", 0);
        StepClear = data1.getInt("scl", 0);

        Step = data1.getInt("step", 0);
        Step2 = Step - (needWalk * StepClear);
        MoveStep();
        //総合歩数
        TextView text22 = (TextView) findViewById((R.id.textView2_1));
        text22.setText(String.valueOf(Step));
        //コイン枚数
        TextView text5 = (TextView) findViewById((R.id.textView5));
        text5.setText(String.valueOf(coin));
        //総合歩数からコイン獲得に使用済みの歩数をマイナスした数値＝コイン獲得回数を変数にすべき？
        //100歩につき1コイン
        TextView text9 = (TextView) findViewById((R.id.textView9));
        text9.setText(String.valueOf(Step2));
        //コイン獲得に必要な歩数
        TextView text11 = (TextView) findViewById((R.id.textView11));
        text11.setText(String.valueOf(needWalk));
    }

    public void MoveStep() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                //アプリ起動が初めてか
                SharedPreferences.Editor editor = data1.edit();
                dat = data1.getInt("datSave", 0);
                if (dat == 0) {
                    d1 = new Date();
                    editor.putString("d1Save", form.format(d1));
                    editor.apply();
                    dat = 1;
                    editor.putInt("datSave", dat);
                    editor.apply();
                }
                Date d2 = new Date();
                //前回の起動から日が変わっているか
                String d = data1.getString("d1Save", "");
                if (d.equals(form.format(d2))) {
                    Step = 0;
                    StepClear = 0;
                    d1 = d2;
                }

                Step++;
                //総合歩数

                editor.putInt("step", Step);
                Step2 = Step - (needWalk * StepClear);
                if (Step2 >= needWalk) {
                    StepClear++;
                    coin++;
                    editor.putInt("COIN", coin);
                    editor.putInt("scl", StepClear);
                }
                editor.apply();
                TextView text22 = (TextView) findViewById((R.id.textView2_1));
                text22.setText(String.valueOf(Step));
                //コイン枚数
                TextView text5 = (TextView) findViewById((R.id.textView5));
                text5.setText(String.valueOf(coin));
                //総合歩数からコイン獲得に使用済みの歩数をマイナスした数値
                //100歩につき1コイン
                TextView text9 = (TextView) findViewById((R.id.textView9));
                text9.setText(String.valueOf(Step2));
                //コイン獲得に必要な歩数
                TextView text11 = (TextView) findViewById((R.id.textView11));
                text11.setText(String.valueOf(needWalk));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        }, sensor, SensorManager.SENSOR_DELAY_UI);
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
        String path = "/data/data/" + this.getPackageName() + "/files/Location.txt";
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            String s = "";
            late = location.getLatitude();
            lon = location.getLongitude();
            if (info % 10 == 0) {
                long time = location.getTime();
                Date date = new Date(time);
                DateFormat format = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
                s += format.format(date) + "," + late + "," + lon;
                bw.write(s);
                bw.newLine();
            }
            LatLng ecc = new LatLng(late, lon);
            if (mark > 0) {
                marker.setVisible(false);
            }
            marker = mMap.addMarker(new MarkerOptions().position(ecc).title("Marker"));
            marker.setVisible(true);

            mMap.moveCamera(CameraUpdateFactory.newLatLng(ecc));
            CameraUpdate cUpdate = CameraUpdateFactory.newLatLngZoom(
                    new LatLng(late, lon), 12);

            mMap.moveCamera(cUpdate);
            info++;
        } catch (IOException e) {
            Toast toast = Toast.makeText(this,
                    "無理", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case R.id.imageButton:
                    //動作確認用、そのうち消す(マーカーを和歌山湾辺りに一つ増やすコード)
                    marker = mMap.addMarker(new MarkerOptions().position(new LatLng(34, 135)).title("Markerrrrrrrrrrrrrrrr"));
                    //  設定画面を開く処理
                    //ナビゲーションドロワー
                    //ガチャ画面、履歴画面、撮影、コレクション、展示モード(歩数を500歩くらいに、コイン5000枚に、位置情報を10個ほど勝手に数字でファイルに書き込む)

                    break;
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
        marker = mMap.addMarker(new MarkerOptions().position(ecc).title("Marker"));
        mark++;
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
