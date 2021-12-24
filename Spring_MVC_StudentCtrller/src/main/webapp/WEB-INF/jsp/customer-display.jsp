<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer Registration</title>
</head>
<body>
    <p>Customer Name: <span>${customer.firstName}</span>&nbsp;<span>${customer.lastName}</span></p>
    <p>Pincode: <span>${customer.pincode}</span>
    <p>Date: <span>${customer.date}</span>
</body>
</html>