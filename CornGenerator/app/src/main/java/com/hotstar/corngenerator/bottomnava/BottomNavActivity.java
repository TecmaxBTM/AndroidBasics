package com.hotstar.corngenerator.bottomnava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.hotstar.corngenerator.LoginFragment;
import com.hotstar.corngenerator.R;
import com.hotstar.corngenerator.SignUpFragment;
import com.hotstar.corngenerator.SignUpListener;

public class BottomNavActivity extends AppCompatActivity implements SignUpListener {

    private TextView mTextMessage;
    static FragmentManager fm;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    replaceFrag(new LoginFragment());
                    return true;
                case R.id.navigation_dashboard:
                    replaceFrag(new SignUpFragment());
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    replaceFrag(new LoginFragment());
//                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        fm = getSupportFragmentManager();
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setVisibility(View.GONE);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    public static void replaceFrag(Fragment fg) {
        FragmentTransaction sd = fm.beginTransaction();
        sd.replace(R.id.cont, fg, fg.getClass().getSimpleName());
        sd.commit();
    }

    @Override
    public void onSignUpClicked(int pos) {

    }
}
