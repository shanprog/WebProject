<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%
    ArrayList<String> nameList = new ArrayList<>();
    nameList.add("David");
    nameList.add("Raymond");
    nameList.add("Beth");
    nameList.add("Joyce");
    request.setAttribute("nameList", nameList);
%>

<head>
    <title>Демо базовых тегов</title>
</head>
<body>
    <c:set var="name" scope="page" value="${param.name}"/>
    <c:out value="Привет, "/>
    <c:choose>
        <c:when test="${!empty name}">
            <c:out value="${name}"/>
        </c:when>
        <c:otherwise>
            <c:out value="незнакомец!"/>
            <br/>
            <c:out value="Вам нужно имя? Вот несколько вариантов:"/>
            <br/>
            <ul>
                <c:forEach var="nameOption" items="${requestScope.nameList}">
                    <li><c:out value="${nameOption}"/></li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
    <c:remove var="name" scope="page"/>
</body>
</html>
