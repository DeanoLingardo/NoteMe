package com.example.daisygarcia.noteme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NotepadActivity extends AppCompatActivity {

    public static final String EXTRA_NOTE_ID = "note_id";
    private static final String TAG = "NotepadActivity";


    public static Intent newIntent(Context packageContext, int noteId) {
        Intent intent = new Intent(packageContext, NotepadActivity.class);
        intent.putExtra(EXTRA_NOTE_ID, noteId);
        return intent;
    }

    /*
    To decouple the fragment and make it reusable, the TodoFragment has a newInstance method
    that receives a todoId and returns the fragment
     */
    protected Fragment createFragment(){
        int noteId = (int) getIntent().getSerializableExtra(EXTRA_NOTE_ID);
        return NotepadFragment.newInstance(noteId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started");
        setContentView(R.layout.activity_fragment);
        Log.d(TAG, "onCreate: view set");

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        Log.d(TAG, "onCreate: fragment container loaded");

        if (fragment == null){

            Fragment noteFragment = createFragment();


            fm.beginTransaction()
                    .add(R.id.fragment_container, noteFragment)
                    .commit();
        }
        Log.d(TAG, "onCreate: fragment added");


    }

}