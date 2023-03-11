<%-- 
    Document   : adAddEnrolled
    Created on : 11-03-2023, 19:47:02
    Author     : Zarius
--%>

<%@page import="dbObject.CPS"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Enrolled</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/adAddUser.css">
    </head>
    <body>
        <script>
            function submitForm() {
                var selectValue = document.getElementById("chooseCourse").value;
                var form = document.getElementById("myForm");
                form.action = "classByCPSMajor";
                form.submit();
            }

            function hideButton() {
                var button = document.querySelector('button');
                button.style.display = 'none';
            }

        </script>
        <h2>Add New Enrolled</h2>
        <div class="container">
            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>/image/course.png" alt="">
            </div>

            <form id="myForm" action="<%= request.getContextPath()%>" method="post">
                <!-- CPS_ID -->
                <div class="row">
                    <div class="col-25">
                        <label for="text">CPS_ID:</label>
                    </div>

                    <div class="col-75">
                        <%String selectedCPS = (String) session.getAttribute("selectedCourse");
                            if (selectedCPS == null || selectedCPS.compareTo("") == 0) { %>
                        <select name="chooseCPS" id="chooseCPS" >
                            <option disabled selected value> -- Select a CPS -- </option>
                            <%
                                ArrayList<CPS> listCPS = (ArrayList<CPS>) request.getAttribute("listCPS");
                                for (CPS cps : listCPS) {
                            %>
                            <option value="<%=cps.getCps_id()%>"><%=cps.getCps_id()%> - <%=cps.getCourse_ID()%></option>
                            <%}%>
                            <%} else {%>
                            <option > <%=selectedCPS%></option>
                            <%}%>
                        </select>
                        <%if (selectedCPS == null || selectedCPS.compareTo("") == 0) {%>
                        <button style=" margin: 0;" type="button" onclick="submitForm();">Find Class</button>
                        <%} else {%>
                        <script>
                            window.onload = function () {
                                hideButton();
                            };
                        </script>
                        <%}%>
                    </div>
                </div>

                <!-- Class ID -->
                <div class="row">
                    <div class="col-25">
                        <label for="text">Class ID:</label>
                    </div>
                    <div class="col-75">
                        <select name="chooseClass" id="chooseClass" >
                            <option disabled selected value> -- Select a Course -- </option>
                            
                            <option value="<%=c.getCourse_ID()%>"><%=c.getCourse_ID()%></option>
                        </select>
                        <button style=" margin: 0;" type="button" onclick="submitForm();">Find Teacher</button>
                    </div>
                </div> 

                    <input type="submit" value="Add Enrolled" name="add">
                    <a href= "<%= request.getContextPath()%>/ad"> <input type="button" value="Back to CPS List"></a>
                </div>              
            </form>                
        </div>
    </body>
</html>
