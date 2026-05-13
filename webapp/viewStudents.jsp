<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>

<html>
<head>
<title>Dashboard</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body>

<%@ include file="components/sidebar.jsp" %>

<div class="main">

<h1>Dashboard</h1>

<form action="viewStudents" method="get">
<input type="text" name="search" placeholder="Search student">
</form>

<div class="cards">

<div class="card">
<h3>Total Students</h3>
<h2>${count}</h2>
</div>

<div class="card">
<h3>Revenue</h3>
<h2>₹ ${totalFee}</h2>
</div>

<div class="card">
<h3>Pending</h3>
<h2>${pending}</h2>
</div>

</div>

<table>

<tr>
<th>ID</th>
<th>Name</th>
<th>Course</th>
<th>Fee</th>
<th>Status</th>
<th>Action</th>
</tr>

<%
List<String[]> list=(List<String[]>)request.getAttribute("data");

for(String[] row:list){
%>

<tr>

<td><%=row[0]%></td>
<td><%=row[1]%></td>
<td><%=row[2]%></td>
<td>₹ <%=row[3]%></td>
<td><%=row[4]%></td>

<td>
<a class="btn edit"
href="editStudent?id=<%=row[0]%>">
Edit
</a>

<a class="btn delete"
href="deleteStudent?id=<%=row[0]%>">
Delete
</a>

<a class="btn pay"
href="payStudent?id=<%=row[0]%>">
Pay
</a>
</td>

</tr>

<% } %>

</table>

<div class="chart-box">
<canvas id="pieChart"></canvas>
</div>

</div>

<script>

var labels=[];
var data=[];

<%
Map<String,Integer> map=
(Map<String,Integer>)request.getAttribute("courseFees");

for(String k:map.keySet()){
%>

labels.push("<%=k%>");
data.push(<%=map.get(k)%>);

<% } %>

new Chart(document.getElementById("pieChart"),{
type:'pie',
data:{
labels:labels,
datasets:[{
data:data
}]
}
});

</script>

</body>
</html>