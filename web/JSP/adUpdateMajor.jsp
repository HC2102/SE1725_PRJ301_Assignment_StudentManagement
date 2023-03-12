<%-- 
    Document   : adUpdateMajor
    Created on : Mar 12, 2023, 2:50:49 PM
    Author     : HE170417
--%>

<%@page import="dbObject.Major"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Major</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CourseStyle_1.css">
    </head>
    <body>
        <h2>Update major</h2>
        <div class="container">
            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>/image/class.png" alt="">
            </div>
            <%
                Major upMajor = (Major) request.getAttribute("updateMajor");
            %>
            <%
                if(session.getAttribute("err")!=null){
                %>
                <span style="color:red"><%=(String)session.getAttribute("err")%></span>
            <%
                }
            %>
            <form action="<%= request.getContextPath()%>/updateMajor" method="post">
                <input type="hidden" name="mID" value="<%=upMajor.getID()%>" >
                <div class="row">
                    <div class="col-25">
                        <label for="text">Major name:</label>

                    </div>
                    <div class="col-75">
                        <input type="text" name="mName" id="text" placeholder="Major name" value="<%=upMajor.getName()%>" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="text">Major bios:</label>
                    </div>
                    <div class="col-75">
                        <textarea  name="mBios" rows="4" cols="50" ><%=upMajor.getBio()%> </textarea>
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Update">
                    <a href= "<%= request.getContextPath()%>/majorList"> <input type="button" value="Back to list"></a>
                </div>              
            </form>                
        </div>
    </body>
</html>
