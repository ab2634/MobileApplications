package com.example.bertbaldoni.facultyandcourseinfoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CourseListActivity extends AppCompatActivity {

    ListView courseListView;
    ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        courseListView = (ListView) findViewById(R.id.courseListView);

        setTitle("Courses");
        processJSON();
        Log.d("DEBUG", courses.toString());

        CourseAdapter adapter = new CourseAdapter(this, courses);
        courseListView.setAdapter(adapter);

        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course c = (Course) parent.getItemAtPosition(position);

                Intent i = new Intent(CourseListActivity.this, CourseDetailActivity.class);
                i.putExtra(Course.COURSE_INTENT_KEY, c);
                startActivity(i);
            }
        });

    }

    void processJSON() {
        String s = loadJSONFromAssert();
        Log.d("DEBUG", s);

        courses = new ArrayList<Course>();

        try {
            JSONObject obj = new JSONObject(s);
            JSONArray jsonArray = obj.getJSONArray(Course.COURSE_ROOT_KEY);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject courseObject = jsonArray.getJSONObject(i);
                Course c = new Course(courseObject);
                courses.add(c);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    String loadJSONFromAssert() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.courses_data);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
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
