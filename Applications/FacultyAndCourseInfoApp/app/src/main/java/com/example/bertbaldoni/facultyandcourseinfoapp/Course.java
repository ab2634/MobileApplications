package com.example.bertbaldoni.facultyandcourseinfoapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by BertBaldoni on 3/28/17.
 */

public class Course implements Serializable {

    private String name, shortDesc, longDesc;
    public static String COURSE_ROOT_KEY = "courses";
    public static String COURSE_NAME_KEY = "name";
    public static String COURSE_SHORT_DESC_KEY = "shortDesc";
    public static String COURSE_LONG_DESC_KEY = "longDesc";
    public static String COURSE_INTENT_KEY = "course";

    public Course(String name, String shortDesc, String longDesc) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public Course(JSONObject jo) {
        try {
            name = jo.getString(COURSE_NAME_KEY);
            shortDesc = jo.getString(COURSE_SHORT_DESC_KEY);
            longDesc = jo.getString(COURSE_LONG_DESC_KEY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

}
