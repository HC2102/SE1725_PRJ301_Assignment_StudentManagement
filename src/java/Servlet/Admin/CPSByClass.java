/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.CPSDAO;
import dbObject.CPS;
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
public class CPSByClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CPSDAO cpsDAO = new CPSDAO();
        String selectedMajor = (String) session.getAttribute("selectedMajor");
        String selectedClass = req.getParameter("chooseClass");
        ArrayList<CPS> listCPSByClassIDAndMajor = cpsDAO.getCPSByClassIDAndMajor(selectedClass, selectedMajor);
        if (req.getParameter("BackToEnrolled") != null) {
            req.setAttribute("status", null);
            req.setAttribute("error", null);
            req.getRequestDispatcher("adEnrolledList").forward(req, resp);
        } else {
            session.setAttribute("selectedMajor", selectedMajor);
            session.setAttribute("selectedClass", selectedClass);
            req.setAttribute("listCPSByClassIDAndMajor", listCPSByClassIDAndMajor);
            req.getRequestDispatcher("JSP/adAddEnrolled.jsp").forward(req, resp);
        }
    }

}
