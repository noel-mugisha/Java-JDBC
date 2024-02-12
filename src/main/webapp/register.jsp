<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2/11/2024
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student registration</title>
</head>
<body>
<h2>Student Registration Form</h2>

<form action="Register" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="class">Class:</label>
    <input type="text" id="class" name="class" required><br>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
