/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.MajorDAO;
import dbObject.Major;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HE170417
 */
public class updateMajor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MajorDAO mdao = new MajorDAO();
        Major upMajor = mdao.getMajor(req.getParameter("upID"));
        req.setAttribute("updateMajor", upMajor);
        req.getRequestDispatcher("JSP/adUpdateMajor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MajorDAO mdao = new MajorDAO();
        int row = 0;
        try {
            String mID = req.getParameter("mID");
            String mName = req.getParameter("mName");
            String mBio = req.getParameter("mBios");
            Major upMajor = new Major(mID, mName, mBio);
            row = mdao.updateMajor(upMajor);
            if(row <1){
                throw new Exception();
            }
            resp.sendRedirect("majorList");
        } catch (Exception e) {
            req.getRequestDispatcher("majorList").forward(req, resp);
        }

    }

}
