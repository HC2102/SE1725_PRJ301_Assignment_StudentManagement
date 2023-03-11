<%-- 
    Document   : ListEnrolled
    Created on : 11-03-2023, 20:25:22
    Author     : Zarius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home_studentstyle.css">
        <title>List Enrolled</title>
    </head>
    <body>
        <div class="ctr1">
            <a style="text-decoration: none; font-family:'Times New Roman'; margin-left:5%; margin-top:1%;" href="<%= request.getContextPath()%>/JSP/StudentHome.jsp"><H1>Home</H1></a>
            <div class="headerbutton">
                <a href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Change Password"></a>
                <a href="<%= request.getContextPath()%>/logout"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Log out"></a>
            </div>
        </div>


        <h2>List Enrolled</h2>
        <a href= "<%= request.getContextPath()%>/AdminInfo"> <input style="margin: 1%;margin-left:5%; font-weight: bold; padding: 0.5%" type="Submit" type="button" value="Back"></a>
        <span class="status">
            <%
                        String status = (String) session.getAttribute("status");
                        if (status != null && status.compareTo("") != 0)
                            out.println(status);
            %> 
        </span>
        
        <span class="error"><% String err = (String) session.getAttribute("error");
                if (err != null && err.compareTo("") != 0)
                    out.println(err); %>
            </span>

        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>CPS_ID</th>
                        <th>Class_ID</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=cps.getBiographic()%></td>
                        <td><%=cps.getResource()%></td>
                        <td><a href="updateCPS?id=<%=cps.getCps_id()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update"></a></td>
                        <td><a href="deleteCPS?id=<%=cps.getCps_id()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <form style=" padding-left: 42%;"  action="" method="post"> 
            <input style=" padding: 1%; font-weight: bold;" type="submit" value="Add CPS" name="addCPS">
        </form>
    </body>
</html>