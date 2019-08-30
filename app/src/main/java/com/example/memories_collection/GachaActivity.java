package com.example.memories_collection;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GachaActivity extends AppCompatActivity {
    int runflag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Random random = new Random();
        int randomValue = random.nextInt(100);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (randomValue < 90) {
            builder.setMessage("N");
        } else if (randomValue < 99) {
            builder.setMessage("R");
        } else {
            builder.setMessage("SR");
        }
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.show();
        return true;
        //return super.onTouchEvent(event);
    }
}
