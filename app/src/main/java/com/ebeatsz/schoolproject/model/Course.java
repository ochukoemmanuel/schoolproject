package com.ebeatsz.schoolproject.model;

public class Course {

    String courseTitle;
    String category;

    public Course(String courseTitle, String category) {
        this.courseTitle = courseTitle;
        this.category = category;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseTitle='" + courseTitle + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
