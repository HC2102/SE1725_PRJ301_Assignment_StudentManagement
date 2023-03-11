/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.CourseDAO;
import DAO.SemesterDAO;
import DAO.TeacherDAO;
import dbObject.Course;
import dbObject.Semester;
import dbObject.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class teacherByCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SemesterDAO semDAO = new SemesterDAO();
        String courseID = req.getParameter("chooseCourse");
        Semester currentSem = semDAO.getSemesterIDByCurrentSemester();
        TeacherDAO tDAO = new TeacherDAO();
        ArrayList<Teacher> listTeacherByCourseIDandMajor = tDAO.getTeacherByCourseIDAndMajorID(courseID);
        req.setAttribute("listTeacherByCourseIDandMajor", listTeacherByCourseIDandMajor);
        CourseDAO cDAO = new CourseDAO();
        ArrayList<Course> listCourse = cDAO.getAllCourse();
        session.setAttribute("selectedCourse", courseID);
        req.setAttribute("currentSem", currentSem.getSemester_ID());
        req.setAttribute("listCourse", listCourse);
        req.getRequestDispatcher("JSP/adAddCPS.jsp").forward(req, resp);
    }

}
