package com.hotstar.corngenerator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.hotstar.corngenerator.coordinator.ExpandingActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher);

        SharedPreferences pref = this.getSharedPreferences("MyPref", MODE_PRIVATE);

        if (pref.getBoolean("key_first_time", false)) {
            finish();
            startActivity(new Intent(LauncherActivity.this, ExpandingActivity.class));
        } else {
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_first_time", true);
            editor.apply();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    startActivity(new Intent(LauncherActivity.this, ExpandingActivity.class));
                }
            }, 1000);
        }
    }
}
