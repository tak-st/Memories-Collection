package com.example.memories_collection;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CameraActivity extends AppCompatActivity {

    private final static int RESULT_CAMERA = 1001;
    private final static int REQUEST_PERMISSION = 1002;

    private ImageView imageView;
    private Uri cameraUri;
    private File cameraFile;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("debug", "onCreate()");
        setContentView(R.layout.activity_camera);

        imageView = findViewById(R.id.image_view);

        Button cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Android 6, API 23以上でパーミッシンの確認
                if (Build.VERSION.SDK_INT >= 23) {
                    checkPermission();
                } else {
                    cameraIntent();
                }
            }
        });
    }

    private void cameraIntent() {
        // 保存先のフォルダー
        File cFolder = getExternalFilesDir(Environment.DIRECTORY_DCIM);

        sharedPref = getSharedPreferences("DataSava", Context.MODE_PRIVATE);
        int photon = sharedPref.getInt("PHOTONO", 1);
        // ファイル名
        String fileName = String.format("CameraIntent_%d.jpg", photon);

        cameraFile = new File(cFolder, fileName);

        cameraUri = FileProvider.getUriForFile(
                CameraActivity.this,
                getApplicationContext().getPackageName() + ".fileprovider",
                cameraFile);
        String fileDate = new SimpleDateFormat(
                "yymmdd", Locale.US).format(new Date());
        String path = "/data/data/" + this.getPackageName() + "/files/Photos" + fileDate + ".txt";
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            Date date = new Date();
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            String PATH = sharedPref.getString("PATH", "");
            String s = photon + "," + format.format(date) + "," + PATH;
            try {
                bw.write(s);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("PHOTONO", photon + 1);
        editor.apply();

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
        startActivityForResult(intent, RESULT_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent intent) {

        if (requestCode == RESULT_CAMERA) {

            if (cameraUri != null) {
                imageView.setImageURI(cameraUri);

                registerDatabase(cameraFile);
            } else {
                Log.d("debug", "cameraUri == null");
            }
        }
    }

    // アンドロイドのデータベースへ登録する
    private void registerDatabase(File file) {
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = CameraActivity.this.getContentResolver();
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        contentValues.put("_data", file.getAbsolutePath());
        contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    // Runtime Permission check
    private void checkPermission() {
        // 既に許可している
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA) ==
                    PackageManager.PERMISSION_GRANTED) {
                cameraIntent();
            } else {
                requestPermissionC();
            }
        }
        // 拒否していた場合
        else {
            requestPermissionS();
        }
    }

    // 許可を求める
    private void requestPermissionS() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(CameraActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION);

        } else {
            Toast toast = Toast.makeText(this,
                    "許可されないとアプリが実行できません",
                    Toast.LENGTH_SHORT);
            toast.show();

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    REQUEST_PERMISSION);

        }
    }

    private void requestPermissionC() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(CameraActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_PERMISSION);

        } else {
            Toast toast = Toast.makeText(this,
                    "許可されないとアプリが実行できません",
                    Toast.LENGTH_SHORT);
            toast.show();

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA,},
                    REQUEST_PERMISSION);

        }
    }
    // 結果の受け取り
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        Log.d("debug", "onRequestPermissionsResult()");

        if (requestCode == REQUEST_PERMISSION) {
            // 使用が許可された
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                checkPermission();

            } else {
                // それでも拒否された時の対応
                Toast toast = Toast.makeText(this,
                        "これ以上なにもできません", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}