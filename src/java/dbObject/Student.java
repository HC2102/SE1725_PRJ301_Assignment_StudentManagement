/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author HE170417
 */
public class Student {
    private String studentID, userName, StudentName, MajorID, phoneNum, address, email;

    public Student() {
    }

    public Student(String studentID, String userName, String StudentName, String MajorID, String phoneNum, String address, String email) {
        this.studentID = studentID;
        this.userName = userName;
        this.StudentName = StudentName;
        this.MajorID = MajorID;
        this.phoneNum = phoneNum;
        this.address = address;
        this.email = email;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getMajorID() {
        return MajorID;
    }

    public void setMajorID(String MajorID) {
        this.MajorID = MajorID;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", userName=" + userName + ", StudentName=" + StudentName + ", MajorID=" + MajorID + ", phoneNum=" + phoneNum + ", address=" + address + ", email=" + email + '}';
    }
    
    
}
