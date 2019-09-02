package com.example.memories_collection;

import android.os.Bundle;
import android.widget.ImageButton;
import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class collectionActivity extends AppCompatActivity {
    private String fileName = "test.xlm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        ImageButton buttonRead = findViewById(R.id.imageButton);
        buttonRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int n = readFile(fileName);
                if(n != 0){

                }else{

                }
            }
        });
    }

    public String readFile(String file){
        try(FileInputStream fileInputStrean = openFileInput(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, standardCharsets.UTF_8))){
            String LineBuffer;
        }
    }


}

