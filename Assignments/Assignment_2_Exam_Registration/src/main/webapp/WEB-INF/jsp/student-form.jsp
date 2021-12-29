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

            <form:form action="displayForm" modelAttribute="student">
                Roll Number<sup>*</sup>: <form:input path="rollNo" cssClass="input-text"
                    placeholder="Enter Roll Number" />
                First Name<sup>*</sup>: <form:input path="firstName" cssClass="input-text"
                    placeholder="Enter First Name" />
                Last Name: <form:input path="lastName" cssClass="input-text" placeholder="Enter Last Name" />

                Semester<sup>*</sup>:
                <form:select path="semester" cssClass="input-text">
                    <form:options items="${student.semesterOptions}" />
                </form:select>

                <h3>Enter Marks</h3>
                    Programming in Java: <form:input path="javaMarks" cssClass="marks" placeholder="Enter Java Marks"/>
                    Data Structure: <form:input path="dsaMarks" cssClass="marks" placeholder="Enter DS Marks" />
                    Operating System: <form:input path="osMarks" cssClass="marks" placeholder="Enter OS Marks" />
                    DBMS: <form:input path="dbmsMarks" cssClass="marks" placeholder="Enter DBMS Marks" />
                    Web Development: <form:input path="wdMarks" cssClass="marks" placeholder="Enter WebDev Marks" />

                <input type="submit" class="button" value="Submit">
            </form:form>
        </div>
    </body>
</html>