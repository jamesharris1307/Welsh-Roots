package com.example.welshroots;

// Imports
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import com.example.welshroots.main_fragments.AboutFragment;
import com.example.welshroots.main_fragments.ExploreFragment;
import com.example.welshroots.main_fragments.HomeFragment;
import com.example.welshroots.main_fragments.MapsFragment;
import com.example.welshroots.main_fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve Current Theme Preferences
        SharedPreferences prefs = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        int currentMode = prefs.getInt("theme", AppCompatDelegate.MODE_NIGHT_NO);
        AppCompatDelegate.setDefaultNightMode(currentMode); // Apply the theme

        // Set View
        setContentView(R.layout.activity_dashboard);
        // Bottom Navigation Widget
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Load Home By Default
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            // Load Selected Navigation Item
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

        // Settings Button
        ImageButton settingsIcon = findViewById(R.id.SettingsIcon);
        settingsIcon.setOnClickListener(v -> {
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