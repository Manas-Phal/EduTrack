<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<div class="form-box">

<h2>Login</h2>
<img src="<%= request.getContextPath() %>/images/logo.png"
     alt="EduTrack Logo"
     width="80">

<form action="login" method="post">

<input type="text"
name="username"
placeholder="Username">

<input type="password"
name="password"
placeholder="Password">

<button class="pay">
Login
</button>

</form>

<p>${error}</p>

<a href="signup.jsp">
Create Account
</a>

</div>

</body>
</html>