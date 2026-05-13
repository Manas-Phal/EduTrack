<%@ page import="java.util.*" %>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>

<%@ include file="components/sidebar.jsp" %>

<div class="main">

<h1>Payments</h1>

<div class="cards">

<div class="card">
<h3>Paid</h3>
<h2>${paidCount}</h2>
</div>

<div class="card">
<h3>Pending</h3>
<h2>${pendingCount}</h2>
</div>

<div class="card">
<h3>Revenue</h3>
<h2>₹ ${revenue}</h2>
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
List<String[]> list=
(List<String[]>)request.getAttribute("payments");

for(String[] row:list){
%>

<tr>

<td><%=row[0]%></td>
<td><%=row[1]%></td>
<td><%=row[2]%></td>
<td>₹ <%=row[3]%></td>
<td><%=row[4]%></td>

<td>
<a class="btn pay"
href="payStudent?id=<%=row[0]%>">
Mark Paid
</a>
</td>

</tr>

<% } %>

</table>

</div>

</body>
</html>