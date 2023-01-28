package com.example.androiddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DiaryEditorActivity extends AppCompatActivity {

    private AnnotationPreferences preferences;
    private EditText editAnnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        FloatingActionButton saveDiary = findViewById(R.id.addText);
        editAnnotation = findViewById(R.id.DiarySheet);

        preferences  = new AnnotationPreferences(getApplicationContext());

        saveDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String existNote = editAnnotation.getText().toString();

                if (existNote.equals("")) {
                    Snackbar.make(view, "Type a notation to save it.", Snackbar.LENGTH_LONG).show();
                } else {
                    preferences.saveNote(existNote);
                    Snackbar.make(view, "Successfully saved", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        //Recover note
        String diary = preferences.recoverNote();
        if(!diary.equals("")){
            editAnnotation.setText(diary);
        }
    }
}