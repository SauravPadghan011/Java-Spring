<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

<html>
    <head>
        <title>Result</title>
                <style>
                    div.background-box {
                        border-radius: 5px;
                        width: 700px;
                        padding: 20px;
                        margin-left: 100px;
                        margin-top: 100px;
                    }

                    p.display {
                        width: 500px;
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
                <h2>Student Information</h2>
                <p class="display">Roll Number: ${student.rollNo}</p><br>
                <p class="display">Student Name: ${student.firstName}&nbsp;${student.lastName}</p><br>
                <p class="display">Semester: ${student.semester}</p>
                <p class="display">Percentage: ${student.percentage}</p>
            </div>
<script>
        alert("${student.percentage}");
        if(${student.percentage} == 0) {
            alert("Failed");
        } else {
            alert("Success");
            window.location = "/student/displayForm";
        }


        </script>
    </body>
</html>