<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ug" uri="/WEB-INF/view/zad1/jsp/ugly.tld" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<ug:welcome authenticated='<%= session.getAttribute("login") != null %>'/>
</body>
</html>
