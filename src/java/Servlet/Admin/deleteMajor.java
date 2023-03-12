/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.MajorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HE170417
 */
public class deleteMajor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MajorDAO mdao =  new MajorDAO();
        String err=null;
        int row = 0;
        try {
            String deleteID = req.getParameter("delID");
            //delete
            row = mdao.deleteMajor(deleteID);
            if(row <1){
                throw new Exception("cannot delete because of user major is currently active");
            }
        } catch (Exception e) {
            err =  e.getMessage();
        }
        req.setAttribute("err", err);
        req.getRequestDispatcher("majorList").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
   
    
}
