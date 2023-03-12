<%-- 
    Document   : adMajorList
    Created on : Mar 12, 2023, 11:57:26 AM
    Author     : HE170417
--%>

<%@page import="dbObject.Semester"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Semester controller</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            ArrayList<Semester> sList = ( ArrayList<Semester>) request.getAttribute("mList");
        %>
        <h2>Semester controller</h2>
        <div class="table-wrapper">
            <!-- notification sections -->
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
            <!--/notification sections -->
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>Semester ID</th>
                        <th>Time start</th>
                        <th>Time end</th>
                        <th>Active</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (!sList.isEmpty()) {
                            for (Semester s: sList) {
                    %>
                    <tr>
                        <th><%=s.getSemester_ID()%></th>
                        <th><%=s.getTime_start()%></th>
                        <th><%=s.getTime_end()%></th>
                        <th> <input type="radio" name="isActive" value="HTML"></th>
                        <th><a style="text-decoration: none; font-weight: bold; border: 3px solid teal;" href="deleteSemester?delSem=<%=s.getSemester_ID()%>" class="confirmation">Delete</a></th>
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
