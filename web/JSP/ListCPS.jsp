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
        <div class="ctr1">
            <a style="text-decoration: none; font-family:'Times New Roman'; margin-left:5%; margin-top:1%;" href="<%= request.getContextPath()%>/JSP/StudentHome.jsp"><H1>Home</H1></a>
            <div class="headerbutton">
                <a href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Change Password"></a>
                <a href="<%= request.getContextPath()%>/logout"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Log out"></a>
            </div>
        </div>

        <%
            ArrayList<CPS> listCPS = (ArrayList<CPS>)request.getAttribute("listCPS");
        %>

        <h2>List Course Teach by Teacher</h2>


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
                        <th>Update</th>
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
                        <td><a href="<%= request.getContextPath()%>/ModifyCPSServlet?id=<%=cps.getCps_id()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update" name="update"></a></td>
                        <td><a href="<%= request.getContextPath()%>/ModifyCPSServlet?id=<%=cps.getCps_id()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete" name="delete"></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <form style=" padding-left: 42%;"  action="" method="post"> 
            <input style=" padding: 1%; font-weight: bold;" type="submit" value="Add CPS" name="addCPS">
            <input style=" padding: 1%; font-weight: bold;" type="submit" value="Enroll a class" name="addEnroll">
        </form>
    </body>
</html>
