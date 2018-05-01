<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/lab3/zad3_rand" method="post">
    Podaj liczbę <input type="number" name="number">
    <input type="submit" value="Zgadnij">
</form>

<c:if test="${compare != null}">
    <c:choose>
        <c:when test="${compare == 0}">
            Brawo, zgadnąłeś po <c:out value="${guess}"/>
        </c:when>
        <c:when test="${compare >= 1}">
            Twoja liczba (<c:out value="${number}"/>) jest większa.
        </c:when>
        <c:when test="${compare <= -1}">
            Twoja liczba (<c:out value="${number}"/>) jest mniejsza.
        </c:when>
    </c:choose>
</c:if>
</body>
</html>
