package com.example.vinzee.andriodfragmentexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d("MainActivity", "selected: " + item.getItemId());
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    PushFragment(new Fragment1());
                    return true;
                case R.id.navigation_dashboard:
                    PushFragment(new Fragment2());
                    return true;
                case R.id.navigation_notifications:
                    PushFragment(new Fragment3());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void PushFragment(Fragment fragment){
        if (fragment == null){
            Log.d("PushFragment", "fragment is null");
            return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager == null){
            Log.d("PushFragment", "fragmentManager is null");
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.root_layout, fragment);
        fragmentTransaction.commit();
    }
//
//    private void PushFragment(Fragment2 fragment){
//        if (fragment == null) return;
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        if (fragmentManager == null) return;
//
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.root_layout, fragment);
//    }
//
//    private void PushFragment(Fragment3 fragment){
//        if (fragment == null) return;
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        if (fragmentManager == null) return;
//
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.root_layout, fragment);
//    }
}
