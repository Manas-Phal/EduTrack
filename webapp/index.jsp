<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
<title>EduTrack Dashboard</title>

<style>

body{
    margin:0;
    font-family:Arial, sans-serif;
    background:#f3f4f6;
}

.container{
    max-width:900px;
    margin:40px auto;
    padding:20px;
}

.title{
    text-align:center;
    color:#1e293b;
    margin-bottom:40px;
}

.stats{
    display:flex;
    gap:20px;
    margin-bottom:40px;
}

.card{
    flex:1;
    background:white;
    padding:25px;
    border-radius:12px;
    box-shadow:0 2px 8px rgba(0,0,0,0.1);
}

.card h3{
    margin:0;
    color:#64748b;
    font-size:18px;
}

.card p{
    margin-top:15px;
    font-size:32px;
    font-weight:bold;
}

.blue{
    color:#4f46e5;
}

.green{
    color:#16a34a;
}

.actions{
    text-align:center;
}

.btn{
    display:inline-block;
    text-decoration:none;
    color:white;
    padding:14px 24px;
    border-radius:8px;
    margin:10px;
    font-weight:bold;
}

.add{
    background:#16a34a;
}

.view{
    background:#4f46e5;
}

.btn:hover{
    opacity:0.9;
}

</style>
</head>

<body>

<div class="container">

    <h1 class="title">
        EduTrack Dashboard
    </h1>

    <div class="stats">

        <div class="card">

            <h3>Total Students</h3>

            <p class="blue">
                <%= request.getAttribute("count") != null ? request.getAttribute("count") : 0 %>
            </p>

        </div>

        <div class="card">

            <h3>Total Fees</h3>

            <p class="green">
                ₹ <%= request.getAttribute("totalFee") != null ? request.getAttribute("totalFee") : 0 %>
            </p>

        </div>

    </div>

    <div class="actions">

        <a href="addStudent.jsp" class="btn add">
            Add Student
        </a>

        <a href="viewStudents" class="btn view">
            View Students
        </a>

    </div>

</div>

</body>
</html>