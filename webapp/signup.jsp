<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<div class="form-box">

<h2>Create Account</h2>
<img src="<%= request.getContextPath() %>/images/logo.png"
     alt="EduTrack Logo"
     width="80">

<form action="signup" method="post">

<input
type="text"
name="username"
placeholder="Username"
>

<input
type="password"
name="password"
placeholder="Password"
>

<button class="pay">
Signup
</button>

</form>

<br>

<a href="login.jsp">
Back to Login
</a>

</div>

</body>
</html>