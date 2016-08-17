<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Demo custom tag</title>
</head>
<body>
<form>
    <h3>Адрес доставки</h3>
    <ct:customtag addressType="shipping" />
</form>
</body>
</html>
