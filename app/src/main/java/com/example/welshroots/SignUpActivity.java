package com.example.welshroots;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonSignUp;
    private TextView textViewLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        // Link views
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewLogin = findViewById(R.id.textViewLogin);

        // Sign-Up Button Click
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    editTextEmail.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    editTextPassword.setError("Password is required");
                    return;
                }

                if (password.length() < 6) {
                    editTextPassword.setError("Password must be at least 6 characters");
                    return;
                }

                // Create User in Firebase
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpActivity.this, task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                                finish();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        // Navigate to Login Screen
        textViewLogin.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        });
    }
}
