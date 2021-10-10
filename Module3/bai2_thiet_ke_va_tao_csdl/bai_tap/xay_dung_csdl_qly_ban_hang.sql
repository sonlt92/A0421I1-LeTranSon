create database QuanLyBanHang;

use QuanLyBanHang;

create table Customer(
cID int primary key,
cName varchar(40),
cAge int
);

create table `Order`(
oID int primary key,
cID int,
oDate datetime,
oTotalPrice int,
foreign key (cID) references Customer(cID)
);

create table OrderDetail(
oID int primary key,
pID int,
odQTY varchar(40),
foreign key (oID) references `Order`(oID),
foreign key (pID) references Product(pID)
);

create table Product(
pID int primary key,
pName varchar(40),
pPrice int
);