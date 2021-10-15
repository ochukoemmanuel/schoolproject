package com.ebeatsz.schoolproject.model;

public class Question {

    String school;
    String session;
    String course_title;
    String class_;
    String courseCode;
    String courseUnit;
    String timeAllowed;
    String instruction;
    String questionNumber;
    String question;

    public Question(String school, String session, String course_title, String class_, String courseCode, String courseUnit, String timeAllowed, String instruction, String questionNumber, String question) {
        this.school = school;
        this.session = session;
        this.course_title = course_title;
        this.class_ = class_;
        this.courseCode = courseCode;
        this.courseUnit = courseUnit;
        this.timeAllowed = timeAllowed;
        this.instruction = instruction;
        this.questionNumber = questionNumber;
        this.question = question;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(String courseUnit) {
        this.courseUnit = courseUnit;
    }

    public String getTimeAllowed() {
        return timeAllowed;
    }

    public void setTimeAllowed(String timeAllowed) {
        this.timeAllowed = timeAllowed;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
