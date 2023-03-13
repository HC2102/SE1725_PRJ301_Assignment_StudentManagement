/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.ClassDAO;
import DAO.MajorDAO;
import dbObject.Class;
import dbObject.Major;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
            MajorDAO md = new MajorDAO();
            ArrayList<dbObject.Class> classlist = cd.getAllClass();
            ArrayList<Major> majorList = md.getAllMajors();
            String id = request.getParameter("id");
            Class cl = cd.getClass(id);
            if(cl == null){
                response.sendRedirect("ClassList");
            }else{
                request.setAttribute("newclass", cl);
                request.setAttribute("classlist", classlist);
                request.setAttribute("majorlist", majorList);
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
            ClassDAO cd = new ClassDAO();
            String id = request.getParameter("id");
            String newid = request.getParameter("cid");
            String mid = request.getParameter("mid");
            int row = 0;
            row=cd.updateClass(id,mid,newid);
            if (row < 1) {
                request.setAttribute("status",null);   
                request.setAttribute("error", "Update failed! Class ID already existed or class is currently in learning session!");
                request.getRequestDispatcher("ClassList").forward(request, response);
            } else {
                request.setAttribute("error", null);
                request.setAttribute("status", "Update success!");
                request.getRequestDispatcher("ClassList").forward(request, response);
            }          
        }catch(Exception e){
            request.getRequestDispatcher("JSP/UpdateClass.jsp").forward(request, response);
        }
    }
}
