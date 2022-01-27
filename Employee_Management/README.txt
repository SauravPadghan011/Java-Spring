Assignment:
An organization has thousands of employees, this organization wants to create a web interface for users where they can upload their information, modify information and view existing information.

As a software engineer in this organization HR came running to you with this requirement. They want someone who can design a backend for the requirement.
The requirement is as mentioned above.
The data that needs to be stored for employees is :
Name, emp id, address, mobile number, department, salary.
Once uploaded user can only update his/her address or mobile number.

Design a web server that should allow performing above operations.


File walk through:
1. config package: This package contains the configuration files.
2. controller: This package contains employee container
3. DAO: Employee DAO which contain create, delete, display operation.
4. Model: Employee entity class

jsp:
1. home-page: Home Page HTML code
2. employee-form: Employee Form which takes input employee details
3. employee-added: For confirmation that data has been added, and also this is responsible to add details into DB.
4. employee-delete: Form to take employee id as an input.
5. employee-deleted: Delete entered employeeId details from DB.
6. employee-display: Display employee details