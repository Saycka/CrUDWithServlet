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

<h1>Add user</h1>

<form method="post">
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
<%
    String item = (String) request.getAttribute("item");
    if(item != null && !item.isEmpty()) {
        out.print("<p>item: " + item + " was added</p>");
    }
%>
<button onclick="location.href='/'">Back to main</button>
</body>
</html>
