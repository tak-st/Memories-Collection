package com.example.memories_collection;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Camera2Activity<bitmap1, bitmap2> {
    private Bitmap image;;
    //背景となるBitmapを生成する
    ImageView imageView = (ImageView) findViewById(R.id.base_image);


    Bitmap newBitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
//画面の表示サイズを取得する為、1行目でImageViewのインスタンスを取得これは、画面サイズがわかるViewであればImageViewである必要はない


    //作成したBitmapインスタンスを元にCanvasを生成する
    Canvas offScreen = new Canvas(newBitmap);

    //作成したCanvasに必要なImageViewから取得したBitmapとMatrixを使用してdrawBitmapを行う
    ImageView imageView1 = (ImageView) findViewById(R.id.image1);
    ImageView imageView2 = (ImageView) findViewById(R.id.image2);



    Bitmap bitmap1 = ((BitmapDrawable) imageView1.getDrawable()).getBitmap();
    Bitmap bitmap2 = ((BitmapDrawable) imageView2.getDrawable()).getBitmap();
offScreen.drawBitmap(bitmap1, imageView1.getImageMatrix(), null);
offScreen.drawBitmap(bitmap2, imageView2.getImageMatrix(), null);
//Canvasに必要な数だけdrawBitmapするその時にImageViewの中のMatrixを使用するように注意

    //ファイルに出力する
    OutputStream outputStream = null;
try {
        outputStream = getContentResolver().openOutputStream(mUri);
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
    }

    private javax.tools.FileObject getContentResolver() {
        return null;
    }
catch (
    FileNotFoundException e) {
    }
finally {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {}
        }
    }
}
