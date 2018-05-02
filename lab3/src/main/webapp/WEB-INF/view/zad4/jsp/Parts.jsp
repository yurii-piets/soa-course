<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parts</title>
</head>
<body>

<c:import var="parts" url="http://localhost:8080/lab3/data/zad4/parts.xml"/>
<x:parse xml = "${parts}" var="output"/>

</body>
</html>
