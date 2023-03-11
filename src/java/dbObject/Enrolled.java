/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author Zarius
 */
public class Enrolled {
    private int CPSID;
    private String ClassID;

    public Enrolled() {
    }

    public Enrolled(int CPSID, String ClassID) {
        this.CPSID = CPSID;
        this.ClassID = ClassID;
    }

    public int getCPSID() {
        return CPSID;
    }

    public void setCPSID(int CPSID) {
        this.CPSID = CPSID;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }
    
}
