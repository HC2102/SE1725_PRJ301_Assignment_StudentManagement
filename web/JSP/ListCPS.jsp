<%-- 
    Document   : ListCPS
    Created on : 11-03-2023, 10:43:33
    Author     : Zarius
--%>

<%@page import="dbObject.CPS"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home_studentstyle.css">
        <title>List CPS</title>
    </head>
    <body>
        <%
            ArrayList<CPS> listCPS = (ArrayList<CPS>)request.getAttribute("listCPS");
        %>

        <h2>List Course Teach by Teacher</h2>

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
                        <th>CPS_ID</th>
                        <th>Course_ID</th>
                        <th>Semester_ID</th>
                        <th>Teacher_User_name</th>
                        <th>Biographic</th>
                        <th>Resource</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (CPS cps : listCPS) {
                        
                    %>
                    <tr>
                        <td><%=cps.getCps_id()%></td>
                        <td><%=cps.getCourse_ID()%></td>
                        <td><%=cps.getSemesterID()%></td>
                        <td><%=cps.getTeacher_User_name()%></td>
                        <td><%=cps.getBiographic()%></td>
                        <td><%=cps.getResource()%></td>
                        <td><a href="deleteCPS?id=<%=cps.getCps_id()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
                
                <div style="display: flex; margin-top: 3%; margin-left: 45%">
            <a href= "<%= request.getContextPath()%>/AdminInfo"> <input style="font-weight: bold; padding: 6%;" type="Submit" type="button" value="Back"></a>
            <form    action="InsertCPS" method="post"> 
                <input style=" padding: 4%; font-weight: bold; margin-left: 20%" type="submit" value="Add CPS" name="addCPS">
            </form>
        </div>
    </body>
</html>
