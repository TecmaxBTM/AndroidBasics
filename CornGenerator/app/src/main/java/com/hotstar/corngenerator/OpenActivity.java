package com.hotstar.corngenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class OpenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawer;
    Group fLevel, sLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fLevel = findViewById(R.id.firstLevel);
        sLevel = findViewById(R.id.secondLevel);
        findViewById(R.id.RepA).setOnClickListener(this);
        findViewById(R.id.RepB).setOnClickListener(this);
        findViewById(R.id.showA).setOnClickListener(this);
        findViewById(R.id.showB).setOnClickListener(this);
        findViewById(R.id.adda).setOnClickListener(this);
        findViewById(R.id.addB).setOnClickListener(this);
        findViewById(R.id.removeA).setOnClickListener(this);
        findViewById(R.id.removeB).setOnClickListener(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Happy", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.open, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager adsf = getSupportFragmentManager();
        if (id == R.id.nav_camera) {
            startActivity(new Intent(OpenActivity.this, HomeActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(OpenActivity.this, MainActivity.class));
        } else if (id == R.id.nav_slideshow) {
//
//            FragmentTransaction asd = adsf.beginTransaction();
//            asd.replace(R.id.hiresh, new LoginFragment(), "a");
//            asd.commit();
            fLevel.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_manage) {
            sLevel.setVisibility(View.VISIBLE);
//            FragmentTransaction asd = adsf.beginTransaction();
//            asd.replace(R.id.hiresh, new SignUpFragment(), "n");
//            asd.commit();
        } else if (id == R.id.nav_share) {
            fLevel.setVisibility(View.GONE);
        } else if (id == R.id.nav_send) {
            sLevel.setVisibility(View.GONE);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        FragmentManager adsf = getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.RepA:
                FragmentTransaction asda = adsf.beginTransaction();
                asda.replace(R.id.nandini, new SignUpFragment(), "n");
                asda.commit();
                break;
            case R.id.RepB:
                FragmentTransaction sd = adsf.beginTransaction();
                sd.add(R.id.nandini, new LoginFragment(), "a");
                sd.commit();
                break;
            case R.id.showA:
                Fragment dfsda = adsf.findFragmentByTag("a");
                if (dfsda != null) {
                    FragmentTransaction gfdg = adsf.beginTransaction();
                    gfdg.show(dfsda);
                    gfdg.commit();
                    break;
                } else {
                    Toast.makeText(this, "No Reference Found For B", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.showB:
                Fragment df = adsf.findFragmentByTag("a");
                if (df != null) {
                    FragmentTransaction nksds1 = adsf.beginTransaction();
                    nksds1.hide(df);
                    nksds1.commit();
                    break;
                } else {
                    Toast.makeText(this, "No Reference Found For B", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.adda:
                FragmentTransaction asd = adsf.beginTransaction();
                asd.add(R.id.nandini, new SignUpFragment(), "n");
                asd.commit();
                break;
            case R.id.addB:
                FragmentTransaction asd1 = adsf.beginTransaction();
                asd1.add(R.id.nandini, new LoginFragment(), "a");
                asd1.commit();
                break;
            case R.id.removeA:
                Fragment ads = adsf.findFragmentByTag("n");
                if (ads != null) {
                    FragmentTransaction nk = adsf.beginTransaction();
                    nk.remove(ads);
                    nk.commit();
                } else {
                    Toast.makeText(this, "No Reference Found For A", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.removeB:
                Fragment sajdsa = adsf.findFragmentByTag("a");
                if (sajdsa != null) {
                    FragmentTransaction nk1 = adsf.beginTransaction();
                    nk1.remove(sajdsa);
                    nk1.commit();
                    break;
                } else {
                    Toast.makeText(this, "No Reference Found For B", Toast.LENGTH_SHORT).show();
                }
        }

    }
}
