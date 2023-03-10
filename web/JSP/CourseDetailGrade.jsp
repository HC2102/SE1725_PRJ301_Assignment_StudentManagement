<%-- Document : CourseDetailGrade Created on : 06-03-2023, 06:56:20 Author :
Zarius --%> <%@page import="dbObject.Student"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <%
        if (session.getAttribute("listDetailGrade") == null || session.getAttribute("averageScore") == null || session.getAttribute("userStudent") == null || session.getAttribute("listTestWeight") == null) {
            response.sendRedirect("Login.jsp");
        }
    %>
    <%
        HashMap<String, Double> listOfDetail = (HashMap<String, Double>) session.getAttribute("listDetailGrade");
        Double avg = (Double) session.getAttribute("averageScore");
        Student s = (Student) session.getAttribute("userStudent");
        HashMap<String, Double> listTestWeight = (HashMap<String, Double>) session.getAttribute("listTestWeight");
        String[] gradeList = listOfDetail.keySet().toArray(new String[listOfDetail.size()]);
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="<%= request.getContextPath()%>/css/table.css"
            rel="stylesheet"
            type="text/css"
            />
        <link
            rel="stylesheet"
            href="<%= request.getContextPath()%>/css/home_studentstyle.css"
            />
        <title>Detail score information</title>
    </head>
    <body>
        <!-- header -->
        <div class="ctr1">
            <a
                style="
                text-decoration: none;
                font-family: 'Times New Roman';
                margin-left: 5%;
                margin-top: 1%;
                "
                href="<%= request.getContextPath()%>/JSP/StudentHome.jsp"
                ><H1>Home</H1></a
            >
            <div class="headerbutton">
                <a href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"
                   ><input
                        style="margin-right: 1%; font-weight: bold"
                        type="Submit"
                        value="Change Password"
                        /></a>
                <a href="<%= request.getContextPath()%>/logout"
                   ><input
                        style="margin-right: 1%; font-weight: bold"
                        type="Submit"
                        value="Log out"
                        /></a>
            </div>
        </div>
        <!-- body -->
        <h2 style="color:white">Course detail</h2>
        <div style="width: 70%; margin: 0 auto">
            <div class="table-wrapper">
                <table class="fl-table">
                    <thead>
                        <tr>
                            <th>Category</th>
                            <th>Values</th>
                        </tr>
                    </thead>
                    <tr>
                        <th>Student name</th>
                        <td><%=s.getStudentName()%></td>
                    </tr>
                    <tr>
                        <th>Course</th>
                        <td><%=request.getParameter("Course_ID")%></td>
                    </tr>
                    <% for (String i : gradeList) {
                    %>
                    <tr>
                        <th><%=i%> (<%=listTestWeight.get(i)%>%)</th>
                        <td><%=listOfDetail.get(i)%></td>
                    </tr>
                    <%}%>
                    <tr>
                        <th>Over all</th>
                        <td style="font-weight: bold;"><%=avg%></td>
                    </tr>
                    <tr>
                        <th>Status</th>
                            <%if (avg > 5) { %>
                        <td><b style="background-color: green; color: white; padding: .3em; border-radius: .25em;">Passed</b></td>
                        <%} else {%>
                        <td><b style="background-color: red; color: white; padding: .3em; border-radius: .25em;">Not passed</b></td>
                        <%}%>
                    </tr>
                </table>
            </div>
        </div>
        <div style="text-align: center;">
            <button type="button" onclick="quay_lai_trang_truoc()">Back</button>
            <a href="<%= request.getContextPath()%>/studentInfo"><input type="button" value="Back to homepage"/></a>
        </div>

        <script>
            function quay_lai_trang_truoc() {
                history.back();
            }
        </script>
    </body>
</html>
