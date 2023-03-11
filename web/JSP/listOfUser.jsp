<%@page import="dbObject.User"%>
<%@page import="dbObject.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbObject.Student_Class_Mark"%>
<%@page import="dbObject.Class"%>
<%@page import="dbObject.Student"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <%
        if (session.getAttribute("userList") == null) {
            response.sendRedirect("Login.jsp");
        }
    %>
    <head>
        <title>List of user</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            ArrayList<User> uList = (ArrayList<User>) session.getAttribute("userList");
        %>
        <h2>User Information</h2>
        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>User name</th>
                        <th>User pass</th>
                        <th>Role_ID</th>
                        <th>Action</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (!uList.isEmpty()) {
                            for (User u : uList) {
                    %>
                    <tr>
                        <th><%=u.getUserName()%></th>
                        <th><%=u.getPassWord()%></th>
                        <th><%if (u.getRole() == 0) {
                                out.print("Admin");
                            } else if (u.getRole() == 1) {
                                out.print("Student");
                            } else {
                                out.print("Teacher");
                            }
                            %></th>
                        <th><a style="text-decoration: none; font-weight: bold; border: 3px solid teal;" href="#">Update</a></th>
                        <th><a style="text-decoration: none; font-weight: bold; border: 3px solid teal;" href="deleteUser?delname=<%=u.getUserName()%>&role=<%=u.getRole()%>" class="confirmation">Delete</a></th>
                    </tr>
                    <%
                            }
                        }

                    %>
                </tbody>
            </table>
            <%                    if (request.getAttribute("err") != null) {
            %>
            <span style="text-align:center; color:red;"><%=request.getAttribute("err")%></span>
            <%
                }
            %>
        </div>
        <div style=" text-align: center; margin-bottom: 2%;">
            <a href="adAddUser" ><input type="button" value="Add more user" style="padding:10px"></a>
            <a href="<%= request.getContextPath()%>/AdminInfo"><input type="button" value="Back to homepage" style="padding:10px"></a>
        </div>
        <script type="text/javascript">
            var elems = document.getElementsByClassName('confirmation');
            var confirmIt = function (e) {
                if (!confirm('Doing this action will cause pernamently delete this user information completely? Do you want to process?'))
                    e.preventDefault();
            };
            for (var i = 0, l = elems.length; i < l; i++) {
                elems[i].addEventListener('click', confirmIt, false);
            }
        </script>
    </body>
</html>