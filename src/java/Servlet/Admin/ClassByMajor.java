/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.ClassDAO;
import dbObject.Class;
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
public class ClassByMajor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String majorID = req.getParameter("chooseMajor");
        ClassDAO clDAO = new ClassDAO();
        ArrayList<Class> listClassByMajor = clDAO.getClassByMajor(majorID);
        if (req.getParameter("BackToEnrolled") != null) {
            req.setAttribute("status", null);
            req.setAttribute("error", null);
            req.getRequestDispatcher("adEnrolledList").forward(req, resp);
        } else {
            req.setAttribute("listClassByMajor", listClassByMajor);
            session.setAttribute("selectedMajor", majorID);
            req.getRequestDispatcher("JSP/adAddEnrolled.jsp").forward(req, resp);
        }
    }

}
