package com.example.galleryapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
// import com.bumptech.glide.Glide; // Placeholder for Glide

// Assuming R will be generated and available.
// import com.example.galleryapp.R;

public class FullScreenImageActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_URI = "com.example.galleryapp.IMAGE_URI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        ImageView fullScreenImageView = findViewById(R.id.fullScreenImageView);

        String imageUriString = getIntent().getStringExtra(EXTRA_IMAGE_URI);

        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            // Basic image loading:
            fullScreenImageView.setImageURI(imageUri);
            // Recommended: Use Glide or Picasso for efficient image loading
            // Glide.with(this).load(imageUri).fitCenter().into(fullScreenImageView);
        } else {
            Toast.makeText(this, "Image URI not found.", Toast.LENGTH_LONG).show();
            // Optionally finish the activity if URI is essential
            finish();
        }

        // Optional: Add support for pinch-to-zoom or other gestures later
        // Optional: Set activity title or customize action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Full Screen Image"); // Example title
            // Or hide action bar for a more immersive experience
            // getSupportActionBar().hide();
        }
    }
}
