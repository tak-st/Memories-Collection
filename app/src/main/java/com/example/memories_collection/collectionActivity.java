package com.example.memories_collection;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.view.Window;
import android.widget.ImageView;


public class collectionActivity extends AppCompatActivity {
    private String fileName = "test.xlm";
    int imageViewld[] = {R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ImageView image = new ImageView(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        // レイアウトオブジェクトから拡大対象のImageViewを取得
        final ImageView tapView = (ImageView) findViewById(R.id.imageView1);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView.getDrawable()).getBitmap();
                imageView.setImageBitmap(bitmap);
                // ディスプレイの幅を取得する（API 13以上）
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;

                float factor = width / bitmap.getWidth();
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // ダイアログを作成する
                Dialog dialog = new Dialog(collectionActivity.this);
                // タイトルを非表示にする
                dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(imageView);
                dialog.getWindow().setLayout((int) (bitmap.getWidth() * factor), (int) (bitmap.getHeight() * factor));
                // ダイアログを表示する
                dialog.show();
            }
        });

        ImageButton buttonRead = findViewById(R.id.imageButton);
        buttonRead.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v){
                String str = readFile(fileName);
                if (str != null) {
                    ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.f2132);
                }else{
                    image.setBackgroundColor(00000000);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String readFile(String file) {
        String text = null;

        // try-with-resources
        try (FileInputStream fileInputStream = openFileInput(file); BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8))) {

            String lineBuffer;
            while ((lineBuffer = reader.readLine()) != null) {
                text = lineBuffer;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }
}
