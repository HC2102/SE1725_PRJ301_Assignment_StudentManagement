<%-- 
    Document   : ListEnrolled
    Created on : 11-03-2023, 20:25:22
    Author     : Zarius
--%>

<%@page import="dbObject.CPS"%>
<%@page import="DAO.CPSDAO"%>
<%@page import="dbObject.Enrolled"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home_studentstyle.css">
        <title>List Enrolled</title>
    </head>
    <body>
        <%ArrayList<Enrolled> listEnrolled = (ArrayList<Enrolled>)request.getAttribute("listEnrolled");%>

        <h2>List Enrolled</h2>

        <span class="status">
            <%
                        String status = (String) request.getAttribute("status");
                        if (status != null && status.compareTo("") != 0)
                            out.println(status);
            %> 
        </span>

        <span class="error"><% String err = (String) request.getAttribute("error");
                if (err != null && err.compareTo("") != 0)
                    out.println(err); %>
        </span>

        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>Course_ID</th>
                        <th>Teacher Name</th>
                        <th>SemesterID</th>
                        <th>Class_ID</th>
                    </tr>
                </thead>
                <tbody>
                    <%      
                            CPSDAO cpsDAO = new CPSDAO();
                            for (Enrolled e : listEnrolled) {
                            CPS cps = cpsDAO.getCPSByID(e.getCPSID());
                    %>
                    <tr>
                        <td><%=cps.getCourse_ID()%></td>
                        <td><%=cps.getTeacher_User_name()%></td>
                        <td><%=cps.getSemesterID()%></td>
                        <td><%=e.getClassID()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <div style="display: flex; margin-left: 45%; margin-top: 2%">
            <a style="margin-right: 2%" href= "<%= request.getContextPath()%>/AdminInfo"> <input style="font-weight: bold; padding: 14%" type="Submit" type="button" value="Back"></a>
            <form action="addEnrolled" method="post"> 
                <input style=" padding: 5%; font-weight: bold;" type="submit" value="Add Enrolled" name="addEnrolled">
            </form>
        </div>
    </body>
</html>