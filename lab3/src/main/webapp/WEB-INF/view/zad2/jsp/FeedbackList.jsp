<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${feedbacks}" var="feedback">
    <div style="margin: 20px">
    <strong><c:out value="${feedback.name}"/></strong>
    (<c:out value="${feedback.email}"/>) says <br>
    <c:out value="${feedback.comment}"/> <br>
    </div>
</c:forEach>
