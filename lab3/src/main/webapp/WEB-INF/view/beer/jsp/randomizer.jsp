<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="/lab3/randomizer" method="post">
    <label>Podaj liczbe:</label>
    <input type="text" label="number">
    <input type="submit" name="signup" value="Guess">
</form>
<jsp:useBean id="randomizer"
             class="com.soa.randomizer.model.RandomizerBean" scope="session"/>
<c:choose>
    <c:when test="${number < randomizer.number}">
        Liczba jest mniejsza ${number}
    </c:when>
    <c:when test="${number > randomizer.number}">
        Liczba jest mniejsza ${number}
    </c:when>
    <c:when test="${number == randomizer.number}">
        Wygrales
    </c:when>
</c:choose>
</body>
</html>