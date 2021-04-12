package com.learningjavaandroid.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    // private Button makeItRain;
    // private Button showInfo;
    private TextView moneyValue;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // makeItRain = findViewById(R.id.buttonMakeItRain);
        moneyValue = findViewById(R.id.moneyValue);

        // makeItRain.setOnClickListener(v -> Log.d("MainActivity", "onClick: Make it rain!!"));
    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
//        if(moneyCounter >= 20000) {
//            Snackbar.make(moneyValue, R.string.getting_rich, Snackbar.LENGTH_LONG)
//                    .show();
//
//            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,
//                    R.color.orange));
//        }
        switch (moneyCounter) {
            case 3000:
                Snackbar.make(moneyValue, R.string.getting_rich, Snackbar.LENGTH_LONG)
                        .show();

                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,
                        R.color.orange));
                break;
            case 5000:
                moneyValue.setTextColor(Color.MAGENTA);
                break;
            case 6000:
                moneyValue.setTextColor(Color.RED);
                break;
            default:
                moneyValue.setTextColor(Color.BLACK);
        }
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        Log.d("MIR", "onClick: Make it rain!!" + moneyCounter);
    }

    public void showInfo(View view) {
        // Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT)
        //        .show();

        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", v -> {
                    Log.d("Snack", "showInfo: Snackbar More");
                })
                .show();
    }
}