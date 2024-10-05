#Student and Employee Management System

This project is a web application developed in Java that implements CRUD (Create, Read, Update, Delete) functionality 
for managing students, employees, attendance, meals, and complaints. It is based on an architecture that uses Java servlets, 
Data Access Objects (DAO), and JSP files for the user interface.

#Features

CRUD for Students: Add, display, update, and delete student information.
CRUD for Employees: Add, display, update, and delete employee information.
Attendance Management: Record, update, and display attendance for students and employees.
Meal Management: Record, display, and update meals consumed.
Complaint Management: Add, view, update, and delete complaints.
Revenue and Expense Tracking: Record and display financial data.
Authentication: A simple login system to secure access to administrative pages.
Project Structure

#The project is structured as follows:

Beans: Contains model classes representing the main entities such as Student, Employee, Complaint, Meal, etc.
DAO (Data Access Object): These classes handle database interactions for each entity. They allow performing CRUD operations on students, employees, attendance, etc.
Servlets: The servlets handle HTTP requests and link the user interface (JSP) with the DAO layer. Each entity has its own servlets for CRUD operations (add, delete, update, etc.).
Webapp (JSP): Contains JSP files for the user interface, organized into different subfolders based on functionality (employees, students, etc.).
