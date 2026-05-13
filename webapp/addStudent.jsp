<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<div class="form-box">

<h2>Add Student</h2>

<form action="addStudent" method="post">

<input type="text"
name="name"
placeholder="Student Name">

<input type="text"
name="course"
placeholder="Course">

<input type="number"
name="fee"
placeholder="Fee">

<button class="pay">
Add Student
</button>

</form>

</div>

</body>
</html>