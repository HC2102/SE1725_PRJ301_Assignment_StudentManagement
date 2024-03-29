<%-- 
    Document   : TestList
    Created on : Mar 13, 2023, 10:04:52 AM
    Author     : dange
--%>

<%@page import="DAO.TestDAO"%>
<%@page import="dbObject.Test" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <body>
        <%
            if (request.getAttribute("tlist") == null) {
                response.sendRedirect("Login.jsp");
            }
        %>
        <% String courseID = (String)request.getAttribute("courseID");%>
        <h2>Test List</h2>

        <div class="table-wrapper">
            <span class="status"><%
                String info = (String) request.getAttribute("status");
                if (info != null && info.compareTo("") != 0)
                    out.println(info);
                %> 
            </span>
            <span class="error"><% String err = (String) request.getAttribute("error");
                if (err != null && err.compareTo("") != 0)
                    out.println(err); %>
            </span>
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>Test ID</th>
                        <th>Course ID</th>
                        <th>Test Name</th>
                        <th>Weight</th>

                        <th>Action</th>    
                    </tr>
                </thead>
                <tbody> 
                    <%
                        ArrayList<Test> tlist = (ArrayList<Test>) request.getAttribute("tlist");
                        if (tlist == null || tlist.size() == 0) {
                            TestDAO tdao = new TestDAO();
                            tlist = tdao.getTestbyID(request.getParameter("id"));
                        }

                        for (Test t : tlist) {
                    %>
                    <tr>
                        <td><%= t.getTest_id()%></td>
                        <td><%= t.getCourse_id()%></td>
                        <td><%= t.getTest_name()%></td>
                        <td><%= t.getWeight()%></td>

                        <td><a href="deleteTest?id=<%=t.getTest_id()%>&crsID=<%= t.getCourse_id()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></td>
                    </tr>
                    <%}%>
                <tbody>

            </table>

        </div>
        <div style="display: flex; margin-left: 42%; margin-top: 2%">
            <a style="margin-right: 3%" href= "<%= request.getContextPath()%>/ToCourses"> <input class="id" style=" font-weight: bold; padding: 22%;" type="Submit" type="button" value="Back"></a>
            <div style="display: flex; justify-content: center;">
                <a href="<%= request.getContextPath()%>/JSP/addTest.jsp?id=<%=courseID%>"><input class="id" style=" font-weight: bold; padding: 5%" type="Submit" value="Add test and its weight"></a>
            </div>
        </div>  
    </body>
</html>
