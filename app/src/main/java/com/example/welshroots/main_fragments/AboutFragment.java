package com.example.welshroots.main_fragments;

// Imports
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.welshroots.R;

public class AboutFragment extends Fragment {

    // Declare Variables
    private static final String PREFS_NAME = "AppReviews";
    private static final String KEY_REVIEWS = "reviews";
    private TextView reviewDisplay;
    private EditText reviewInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        reviewInput = view.findViewById(R.id.reviewInput);
        Button submitReviewButton = view.findViewById(R.id.submitReviewButton);
        reviewDisplay = view.findViewById(R.id.reviewDisplay);

        // Load Reviews
        loadReviews();

        submitReviewButton.setOnClickListener(v -> {
            String reviewText = reviewInput.getText().toString().trim();

            if (TextUtils.isEmpty(reviewText)) {
                Toast.makeText(getContext(), "No Review Submitted", Toast.LENGTH_SHORT).show();
            } else {
                saveReview(reviewText);
                reviewInput.setText(""); // Clear input field
                Toast.makeText(getContext(), "Review Submitted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void loadReviews() {
        SharedPreferences prefs = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String allReviews = prefs.getString(KEY_REVIEWS, "No Reviews at the Moment");
        reviewDisplay.setText(allReviews);
    }

    private void saveReview(String reviewText) {
        SharedPreferences prefs = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Append the new review to existing reviews
        String currentReviews = prefs.getString(KEY_REVIEWS, "");
        String updatedReviews = currentReviews.isEmpty() ? reviewText : currentReviews + "\n\n" + reviewText;

        editor.putString(KEY_REVIEWS, updatedReviews);
        editor.apply();

        // Update the displayed reviews
        reviewDisplay.setText(updatedReviews);
    }
}
