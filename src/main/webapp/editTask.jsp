<%@ page import="Model.Task" %>

<%
Task t = (Task) request.getAttribute("task");
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Task</title>

<style>
body {
    font-family: Arial;
    background: #667eea;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.box {
    background: white;
    padding: 20px;
    border-radius: 10px;
}
</style>

</head>

<body>

<div class="box">

<h2>Edit Task</h2>

<form action="TaskServlet" method="post">

<input type="hidden" name="action" value="update">
<input type="hidden" name="id" value="<%= t.getId() %>">

<input type="text" name="title" value="<%= t.getTitle() %>"><br><br>
<input type="text" name="description" value="<%= t.getDescription() %>"><br><br>

<select name="status">
    <option <%= t.getStatus().equals("Pending") ? "selected" : "" %>>Pending</option>
    <option <%= t.getStatus().equals("InProgress") ? "selected" : "" %>>InProgress</option>
    <option <%= t.getStatus().equals("Completed") ? "selected" : "" %>>Completed</option>
</select>

<br><br>

<button type="submit">Update</button>

</form>

</div>

</body>
</html>