/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.MajorDAO;
import dbObject.Major;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HE170417
 */
public class addMajor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.getRequestDispatcher("JSP/adAddMajor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            int row = 0;
            MajorDAO mdao = new MajorDAO();
            Major newMajor = new Major(req.getParameter("mID"), req.getParameter("mName"), req.getParameter("mBios"));
            row = mdao.insertMajor(newMajor);
            if(row<1){
                throw new Exception();
            }
            resp.sendRedirect("majorList");
        }catch(Exception e){
            req.setAttribute("error", "Error!");
            resp.sendRedirect("majorList");
        }
    }
   
   
}
