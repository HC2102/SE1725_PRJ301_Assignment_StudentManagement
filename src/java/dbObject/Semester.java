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
//    [Semester](
//	[Semester_ID] [nvarchar](15) NOT NULL,
//	[Time_start] [date] NOT NULL,
//	[Time_end] [date] NOT NULL,
//	[current_Semester] [bit] NOT NULL,
    String Semester_ID;
    Date Time_start,Time_end;
    int current_Semester;

    public Semester() {
    }

    public Semester(String Semester_ID, Date Time_start, Date Time_end, int current_Semester) {
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

    public Date getTime_start() {
        return Time_start;
    }

    public void setTime_start(Date Time_start) {
        this.Time_start = Time_start;
    }

    public Date getTime_end() {
        return Time_end;
    }

    public void setTime_end(Date Time_end) {
        this.Time_end = Time_end;
    }

    public int getCurrent_Semester() {
        return current_Semester;
    }

    public void setCurrent_Semester(int current_Semester) {
        this.current_Semester = current_Semester;
    }
    
}
