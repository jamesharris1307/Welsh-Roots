package com.example.welshroots;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import androidx.fragment.app.Fragment;

import com.example.welshroots.fragments.AboutFragment;
import com.example.welshroots.fragments.ExploreFragment;
import com.example.welshroots.fragments.HomeFragment;
import com.example.welshroots.fragments.MapsFragment;
import com.example.welshroots.fragments.SettingsFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;




public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Apply theme from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        int currentMode = prefs.getInt("theme", AppCompatDelegate.MODE_NIGHT_NO);
        AppCompatDelegate.setDefaultNightMode(currentMode); // Apply the theme

        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home as Default Fragment
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.nav_explore) {
                selectedFragment = new ExploreFragment();
            } else if (item.getItemId() == R.id.nav_maps) {
                selectedFragment = new MapsFragment();
            } else if (item.getItemId() == R.id.nav_about) {
                selectedFragment = new AboutFragment();
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }
            return true;
        });

        // Set up the Settings/Accounts
        ImageButton accountIcon = findViewById(R.id.accountIcon);
        accountIcon.setOnClickListener(v -> {
            // Open Settings/Account
            loadFragment(new SettingsFragment());
        });
    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
    }
}