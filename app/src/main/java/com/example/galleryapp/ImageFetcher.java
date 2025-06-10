package com.example.galleryapp;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ImageFetcher {

    private static final String TAG = "ImageFetcher";

    public static List<Uri> getImageUris(Context context) {
        List<Uri> imageUris = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();

        Uri queryUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Images.Media._ID};
        String sortOrder = MediaStore.Images.Media.DATE_ADDED + " DESC";

        Cursor cursor = null;
        try {
            cursor = contentResolver.query(queryUri, projection, null, null, sortOrder);
            if (cursor != null && cursor.moveToFirst()) {
                int idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
                do {
                    long id = cursor.getLong(idColumn);
                    Uri contentUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
                    imageUris.add(contentUri);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(TAG, "Error fetching images", e);
            // Handle exception
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return imageUris;
    }
}
