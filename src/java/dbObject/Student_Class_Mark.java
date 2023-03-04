/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author HE170417
 */
public class Student_Class_Mark {

    Student st;
    Class cl;
    double mark;

    public Student_Class_Mark() {
    }

    public Student_Class_Mark(Student st, Class cl, double mark) {
        this.st = st;
        this.cl = cl;
        this.mark = mark;
    }

    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public Class getCl() {
        return cl;
    }

    public void setCl(Class cl) {
        this.cl = cl;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    
}