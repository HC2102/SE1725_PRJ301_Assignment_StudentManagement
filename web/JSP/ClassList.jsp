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
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
        <h2>Class List</h2>

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
                        <th>Class ID</th>
                        <th>Major ID</th>                     
                        <th>Action 1</th>
                        <th>Action 2</th>
                        <th>Detail</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                ArrayList<Class> clist = (ArrayList<Class>) request.getAttribute("classlist");
                for (Class c : clist) {%>
                    <tr>
                        <td><%= c.getClass_ID()%></td>
                        <td><%= c.getMajor_ID()%></td>
                        <td><a href="UpdateClass?id=<%=c.getClass_ID()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update"></a></td> 
                        <td><a href="DeleteClass?id=<%=c.getClass_ID()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></td>
                        <td><a href="ClassDetail?id=<%=c.getClass_ID()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Class Detail"></a></td>
                    </tr>

                    <%}
                    %>

                <tbody>

            </table>

        </div>

        <div style="display: flex; margin-left: 45%; margin-top: 3%">
            <a style="margin-right: 3%" href= "<%= request.getContextPath()%>/AdminInfo"> <input class="id" style=" font-weight: bold; padding: 16%" type="Submit" type="button" value="Back"></a>
            <div style="display: flex; justify-content: center;">
                <a href="<%= request.getContextPath()%>/JSP/addClass.jsp"><input class="id" style=" font-weight: bold; padding: 5%" type="Submit" value="Add more classes"></a>
            </div>
        </div>
    </body>
</html>
