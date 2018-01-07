package com.example.daisygarcia.noteme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Daisy Garcia on 03/01/2018.
 */

public class NotepadListActivity extends AppCompatActivity {

    private static final String TAG = "NotepadListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Log.d(TAG, "onCreate: started");

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            NotepadListFragment notepadListFragment = new NotepadListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, notepadListFragment)
                    .commit();
        }

    }
}
