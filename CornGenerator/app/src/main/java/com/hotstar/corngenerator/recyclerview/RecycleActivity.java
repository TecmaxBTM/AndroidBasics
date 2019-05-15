package com.hotstar.corngenerator.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotstar.corngenerator.R;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {

    RecyclerView asfl;
    RecyclerView.LayoutManager layoutManager;

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
        ad.add(new Student("Nandini","25","2134r43","",""));
        ad.add(new Student("Imran","26","234532","",""));
        ad.add(new Student("Rashmi","25","4324","",""));
        ad.add(new Student("Latesh","24","342","",""));
        ad.add(new Student("Latesh","24","342","",""));
        ad.add(new Student("Latesh","24","342","",""));
        ad.add(new Student("Latesh","24","342","",""));
        ad.add(new Student("Latesh","24","342","",""));
        ad.add(new Student("Latesh","24","342","",""));
        ad.add(new Student("Latesh","24","342","",""));
        ad.add(new Student("Supritha","22","5342","",""));
        ad.add(new Student("Pankaj","21","45324","",""));
        ad.add(new Student("Harsha","27","43524","",""));
        StudentAdapter adf = new StudentAdapter(ad);
        asfl.setAdapter(adf);

    }
}
