<%@ page import="model.MyDataBase" %>
<%@ page import="model.Item" %>
<%@ page import="java.util.List" %><%--
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
<h1>List of items</h1>
<ul>
    <%
        MyDataBase myDataBase = MyDataBase.getInstance();
        List<String> list = myDataBase.getItemsList();

        for (String item : list) {
            out.println("<li>" + item + "</li>");
        }
    %>
</ul>
<button onclick="location.href='/'">Back to main</button>
</body>
</html>
