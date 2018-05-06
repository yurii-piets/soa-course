<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<style>
    form {
        display: inline;
    }
</style>
<body>
<c:forEach items="${books}" var="book">
    <h1><c:out value="${book.title}"/></h1>
    (<c:out value="${book.author}"/>)
    <div style="display: block">
        <form action="/lab6/library" method="post">
            <input type="hidden" name="isbn" value="<c:out value="${book.isbn}"/>"/>
            <input type="hidden" name="operation" value="reserve"/>
            <input type="submit" value="Reserve" <c:if test="${book.reserved || book.rented}">disabled</c:if>/>
        </form>
        <form action="/lab6/library" method="post">
            <input type="hidden" name="isbn" value="<c:out value="${book.isbn}"/>"/>
            <input type="hidden" name="operation" value="rent"/>
            <input type="submit" value="Rent" <c:if test="${book.reserved || book.rented}">disabled</c:if>/>
        </form>
        <form action="/lab6/library" method="post">
            <input type="hidden" name="isbn" value="<c:out value="${book.isbn}"/>"/>
            <input type="hidden" name="operation" value="retrieve"/>
            <input type="submit" value="Retrieve" <c:if test="${!book.rented && !book.reserved}">disabled</c:if>/>
        </form>
    </div>
</c:forEach>
<c:if test="${error != null}">
    Error:
    <div style="color: red"><c:out value="${error}"/></div>
</c:if>
</body>
</html>
