<%-- 
    Document   : addList
    Created on : Mar 13, 2023, 7:33:17 PM
    Author     : dange
--%>

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
    <body>
        <h2>Add New Test...</h2>
        <div class="container">

            <div class="imgdiv">

                <img src="<%= request.getContextPath()%>/image/test.png" alt="">
            </div>
            <form action="<%= request.getContextPath()%>/addTest?id=<%=request.getParameter("id")%>" method="post">
                <input type="hidden" value="<%request.getParameter("Course_id");%>" name="cid">
                
                <div class="row">
                    <div class="col-25">
                        <label for="text">New Test ID:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="tid" id="text" placeholder="Test ID" required>
                       
                    </div>
                </div>            
                
                <div class="row">
                    <div class="col-25">
                        <label for="text">Test Name:</label>

                    </div>
                    <div class="col-75">
                        <input type="text" name="name" id="text" placeholder="Test name" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="text">Weight:</label>
                    </div>
                    <div class="col-75" >
                        <input type="number" name="name" id="text" placeholder="Weight" required>
                    </div>
                </div>
                <div class="row">
                    
                    <input type="submit" value="Add">   
                    <a href= "<%= request.getContextPath()%>/CourseTest"> <input type="button" value="Back to list"></a>
                </div>              
            </form>  
                <span class="err" style="color: red;"><%
                        String err = (String) request.getAttribute("info");
                        if(err!=null && err.compareTo("")!=0){ 
                        out.println("<br>" + err);
                            }
                            %> 
                        </span>
        </div>
    </body>
</html>
