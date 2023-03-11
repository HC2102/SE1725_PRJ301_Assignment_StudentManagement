<%-- 
    Document   : updateMark
    Created on : 06-03-2023, 13:06:29
    Author     : ADMIN
--%>
<%@page import="DAO.SemesterDAO"%>
<%@page import="dbObject.Semester"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbObject.Student_Class_Mark"%>
<%@page import="dbObject.Class"%>
<%@page import="dbObject.Student"%>
<%@page import="java.util.List" %>
<%@page import="dbObject.CPS"%>
<%@page import="dbObject.Grade"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/UpdateMark.css">
        <title>JSP Page</title>

    </head>
    <body>
        <% 
        ArrayList<Grade> list = (ArrayList<Grade>)request.getAttribute("data");
        CPS cps=(CPS)request.getAttribute("cps");
        //Semester cua CPS la object Semester
        SemesterDAO semDAO = new SemesterDAO();
        Semester sem = semDAO.getSemesterByID(cps.getSemesterID());
        if(sem.isCurrent_Semester() == true){%>
        <div class="ctr1">   
            SEMESTER: &nbsp; <%= sem.getSemester_ID()%><br/>
            TIME START: &nbsp; <%= sem.getTime_start()%><br/>
            TIME END: &nbsp;<%= sem.getTime_end()%><br/>
            <p>Scores of this semester can't be changed</p>
            <%for(Grade i : list){
            if(i.getTest_id().equalsIgnoreCase("AC")){%>
            <b>AC Mark:</b> <input  readonly type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="AC" value="<%= i.getValue()%>" required/><br/>
            <%}else if(i.getTest_id().equalsIgnoreCase("PT")){%>
            <b>PT Mark:</b> <input readonly type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="PT" value="<%= i.getValue()%>" required/><br/>
            <%}else if(i.getTest_id().equalsIgnoreCase("PE")){%>
            <b>PE Mark:</b> <input readonly type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="PE" value="<%= i.getValue()%>" required/><br/>
            <%}else if(i.getTest_id().equalsIgnoreCase("FE")){%>
            <b>FE Mark:</b> <input readonly type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="FE" value="<%= i.getValue()%>" required/><br/>
            <%}else if(i.getTest_id().equalsIgnoreCase("FE")){%>
            <b>PRJ Mark:</b> <input readonly type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="PRJ" value="<%= i.getValue()%>" required/><br/>
            <%}else if(i.getTest_id().equalsIgnoreCase("FE")){%>
            <b>PRS Mark:</b> <input readonly type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="PRS" value="<%= i.getValue()%>" required/><br/>
            <%}
                }
            %>
            <input type="submit" disabled value="UPDATE"/>
            <button class="ctr2" type="button" onclick="quay_lai_trang_truoc()">Back</button>
        </div>
        <%    } else{%>
        <div class="ctr1">
            <b>SEMESTER: &nbsp; <%= sem.getSemester_ID()%><br/>
                <b>TIME START: &nbsp; <%= sem.getTime_start()%><br/>
                    <b>TIME END: &nbsp;<%= sem.getTime_end()%><br/>
                        <form action="update" method="post">
                            <%String st_id=(String)request.getAttribute("st_id");
              String course_id=(String)request.getAttribute("course_id");%>
                            <input type="text" name="st_id"value="<%= st_id%>" hidden/>
                            <input type="text" name="course_id"value="<%= course_id%>" hidden/>
                            <input type="text" name="cps_id"value="<%= cps.getCps_id()%>" hidden/>
                            <%for(Grade i : list){
            if(i.getTest_id().equalsIgnoreCase("AC")){%>
                            <b>AC Mark:</b> <input type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="AC" value="<%= i.getValue()%>" required/><br/>
                            <%}else if(i.getTest_id().equalsIgnoreCase("PT")){%>
                            <b>PT Mark:</b> <input type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="PT" value="<%= i.getValue()%>" required/><br/>
                            <%}else if(i.getTest_id().equalsIgnoreCase("PE")){%>
                            <b>PE Mark:</b> <input type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="PE" value="<%= i.getValue()%>" required/><br/>
                            <%}else if(i.getTest_id().equalsIgnoreCase("FE")){%>
                            <b>FE Mark:</b> <input type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="FE" value="<%= i.getValue()%>" required/><br/>
                            <%}else if(i.getTest_id().equalsIgnoreCase("FE")){%>
                            <b>PRJ Mark:</b> <input type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="PRJ" value="<%= i.getValue()%>" required/><br/>
                            <%}else if(i.getTest_id().equalsIgnoreCase("FE")){%>
                            <b>PRS Mark:</b> <input type="number" step="any" pattern="[-+]?[0-9]*[.,]?[0-9]+" name="PRS" value="<%= i.getValue()%>" required/><br/>
                            <%}
                                }   
                            %>
                            <input class="ctr2" type="submit" value="UPDATE"/>
                            <button class="ctr2" type="button" onclick="quay_lai_trang_truoc()">Back</button>

                        </form>

                        </div>
                        <%}
                        %>

                        <script>
                            function quay_lai_trang_truoc() {
                                history.back();
                            }
                        </script>
                        </body>
                        </html>
