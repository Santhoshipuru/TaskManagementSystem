<%@ page import="java.util.List" %>
<%@ page import="Model.Task" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Tasks</title>

<style>
    body {
        font-family: Arial;
        background: linear-gradient(135deg, #43cea2, #185a9d);
        min-height: 100vh;
        margin: 0;
        padding: 30px;
    }

    h2 {
        text-align: center;
        color: white;
        margin-bottom: 30px;
    }

    .task-container {
        max-width: 700px;
        margin: auto;
    }

    .task {
        background: white;
        padding: 15px;
        margin: 15px 0;
        border-radius: 10px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        position: relative;
    }

    .title {
        font-size: 20px;
        font-weight: bold;
    }

    .desc {
        color: #555;
        margin-top: 5px;
    }

    .status {
        margin-top: 8px;
        font-weight: bold;
        color: #333;
    }

    .delete-btn {
        position: absolute;
        right: 15px;
        top: 15px;
        background: #e53e3e;
        color: white;
        padding: 6px 12px;
        text-decoration: none;
        border-radius: 6px;
        font-size: 13px;
    }

    .delete-btn:hover {
        background: #c53030;
    }

    .no-task {
        color: white;
        text-align: center;
        font-size: 18px;
    }

    .add-btn {
        display: block;
        width: 200px;
        margin: 30px auto;
        text-align: center;
        background: white;
        padding: 10px;
        border-radius: 8px;
        text-decoration: none;
        color: #333;
        font-weight: bold;
    }

    .add-btn:hover {
        background: #ddd;
    }
    .edit-btn {
    position: absolute;
    right: 80px;
    top: 15px;
    background: #3182ce;
    color: white;
    padding: 6px 12px;
    text-decoration: none;
    border-radius: 6px;
    font-size: 13px;
}
.logout-btn {
    position: absolute;
    top: 20px;
    right: 30px;
    background: red;
    color: white;
    padding: 8px 15px;
    border-radius: 6px;
    text-decoration: none;
}

.logout-btn:hover {
    background: darkred;
}

.edit-btn:hover {
    background: #2b6cb0;
}

/* STATUS COLORS */
.pending {
    color: orange;
}

.progress {
    color: blue;
}

.completed {
    color: green;
}
</style>
</head>

<body>

<h2>Task List</h2>
<a href="LogoutServlet" class="logout-btn">Logout</a>

<div class="task-container">

<%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");

    if (tasks != null && !tasks.isEmpty()) {
        for (Task t : tasks) {
%>

    <div class="task">

    <!-- DELETE -->
    <a class="delete-btn" href="TaskServlet?action=delete&id=<%= t.getId() %>">Delete</a>

    <!-- EDIT -->
    <a class="edit-btn" href="TaskServlet?action=edit&id=<%= t.getId() %>">Edit</a>


    <div class="title"><%= t.getTitle() %></div>
    <div class="desc"><%= t.getDescription() %></div>

    <div class="status 
        <%= t.getStatus().equals("Pending") ? "pending" : 
            t.getStatus().equals("InProgress") ? "progress" : "completed" %>">
        Status: <%= t.getStatus() %>
    </div>

</div>

<%
        }
    } else {
%>

    <p class="no-task">
        No tasks found 😢
    </p>

<%
    }
%>

</div>

<a href="addTask.html" class="add-btn">+ Add New Task</a>

</body>
</html>