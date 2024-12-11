package com.example.welshroots.main_fragments;

// Imports
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import java.util.Locale;
import com.example.welshroots.R;

public class SettingsFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch themeSwitch = view.findViewById(R.id.modeChoice);

        SharedPreferences prefs = requireActivity().getSharedPreferences("ThemePrefs", Context.MODE_PRIVATE);
        int currentMode = prefs.getInt("theme", AppCompatDelegate.MODE_NIGHT_NO);

        themeSwitch.setChecked(currentMode == AppCompatDelegate.MODE_NIGHT_YES);

        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                editor.putInt("theme", AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editor.putInt("theme", AppCompatDelegate.MODE_NIGHT_NO);
            }
            editor.apply();
        });

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch languageSwitch = view.findViewById(R.id.modeLanguage);
        SharedPreferences langPrefs = requireActivity().getSharedPreferences("LanguagePrefs", Context.MODE_PRIVATE);
        String currentLanguage = langPrefs.getString("language", "en");

        languageSwitch.setChecked(currentLanguage.equals("cy"));

        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String newLanguage = isChecked ? "cy" : "en";
            setLocale(newLanguage);

            SharedPreferences.Editor langEditor = langPrefs.edit();
            langEditor.putString("language", newLanguage);
            langEditor.apply();

            requireActivity().recreate();
        });
        return view;
    }

    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);

        Context context = requireActivity();
        android.content.res.Resources resources = context.getResources();
        android.content.res.Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}