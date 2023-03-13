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
    <body>
        <%

            if (request.getAttribute("tlist") == null) {
                response.sendRedirect("Login.jsp");
            }
        %>
        <h2>Test List</h2>
        <a href= "<%= request.getContextPath()%>/ToCourses"> <input style="margin: 1%;margin-left:5%; font-weight: bold; padding: 0.5%" type="Submit" type="button" value="Back"></a>
        <div class="table-wrapper">
            <span class="status"><%
                String info = (String) session.getAttribute("status");
                if (info != null && info.compareTo("") != 0)
                    out.println(info);
                %> 
            </span>
            <span class="error"><% String err = (String) session.getAttribute("error");
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
                        <th>Action 1</th>
                        <th>Action 2</th>    
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
                        <td><a href="updateTest?id=<%=t.getTest_id()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update"></a></td> 
                        <td><a href="deleteTest?id=<%=t.getTest_id()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></td>
                    </tr>
                    <%}%>
                <tbody>

            </table>

        </div>
        <div style="display: flex; justify-content: center;">
            <a href="<%= request.getContextPath()%>/JSP/addTest.jsp?id=<%=request.getParameter("id")%>"><input style=" font-weight: bold; padding: 5%" type="Submit" value="Add test and its weight..."></a>
        </div>

    </body>
</html>
