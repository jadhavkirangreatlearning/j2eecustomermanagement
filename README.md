# j2eecustomermanagement
J2EE- Servlet | JSP | JDBC | JDK 1.8

Customer Management Application

Functionality->
1. signUp
2. signIn
3. getDataById
4. getDataByName
5. getDataByContactNumber
6. getDataByEmailId
7. getAllData
8. sortById
9. sortByName
10. sortByAge
11. sortByDOB
12. filterDataByAccBalance
13. updateData
14. deleteDataById
15. deleteAllData

-------------------------------------------
MVC->
M- Model[DAO]
V- View[Presentation]
C- Controller[Business]

BackEnd-> Java
model-
Customer.java
dao-
CustomerDao.java
CustomerDaoImpl.java
service-
CustomerService.java
CustomerServiceImpl.java
controller-
CustomerController.java


Database
j2eecustomermanagement
table- customer
custid custname custaddress custcontactnumber
custage custaccountbalance custgender custdob
custemailid custpassword

UI->
index.jsp
signup.jsp
signin.jsp
show.jsp
edit.jsp



----------------------------------------


-- create database j2eecustomermanagement

-- use j2eecustomermanagement

CREATE TABLE customer(custid INT, custname VARCHAR(255),
custaddress VARCHAR(255), custcontactnumber BIGINT,
custage INT,  custaccountbalance DOUBLE, 
custgender VARCHAR(255), custdob DATE,
custemailid VARCHAR(255), custpassword VARCHAR(255),
PRIMARY KEY(custid), UNIQUE KEY(custcontactnumber),
UNIQUE KEY(custemailid))

SELECT * FROM customer

DESC customer