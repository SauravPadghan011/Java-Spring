<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
    <head>
        <style>
            div.background-box {
                border-radius: 5px;
                background-color: #ebebeb;
                width: 600px;
                padding: 20px;
                margin-left: 100px;
                margin-top: 100px;
            }

            #exam {
              font-family: Arial, Helvetica, sans-serif;
              border-collapse: collapse;
            }

            #exam td, #exam th {
              border: 1px solid #6a6a6a;
              padding: 8px;
            }

            #exam tr:hover {
                background-color: #ddd;
            }

            #exam th {
              padding-top: 12px;
              padding-bottom: 12px;
              text-align: left;
              background-color: #04AA6D;
              color: white;
            }
        </style>
    </head>

    <body>
        <sql:setDataSource var = "snapshot" driver = "com.mysql.cj.jdbc.Driver"
                      url = "jdbc:mysql://localhost:3306/edyoda"
                      user = "root"  password = "xxxx"/>
        <sql:query dataSource = "${snapshot}" var = "result">
                 SELECT * FROM exam ORDER BY totalMarks;
        </sql:query>

        <div class="background-box">
            <h2>Student Information</h2>
            <table id="exam">
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Semester</th>
                    <th>Total Marks</th>
                    <th>Percentage</th>
                </tr>

                <c:forEach var = "row" items = "${result.rows}">
                    <tr>
                        <td><c:out value = "${row.id}"/></td>
                        <td><c:out value = "${row.firstName}"/></td>
                        <td><c:out value = "${row.lastName}"/></td>
                        <td><c:out value = "${row.semester}"/></td>
                        <td><c:out value = "${row.totalMarks}"/></td>
                        <td><c:out value = "${row.percentage}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <%-- <div class="background-box">
            <h2>Student Information</h2>
            <p class="display">Roll Number: ${student.rollNo}</p><br>
            <p class="display">Student Name: ${student.firstName}&nbsp;${student.lastName}</p><br>
            <p class="display">Percentage: ${student.percentage}</p>
        </div>

        <button onclick="myFunction()">Try it</button>
        <script>
            function myFunction() {
                alert("${student.percentage}");
            }
        </script> --%>
    </body>
</html>
