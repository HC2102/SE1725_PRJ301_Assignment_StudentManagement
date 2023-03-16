<%-- 
    Document   : table_information_student
    Created on : 02-03-2023, 23:38:29
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbObject.Student_Class_Mark"%>
<%@page import="dbObject.Class"%>
<%@page import="dbObject.Student"%>
<%@page import="java.util.List" %>
<%@page import="dbObject.CPS"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <html>
        <head>
            <title>Đăng nhập vào website</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
            <script type="text/javascript">
                function change() {
                    document.getElementById("f1").submit();
                }
            </script>
        </head>
        <body>

            <h2>Student Information</h2>
            <div class="table-wrapper">
                <% ArrayList<Student_Class_Mark> list=(ArrayList<Student_Class_Mark>)request.getAttribute("list");
                    CPS cps=(CPS)request.getAttribute("cps");
                %> 
                <c:set var="cl_id" value="${requestScope.cl_id}" />               
                <form id="f1" action="listStudentOfCps">
                    <input type="text" name="subject" value="<%= cps.getCps_id()%>" hidden/>
                    <select class="select" name="class" onchange="change()">
                        <option value="all">ALL</option>
                        <c:forEach items="${requestScope.classes}" var="c">
                            <c:if test="${(c.getClass_ID()!='null')}">
                                <option ${(cl_id==c.getClass_ID())? 'selected':''} value="${c.getClass_ID()}">${c.getClass_ID()}</option>
                            </c:if>

                        </c:forEach>
                    </select>
                </form>
                <table class="fl-table">
                    <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>User name</th>
                            <th>Student name</th>
                            <th>Major ID</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Class ID</th>
                            <th>Average of Subject</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%       
            for(Student_Class_Mark i : list){%>
                        <tr>
                            <td><%= i.getSt().getStudentID()%></td>
                            <td><%= i.getSt().getUserName()%></td>
                            <td><%= i.getSt().getStudentName()%></td>
                            <td><%= i.getSt().getMajorID()%></td>
                            <td><%= i.getSt().getPhoneNum()%></td>
                            <td><%= i.getSt().getAddress()%></td>
                            <td><%= i.getSt().getEmail()%></td>
                            <td><%= i.getCl().getClass_ID()%></td>
                            <td><a href="update?st_id=<%= i.getSt().getStudentID()%>&course_id=<%=cps.getCourse_ID()%>&cps_id=<%= cps.getCps_id()%>"><%= i.getMark()%></a></td>
                        </tr>

                        <%}
                        %>
                    <tbody>
                </table>
            </div>            

            <script>
                function quay_lai_trang_truoc() {
                    history.back();
                }
            </script>
            <a style="margin-left: 45%" href="<%= request.getContextPath()%>\teacherInfo"><input class="id" type="button" value="Back to homepage"></a>
        </body>
    </html>
