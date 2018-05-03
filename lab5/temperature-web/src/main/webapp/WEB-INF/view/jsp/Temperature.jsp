<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Temperature</title>
</head>
<body>
<form action="/lab5/temperature" method="post">
    <label>
        Temperature:
        <input type="number" name="temperature"/>
    </label>
    <br/>
    <label>
        Convert direction:
        <select name="direction" required>
            <option value="c2f">Celsius to fahrenheit</option>
            <option value="f2c">Fahrenheit to celsius</option>
        </select>
    </label>

    <input type="submit" value="Convert">
</form>

<c:if test="${result != null}">
    Result: <c:out value="${result}"/>
</c:if>
</body>
</html>
