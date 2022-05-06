REM   Script: Activity4
REM   Alter and update

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

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';

DELETE FROM Customers WHERE CustomerName='Tijo';

DELETE FROM Customers WHERE CustomerName='Walla';

