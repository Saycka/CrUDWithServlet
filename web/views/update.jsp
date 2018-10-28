<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 28.10.2018
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CrUd App</title>
</head>
<body>
<h1>Update</h1>
<form method="post">
    <label>Id:
        <input type="number" name="id"><br/>
    </label>
    <label>Vendor code:
        <input type="text" name="vendorCode"><br/>
    </label>
    <label>Name:
        <input type="text" name="name"><br/>
    </label>
    <label>Cost:
        <input type="number" name="cost"><br/>
    </label>
    <button type="submit">Submit</button>
</form>
<button onclick="location.href='/'">Back to main</button>
</body>
</html>
