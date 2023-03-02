/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author Zarius
 */
public class Student_Class {
    private String Student_ID, Class_ID;

    public Student_Class() {
    }

    public Student_Class(String Student_ID, String Class_ID) {
        this.Student_ID = Student_ID;
        this.Class_ID = Class_ID;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String Student_ID) {
        this.Student_ID = Student_ID;
    }

    public String getClass_ID() {
        return Class_ID;
    }

    public void setClass_ID(String Class_ID) {
        this.Class_ID = Class_ID;
    }

    @Override
    public String toString() {
        return "Student_Class{" + "Student_ID=" + Student_ID + ", Class_ID=" + Class_ID + '}';
    }
    
    
}
