<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Дата и время сервера</title>
</head>
<body>
<p>Дата и время сервера: <% out.println(new Date()); %></p>
</body>
</html>
