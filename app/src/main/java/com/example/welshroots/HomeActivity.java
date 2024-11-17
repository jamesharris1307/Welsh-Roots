package com.example.welshroots;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.welshroots.fragments.HomeFragment;
import com.example.welshroots.fragments.ExploreFragment;
import com.example.welshroots.fragments.MapsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.welshroots.R;

public class HomeActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set the default fragment
        loadFragment(new HomeFragment());

        // Handle navigation item clicks
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_explore:
                    selectedFragment = new ExploreFragment();
                    break;
                case R.id.nav_maps:
                    selectedFragment = new MapsFragment();
                    break;
            }

            // Load the selected fragment
            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        // Replace the current fragment in the single container
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}


