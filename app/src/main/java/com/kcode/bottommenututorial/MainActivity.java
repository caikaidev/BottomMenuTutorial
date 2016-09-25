package com.kcode.bottommenututorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment();
    }

    private void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,MainFragment.newInstance())
                .commit();
    }

}
