<%-- 
    Document   : teacherHome
    Created on : 02-03-2023, 17:34:58
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbObject.Teacher" %>
<%@page import="dbObject.CPS" %>
<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/TeacherHome.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    <body>
        <div class="ctr1">
            <H1>Home</H1>
            <div class="headerbutton">
                <a style="margin-right: 5%" href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"><input style="font-weight: bold;" type="Submit" value="Change Password"></a>
                <a href="<%= request.getContextPath()%>/logout"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Log out"></a>
            </div>
        </div>
        <div class="ctr4">

            <div class="ctr3">
                <p></p>
            </div>
            <%
                Teacher t=(Teacher)session.getAttribute("data");
            %>
            <div class="ctr2">
                <P>Name: <%= t.getTeacherName()%></P>
                <P>Major: <%= t.getMajorID()%></P>
                <P>Adress: <%= t.getAddress()%></P>
                <p>Email: <%= t.getEmail()%></p>
            </div>
        </div>
        <div>
            <form style="padding-top: 5%; padding-left: 42%; color: red" action="<%=request.getContextPath()%>/sos">
                <input type="text" name="user_name" value="<%= t.getUserName()%>" hidden/>
                <c:set var="semester" value="${requestScope.semester}" /> 
                <select class="select" id="Sub" name="semester">    
                    <option value="CHOOSE SEMESTER" hidden>CHOOSE SEMESTER</option>  
                    <c:forEach items="${sessionScope.list_semester}" var="c">                            
                                <option ${(semester==c)? 'selected':''} value="${c}">${c}</option>
                    </c:forEach>
                </select>
                <input style="padding: 1%; font-weight: bold" type="submit" value="CHOOSE"/>
            </form>
            <% List<CPS> list=(List<CPS>)request.getAttribute("cps");
                if(list!=null){
            %>            
            <form style="padding-top: 1%; padding-left: 42%; padding-bottom: " action="listStudentOfCps" method="get">
                <select class="select" id="Sub" name="subject">               
                    <% 
                    
                    for(int i=0; i<list.size();i++){%>
                    <option value="<%= list.get(i).getCps_id()%>"><%= list.get(i).getCourse_ID()%></option>            
                    <%}
                    %>
                </select>
                <input style=" padding: 1%; font-weight: bold; margin-right: 1% ;" type="submit" value="Search">
            </form>
            <%}%>
        </div>
    </body>
</html>
