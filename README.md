# 🎓 EduTrack – Student Management System (JSP + JDBC)

EduTrack is a **Student Management Web Application** built using **Java JSP, Servlets, JDBC, and MySQL**.  
It helps tuition classes and educational institutes manage student records, fee payments, and analytics through a simple dashboard interface.

---

## 🚀 Features

### 🔐 Authentication
- User Signup
- User Login
- Secure Logout

### 👨‍🎓 Student Management
- Add new student
- View all students
- Search students
- Edit student details
- Delete student records

### 💳 Payment Management
- Track paid students
- Track pending payments
- Calculate total revenue
- Mark fee status

### 📊 Analytics Dashboard
- Course-wise student distribution
- Student count visualization
- Payment status charts
- Revenue insights using Chart.js

### 🎨 Clean UI
- Sidebar navigation
- Dashboard cards
- Responsive layout
- Custom CSS styling

---

## 🛠️ Tech Stack

### Frontend
- JSP (Java Server Pages)
- HTML
- CSS
- JavaScript
- Chart.js

### Backend
- Java Servlets
- JDBC

### Database
- SQLite

### Server
- Apache Tomcat

### IDE
- IntelliJ IDEA

---

## 📂 Project Structure

```text
EduTrack/
│
├── src/
│   ├── LoginServlet.java
│   ├── SignupServlet.java
│   ├── LogoutServlet.java
│   ├── ViewStudentsServlet.java
│   ├── AddStudentServlet.java
│   ├── EditStudentServlet.java
│   ├── UpdateStudentServlet.java
│   ├── DeleteStudentServlet.java
│   ├── AnalyticsServlet.java
│   ├── PaymentsServlet.java
│   ├── DBConnection.java
│   └── LoginDBConnection.java
│
├── web/
│   ├── login.jsp
│   ├── signup.jsp
│   ├── dashboard.jsp
│   ├── addStudent.jsp
│   ├── editStudent.jsp
│   ├── viewStudents.jsp
│   ├── analytics.jsp
│   ├── payments.jsp
│   ├── components/
│   │   ├── sidebar.jsp
│   │   └── navbar.jsp
│   ├── css/
│   │   └── style.css
│   └── js/
│       └── charts.js
│
└── WEB-INF/
    └── web.xml
```

---

## ⚙️ Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/yourusername/edutrack.git
```

---

### 2. Open in IntelliJ IDEA

Import as **Java Web Project**.

---

### 3. Setup MySQL Database

Create database:

```sql
CREATE DATABASE edutrack;
```

Create **users** table:

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);
```

Create **students** table:

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    course VARCHAR(100),
    fee INT,
    status VARCHAR(20)
);
```

---

### 4. Update Database Credentials

Inside:

```java
DBConnection.java
LoginDBConnection.java
```

Update:

```java
username = "root";
password = "yourpassword";
```

---

### 5. Configure Apache Tomcat

Add Tomcat server in IntelliJ and deploy project.

---

### 6. Run Project

Open browser:

```text
http://localhost:8080/EduTrack
```

---

## 📸 Screens Included

- Login Page
  <img width="728" height="458" alt="image" src="https://github.com/user-attachments/assets/0e7431ce-42c0-425f-9576-342a15bab418" />

- Signup Page
  <img width="706" height="495" alt="image" src="https://github.com/user-attachments/assets/161c84a4-eb86-458e-b4b1-31baf5fcebcc" />

- Analytics Dashboard
  <img width="940" height="459" alt="image" src="https://github.com/user-attachments/assets/532a508f-7404-4151-9ff1-f887ad3067ce" />
  <img width="940" height="361" alt="image" src="https://github.com/user-attachments/assets/aad8da67-2c1b-48da-b427-09c9afc128ba" />
  <img width="940" height="369" alt="image" src="https://github.com/user-attachments/assets/ddc987e3-571b-484f-ba45-9c3be558816f" />

- Student Records
  <img width="963" height="521" alt="image" src="https://github.com/user-attachments/assets/a704550e-97b6-49b2-a559-deaac5807c85" />


- Payment Management
  <img width="963" height="521" alt="image" src="https://github.com/user-attachments/assets/07e69cb3-37c8-4bf3-8d88-84fa75a44185" />


---
## 📌 Future Improvements

- Export reports to PDF
- Email notifications
- Attendance management
- Role-based admin access
- Cloud deployment

---

## ⭐ Project Purpose

Built as an academic project to practice:

- JSP
- Servlets
- JDBC
- MySQL
- MVC architecture
- CRUD operations
- Dashboard UI design

---
