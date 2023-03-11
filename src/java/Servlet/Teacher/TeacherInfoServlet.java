/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


package Servlet.Teacher;

import DAO.TeacherDao;
import dbObject.CPS;
import dbObject.Teacher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TeacherInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user_name = (String) session.getAttribute("userName");
        TeacherDao td = new TeacherDao();
        Teacher t = td.getByUserName(user_name);
        List<CPS> list = td.getCpsByUserName(user_name);
        List<String> list_semester = td.getListSemesterByUsername(user_name);
        session.setAttribute("data", t);
        session.setAttribute("list_semester", list_semester);
        response.sendRedirect("JSP/teacherHome.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
