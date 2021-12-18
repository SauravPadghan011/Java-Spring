<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

<html>
<head>
    <title>Student Main Page</title>
</head>
<body>
    <p>Registration Form</span>
    <div>
        <form:form action="processForm" modelAttribute="student">
            First Name: <form:input path="firstName" />
            <br><br>
            Last Name: <form:input path="lastName" />
            <br><br>
            Select Country:
            <form:select path="country">
            	<form:options items="${student.countryOptions}" />
            </form:select>
            <br><br>
            Favourite Language:
            <form:radiobutton path="language" value="Java" /> Java
            <form:radiobutton path="language" value="C#" /> C#
            <form:radiobutton path="language" value="Python" /> Python
            <form:radiobutton path="language" value="C++" /> C++
            <form:radiobutton path="language" value="GOLANG" /> GO

            <br><br>
            Operating Systems:
            <form:checkbox path="operatingSystems" value="Windows" /> Windows
            <form:checkbox path="operatingSystems" value="Mac OS" /> Mac OS
            <form:checkbox path="operatingSystems" value="Linux" /> Linux

            <br><br>
            <input type="submit" value="Submit">
        </form:form>
    </div>
</body>
</html>