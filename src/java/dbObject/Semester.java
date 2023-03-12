/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Semester {
    private String Semester_ID;
    private String Time_start,Time_end;
    private boolean current_Semester;

    public Semester() {
    }

    public Semester(String Semester_ID, String Time_start, String Time_end, boolean current_Semester) {
        this.Semester_ID = Semester_ID;
        this.Time_start = Time_start;
        this.Time_end = Time_end;
        this.current_Semester = current_Semester;
    }


    public String getSemester_ID() {
        return Semester_ID;
    }

    public void setSemester_ID(String Semester_ID) {
        this.Semester_ID = Semester_ID;
    }

    public String getTime_start() {
        return Time_start;
    }

    public void setTime_start(String Time_start) {
        this.Time_start = Time_start;
    }

    public String getTime_end() {
        return Time_end;
    }

    public void setTime_end(String Time_end) {
        this.Time_end = Time_end;
    }

    public boolean isCurrent_Semester() {
        return current_Semester;
    }

    public void setCurrent_Semester(boolean current_Semester) {
        this.current_Semester = current_Semester;
    }

    
    
}
