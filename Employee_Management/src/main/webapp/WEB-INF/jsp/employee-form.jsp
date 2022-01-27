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

            .error {
                color:red;
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
                cursor: pointer;
                transition-duration: 0.4s;
            }
            .button:hover {
              background-color: white;
              color: #4CAF50;  /* Green */
            }

            .input-text {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            .marks {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
        </style>
    </head>

    <body>
        <div class="background-box">
            <h2>Registration Form</h2>

            <form:form action="added" modelAttribute="employee">
                Employee Name<sup>*</sup>: <form:input path="empName" cssClass="input-text" placeholder="Employee Name" />
                Employee Id<sup>*</sup>: <form:input path="empId" cssClass="input-text" placeholder="Employee Id" />
                Employee Address<sup>*</sup>: <form:input path="empAddr" cssClass="input-text" placeholder="Employee Address" />
                Employee Mobile Number<sup>*</sup>: <form:input path="empMobile" cssClass="input-text" placeholder="Employee Mobile Number" />
                Employee Department<sup>*</sup>: <form:input path="empDept" cssClass="input-text" placeholder="Employee Department" />
                Employee Salary<sup>*</sup>: <form:input path="empSalary" cssClass="input-text" placeholder="Employee Salary" />

                <input type="submit" class="button" value="Submit">
            </form:form>
        </div>
    </body>
</html>