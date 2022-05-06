REM   Script: Activity1
REM   Activity1-Table creation

CREATE TABLE Customers ( 
    CustomerID int, 
    CustomerName varchar(52), 
    ContactName varchar(32), 
    Address varchar(255), 
    City varchar(50), 
    PostalCode varchar(20), 
    Country varchar(20) 
);

INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country) 
VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');

INSERT ALL 
    INTO Customers VALUES('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway') 
    INTO Customers VALUES('Wolski', 'Tjo', '305 b wing,alaska', 'Walla', '43200', 'USA') 
     INTO Customers VALUES('wilman', 'Rayman', 'Wimbington town', 'helskini', '0956', 'Poland') 
     INTO Customers VALUES('kala', 'Diski', 'planet area', 'Lineko', '110001', 'Finland') 
SELECT 1 FROM DUAL;

INSERT ALL 
    INTO Customers VALUES('11','Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway') 
    INTO Customers VALUES('12','Wolski', 'Tjo', '305 b wing,alaska', 'Walla', '43200', 'USA') 
     INTO Customers VALUES('13','wilman', 'Rayman', 'Wimbington town', 'helskini', '0956', 'Poland') 
     INTO Customers VALUES('14','kala', 'Diski', 'planet area', 'Lineko', '110001', 'Finland') 
SELECT 1 FROM DUAL;

SELECT DISTINCT Country FROM Customers;

SELECT * FROM Customers 
WHERE Country='Poland';

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

