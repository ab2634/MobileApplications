package com.example.bertbaldoni.facultyandcourseinfoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BertBaldoni on 3/28/17.
 */

public class FacultyAdapter extends ArrayAdapter<Faculty> {

    public FacultyAdapter(Context context, ArrayList<Faculty> faculty) {
        super(context, 0, faculty);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Faculty f = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_faculty_list, parent, false);
        }
        TextView fullNameAndDegreeTextView = (TextView) convertView.findViewById(R.id.fullNameAndDegreeTextView);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
        ImageView facultyImageView = (ImageView) convertView.findViewById(R.id.facultyImageView);

        fullNameAndDegreeTextView.setText(f.getFirstName() + " " + f.getLastName() + ", " + f.getDegree());
        titleTextView.setText(f.getTitle());
        Context context = facultyImageView.getContext();
        int id = context.getResources().getIdentifier(f.getAssetName(), "drawable", context.getPackageName());
        facultyImageView.setImageResource(id);

        return convertView;
    }

}
