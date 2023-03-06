/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author Zarius
 */
public class Grade {
    private String Test_ID, Course_ID, Student_ID;
    private Double Value;

    public Grade() {
    }

    public Grade(String Test_ID, String Course_ID, String Student_ID, Double Value) {
        this.Test_ID = Test_ID;
        this.Course_ID = Course_ID;
        this.Student_ID = Student_ID;
        this.Value = Value;
    }

    public String getTest_ID() {
        return Test_ID;
    }

    public void setTest_ID(String Test_ID) {
        this.Test_ID = Test_ID;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String Course_ID) {
        this.Course_ID = Course_ID;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String Student_ID) {
        this.Student_ID = Student_ID;
    }

    public Double getValue() {
        return Value;
    }

    public void setValue(Double Value) {
        this.Value = Value;
    }

    @Override
    public String toString() {
        return "Grade{" + "Test_ID=" + Test_ID + ", Course_ID=" + Course_ID + ", Student_ID=" + Student_ID + ", Value=" + Value + '}';
    }
    
    
}
