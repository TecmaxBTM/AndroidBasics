package com.hotstar.corngenerator.coordinator;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.hotstar.corngenerator.R;
import com.hotstar.corngenerator.realm.DbExampleActivity;
import com.hotstar.corngenerator.recyclerview.RecycleActivity;

public class ExpandingActivity extends AppCompatActivity {
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanding);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t1 = findViewById(R.id.t1);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.performClick();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                callNumber(v);
                startActivity(new Intent(ExpandingActivity.this, RecycleActivity.class));
            }
        });

        findViewById(R.id.t2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                t1.startAnimation(animation1);
            }
        });

        findViewById(R.id.t3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingActivity.this, DbExampleActivity.class));
            }
        });
    }

    public void showWebPage(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.tecmax.in"));

        startActivity(intent);
    }


    public void dailNumber(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:8310701931"));

        startActivity(intent);
    }

    public void callNumber(View view) {
        if (askForPermission(Manifest.permission.CALL_PHONE, 1)) {
            Intent intent = new Intent(Intent.ACTION_CALL,
                    Uri.parse("tel:8310701931"));
            startActivity(intent);
        } else {
            displayPermission(Manifest.permission.CALL_PHONE, 1);
        }
    }


    private boolean askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(ExpandingActivity.this, permission)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    void displayPermission(String permission, Integer requestCode) {
        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                ExpandingActivity.this, permission)) {
            //This is called if user has denied the permission before
            //In this case I am just asking the permission again
            ActivityCompat.requestPermissions(ExpandingActivity.this,
                    new String[]{permission}, requestCode);
        } else {
            ActivityCompat.requestPermissions(ExpandingActivity.this,
                    new String[]{permission}, requestCode);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == 1) {
                callNumber(t1);
            }
        } else {
            Toast.makeText(this, "Need Permission to Call", Toast.LENGTH_SHORT).show();
        }

    }
}
