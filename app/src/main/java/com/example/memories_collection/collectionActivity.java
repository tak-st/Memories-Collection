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
import android.widget.ImageView;

public class collectionActivity extends AppCompatActivity {
    private ImageView tapView[] = new ImageView[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        SharedPreferences data = getSharedPreferences("Collection", Context.MODE_PRIVATE);

       /* findViewById(R.id.imageView1).setVisibility(data.getInt("Item_1", 4));
        findViewById(R.id.imageView2).setVisibility(data.getInt("Item_2", 4));
        findViewById(R.id.imageView3).setVisibility(data.getInt("Item_3", 4));
        findViewById(R.id.imageView4).setVisibility(data.getInt("Item_4", 4));
        findViewById(R.id.imageView5).setVisibility(data.getInt("Item_5", 4));
        findViewById(R.id.imageView6).setVisibility(data.getInt("Item_6", 4));
        findViewById(R.id.imageView7).setVisibility(data.getInt("Item_7", 4));
        findViewById(R.id.imageView8).setVisibility(data.getInt("Item_8", 4));
        findViewById(R.id.imageView9).setVisibility(data.getInt("Item_9", 4));
        findViewById(R.id.imageView10).setVisibility(data.getInt("Item_10", 4));
        findViewById(R.id.imageView11).setVisibility(data.getInt("Item_11", 4));
        findViewById(R.id.imageView12).setVisibility(data.getInt("Item_12", 4));
        findViewById(R.id.imageView13).setVisibility(data.getInt("Item_13", 4));
        findViewById(R.id.imageView14).setVisibility(data.getInt("Item_14", 4));
        findViewById(R.id.imageView15).setVisibility(data.getInt("Item_15", 4));
        findViewById(R.id.imageView16).setVisibility(data.getInt("Item_16", 4));
        findViewById(R.id.imageView17).setVisibility(data.getInt("Item_17", 4));
        findViewById(R.id.imageView18).setVisibility(data.getInt("Item_18", 4));
        findViewById(R.id.imageView19).setVisibility(data.getInt("Item_19", 4));
        findViewById(R.id.imageView20).setVisibility(data.getInt("Item_20", 4));*/

        // レイアウトオブジェクトから拡大対象のImageViewを取得
        tapView[0] = (ImageView) findViewById(R.id.imageView1);
        tapView[1] = (ImageView) findViewById(R.id.imageView2);
        tapView[2] = (ImageView) findViewById(R.id.imageView3);
        tapView[3] = (ImageView) findViewById(R.id.imageView4);
        tapView[4] = (ImageView) findViewById(R.id.imageView5);
        tapView[5] = (ImageView) findViewById(R.id.imageView6);
        tapView[6] = (ImageView) findViewById(R.id.imageView7);
        tapView[7] = (ImageView) findViewById(R.id.imageView8);
        tapView[8] = (ImageView) findViewById(R.id.imageView9);
        tapView[9] = (ImageView) findViewById(R.id.imageView10);
        tapView[10] = (ImageView) findViewById(R.id.imageView11);
        tapView[11] = (ImageView) findViewById(R.id.imageView12);
        tapView[12] = (ImageView) findViewById(R.id.imageView13);
        tapView[13] = (ImageView) findViewById(R.id.imageView14);
        tapView[14] = (ImageView) findViewById(R.id.imageView15);
        tapView[15] = (ImageView) findViewById(R.id.imageView16);
        tapView[16] = (ImageView) findViewById(R.id.imageView17);
        tapView[17] = (ImageView) findViewById(R.id.imageView18);
        tapView[18] = (ImageView) findViewById(R.id.imageView19);
        tapView[19] = (ImageView) findViewById(R.id.imageView20);

        for (int n = 0; n < 20; n++) {
            switch (n) {
                case 0:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[0].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[0].getDrawable()).getBitmap();
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
                    break;
                case 1:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[1].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[1].getDrawable()).getBitmap();
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
                    break;
                case 2:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[2].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[2].getDrawable()).getBitmap();
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
                    break;
                case 3:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[3].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[3].getDrawable()).getBitmap();
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
                    break;
                case 4:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[4].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[4].getDrawable()).getBitmap();
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
                    break;
                case 5:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[5].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[5].getDrawable()).getBitmap();
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
                    break;
                case 6:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[6].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[6].getDrawable()).getBitmap();
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
                    break;
                case 7:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[7].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[7].getDrawable()).getBitmap();
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
                    break;
                case 8:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[8].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[8].getDrawable()).getBitmap();
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
                    break;
                case 9:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[9].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[9].getDrawable()).getBitmap();
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
                    break;
                case 10:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[10].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[10].getDrawable()).getBitmap();
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
                    break;
                case 11:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[11].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[11].getDrawable()).getBitmap();
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
                    break;
                case 12:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[12].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[12].getDrawable()).getBitmap();
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
                    break;
                case 13:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[13].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[13].getDrawable()).getBitmap();
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
                    break;
                case 14:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[14].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[14].getDrawable()).getBitmap();
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
                    break;
                case 15:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[15].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[15].getDrawable()).getBitmap();
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
                    break;
                case 16:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[16].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[16].getDrawable()).getBitmap();
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
                    break;
                case 17:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[17].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[17].getDrawable()).getBitmap();
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
                    break;
                case 18:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[18].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[18].getDrawable()).getBitmap();
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
                    break;
                case 19:// 拡大対象のImageViewにタップ時のリスナーをセット
                    tapView[19].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = new ImageView(collectionActivity.this);
                            Bitmap bitmap = ((BitmapDrawable) tapView[19].getDrawable()).getBitmap();
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
            }
        }
    }
}
