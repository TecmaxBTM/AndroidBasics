package com.hotstar.corngenerator.recyclerview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hotstar.corngenerator.R;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity implements StudentAdapter.StudentClickListener {

    RecyclerView asfl;
    RecyclerView.LayoutManager layoutManager;

    Student callNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        asfl = findViewById(R.id.rec);
        // INFO: FOR vertical orientation
//        layoutManager = new LinearLayoutManager(this);
        // INFO: FOR horizontal orientation
//        layoutManager = new LinearLayoutManager(this,
//                LinearLayoutManager.HORIZONTAL, true);
        // INFO: FOR Grid orientation
        layoutManager = new GridLayoutManager(this, 2);
        // INFO: FOR Staggred orientation
//        layoutManager = new StaggeredGridLayoutManager(3, 1);
        asfl.setLayoutManager(layoutManager);

        ArrayList<Student> ad = new ArrayList<>();
        ad.add(new Student("Nandini", "25", "213443", "https://www.samaa.tv/wp-content/uploads/2019/03/imran-khan-2.jpg", ""));
        ad.add(new Student("Imran", "26", "234532", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSx7pFSRTQnitf0Ls3WkMycBEyOhiWOHKj8YddW6VAVZBFOkDsx", ""));
        ad.add(new Student("Rashmi", "25", "4324", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQj705GWz4t-7eXOHO5O3WbLmyKrPg-0wHkIlRNvZJqt1gAp68tvQ", ""));
        ad.add(new Student("Latesh", "24", "*123" + Uri.encode("#"), "https://images.jdmagicbox.com/events/A318747/A318747_gal_20180321155718.jpg", ""));
        ad.add(new Student("Latesh", "24", "342", "https://www.gurusfeet.com/files/imagecache/guru_pic_main_imagescale/files/gurus_pics/4798_228840655098_767230098_7363359_7277482_n.jpg", ""));
        ad.add(new Student("Latesh", "24", "342", "", ""));
        ad.add(new Student("Latesh", "24", "342", "", ""));
        ad.add(new Student("Latesh", "24", "342", "", ""));
        ad.add(new Student("Latesh", "24", "342", "", ""));
        ad.add(new Student("Latesh", "24", "342", "", ""));
        ad.add(new Student("Supritha", "22", "5342", "", ""));
        ad.add(new Student("Pankaj", "21", "45324", "", ""));
        ad.add(new Student("Harsha", "27", "43524", "", ""));
        StudentAdapter adf = new StudentAdapter(ad, this);
        asfl.setAdapter(adf);

    }

    @Override
    public void onCallClick(Student object) {
        callNumber = object;
        if (askForPermission(Manifest.permission.CALL_PHONE, 1)) {
            Intent intent = new Intent(Intent.ACTION_CALL,
                    Uri.parse("tel:" + object.getMobile()));
            startActivity(intent);

        } else {
            displayPermission(Manifest.permission.CALL_PHONE, 1);
        }
    }

    private boolean askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission)
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
                this, permission)) {
            //This is called if user has denied the permission before
            //In this case I am just asking the permission again
            ActivityCompat.requestPermissions(this,
                    new String[]{permission}, requestCode);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{permission}, requestCode);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == 1) {
                onCallClick(callNumber);
            }
        } else {
            Toast.makeText(this, "Need Permission to Call", Toast.LENGTH_SHORT).show();
        }

    }
}
