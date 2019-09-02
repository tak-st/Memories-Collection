package com.example.memories_collection;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GachaActivity extends AppCompatActivity {

    int coin = 1000;
    private int power = 1;

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
        findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (power == 99 || coin <= power) {

                } else {
                    power += 1;
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
                    TextView tv = findViewById(R.id.textView3);
                    tv.setText(String.valueOf(power));
                }
            }
        });
    }

    private void gachaClickEvent(View v) {
        Random random = new Random();
        int randomValue = random.nextInt(100);
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
            if (randomValue < 90 - (power * 0.9)) {
                builder.setMessage("N");
            } else if (randomValue < 99 - (power * 0.3)) {
                builder.setMessage("R");
            } else {
                builder.setMessage("SR");
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
            }
            builder.show();
        }
    }

/*    private void gachaLongClickEvent(View v) {
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

    }*/
}
