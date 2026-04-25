<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <style>
        body {
            font-family: Arial;
            background: linear-gradient(to right, #667eea, #764ba2);
        }

        .container {
            width: 350px;
            margin: 100px auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
            text-align: center;
        }

        input, button {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
        }

        button {
            background: #667eea;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background: #5a67d8;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Login</h2>

    <% String msg = request.getParameter("msg"); 
       if ("registered".equals(msg)) { %>
        <p style="color:green;">Registration successful! Please login.</p>
    <% } else if ("invalid".equals(msg)) { %>
        <p style="color:red;">Invalid username or password!</p>
    <% } %>

    <!-- 🔥 FORM -->
    <form id="loginForm" action="LoginServlet" method="post" autocomplete="off">

        <input type="text" name="username" placeholder="Username" required autocomplete="off">

        <input type="password" name="password" placeholder="Password" required autocomplete="new-password">

        <button type="submit">Login</button>

    </form>

</div>

<script>
    // 🔥 Force clear fields on load
    window.onload = function () {
        document.getElementById("loginForm").reset();
    };
</script>

</body>
</html>