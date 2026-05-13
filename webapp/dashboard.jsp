<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<%@ include file="components/sidebar.jsp" %>

<div class="main">

<%@ include file="components/navbar.jsp" %>

<h1>Welcome to EduTrack</h1>

<div class="cards">

<div class="card">
<h3>Total Students</h3>
<h2>${count}</h2>
</div>

<div class="card">
<h3>Total Revenue</h3>
<h2>₹ ${totalFee}</h2>
</div>

</div>

<div style="margin-top:20px;">

<a href="addStudent.jsp" class="btn pay">
Add Student
</a>

<a href="viewStudents" class="btn edit">
View Students
</a>

</div>

</div>

</body>
</html>