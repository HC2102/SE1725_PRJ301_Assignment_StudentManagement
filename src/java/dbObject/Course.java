/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author Zarius
 */
public class Course {
    private String Course_ID, Course_name, Major_ID, Biographic;

    public Course() {
    }

    public Course(String Course_ID, String Course_name, String Major_ID, String Biographic) {
        this.Course_ID = Course_ID;
        this.Course_name = Course_name;
        this.Major_ID = Major_ID;
        this.Biographic = Biographic;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String Course_ID) {
        this.Course_ID = Course_ID;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String Course_name) {
        this.Course_name = Course_name;
    }

    public String getMajor_ID() {
        return Major_ID;
    }

    public void setMajor_ID(String Major_ID) {
        this.Major_ID = Major_ID;
    }

    public String getBiographic() {
        return Biographic;
    }

    public void setBiographic(String Biographic) {
        this.Biographic = Biographic;
    }

    @Override
    public String toString() {
        return "Course{" + "Course_ID=" + Course_ID + ", Course_name=" + Course_name + ", Major_ID=" + Major_ID + ", Biographic=" + Biographic + '}';
    }
    
    
}
