package com.example.bertbaldoni.facultyandcourseinfoapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by BertBaldoni on 3/28/17.
 */

public class Faculty implements Serializable{

    private String category, userName, middleName, degree, firstName, lastName, title, bio;
    public static String FACULTY_ROOT_KEY = "faculty";
    public static String FACULTY_CATEGORY_KEY = "category";
    public static String FACULTY_USERNAME_KEY = "userName";
    public static String FACULTY_MIDDLE_NAME_KEY = "middleName";
    public static String FACULTY_DEGREE_KEY = "degree";
    public static String FACULTY_FIRST_NAME_KEY = "firstName";
    public static String FACULTY_LAST_NAME_KEY = "lastName";
    public static String FACULTY_TITLE_KEY = "title";
    public static String FACULTY_BIO_KEY = "bio";
    public static String FACULTY_INTENT_KEY = "faculty";

    public Faculty(String category, String userName, String middleName, String degree, String firstName, String lastName, String title, String bio) {
        this.category = category;
        this.userName = userName;
        this.middleName = middleName;
        this.degree = degree;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.bio = bio;
    }

    public Faculty(JSONObject jo) {
        try {
            category = jo.getString(FACULTY_CATEGORY_KEY);
            userName = jo.getString(FACULTY_USERNAME_KEY);
            middleName = jo.getString(FACULTY_MIDDLE_NAME_KEY);
            degree = jo.getString(FACULTY_DEGREE_KEY);
            firstName = jo.getString(FACULTY_FIRST_NAME_KEY);
            lastName = jo.getString(FACULTY_LAST_NAME_KEY);
            title = jo.getString(FACULTY_TITLE_KEY);
            bio = jo.getString(FACULTY_BIO_KEY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "category='" + category + '\'' +
                ", userName='" + userName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", degree='" + degree + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAssetName() {
        return (userName.toLowerCase());
    }
}
