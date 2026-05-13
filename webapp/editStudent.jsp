<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<div class="form-box">

<h2>Edit Student</h2>

<form action="updateStudent" method="post">

<input type="hidden" name="id" value="${id}">

<input
type="text"
name="name"
value="${name}"
>

<input
type="text"
name="course"
value="${course}"
>

<input
type="number"
name="fee"
value="${fee}"
>

<button class="pay">
Update Student
</button>

</form>

</div>

</body>
</html>