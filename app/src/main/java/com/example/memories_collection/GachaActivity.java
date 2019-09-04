package com.example.memories_collection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GachaActivity extends AppCompatActivity {

    private static final String PREF_FILE_NAME = "DataSave";
    SharedPreferences sharedPref = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    private int coin = sharedPref.getInt("COIN", 0);
    private int power = 1;
    private double newitem = 1;
    private double powernewitem = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //確率更新
        Refreshnewitemprob();
        Refreshpowerprob();
        //コイン枚数更新
        TextView tv = findViewById(R.id.textView);
        tv.setText(String.valueOf(coin));
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ガチャマシンをタップでガチャメゾットへ。
                gachaClickEvent(v);
            }
        });
        findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (power == 99 || coin <= power) {
                    //同時投入は99枚まで、または手持ちのコインの枚数まで。
                } else {
                    power += 1;
                    Refreshpowerprob();
                    TextView tv = findViewById(R.id.textView3);
                    tv.setText(String.valueOf(power));
                }

            }
        });
        findViewById(R.id.imageView4).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //上を長押しした場合、コイン投入数を所持コインと同額にする
                power = coin;
                if (power == 0) {
                    //ただし0になる場合、1に設定。
                    power = 1;
                }
                if (power > 99) {
                    //ただし99を超える場合、99に設定。
                    power = 99;
                }
                TextView tv3 = findViewById(R.id.textView3);
                tv3.setText(String.valueOf(power));
                //確率更新
                Refreshpowerprob();
                return true;
            }
        });
        findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (power == 1) {
                    //同時投入の下限は1。0では回せない。
                } else {
                    power -= 1;
                    Refreshpowerprob();
                    TextView tv = findViewById(R.id.textView3);
                    tv.setText(String.valueOf(power));
                }
            }
        });
        findViewById(R.id.imageView5).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //下を長押しした場合、コイン投入数を1にする
                power = 1;
                TextView tv3 = findViewById(R.id.textView3);
                tv3.setText(String.valueOf(power));
                //確率更新
                Refreshpowerprob();
                return true;
            }
        });
    }

    private void Refreshpowerprob() {
        //コイン複数投入時の獲得確率の更新
        TextView probt = findViewById(R.id.textView2);
        powernewitem = 1 - Math.pow((1 - newitem), (power - 1) * 1.05 + 1);
        probt.setText(String.format("%.1f%%", powernewitem * 100));
    }

    private void Refreshnewitemprob() {
        //新アイテム獲得確率の更新

        // 設定に保存している値の取得
        int intVal = sharedPref.getInt("UNLOCK_ITEM", 0);
        if (intVal < 6) {
            // 新アイテムが5種類以下
            newitem = 1.5 / (intVal + 1.5);
        } else {
            if (intVal < 37) {
                // 新アイテムが6~36
                newitem = 1.5 / (Math.pow((intVal - 5), 2) + 6.5);
            } else {
                //37~
                if (intVal == 70) {
                    newitem = 0;
                } else {
                    newitem = 0.001;
                }
            }
        }
    }
    private void gachaClickEvent(View v) {
        //ガチャを行うメゾッド
        Random random = new Random();
        int randomValue = random.nextInt(1000);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (coin < power) {
            //コインが無ければ回せない。
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
            editor.putInt("COIN", coin);
            editor.apply();
            Refreshpowerprob();
            //確率で分岐する
            if (randomValue < powernewitem * 1000) {
                //当たり
                // 設定に保存している値の取得
                int intVal = sharedPref.getInt("UNLOCK_ITEM", 0);
                //所持アイテム数を1増加。
                editor.putInt("UNLOCK_ITEM", intVal + 1);
                editor.apply();
                if (intVal > 19) {
                    builder.setMessage("コイン獲得歩数減少獲得！ (-" + (intVal - 19) + ")");
                } else {
                    SharedPreferences Csp = getSharedPreferences("Collection", Context.MODE_PRIVATE);
                    SharedPreferences.Editor Ced = Csp.edit();
                    int rndv = random.nextInt(20);
                    while (Csp.getInt("Item_" + rndv, 4) == 0) {
                        rndv = random.nextInt(20);
                    }
                    editor.putInt("Item_" + rndv, 0);
                    editor.apply();
                    builder.setMessage("新アイテム獲得！ (" + (intVal + 1) + "/20)");
                }
                if (intVal == 19) {
                    builder.setMessage("新アイテム獲得！ コンプリートおめでとう！");
                }
                //確率更新
                Refreshnewitemprob();
                Refreshpowerprob();
            } else {
                //はずれ
                builder.setMessage("はずれ");
            }
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });

            if (coin < power) {
                //現在のコイン投入数より所持コインが少ない場合、コイン投入数を所持コインと同額にする
                power = coin;
                if (power == 0) {
                    //ただし0になる場合、1に設定。
                    power = 1;
                }
                TextView tv3 = findViewById(R.id.textView3);
                tv3.setText(String.valueOf(power));
                //確率更新
                Refreshpowerprob();
            }
            builder.show();
        }
    }
}