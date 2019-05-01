package com.hotstar.corngenerator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class WhatsappActivity extends AppCompatActivity implements SignUpListener {
    static ViewPager asdas;
    static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fm = getSupportFragmentManager();

        String className = LoginFragment.class.getSimpleName();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        asdas = findViewById(R.id.vp);
        TabLayout ds = findViewById(R.id.tabL);
        ds.setupWithViewPager(asdas);
        VpAdapter asd = new VpAdapter(getSupportFragmentManager());
        asd.addFr(new LoginFragment(), "Login");
        asd.addFr(new SignUpFragment().getInstance("Mahesh", "Harsha"), "Signup");
        asdas.setAdapter(asd);
    }

    @Override
    public void onSignUpClicked(int pos) {
        asdas.setCurrentItem(pos);
    }


    class VpAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fgList;
        ArrayList<String> titleLi;

        public VpAdapter(FragmentManager fm) {
            super(fm);
            fgList = new ArrayList<>();
            titleLi = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int i) {
            return fgList.get(i);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleLi.get(position);
        }

        @Override
        public int getCount() {
            return fgList.size();
        }


        public void addFr(Fragment af, String title) {
            fgList.add(af);
            titleLi.add(title);
        }
    }

    public static void replaceFrag(Fragment fg) {
        FragmentTransaction sd = fm.beginTransaction();
        sd.replace(R.id.containerLV, fg, fg.getClass().getSimpleName());
        sd.commit();
    }

}
