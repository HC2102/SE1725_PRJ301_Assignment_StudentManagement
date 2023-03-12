<%-- 
    Document   : adAddCPS
    Created on : 11-03-2023, 15:09:32
    Author     : Zarius
--%>

<%@page import="dbObject.Teacher"%>
<%@page import="DAO.TeacherDAO"%>
<%@page import="dbObject.Course"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add CPS</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/adAddUser.css">
    </head>

    <body>

        <script>
            function submitForm() {
                var selectValue = document.getElementById("chooseCourse").value;
                var form = document.getElementById("myForm");
                form.action = "teacherByCourse";
                form.submit();
            }

            function hideButton() {
                var button = document.querySelector('button');
                button.style.display = 'none';
            }

        </script>
        <h2>Add New CPS</h2>
        <div class="container">

            <div class="imgdiv">

                <img src="<%= request.getContextPath()%>/image/course.png" alt="">
            </div>


            <form id="myForm" action="<%= request.getContextPath()%>/addCPSToList" method="post">
                <!-- Current Semester -->
                <div class="row">
                    <div class="col-25">
                        <label for="text">Current Semester:</label>
                    </div>

                    <div class="col-75">
                        <% String currentSem = (String) request.getAttribute("currentSem");%>
                        <label for="text" ><%=currentSem%></label>
                    </div>
                </div>

                <!-- Course ID -->
                <div class="row">
                    <div class="col-25">
                        <label for="text">Course ID:</label>
                    </div>
                    <div class="col-75">
                        <%String selectedCourse = (String) session.getAttribute("selectedCourse");
                            if (selectedCourse == null || selectedCourse.compareTo("") == 0) { %>
                        <select name="chooseCourse" id="chooseCourse" >
                            <option disabled selected value> -- Select a Course -- </option>
                            <%ArrayList<Course> listCourse = (ArrayList<Course>) request.getAttribute("listCourse");
                                for (Course c : listCourse) {
                            %>
                            <option value="<%=c.getCourse_ID()%>"><%=c.getCourse_ID()%></option>
                            <%}%>
                            <%} else {%>
                            <option > <%=selectedCourse%></option>
                            <%}%>
                        </select>
                        <%if (selectedCourse == null || selectedCourse.compareTo("") == 0) {%>
                        <button style=" margin: 0;" type="button" onclick="submitForm();">Find Teacher</button>
                        <%} else {%>
                        <script>
                            window.onload = function () {
                                hideButton();
                            };
                        </script>
                        <%}%>
                    </div>
                </div> 

                <!-- Teacher Name -->     
                <div class="row">
                    <div class="col-25">
                        <label for="text">Teacher:</label>

                    </div>
                    <div class="col-75">
                        <%  ArrayList<Teacher> listTeacherByCourseIDandMajor = (ArrayList<Teacher>) request.getAttribute("listTeacherByCourseIDandMajor");
                            if (listTeacherByCourseIDandMajor != null) {%>
                        <select name="chooseTeacher">
                            <option disabled selected value> -- Select a Teacher -- </option>
                            <%for (Teacher t : listTeacherByCourseIDandMajor) {
                            %>
                            <option value="<%=t.getUserName()%>"><%=t.getUserName()%></option>
                            <%}%>
                        </select>
                        <%}%>
                    </div>
                </div>

                <!-- Biographic -->  
                <div class="row">
                    <div class="col-25">
                        <label for="desc">Biographic: </label>
                    </div>
                    <div class="col-75" >
                        <input type="text" name="biographic" id="text" placeholder="Biographic" >
                    </div>
                </div>

                <!-- Resource -->  
                <div class="row">
                    <div class="col-25">
                        <label for="desc">Resource: </label>
                    </div>
                    <div class="col-75" >
                        <input type="text" name="resource" id="text" placeholder="Resource" >
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Add CPS" name="add">
                    <input type="submit" value="Back to CPS List" name="BackToCPSList">
                </div>              
            </form>                
        </div>
    </body>
</html>
