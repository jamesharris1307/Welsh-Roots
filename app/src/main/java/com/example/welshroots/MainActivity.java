package com.example.welshroots;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(v -> {
            // Navigate to LoginActivity
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        Button buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(v -> {
            // Navigate to SignUpActivity
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        TextView continueGuest = findViewById(R.id.continueGuest);

        continueGuest.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        });
    }
}


