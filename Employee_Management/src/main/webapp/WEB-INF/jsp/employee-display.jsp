<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

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
            .button {
                background-color: #4CAF50;  /* Green */
                border: 2px;
                border-radius: 2px;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                margin-left: 24px;
                cursor: pointer;
                transition-duration: 0.4s;
                }
            .button:hover {
                background-color: white;
                color: #4CAF50;  /* Green */
            }
            #table {
                font-family: Arial, Helvetica, sans-serif;
                border-collapse: collapse;
            }

            #table td, #table th {
                border: 1px solid #6a6a6a;
                padding: 8px;
            }

            #table tr:hover {
                background-color: #ddd;
            }

            #table th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #04AA6D;
                color: white;
            }
        </style>
    </head>

    <body>
        <div class="background-box">
            <h2>Employee Information</h2>

            <!-- <p class="display">Employee Name: ${employee.empName}</p><br>
            <p class="display">Employee Id: ${employee.empId}</p><br>
            <p class="display">Employee Address: ${employee.empAddr}</p><br>
            <p class="display">Employee Mobile Number: ${employee.empMobile}</p><br>
            <p class="display">Employee Department: ${employee.empDept}</p><br>
            <p class="display">Employee Salary: ${employee.empSalary}</p><br> --!>


            <table id="table">
                <tr>
                    <th>Name</th>
                    <th>Id</th>
                    <th>Address</th>
                    <th>Mobile Number</th>
                    <th>Department</th>
                    <th>Salary</th>
                </tr>

                <c:forEach items="${employeeList}" var="employee">
                    <tr>
                        <td>${employee.getEmpName()}</td>
                        <td>${employee.getEmpId()}</td>
                        <td>${employee.getEmpAddr()}</td>
                        <td>${employee.getEmpMobile()}</td>
                        <td>${employee.getEmpDept()}</td>
                        <td>${employee.getEmpSalary()}</td>
                    </tr>
                </c:forEach>
            </table>

            <br><br>
            <a href="/employee/homePage"><button class="button">Home</button></a>
        </div>
    </body>
</html>
