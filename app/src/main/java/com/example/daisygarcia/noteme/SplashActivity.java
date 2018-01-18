package com.example.daisygarcia.noteme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Daisy Garcia on 17/01/2018.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        startActivity(new Intent(SplashActivity.this, NotepadListActivity.class));
        // close splash activity
        finish();
    }
}


