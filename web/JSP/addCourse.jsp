<%-- 
    Document   : addCourse
    Created on : Mar 8, 2023, 4:21:38 PM
    Author     : dange
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add course</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CourseStyle.css">
    </head>
    <%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <body>
        <h2>Add New Course...</h2>
        <div class="container">

            <div class="imgdiv">

                <img src="<%= request.getContextPath()%>/image/course.png" alt="">
            </div>
            <form action="<%= request.getContextPath()%>/addCourse" method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="text">New Course ID:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="cid" id="text" placeholder="Course ID" required>
                        <span class="err" style="color: red;"><%
                        String err = (String) request.getAttribute("info");
                        if(err!=null && err.compareTo("")!=0){ 
                        out.println("<br>" + err);
                            }
                            %> 
                        </span>
                    </div>
                </div>            
                <div class="row">
                    <div class="col-25">
                        <label for="text">New Major ID:</label>

                    </div>
                    <div class="col-75">
                        <select name="mid">
                            <c:if test="${mlist != null}">
                                <c:forEach items="${mlist}" var="m">
                                    <option value="${m.ID}">${m.name}</option>
                                </c:forEach>
                            </c:if>
                        </select>

                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="text">Course Name:</label>

                    </div>
                    <div class="col-75">
                        <input type="text" name="cname" id="text" placeholder="Course name" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="desc">Biographic: </label>
                    </div>
                    <div class="col-75" >
                        <textarea name="nbio" id="desc" value="input text" rows="5" placeholder="Course Biographic" required></textarea>
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Add">   
                    <a href= "<%= request.getContextPath()%>/ToCourses"> <input type="button" value="Back to list"></a>
                </div>              
            </form>                
        </div>
    </body>
</html>
