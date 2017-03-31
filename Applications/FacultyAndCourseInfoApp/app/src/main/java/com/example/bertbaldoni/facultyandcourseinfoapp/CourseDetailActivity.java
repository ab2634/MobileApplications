package com.example.bertbaldoni.facultyandcourseinfoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class CourseDetailActivity extends AppCompatActivity {

    TextView nameTextView, shortDescTextView, longDescTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Course c = (Course) i.getSerializableExtra(Course.COURSE_INTENT_KEY);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        shortDescTextView = (TextView) findViewById(R.id.shortDescTextView);
        longDescTextView = (TextView) findViewById(R.id.longDescTextView);

        nameTextView.setText(c.getName());
        shortDescTextView.setText(c.getShortDesc());
        longDescTextView.setText(c.getLongDesc());
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
