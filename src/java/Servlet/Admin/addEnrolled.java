/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.MajorDAO;
import dbObject.Major;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class addEnrolled extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("addEnrolled") != null) {
            MajorDAO mDAO = new MajorDAO();
            ArrayList<Major> listMajor = mDAO.getAllMajors();
            req.setAttribute("listMajor", listMajor);
            req.getRequestDispatcher("JSP/adAddEnrolled.jsp").forward(req, resp);
        }
    }

}
