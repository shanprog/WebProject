<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SQL Tag Demo</title>
</head>
<body>
<sql:setDataSource url="java:jboss/datasources/PostgreDataSource" user="postgres" password="njk,hfvtk"/>

<sql:transaction>
    <sql:update>
        insert into author values(
        3
        <sql:param value="${param.fNm}"/>
        <sql:param value="${param.lNm}"/>
        )
    </sql:update>
</sql:transaction>
<sql:query var="selectedRows" sql="SELECT  fio, birthday from author WHERE fio=? and birthday=?">
    <sql:param value="${param.fio}"/>
    <sql:param value="${param.birthday}"/>
</sql:query>
<table border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>ФИО</td>
        <td>Дата</td>
    </tr>
    <c:forEach var="currentRow" items="${selectedRows.rows}">
        <tr>
            <td><c:out value="${currentRow.fio}"/></td>
            <td><c:out value="${currentRow.birthday}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
