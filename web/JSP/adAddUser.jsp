<%-- 
    Document   : adAddUser
    Created on : Mar 8, 2023, 11:10:34 PM
    Author     : HE170417
--%>

<%@page import="dbObject.Major"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title></title>
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="<%= request.getContextPath()%>\css\adAddUser.css" />
    </head>
   <%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <body>
        <!-- <script src="function.js"></script> -->
        <script>
            function RoleCheck() {
                if (document.getElementById("student").checked) {
                    document.getElementById("ifStudent").style.display = "block";
                    document.getElementById("ifTeacher").style.display = "none";
                } else if (document.getElementById("teacher").checked) {
                    document.getElementById("ifTeacher").style.display = "block";
                    document.getElementById("ifStudent").style.display = "none";
                } else if (document.getElementById("admin").checked) {
                    document.getElementById("ifTeacher").style.display = "none";
                    document.getElementById("ifStudent").style.display = "none";
                }
            }
        </script>
        <%
            ArrayList<Major> mList = (ArrayList<Major>) session.getAttribute("majorList");
        %>
        <h2>Add user information</h2>
        <div class="container">
            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>\image\manyUser.png" alt="" />
            </div>
            <div class="row">
                <div>
                    <%
                        String err = (String) request.getAttribute("noti");
                        if (err != null) {
                    %>
                    <span style="text-align: center; color:red;"><%=err%></span>
                    <%
                        }
                    %> 
                </div>
            </div>
            <form action="AddUserByRole" method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="username">User name:</label>
                    </div>
                    <div class="col-75">
                        <input
                            type="text"
                            id="username"
                            name="username"
                            placeholder="Username"
                            required
                            />
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="username">new password:</label>
                    </div>
                    <div class="col-75">
                        <input
                            type="password"
                            id="pass"
                            name="pass"
                            placeholder="password"
                            required
                            />
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="fullname">Full Name:</label>
                    </div>
                    <div class="col-75">
                        <input
                            type="text"
                            id="fullname"
                            name="fullname"
                            placeholder="full name"
                            required
                            />
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="Address">Address:</label>
                    </div>
                    <div class="col-75">
                        <input
                            type="text"
                            id="Address"
                            name="Address"
                            placeholder="Address"
                            />
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="number">Phone Number:</label>
                    </div>
                    <div class="col-75">
                        <input
                            type="text"
                            pattern="[0-9]{10}"
                            id="number"
                            name="phone"
                            placeholder="Phone Number (10 num required)"
                            />
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="email">Email:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="email" name="email" placeholder="Email" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="Address">Role:</label>
                    </div>
                    <div class="col-75">
                        <label for="student">Student</label
                        ><input
                            style="width: auto; margin-left: 2%"
                            type="radio"
                            onclick="RoleCheck()"
                            value="student"
                            name="roles"
                            id="student"
                            />
                        <label for="teacher">Teacher</label
                        ><input
                            style="width: auto; margin-left: 2%"
                            type="radio"
                            onclick="RoleCheck()"
                            value="teacher"
                            name="roles"
                            id="teacher"
                            />
                        <label for="admin">Admin</label
                        ><input
                            style="width: auto; margin-left: 2%"
                            type="radio"
                            onclick="RoleCheck()"
                            value="admin"
                            name="roles"
                            id="admin"
                            checked
                            />
                    </div>
                </div>
                <div id="ifStudent" style="display: none">
                    <div class="row">
                        <div class="col-25">
                            <label for="stID">Student ID:</label>
                        </div>
                        <div class="col-75">
                            <input
                                type="text"
                                name="studentID"
                                id="stID"
                                placeholder="Student ID"
                                />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="mjID">Major ID:</label>
                        </div>
                        <div class="col-75">
                            <select name="major" id="mjID" style="margin-top:3%">
                                <%
                                    for (Major m : mList) {
                                %>
                                <option value="<%=m.getID()%>"><%=m.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>

                <div id="ifTeacher" style="display: none">
                    <div class="row">
                        <div class="col-25">
                            <label for="mjID">Major ID:</label>
                        </div>
                        <div class="col-75">
                            <select name="major" id="mjID" style="margin-top:3%">
                                <%
                                    for (Major m : mList) {
                                %>
                                <option value="<%=m.getID()%>"><%=m.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>
                <button type="submit">Add user</button>
                <a href="adUserList"><button type="button">Go back</button></a>
            </form>
        </div>
    </body>
</html>
