/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.TeacherDAO;
import dbObject.CPS;
import dbObject.Student_Class_Mark;
import dbObject.Teacher;
import dbObject.Class;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ListStudentOfCpsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherDAO td = new TeacherDAO();
        String cid_raw = request.getParameter("subject");
        if(cid_raw==null){
            cid_raw=(String) request.getAttribute("cps_id");
        }
        String class_id = request.getParameter("class");
        if (class_id == null) {
            class_id = "null";
        }
        int cid;
        ArrayList<Student_Class_Mark> list = new ArrayList<>();
        ArrayList<Class> list_class = new ArrayList<>();
        Class classStudent = new Class("null", "null");
        list_class.add(classStudent);
        try {
            cid = Integer.parseInt(cid_raw);
            list = td.getStudent_Class_MarkByCid(cid);
            CPS cps = td.getCpsByCid(cid);           
            List<Double> list_marks = td.getListMarkOfStudentByCourseIdAndStudentId(list, cps.getCourse_ID());
            for (int i = 0; i < list_marks.size(); i++) {
                list.get(i).setMark(list_marks.get(i));
            }
            for (int i = 0; i < list.size(); i++) {
                for (int k = 0; k < list_class.size(); k++) {
                    if ((list.get(i).getCl().getClass_ID().equalsIgnoreCase(list_class.get(k).getClass_ID()))) {
                        break;
                    }
                    if (k == list_class.size() - 1) {
                        list_class.add(list.get(i).getCl());
                        break;
                    }
                }
            }
            request.setAttribute("cps", cps);
            request.setAttribute("classes", list_class);
            if (!(class_id.equalsIgnoreCase("null")) && !(class_id.equalsIgnoreCase("all"))) {
                List<Integer> remove = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (!(list.get(i).getCl().getClass_ID().equalsIgnoreCase(class_id))) {
                        remove.add(i);
                    }
                }
                int index_remove = 0;
                for (int i = 0; i < remove.size(); i++) {
                    list.remove(remove.get(i) - index_remove);
                    index_remove++;
                }

            }
            request.setAttribute("cl_id", class_id);
            request.setAttribute("list", list);
            request.getRequestDispatcher("JSP/table_information_student.jsp").forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    public static void main(String[] args) {
        TeacherDAO td = new TeacherDAO();
        ArrayList<Student_Class_Mark> list = new ArrayList<>();
        list = td.getStudent_Class_MarkByCid(1);
        System.out.println(list.get(1).getSt().getStudentID());
        ArrayList<Class> list_class = new ArrayList<>();
        Class classStudent = new Class("null", "null");
        list_class.add(classStudent);
        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list_class.size(); k++) {
                if ((list.get(i).getCl().getClass_ID().equalsIgnoreCase(list_class.get(k).getClass_ID()))) {
                    break;
                }
                if (k == list_class.size() - 1) {
                    list_class.add(list.get(i).getCl());
                    break;
                }
            }
        }
        System.out.println(list_class.toString());
        String class_id = "SE1725";
        if (!(class_id.equalsIgnoreCase("null")) && !(class_id.equalsIgnoreCase("all"))) {
            List<Integer> remove = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (!(list.get(i).getCl().getClass_ID().equalsIgnoreCase(class_id))) {
                    remove.add(i);
                }
            }
            int index_remove = 0;
            for (int i = 0; i < remove.size(); i++) {
                list.remove(remove.get(i) - index_remove);
                index_remove++;
            }

        }
        System.out.println(list.get(0).getCl().getClass_ID());
        System.out.println(list_class.get(1).getClass_ID());
        for (int i = 0; i < list_class.size(); i++) {
            if (list_class.get(i).getClass_ID() != "null") {
                if (class_id.equalsIgnoreCase(list_class.get(i).getClass_ID())) {
                    System.out.println(list_class.get(i).getClass_ID() + " selected");
                }
            }
        }
    }

}
