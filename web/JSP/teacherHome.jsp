<%-- 
    Document   : teacherHome
    Created on : 02-03-2023, 17:34:58
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbObject.Teacher" %>
<%@page import="dbObject.CPS" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/TeacherHome.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Teacher Homepage</title>
    </head>
    <body>
        <div class="ctr1">
            <a style="text-decoration: none; font-family:'Times New Roman'; margin-left:5%; margin-top:1%;" href="<%= request.getContextPath()%>/teacherInfo"><H1>Home</H1></a>
           <div class="headerbutton">
                <a href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Change Password"></a>
                <a href="<%= request.getContextPath()%>/logout"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Log out"></a>
            </div>
        </div>
        <div class="ctr4">

            <div class="ctr3">
                <img src="<%= request.getContextPath()%>\image\anh2.jpg" style="width:100%; height: 100%;" class="" alt="">
            </div>
            <%
                Teacher t=(Teacher)request.getAttribute("data");
            %>
            <div class="ctr2">
                <P>Name: <%= t.getTeacherName()%></P>
                <P>Major: <%= t.getMajorID()%></P>
                <P>Adress: <%= t.getAddress()%></P>
                <p>Email: <%= t.getEmail()%></p>
            </div>
        </div>
        <form style="padding-top: 5%; padding-left: 42%;" action="listStudentOfCps" method="get">
            <input style=" padding: 1%; font-weight: bold; margin-right: 1% ;" type="submit" value="Search">
            <select class="select" id="Sub" name="subject">
                <% 
                List<CPS> list=(List<CPS>)request.getAttribute("cps");
                for(int i=0; i<list.size();i++){%>
                <option value="<%= list.get(i).getCps_id()%>"><%= list.get(i).getCourse_ID()%></option>            
                <%}
                %>
            </select>

        </form>

    </body>
</html>
