package com.example.a10119232latihan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/*M Faisal Obara
10119232
IF 6
06 Mei 2022*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,WalkthroughActivity.class);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(intent);
            finish();
        }, 2500);
    }
}