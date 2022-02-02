<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

<html>
    <head>
        <style>
            div.background-box {
                border-radius: 5px;
                background-color: #d3d2d2;
                width: 700px;
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
        </style>
    </head>

    <body>
        <div class="background-box">
            <h2>Employee Registration Form</h2>
            <a href="/employee/employeeForm"><button class="button">Add Data</button></a>
            <a href="/employee/employeeDelete"><button class="button">Delete Data</button></a>
            <a href="/employee/employeeDisplay"><button class="button">View</button></a>
        </div>
    </body>
</html>