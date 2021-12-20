<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Customer Registration</title>
        <style>
            .error {
                color:red;
            }
        </style>
    </head>

    <body>
        <p>Customer Registration Form</p>
            <div>
                <form:form action="processForm" modelAttribute="customer">
                    First Name: <form:input path="firstName" placeholder="First Name" />
                    <br><br>
                    Last Name<sup>*</sup> : <form:input path="lastName" placeholder="Last Name" />
                    <form:errors path="lastName" cssClass="error"></form:errors>
                    <br><br>
                    Free Passes : <form:input path="freePasses" />
                    <form:errors path="freePasses" cssClass="error"></form:errors>

                    <br><br>
                    <input type="submit" value="Submit">
                </form:form>
            </div>

    </body>
</html>