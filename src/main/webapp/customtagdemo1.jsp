<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" uri="DemoTagLibrary" %>
<html>
<head>
    <title>Demo custom tag</title>
</head>
<body>
<form>
    <table>
        <d:labeledTextField label="Улица 1" name="line1" value="Где эта улица где этот дом" />
        <d:labeledTextField label="Улица 2" name="line2" />
        <d:labeledTextField label="Город" name="city" />
        <d:labeledTextField label="Штат" name="state" />
        <d:labeledTextField label="Zip код" name="zip" />
        <tr>
            <td></td>
            <td><input type="submit" value="Send"> </td>
        </tr>
    </table>
</form>
</body>
</html>
