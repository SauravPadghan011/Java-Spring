USE edyoda;
CREATE TABLE employee(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    empName VARCHAR(50),
    empId INT(10),
    empAddr VARCHAR(100),
    empMobile VARCHAR(10),
    empDept VARCHAR(20),
    empSalary VARCHAR(50)
);
SELECT * FROM employee;
TRUNCATE TABLE employee;