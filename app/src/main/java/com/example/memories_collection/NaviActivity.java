package com.example.memories_collection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NaviActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);
    }
    //展示モード(歩数を500歩くらいに、コイン5000枚に、位置情報を10個ほど勝手に数字でファイルに書き込む)
    @Override
    public void onClick(View view) {
        if (view != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            switch (view.getId()) {
                case R.id.button:
                    finish();
                    Intent intent=new Intent(NaviActivity.this,GachaActivity.class);
                    startActivity(intent);
                    break;

                case R.id.button2:
                    intent = new Intent(NaviActivity.this, HistoryPhotoActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button3:
                    intent=new Intent(NaviActivity.this,CameraActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button4:
                    intent = new Intent(NaviActivity.this, collectionActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button5:

                    //展示モード
                    SharedPreferences data1= getSharedPreferences("DataSave", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = data1.edit();
                    int eten=data1.getInt("ETEN",0);
                    //offの時はONに
                    if(eten==0) {
                        int tempcoin = data1.getInt("COIN", 0);
                        editor.putInt("TEMPCOIN", tempcoin);
                        int tempStep = data1.getInt("step", 0);
                        editor.putInt("TEMPstep", tempStep);
                        int tempScl = data1.getInt("scl", 0);
                        editor.putInt("TEMPscl", tempScl);
                        int go = 50;
                        editor.putInt("COIN", go);
                        int coin = data1.getInt("COIN", 0);
                        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+coin);
                        editor.putInt("scl", 0);
                        editor.putInt("step", 95);
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+tempcoin+","+tempScl+","+tempStep+","+data1.getInt("COIN",0)+","+data1.getInt("scl",0)+","+data1.getInt("step",0));
                        eten=1;
                        editor.putInt("ETEN",eten);
                        editor.apply();
                        //位置情報
                        DateFormat form = new SimpleDateFormat("yyyy/MM/dd");
                        Date dd=new Date();
                        String path= "/data/data/com.example.memories_collection/files/Location"+form.format(dd)+".txt";
                        editor.putString("PATH", path);
                        try {
                            FileWriter fw = new FileWriter(path);
                            BufferedWriter bw = new BufferedWriter(fw);
                            String s = "";
                            //テンプレ1970/01/01 09:00:00,0.0,0.0
                            s = "2019/09/06 04:24:00,0.0,0,0";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:25:00,0.1,0,1";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:26:00,0.2,0,2";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:27:00,0.3,0,3";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:28:00,0.4,0,4";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:29:00,0.5,0,5";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:30:00,0.6,0,6";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:31:00,0.7,0,7";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:32:00,0.8,0,8";
                            bw.write(s);
                            bw.newLine();
                            s = "2019/09/06 04:33:00,0.9,0,9";
                            bw.write(s);
                            bw.newLine();

                        } catch (IOException e) {
                            Toast toast = Toast.makeText(this,
                                    "IOException！", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    intent = new Intent(getApplication(), MainActivity.class);
                    startActivity(intent);
                        //onの時はOFFに
                    }else if(eten==1){
                        int tempcoin=data1.getInt("TEMPCOIN",0);
                        editor.putInt("COIN",tempcoin);
                        int tempStep = data1.getInt("TEMPstep", 0);
                        editor.putInt("step", tempStep);
                        int tempScl = data1.getInt("TEMPscl", 0);
                        editor.putInt("scl", tempScl);
                        eten=0;
                        editor.putInt("ETEN",eten);
                        editor.apply();
                        intent = new Intent(NaviActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    break;


            }
        }
    }
}
