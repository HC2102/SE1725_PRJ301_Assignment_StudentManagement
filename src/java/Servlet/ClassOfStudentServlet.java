/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

import DAO.ClassDAO;
import DAO.CourseDAO;
import DAO.GradeDAO;
import DAO.StudentDAO;
import dbObject.Student;
import dbObject.Student_Class;
import dbObject.Class;
import dbObject.Course;
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
public class ClassOfStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("yourClass") != null) {
            this.classOfStudent(req, resp);
        } else if (req.getParameter("avgScore") != null) {
            this.studentAvgScore(req, resp);
        }
    }

    public void classOfStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            StudentDAO stDAO = new StudentDAO();
            Student_Class stcl = (Student_Class) session.getAttribute("studentClass");
            ClassDAO cDAO = new ClassDAO();
            //Class ID cua Student dang nhap vao
            String classID = stcl.getClass_ID();
            //List cac class co trong db ngoai tru classID cua Student
            ArrayList<Class> listClass = cDAO.getAllClassExceptClassID(classID);

            ArrayList<Student> listStudentFromClassID = stDAO.getAllStudentFromClassID(classID);
            req.setAttribute("listClass", listClass);
            req.setAttribute("classID", classID);
            req.setAttribute("listStudentFromClassID", listStudentFromClassID);
            req.getRequestDispatcher("JSP/ClassOfStudent.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void studentAvgScore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            CourseDAO crDAO = new CourseDAO();
            StudentDAO stDAO = new StudentDAO();
            Student stu = (Student) session.getAttribute("userStudent");
            ArrayList<Course> listCourseByStudentID = crDAO.getAllCourseFromStudentID(stu.getStudentID());
            req.setAttribute("listCourse", listCourseByStudentID);
            req.getRequestDispatcher("JSP/StudentAverageScore.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
