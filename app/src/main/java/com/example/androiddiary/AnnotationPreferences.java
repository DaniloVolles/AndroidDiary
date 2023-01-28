package com.example.androiddiary;

import android.content.Context;
import android.content.SharedPreferences;

public class AnnotationPreferences {

    private Context context;
    private SharedPreferences preferences;
    private final String ARCHIVE_NAME = "annotations.preferences";
    private SharedPreferences.Editor editor;
    private final String NAME_KEY = "name";


    public AnnotationPreferences(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(ARCHIVE_NAME, 0);
        editor = preferences.edit();
    }

    public void saveNote (String note) {
        editor.putString(NAME_KEY, note);
        editor.commit();
    }

    public String recoverNote () {

        return preferences.getString(NAME_KEY, "");
    }
}
