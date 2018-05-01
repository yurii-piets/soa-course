<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${films != null}">
    List filmów
    <table>
        <thead>
        <tr>
            <th>Tytuł</th>
            <th>Gatunek</th>
            <th>Rok</th>
            <th>Dochód</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${films}" var="film">
            <tr>
                <th><c:out value="${film.name}"/></th>
                <th <c:if test="${film.type == 'wojenny'}"> bgcolor="aqua" </c:if>> <c:out value="${film.type}"/></th>
                <th><c:out value="${film.year}"/></th>
                <th><fmt:formatNumber type="currency" currencySymbol="$" value="${film.income}"/></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
