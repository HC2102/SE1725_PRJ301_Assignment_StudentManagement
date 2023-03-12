<%-- 
    Document   : Class
    Created on : Mar 11, 2023, 9:41:11 PM
    Author     : dange
--%>
<%@page import="dbObject.Class" %>
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
            if (request.getAttribute("classlist") == null) {
                response.sendRedirect("JSP/Login.jsp");
            }
        %>
        <h2>Class List</h2>
        <a href= "<%= request.getContextPath()%>/AdminInfo"> <input style="margin: 1%;margin-left:5%; font-weight: bold; padding: 0.5%" type="Submit" type="button" value="Back"></a>
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
                        <th>Class ID</th>
                        <th>Major ID</th>                     
                        <th>Action 1</th>
                        <th>Action 2</th>
                        <th>Add Student</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                ArrayList<Class> clist = (ArrayList<Class>) request.getAttribute("classlist");
                for (Class c : clist) {%>
                    <tr>
                        <td><%= c.getClass_ID()%></td>
                        <td><%= c.getMajor_ID()%></td>
                        <td><a href="UpdateClass?id=<%=c.getClass_ID()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update"></a></td> 
                        <td><a href="DeleteClass?id=<%=c.getClass_ID()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></td>
                        <td><a href="AddStudent?id=<%=c.getClass_ID()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Add Students"></a></td>
                    </tr>

                    <%}
                    %>

                <tbody>

            </table>

        </div>
        <div style="display: flex; justify-content: center;">
            <a href="<%= request.getContextPath()%>/JSP/addClass.jsp"><input style=" font-weight: bold; padding: 5%" type="Submit" value="Add more classes..."></a>
        </div>

    </body>
</html>
