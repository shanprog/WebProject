<jsp:useBean id="customer" class="beans.CustomerBean" scope="page"/>
<jsp:setProperty name="customer" property="*"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Properties JavaBean</title>
</head>
<body>
<form>
    <table cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td align="right">Имя:&nbsp;</td>
            <td>
                <input type="text" name="firstName" value='<jsp:getProperty name="customer" property="firstName"/>'>
            </td>
        </tr>
        <tr>
            <td align="right">Фамилия:&nbsp;</td>
            <td>
                <input type="text" name="lastName" value='<jsp:getProperty name="customer" property="lastName"/>'>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Отправить">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
