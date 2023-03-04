/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author ADMIN
 */
public class CPS {
    /*
    [dbo].[CPS](
	[CPS_ID] [int] NOT NULL,
	[Course_ID] [nvarchar](10) NOT NULL,
	[Semester_ID] [nvarchar](15) NOT NULL,
	[Teacher_User_name] [nvarchar](30) NOT NULL,
	[Biographic] [ntext] NULL,
	[Resource] [ntext] NULL,
    */
    int cps_id;
    String Course_ID,Semester_ID,Teacher_User_name,Biographic,Resource;

    public CPS() {
    }

    public CPS(int cps_id, String Course_ID, String Semester_ID, String Teacher_User_name, String Biographic, String Resource) {
        this.cps_id = cps_id;
        this.Course_ID = Course_ID;
        this.Semester_ID = Semester_ID;
        this.Teacher_User_name = Teacher_User_name;
        this.Biographic = Biographic;
        this.Resource = Resource;
    }

    public int getCps_id() {
        return cps_id;
    }

    public void setCps_id(int cps_id) {
        this.cps_id = cps_id;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String Course_ID) {
        this.Course_ID = Course_ID;
    }

    public String getSemester_ID() {
        return Semester_ID;
    }

    public void setSemester_ID(String Semester_ID) {
        this.Semester_ID = Semester_ID;
    }

    public String getTeacher_User_name() {
        return Teacher_User_name;
    }

    public void setTeacher_User_name(String Teacher_User_name) {
        this.Teacher_User_name = Teacher_User_name;
    }

    public String getBiographic() {
        return Biographic;
    }

    public void setBiographic(String Biographic) {
        this.Biographic = Biographic;
    }

    public String getResource() {
        return Resource;
    }

    public void setResource(String Resource) {
        this.Resource = Resource;
    }
    
}
