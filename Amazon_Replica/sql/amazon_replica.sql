CREATE DATABASE Amazon;
USE Amazon;
CREATE TABLE userData (
	id INT(10) NOT NULL AUTO_INCREMENT,
	firstName VARCHAR(20),
    lastName VARCHAR(20),
    email VARCHAR(50),
    passwd VARCHAR(20),
    fullAddress VARCHAR(255),
    userType VARCHAR(10),
    PRIMARY KEY(id)
);
DROP TABLE userDATA;
SELECT * FROM userData;
SELECT * FROM userData WHERE email='sauravp@gmail.com' and passwd='Saurav@123';
DELETE FROM userData WHERE id=6;

CREATE TABLE productDetails(
	pId INT(10) NOT NULL AUTO_INCREMENT,
	productId VARCHAR(20) NOT NULL UNIQUE,
    productName VARCHAR(100),
    manufacturerName VARCHAR(255),
    productPrice INT(10),
    productDiscount INT(10),
    productStock INT(10),
    createdBy VARCHAR(50),
    PRIMARY KEY(pId)
);
INSERT INTO productDetails VALUES(1, "GTRX1", "GEFORCE RTX 3070", "Nvidia", 70000, 30, 10, "SauravPadghan");
DROP TABLE productDetails;
SELECT * FROM productDetails;


CREATE TABLE orderDetails (
	oId INT(10) NOT NULL AUTO_INCREMENT,
    orderId VARCHAR(20),
    productName VARCHAR(255),
    productPrice INT(10),
    productDiscount INT(10),
    priceAfterDis INT(10),
    totalCost INT(10),
    quantity INT(10),
    orderedBy VARCHAR(50),
    deliveryAddr VARCHAR(255),
    PRIMARY KEY(oId)
);
SELECT * FROM orderDetails;
TRUNCATE orderDetails;
DROP TABLE orderDetails;