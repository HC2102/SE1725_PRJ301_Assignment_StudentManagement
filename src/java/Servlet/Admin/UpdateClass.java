/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.ClassDAO;
import dbObject.Class;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author dange
 */
public class UpdateClass extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int row = 0;
            ClassDAO cd = new ClassDAO();
            ArrayList<dbObject.Class> classlist = cd.getAllClass();
            String id = request.getParameter("id");
            System.out.println(""+id);
            Class cl = cd.getClass(id);
            
            if(cl == null){
                response.sendRedirect("ClassList");
                return;
            }else{
                request.setAttribute("newclass", cl);
                request.setAttribute("classlist", classlist);
                request.getRequestDispatcher("JSP/UpdateClass.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.sendRedirect("ClassList");
        }
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            ClassDAO cd = new ClassDAO();
            String id = request.getParameter("id");
            String newid = request.getParameter("cid");
            String mid = request.getParameter("mid");
            int row = 0;
            row=cd.updateClass(id,mid,newid);
            if (row < 1) {
                session.setAttribute("status",null);   
                request.setAttribute("info", null);
                session.setAttribute("error", "Update failed! Class ID already existed or class is currently in learning session!");
                response.sendRedirect("ClassList");
                return;
                
            } else {
                session.setAttribute("error", null);
                request.setAttribute("info", null);
                session.setAttribute("status", "Update success!");
                response.sendRedirect("ClassList"); 
            }          
        }catch(Exception e){
            request.setAttribute("error", "Error!");
            request.getRequestDispatcher("JSP/UpdateClass.jsp").forward(request, response);
            return;
        }
    }
}
