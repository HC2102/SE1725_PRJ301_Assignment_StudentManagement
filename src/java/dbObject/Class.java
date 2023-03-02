/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author Zarius
 */
public class Class {
    private String Class_ID, Major_ID;

    public Class(String Class_ID, String Major_ID) {
        this.Class_ID = Class_ID;
        this.Major_ID = Major_ID;
    }

    public Class() {
    }

    public String getClass_ID() {
        return Class_ID;
    }

    public void setClass_ID(String Class_ID) {
        this.Class_ID = Class_ID;
    }

    public String getMajor_ID() {
        return Major_ID;
    }

    public void setMajor_ID(String Major_ID) {
        this.Major_ID = Major_ID;
    }

    @Override
    public String toString() {
        return "Class{" + "Class_ID=" + Class_ID + ", Major_ID=" + Major_ID + '}';
    }
    
    
}
