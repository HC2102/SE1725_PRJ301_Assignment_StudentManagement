<%-- 
    Document   : UpdateCourse
    Created on : Mar 8, 2023, 1:26:54 AM
    Author     : dange
--%>
<%@page import="dbObject.Major"%>
<%@page import="dbObject.Class" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Update</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CourseStyle_1.css">
    </head>
    <%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <body>
        <h2>Update Class...</h2>
        <%
            Class c = (Class) request.getAttribute("newclass");
            ArrayList<Major> mList = (ArrayList<Major>) request.getAttribute("majorlist");

        %>
        <div class="container">

            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>/image/class.png" alt="">
            </div>

            <form action="<%= request.getContextPath()%>/UpdateClass?id=<%=c.getClass_ID()%>" method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="text">New Class ID:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="cid" id="text" placeholder="Class ID" required>
                        <span class="err"><%
                            String err = (String) request.getAttribute("info");
                            if (err != null && err.compareTo("") != 0)
                                out.println(err);
                            %> 
                        </span>
                    </div>
                </div>            
                <div class="row">
                    <div class="col-25">
                        <label for="text">Major ID:</label>

                    </div>
                    <div class="col-75">

                        <select name="mid">
                            <% if (mList != null) {
                                    for (Major m : mList) {
                            %>
                            <option value="<%=m.getID()%>"><%=m.getName()%></option>
                            <%
                                    }
                                }%>
                        </select>

                    </div>
                </div>
                <div class="row">

                    <input type="submit" value="Update">
                    <a href= "<%= request.getContextPath()%>/ClassList"> <input type="button" value="Back to list"></a>
                </div>


            </form>
        </div>
    </body>
</html>
