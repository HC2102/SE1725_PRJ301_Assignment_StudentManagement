/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.EnrolledDAO;
import dbObject.Enrolled;
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
public class adEnrolledList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EnrolledDAO eDAO = new EnrolledDAO();
        String status = (String)req.getAttribute("status");
        String error = (String)req.getAttribute("error");
        ArrayList<Enrolled> listEnrolled = eDAO.getAllEnrolled();
        req.setAttribute("listEnrolled", listEnrolled);
        req.setAttribute("status", status);
        req.setAttribute("error", error);
        req.getRequestDispatcher("JSP/ListEnrolled.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);

    }

}
