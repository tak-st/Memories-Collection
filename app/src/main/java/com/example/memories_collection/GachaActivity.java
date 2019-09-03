package com.example.memories_collection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GachaActivity extends AppCompatActivity {

    private static final String TAG = "GachaActivity";
    private static final String PREF_FILE_NAME = "com.example.memories_collection.PREF_FILE_NAME";

    private int coin = 1000;
    private int power = 1;
    private double newitem = 1;
    private double powernewitem = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Refreshnewitemprob();
        Refreshpowerprob();
        TextView tv = findViewById(R.id.textView);
        tv.setText(String.valueOf(coin));
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gachaClickEvent(v);
            }
        });
        findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (power == 99 || coin <= power) {

                } else {
                    power += 1;
                    Refreshpowerprob();
                    TextView tv = findViewById(R.id.textView3);
                    tv.setText(String.valueOf(power));
                }

            }
        });
        findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (power == 1) {

                } else {
                    power -= 1;
                    Refreshpowerprob();
                    TextView tv = findViewById(R.id.textView3);
                    tv.setText(String.valueOf(power));
                }
            }
        });
    }

    private void Refreshpowerprob() {
        TextView probt = findViewById(R.id.textView2);
        powernewitem = 1 - Math.pow((1 - newitem), (power - 1) * 1.05 + 1);
        probt.setText(String.format("%.1f%%", powernewitem * 100));
    }

    private void Refreshnewitemprob() {
        SharedPreferences sharedPref = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        // 値の取得
        int intVal = sharedPref.getInt("UNLOCK_ITEM", 0);
        if (intVal < 6) {
            newitem = 1.5 / (intVal + 1.5);
        } else {
            if (intVal < 20) {
                newitem = 1.5 / (Math.pow((intVal - 5), 2) + 6.5);
            } else {
                newitem = 0;
            }
        }
    }
    private void gachaClickEvent(View v) {
        Random random = new Random();
        int randomValue = random.nextInt(1000);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (coin < power) {
            builder.setMessage("コインが足りません。");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        } else {
            coin -= power;
            TextView tv = findViewById(R.id.textView);
            tv.setText(String.valueOf(coin));
            Refreshpowerprob();
            if (randomValue < powernewitem * 1000) {
                builder.setMessage("新アイテム獲得！");
                SharedPreferences sharedPref = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
                int intVal = sharedPref.getInt("UNLOCK_ITEM", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("UNLOCK_ITEM", intVal + 1);
                editor.apply();
                Refreshnewitemprob();
                Refreshpowerprob();
            } else {
                builder.setMessage("はずれ");
            }
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            if (coin < power) {
                power = coin;
                if (power == 0) {
                    power = 1;
                }
                TextView tv3 = findViewById(R.id.textView3);
                tv3.setText(String.valueOf(power));
                Refreshpowerprob();
            }
            builder.show();
        }
    }
}