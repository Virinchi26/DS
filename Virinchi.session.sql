CREATE DATABASE Hotel_Management;
USE  Hotel_Management;
CREATE TABLE Customer (
    Name1 varchar(255),
    PhoneNo int,
    Details varchar(255),
    Age int,
    BloodGroup varchar(255),
    price int ,
    CID int NOT NULL,
    PRIMARY KEY (price)
);
insert into Customer values('ROHIT','7131','Address','18','B+',1000,'20');
insert into Customer values('Vanshika','798983','Addrees1','19','AB-',2000,'29');
insert into Customer values('Vineet','73264','Address2','20','O+',3000,'22');
insert into Customer values('Tathagat','79589','Address3','21','B-',4000,'24');
insert into Customer values('Dev','797464','Address4','22','AB+',5000,'27');
insert into Customer values('Pranav','7364','Address5','20','O+',6000,'21');
insert into Customer values('Harditya','7589','Address6','21','B-',7000,'23');
insert into Customer values('Riti','79744','Address7','22','B+',8000,'26');
SELECT * FROM Customer;



CREATE TABLE Staff (
    Name2 varchar(255),
    Age2 int,
    BloodGroup1 varchar(255),
    SID1 int
);
insert into Staff values('ABCD',18 ,'AB+',206);
insert into Staff values('EFGH',19 ,'B+',207);
insert into Staff values('PQRS',20 ,'A+',208);
insert into Staff values('XYZ',21,'O+',209);
insert into Staff values('Pranav',25,'B+',210);
SELECT * FROM Staff;



DELETE FROM Staff WHERE Age2=25;

CREATE TABLE Rooms3(
    Type1 varchar(255),
    bed varchar(255),
    view1 varchar(255),
    price int,
    roomNo int,
    PRIMARY KEY (roomNo),
    foreign key(price) REFERENCES Customer(price)
);



insert into Rooms3  values('deluxe','single','beach',1000,101);
insert into Rooms3  values('AC','double','Garden',2000,103);
insert into Rooms3  values('Non-AC','triple','beach',3000,104);
insert into Rooms3  values('AC-Deluxe','Quad','SwimmingPool',4000,201);
insert into Rooms3  values('AC-deluxe','Single','sunset-view',6000,202);
insert into Rooms3  values('NonAC-deluxe','Single','SwimmingPool',7000,203);
insert into Rooms3  values('AC-Deluxe','Single','Garden',8000,204);
select * from Rooms3;

DELETE FROM Rooms3 WHERE roomNo=101;



CREATE TABLE Bill(
    CName varchar(255),
    Time1 varchar(255),
    Amount int,
    Taxes int,
    roomNo int,
    FOREIGN KEY (roomNo) REFERENCES Rooms3(roomNo)
);
insert into Bill  values('Dev','10:30',800,27,101);
insert into Bill  values('Udit','11:30',900,27,103);
insert into Bill  values('Vanshika','12:30',1000,27,104);
insert into Bill  values('Vineet','00:30',1200,27,201);
insert into Bill  values('Onam','01:30',1300,27,202);

select * FROM Bill;

CREATE TABLE Services(
    PickUpDrop varchar(255),
    Food varchar(255),
    RoomServices varchar(255),
    Wifi int
);
   
insert into Services  values('Car','Pizza','Clean',101);
insert into Services  values('Bike','Sandwich','Not-Clean',102);
insert into Services  values('Car','Noodle','Clean',103);
insert into Services  values('Bike','Burger','Not-Clean',104);
insert into Services  values('Car','Pasta','Clean',105);
select * from Services;

DROP TABLE Rooms3;
DROP TABLE Bill;
DROP TABLE Services;
DROP TABLE Customer;
DROP TABLE customer45;
DROP TABLE Staff;




SELECT * FROM Customer2 where Name1 Like 'v%';
SELECT * FROM Customer2 where Name1 like '%t';
SELECT * FROM Customer2 where Name1 like '%i%';

SELECT * FROM Bill where price > 1000;

SELECT * FROM Services where RoomServices ='Clean';

SELECT * FROM Services where PickUpDrop  REGEXP '^c';

SELECT * FROM Staff where Age2  like  18;

SELECT * FROM Customer2 NATURAL JOIN Bill;

SELECT * FROM Customer2 where Age > 20;

SELECT * FROM Customer2 where BloodGroup ='O+';

UPDATE Customer2
SET Age=29
WHERE Age=19;

SELECT * FROM Staff where SID1 BETWEEN 207 AND 209;

SELECT * FROM Rooms3
WHERE view1 LIKE 'b%';

SELECT * FROM Services
WHERE RoomServices <> 'Not-Clean';

SELECT Customer.Name1, Staff.Name2, Customer.Details
FROM Customer
INNER JOIN Staff
ON Customer.Age=Staff.Age2;

SELECT Customer.Name1, Staff.Name2, Customer.Details,Customer.CID,Staff.SID1
FROM Customer
LEFT JOIN Staff
ON Customer.Age=Staff.Age2;

SELECT Customer.Name1, Staff.Name2, Customer.Details,Customer.CID,Staff.SID1,Customer.Age
FROM Customer
CROSS JOIN Staff;

--To find Minimum price in Customer
SELECT MIN(price) AS SmallestPriceInCustomer
FROM Customer;

--To find Maximum price in Customer
SELECT MAX(price) AS LargestPriceInCustomer
FROM Customer; 

--To find Average price in Customer
SELECT AVG(price)
FROM customer;

--To count no. of Customer
SELECT COUNT(price)
FROM customer;

--To find sum of all prices in Customer
SELECT SUM(price)
FROM customer;

--  Minimum cost for each BloodGroup in Customer
SELECT MIN(price), BloodGroup,Name1,CID
FROM Customer
GROUP BY BloodGroup;

--  Maximum cost for each BloodGroup in Customer
SELECT MAX(price), BloodGroup,Name1,CID
FROM Customer
GROUP BY BloodGroup;

--To find price greater than 2000 and CID greater than 24 in Customer
SELECT CID,Name1,price,BloodGroup
FROM Customer
WHERE price>2000
GROUP BY BloodGroup
HAVING CID > 24;

--To find Minimum SID in Staff
SELECT MIN(SID1) AS MinSID
FROM Staff;

--To find Maximum SID in Staff
SELECT MAX(SID1) AS MaxSID
FROM Staff;

--Group by BloodGroup in Staff
SELECT Name2,SID1,BloodGroup1
FROM Staff
GROUP BY BloodGroup1;

--To find Age greater than 20 and SID1 greater than 205 in Customer
SELECT SID1,Name2,BloodGroup1
FROM Staff
WHERE Age2>20
GROUP BY BloodGroup1
HAVING SID1 > 205;

--To find Minimum rooomNo in Rooms
SELECT MIN(roomNo) AS MinRoomNumber
FROM Rooms3;

--To find Maximum roomNo in Customer
SELECT MAX(roomNo) AS MaxRoomNumber
FROM Rooms3;

--Group by view in Rooms
SELECT bed,Type1,view1
FROM Rooms3
GROUP BY view1;