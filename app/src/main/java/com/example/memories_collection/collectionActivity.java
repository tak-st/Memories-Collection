package com.example.memories_collection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;


public class collectionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        SharedPreferences data = getSharedPreferences("Collection", Context.MODE_PRIVATE);
        findViewById(R.id.imageView1).setVisibility(data.getInt("Item_1", 4));

        // レイアウトオブジェクトから拡大対象のImageViewを取得
        final ImageView tapView1 = (ImageView) findViewById(R.id.imageView1);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView1.getDrawable()).getBitmap();
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

        final ImageView tapView2 = (ImageView) findViewById(R.id.imageView2);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView2.getDrawable()).getBitmap();
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

        final ImageView tapView3 = (ImageView) findViewById(R.id.imageView3);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView3.getDrawable()).getBitmap();
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

        final ImageView tapView4 = (ImageView) findViewById(R.id.imageView4);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView4.getDrawable()).getBitmap();
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

        final ImageView tapView5 = (ImageView) findViewById(R.id.imageView5);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView5.getDrawable()).getBitmap();
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

        final ImageView tapView6 = (ImageView) findViewById(R.id.imageView6);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView6.getDrawable()).getBitmap();
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

        final ImageView tapView7 = (ImageView) findViewById(R.id.imageView7);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView7.getDrawable()).getBitmap();
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

        final ImageView tapView8 = (ImageView) findViewById(R.id.imageView8);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView8.getDrawable()).getBitmap();
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

        final ImageView tapView9 = (ImageView) findViewById(R.id.imageView9);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView9.getDrawable()).getBitmap();
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

        final ImageView tapView10 = (ImageView) findViewById(R.id.imageView10);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView10.getDrawable()).getBitmap();
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

        final ImageView tapView11 = (ImageView) findViewById(R.id.imageView11);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView11.getDrawable()).getBitmap();
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

        final ImageView tapView12 = (ImageView) findViewById(R.id.imageView12);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView12.getDrawable()).getBitmap();
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

        final ImageView tapView13 = (ImageView) findViewById(R.id.imageView13);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView13.getDrawable()).getBitmap();
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

        final ImageView tapView14 = (ImageView) findViewById(R.id.imageView14);
        // 拡大対象のImageViewにタップ時のリスナーをセット
        tapView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(collectionActivity.this);
                Bitmap bitmap = ((BitmapDrawable) tapView14.getDrawable()).getBitmap();
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

        /*ImageButton button;
        ImageView iv1;
            public void onClick(View v) {
                if(v == button){
                    Array typedArray = getResources().obtainTypedArray(R.array.default_albumart);
       　　         int i = (int) (Math.floor(Math.random() * 20));
                    Drawable drawable = typedArray.getDrawable(i);
                    iv1.setImageDrawable(drawable);}
            }*/


    }
}
