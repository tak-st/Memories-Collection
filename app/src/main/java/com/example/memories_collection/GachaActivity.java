package com.example.memories_collection;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GachaActivity extends AppCompatActivity {

    int coin = 100;
    private int power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha);
        TextView tv = findViewById(R.id.textView);
        tv.setText(String.valueOf(coin));
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gachaClickEvent(v);
            }
        });
        findViewById(R.id.imageView).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                gachaLongClickEvent(v);
                return true;
            }
        });
    }

    private void gachaClickEvent(View v) {
        Random random = new Random();
        int randomValue = random.nextInt(100);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (coin <= 0) {

        } else {
            coin -= 1;
            TextView tv = findViewById(R.id.textView);
            tv.setText(String.valueOf(coin));
            if (randomValue < 90 - (power * 0.6)) {
                builder.setMessage("N");
            } else if (randomValue < 99 - (power * 0.3)) {
                builder.setMessage("R");
            } else {
                builder.setMessage("SR");
            }
            power = 0;
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }
    }

    private void gachaLongClickEvent(View v) {
        if (power == 98) {

        } else {
            if (coin <= 0) {

            } else {
                coin -= 1;
                power += 1;
                TextView tv = findViewById(R.id.textView);
                tv.setText(String.valueOf(coin));

            }
        }

    }
}
