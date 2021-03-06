package com.mythio.movii.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mythio.movii.R;
import com.mythio.movii.fragment.MoviesFragment;
import com.mythio.movii.fragment.ProfileFragment;
import com.mythio.movii.fragment.SeriesFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MoviesFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            menuItem -> {
                Fragment fragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.navigation_movies:
                        fragment = new MoviesFragment();
                        break;
                    case R.id.navigation_series:
                        fragment = new SeriesFragment();
                        break;
                    case R.id.navigation_profiles:
                        fragment = new ProfileFragment();
                        break;
                }

                assert fragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                return true;
            };
}
