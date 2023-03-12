<%-- 
    Document   : adMajorList
    Created on : Mar 12, 2023, 11:57:26 AM
    Author     : HE170417
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dbObject.Major"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Major data</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            ArrayList<Major> mList = ( ArrayList<Major>) request.getAttribute("mList");
        %>
        <h2>Major data</h2>
        <div class="table-wrapper">
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
                        <th>Major ID</th>
                        <th>Major name</th>
                        <th>bios</th>
                        <th>Action</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (!mList.isEmpty()) {
                            for (Major m: mList) {
                    %>
                    <tr>
                        <th><%=m.getID()%></th>
                        <th><%=m.getName()%></th>
                        <th><%=m.getBio()%></th>
                        <th><a style="text-decoration: none; font-weight: bold; border: 3px solid teal;" href="updateMajor?upID=<%=m.getID()%>">Update</a></th>
                        <th><a style="text-decoration: none; font-weight: bold; border: 3px solid teal;" href="deleteMajor?delID=<%=m.getID()%>" class="confirmation">Delete</a></th>
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
            <a href="addMajor" ><input type="button" value="Add more Major" style="padding:10px"></a>
            <a href="AdminInfo"><input type="button" value="Back to homepage" style="padding:10px"></a>
        </div>
        <script type="text/javascript">
            var elems = document.getElementsByClassName('confirmation');
            var confirmIt = function (e) {
                if (!confirm('Doing this action will cause pernamently delete this major information completely? Do you want to process?'))
                    e.preventDefault();
            };
            for (var i = 0, l = elems.length; i < l; i++) {
                elems[i].addEventListener('click', confirmIt, false);
            }
        </script>
    </body>
</html>
