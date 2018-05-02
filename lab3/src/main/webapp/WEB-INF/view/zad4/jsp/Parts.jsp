<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parts</title>
</head>
<body>

<c:import var="parts" url="http://localhost:8080/lab3/data/zad4/parts.xml"/>
<x:parse xml="${parts}" var="output"/>

<x:forEach select="$output/parts/part" var="item">
    <div style="margin: 20px">
        Przedmiot: <x:out select="$item/name"/><br>
        Cena: <x:out select="$item/price"/><br>
        <form method="post" action="/lab3/zad4_parts">
            <input type="hidden" name="id" value="<x:out select="$item/@id"/>"/>
            <input type="hidden" name="amount" value="1"/>
            <input type="submit" value="Add to cart"/>
        </form>
    </div>
</x:forEach>

<div style="margin: 20px">
    <form method="get" action="/lab3/zad4_cart">
        <input type="submit" value="Go to cart"/>
    </form>
</div>

</body>
</html>
