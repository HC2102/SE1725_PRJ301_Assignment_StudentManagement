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
            <!--search by role-->
            <form id="f1" action="<%= request.getContextPath()%>/adUserList" method="post" class="table-wrapper" style="margin-bottom: 0; box-shadow: none">
                <label for="roleFind">Roles </label>
                <select name="roleFind" onchange="change()">
                    <option disabled selected value> -- select a role -- </option>
                    <option value="">All</option>
                    <option value="0">Admin</option>
                    <option value="1">Student</option>
                    <option value="2">Teacher</option>
                </select>
            </form>
            <!--end of search by role-->
            <span class="status"><%
                String info = (String) request.getAttribute("status");
                if (info != null && info.compareTo("") != 0)
                    out.println(info);
                %> 
            </span>
            <span class="error"><% String err = (String) request.getAttribute("error");
                if (err != null && err.compareTo("") != 0)
                    out.println(err); %>
            </span>
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
                        <th><a href="updateUser?upname=<%=u.getUserName()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update"></a></th>
                        <th><a href="deleteUser?delname=<%=u.getUserName()%>&role=<%=u.getRole()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></th>
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
            <a href="adAddUser" ><input class="id" type="button" value="Add more user" style="padding:10px; font-weight: bold"></a>
            <a href="<%= request.getContextPath()%>/AdminInfo"><input class="id" type="button" value="Back to homepage" style="padding:10px; font-weight: bold  "></a>
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
            function change() {
                document.getElementById("f1").submit();
            }
        </script>
    </body>
</html>