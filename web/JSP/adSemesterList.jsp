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
            ArrayList<Semester> sList = ( ArrayList<Semester>) request.getAttribute("semesterList");
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
            <form action="updateActiveSemester" action="get" id="f1">
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
                            <th> <input class="cfActive" type="radio" name="isActive" value="<%=s.getSemester_ID()%>" <%=s.isCurrent_Semester()==true?"Checked":""%> onchange="change()"></th>
                            <th><a href="deleteSemester?delSem=<%=s.getSemester_ID()%>"><input class="id confirmation" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update"></a></th>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </form>
            <%                    if (request.getAttribute("err") != null) {
            %>
            <span style="text-align:center; color:red;"><%=request.getAttribute("err")%></span>
            <%
                }
            %>

        </div>
        <div style=" text-align: center; margin-bottom: 2%;">
            <a href="addSemester" ><input class="id" type="button" value="Add Semester" style="padding:10px; font-weight: bold"></a>
            <a href="AdminInfo"><input class="id" type="button" value="Back to homepage" style="padding:10px; font-weight: bold"></a>
        </div>
        <script type="text/javascript">
            var elems = document.getElementsByClassName('confirmation');
            var elemsActive = document.getElementsByClassName('cfActive');
            var confirmIt = function (e) {
                if (!confirm('Doing this action will cause pernamently delete this major information completely? Do you want to process?'))
                    e.preventDefault();
            };
            var confirmActive = function (e) {
                if (!confirm('This action will change the current semester! Do you want to continue?'))
                    e.preventDefault();
            };
            for (var i = 0, l = elems.length; i < l; i++) {
                elems[i].addEventListener('click', confirmIt, false);
                elemsActive[i].addEventListener('click', confirmActive, false)
            }
            function change() {
                document.getElementById("f1").submit();
            }
        </script>
    </body>
</html>
