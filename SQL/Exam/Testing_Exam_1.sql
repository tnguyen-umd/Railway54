DROP DATABASE IF EXISTS RDBMS;
CREATE DATABASE IF NOT EXISTS RDBMS;
USE RDBMS;

## CREATE TABLE Customer
DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer (
	customerID INT AUTO_INCREMENT KEY,
	name VARCHAR(50),
	phone INT,
	email VARCHAR(50),
	address VARCHAR(50),
	note VARCHAR(50)
);
insert into Customer (name, phone, email, address, note) values ( 'Aigneis', 88, 'ataberner0@mysql.com', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Lazare', 63, 'ljakab1@mayoclinic.com', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Sallie', 7, 'sbeininck2@tuttocitta.it', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Maisie', 63, 'mflatt3@e-recht24.de', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Rolfe', 58, 'rmatzaitis4@ucsd.edu', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Amity', 29, 'agrovier5@sourceforge.net', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Catina', 94, 'cure6@purevolume.com', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Lizbeth', 57, 'lgrills7@sphinn.com', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Minnnie', 7, 'mfrancisco8@bloglines.com', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Maura', 9, 'mcastille9@hatena.ne.jp', '', '');
insert into Customer (name, phone, email, address, note) values ( 'Emeline', 63, 'eakasta@ucla.edu', '', '');

## CREATE TABLE Order
DROP TABLE IF EXISTS Car;
create table Car (
	CarID INT AUTO_INCREMENT PRIMARY KEY,
	Maker ENUM ('Honda','Toyota','Nissan'),
	Model VARCHAR(50),
	`Year` VARCHAR(50),
	Color VARCHAR(50),
	Note VARCHAR(50)
);
insert into Car (Maker, Model, Year, Color, Note) values ( 'Honda', 'Blazer', 1996, 'Black', 'Note1');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Toyota', 'S-Class', 2001, 'White', 'Note2');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Toyota', 'GTO', 1990, 'Yellow', 'Note3');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Toyota', 'E250', 2003, 'Red', 'Note4');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Nissan', 'Ram Wagon B350', 1994, 'Black', 'Note5');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Nissan', 'Golf', 1995, 'White', 'Note6');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Nissan', 'Esprit', 1995, 'Yellow', 'Note7');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Honda', 'Express 2500', 2011, 'Red', 'Note8');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Nissan', 'V12 Vantage', 2011, 'White', 'Note9');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Honda', 'Blazer', 2002, 'Black', 'Note10');
insert into Car ( Maker, Model, Year, Color, Note) values ( 'Honda', 'Impala', 1996, 'White', 'Note11');

## CREATE TABLE Order
DROP TABLE IF EXISTS `Order`;
create table `Order` (
	OrderID INT AUTO_INCREMENT PRIMARY KEY,
	CustomerID INT,
	CarID INT,
	Amount INT DEFAULT 1,
	SalePrice INT,
	OrderDate DATE,
	DeliveryDate DATE,
	DeliveryAddress VARCHAR(50),
	`Status` ENUM ('Ordered','Delivered','Cancelled') DEFAULT 'Cancelled',
	Note VARCHAR(50),
	FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (CarID) REFERENCES Car(CarID)
);
insert into `Order` ( CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) 

values 
( 1, 1, 35, 68, '2022-04-26', '2022-07-21', '', 'Ordered', ''),
( 2, 2, 20, 49, '2022-05-07', '2022-04-25', '', 'Ordered', ''),
( 3, 3, 65, 34, '2022-05-01', '2021-11-14', '', 'Ordered', ''),
( 4, 4, 94, 99, '2022-04-07', '2021-12-15', '', 'Cancelled', ''),
( 5, 5, 37, 56, '2022-04-26', '2022-05-30', '', 'Delivered', ''),
( 6, 6, 91, 35, '2022-02-26', '2022-08-03', '', 'Delivered', ''),
( 7, 7, 94, 20, '2022-05-20', '2021-10-02', '', 'Delivered', ''),
( 8, 8, 46, 31, '2022-06-08', '2022-05-07', '', 'Cancelled', ''),
( 9, 9, 93, 79, '2022-05-29', '2022-07-18', '', 'Cancelled', ''),
( 10, 10, 8, 31, '2021-10-02', '2022-06-21', '', 'Cancelled', ''),
( 11, 11, 35, 11, '2022-06-30', '2021-10-11', '', 'Cancelled', '');
