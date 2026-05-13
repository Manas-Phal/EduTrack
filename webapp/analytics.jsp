<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>

<html>
<head>
<meta charset="UTF-8">
<title>Analytics</title>

<link rel="stylesheet"
href="<%= request.getContextPath() %>/css/style.css">

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body>

<%@ include file="components/sidebar.jsp" %>

<div class="main">

    <%@ include file="components/navbar.jsp" %>

    <h1>Analytics Dashboard</h1>

    <!-- chart buttons -->
    <div style="margin-bottom:20px;">

        <button onclick="showChart('pie')">
            Course Distribution
        </button>

        <button onclick="showChart('bar')">
            Student Count
        </button>

        <button onclick="showChart('doughnut')">
            Payment Status
        </button>

    </div>

    <!-- chart area -->
    <div class="chart-box">
        <canvas id="mainChart"></canvas>
    </div>

</div>

<!-- DATA FOR charts.js -->
<script>

const courseLabels = [];
const courseData = [];

<%
Map<String,Integer> map =
(Map<String,Integer>) request.getAttribute("courseMap");

if(map != null){
    for(String k : map.keySet()){
%>

courseLabels.push("<%= k %>");
courseData.push(<%= map.get(k) %>);

<%
    }
}
%>

const paid =
<%= request.getAttribute("paid") != null
? request.getAttribute("paid")
: 0 %>;

const pending =
<%= request.getAttribute("pending") != null
? request.getAttribute("pending")
: 0 %>;

</script>

<!-- your external JS -->
<script src="js/charts.js"></script>

</body>
</html>