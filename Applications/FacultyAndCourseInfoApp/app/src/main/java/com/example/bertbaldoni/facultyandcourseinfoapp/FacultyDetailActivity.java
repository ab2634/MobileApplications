package com.example.bertbaldoni.facultyandcourseinfoapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FacultyDetailActivity extends AppCompatActivity {

    ImageView facultyImageView;
    TextView fullNameAndDegreeTextView, titleTextView, bioTextView;
    Faculty f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_detail);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        f = (Faculty) i.getSerializableExtra(Faculty.FACULTY_INTENT_KEY);

        setTitle(f.getFirstName() + " " + f.getLastName());
        facultyImageView = (ImageView) findViewById(R.id.facultyImageView);
        Context context = facultyImageView.getContext();
        int id = context.getResources().getIdentifier(f.getAssetName(), "drawable", context.getPackageName());
        facultyImageView.setImageResource(id);
        fullNameAndDegreeTextView = (TextView) findViewById(R.id.fullNameAndDegreeTextView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        bioTextView = (TextView) findViewById(R.id.bioTextView);

        fullNameAndDegreeTextView.setText(f.getFirstName() + " " + f.getLastName() + ", " + f.getDegree());
        titleTextView.setText(f.getTitle());
        bioTextView.setText(f.getBio());


    }

    public void goToWebPage(View view) {
        String url = "http://cec.nova.edu/~" + f.getAssetName();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
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
