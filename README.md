CustomerManagementSystem
-------------------------
Overview
This project is a simple Customer Management System (CRUD application) built with Spring Boot for the backend and HTML/JavaScript for the frontend.
It includes JWT authentication for secure user access.


Features
-----------
Authentication: JWT-based authentication for secure login and session management.

Customer CRUD: Allows creating, reading, updating, and deleting customer records.

Pagination and Sorting: API supports pagination, sorting, and searching functionalities.

Frontend: Basic HTML interface with forms for login and customer management.


Project Structure
....................
Backend: Built with Spring Boot, includes controllers, services, filters, and security configurations.
Frontend: Uses plain HTML and JavaScript to interact with backend APIs.
Database: MySQL database used for storing customer information.

Setup Instructions
-------------------
Database Configuration:
-----------------------
Set up MySQL database. Update application.properties with database credentials.
Backend Setup:
---------------
Import the project into your IDE.
Run the Spring Boot application (CustomersApplication.java).

Frontend Setup:
----------------
Place the HTML files in a web server directory or use a local server like Tomcat.
Access the frontend pages (log.html for login, customers.html for customer list).


Usage:
------
Navigate to http://localhost:8080/log.html to access the login page.
Use the provided credentials to log in and manage customers.
Technologies Used
Backend: Java, Spring Boot, Spring Security, JWT, MySQL.
--------
Frontend: HTML, CSS, JavaScript.
--------


Contributor
------------
Arvapalli Ramprasad


