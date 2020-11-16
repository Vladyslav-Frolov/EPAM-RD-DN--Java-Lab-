<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>

<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">

<head>
    <title>Error page 404</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
    </style>
</head>

<body>
<fmt:message key="label.error_404"/>


<form action="/frontControllerServlet" method="post">
    <button class="design" name="command" value="homePage"><fmt:message key="label.homePage"/></button>
</form>


<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>
