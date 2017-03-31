package com.example.bertbaldoni.icecreamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import static com.example.bertbaldoni.icecreamapp.R.string.action_about;

public class AboutActivity extends AppCompatActivity {


    TextView about01TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle(action_about);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        about01TextView = (TextView) findViewById(R.id.about01TextView);

        Intent aboutIntent = getIntent();
        String message = aboutIntent.getStringExtra("DataKey");
        about01TextView.setText(message);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);

    }

}
