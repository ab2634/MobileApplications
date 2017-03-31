package com.example.bertbaldoni.facultyandcourseinfoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BertBaldoni on 3/28/17.
 */

public class CourseAdapter extends ArrayAdapter<Course> {

    public CourseAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Course c = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_course_list, parent, false);
        }
        TextView nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView shortDescTextView = (TextView) convertView.findViewById(R.id.shortDescTextView);

        nameTextView.setText(c.getName());
        shortDescTextView.setText(c.getShortDesc());

        return convertView;
    }

}
