<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>

<c:import var="parts" url="http://localhost:8080/lab3/data/zad4/parts.xml"/>
<x:parse xml="${parts}" var="output"/>

<c:forEach items="${cart}" var="part">
    <c:set var="idSelector" value="@id=${part.key}"/>
    Name: <x:out select="$output/parts/part[$idSelector]/name"/><br>
    Price: <x:out select="$output/parts/part[$idSelector]/price"/><br>
    Amount: <c:out value="${part.value}"/><br>
    <form action="/lab3/zad4_cart" method="post">
        <input type="hidden" name="type" value="inc"/>
        <input type="hidden" name="id" value="<x:out select="$output/parts/part[$idSelector]/@id"/>"/>
        <input type="submit" value="Increment"/>
    </form>
    <form action="/lab3/zad4_cart" method="post">
        <input type="hidden" name="type" value="dec"/>
        <input type="hidden" name="id" value="<x:out select="$output/parts/part[$idSelector]/@id"/>"/>
        <input type="submit" value="Decrement" <c:if test="${part.value < 1}">disabled</c:if>/>
    </form>
    <form action="/lab3/zad4_cart" method="post">
        <input type="hidden" name="type" value="clr"/>
        <input type="hidden" name="id" value="<x:out select="$output/parts/part[$idSelector]/@id"/>"/>
        <input type="submit" value="Delete" <c:if test="${part.value < 1}">disabled</c:if>/>
    </form>
</c:forEach>

<div style="margin: 20px">
    <form method="get" action="/lab3/zad4_parts">
        <input type="submit" value="Go to parts"/>
    </form>
</div>

</body>
</html>
