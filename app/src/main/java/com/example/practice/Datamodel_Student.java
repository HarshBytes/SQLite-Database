package com.example.practice;

public class Datamodel_Student {
    public Datamodel_Student(String name, String enrollment, String course, String birthdate, String email) {
        Name = name;
        Enrollment = enrollment;
        Course = course;
        Birthdate = birthdate;
        Email = email;
    }

    public Datamodel_Student() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(String enrollment) {
        Enrollment = enrollment;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    String Name;
    String Enrollment;
    String Course;
    String Birthdate;
    String Email;
}
