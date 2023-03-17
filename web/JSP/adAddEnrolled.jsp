<%-- 
    Document   : adAddEnrolled
    Created on : 11-03-2023, 19:47:02
    Author     : Zarius
--%>

<%@page import="dbObject.CPS"%>
<%@page import="dbObject.Major"%>
<%@page import="dbObject.Class"%>
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
    <%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <body>
        <script>
            function submitFormToGetClass() {
                var selectValue = document.getElementById("chooseMajor").value;
                var form = document.getElementById("myForm");
                form.action = "ClassByMajor";
                form.submit();
            }

            function submitFormToGetCPS() {
                var selectValue = document.getElementById("chooseClass").value;
                var form = document.getElementById("myForm");
                form.action = "CPSByClass";
                form.submit();
            }

            function hideButton(buttonId) {
                var button = document.getElementById(buttonId);
                button.style.display = 'none';
            }

        </script>
        <h2>Add New Enrolled</h2>
        <div class="container">
            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>/image/course.png" alt="">
            </div>

            <form id="myForm" action="<%= request.getContextPath()%>/insertEnrolled" method="post">
                <!-- Major -->
                <div class="row">
                    <div class="col-25">
                        <label for="text">Select Major: </label>
                    </div>

                    <div class="col-75">
                        <%String selectedMajor = (String) session.getAttribute("selectedMajor");
                            if (selectedMajor == null || selectedMajor.compareTo("") == 0) { %>
                        <select name="chooseMajor" id="chooseMajor" >
                            <option disabled selected value> -- Select a Major -- </option>
                            <%
                                ArrayList<Major> listMajor = (ArrayList<Major>) request.getAttribute("listMajor");
                                for (Major m : listMajor) {
                            %>
                            <option value="<%=m.getID()%>"><%=m.getID()%></option>
                            <%}%>
                            <%} else {%>
                            <option> <%=selectedMajor%></option>
                            <%}%>
                        </select>
                        <%if (selectedMajor == null || selectedMajor.compareTo("") == 0) {%>
                        <button id="button1" style=" margin: 0;" type="button" onclick="submitFormToGetClass();">Find Class</button>
                        <%} else {%>
                        <script>
                            window.onload = function () {
                                hideButton(button1);
                            };
                        </script>
                        <%}%>
                    </div>
                </div>

                <!-- Class ID by Major ID -->
                <div class="row">
                    <div class="col-25">
                        <label for="text">Class ID:</label>
                    </div>
                    <div class="col-75">
                        <%  String selectedClass = (String) session.getAttribute("selectedClass");
                            if (selectedClass == null || selectedClass.compareTo("") == 0) {
                                ArrayList<Class> listClassByMajor = (ArrayList<Class>) request.getAttribute("listClassByMajor");
                                if(listClassByMajor != null){%>
                        <select name="chooseClass" id="chooseClass" >
                            <option disabled selected value> -- Select a Class -- </option>
                            <%
                                for (Class cl : listClassByMajor) {
                            %>
                            <option value="<%=cl.getClass_ID()%>"><%=cl.getClass_ID()%></option>
                            <%}%>
                            <%}%>
                            <%} else {%>
                            <option> <%=selectedClass%></option>
                            <%}%>
                        </select>
                        <%if (selectedMajor == null || selectedMajor.compareTo("") == 0) {%>
                        <script>
                            window.onload = function () {
                                hideButton(button2);
                            };
                        </script>
                        <%} else {%>
                        <%if (selectedClass == null || selectedClass.compareTo("") == 0) {%>
                        <button id="button2" style=" margin: 0;" type="button" onclick="submitFormToGetCPS();">Find CPS</button>
                        <%} else {%>
                        <script>
                            window.onload = function () {
                                hideButton(button2);
                            };
                        </script>
                        <%}%>
                        <%}%>
                    </div>
                </div> 

                <!-- CPS ID by Class ID -->
                <div class="row">
                    <div class="col-25">
                        <label for="text">CPS ID:</label>
                    </div>
                    <div class="col-75">
                        <%ArrayList<CPS> listCPSByClassIDAndMajor = (ArrayList<CPS>) request.getAttribute("listCPSByClassIDAndMajor");
                            if (listCPSByClassIDAndMajor != null) {%>
                        <select name="chooseCPS" id="chooseCPS" >
                            <option disabled selected value> -- Select a CPS -- </option>
                            <%
                                for (CPS cps : listCPSByClassIDAndMajor) {
                            %>
                            <option value="<%=cps.getCps_id()%>"><%=cps.getCps_id()%>-<%=cps.getCourse_ID()%></option>
                            <%}%>
                        </select>
                        <%}%>

                    </div>
                </div> 

                <input type="submit" value="Add Enrolled" name="add">
                <input type="submit" value="Back to Enrolled List" name="BackToEnrolled">
            </form>                
        </div>
    </body>
</html>
