<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>


<!DOCTYPE html>
<html lang="${sessionScope.lang}">

<head>
    <title>Error page 404</title>
    <link rel="stylesheet" href="../../../css/style.css">
    <link rel="icon" href="../../../css/images/favicon.ico" type="image/x-icon" />
    <style>
    </style>
</head>

<body>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<fmt:message key="label.error_404"/>


<form action="/frontControllerServlet" method="post">
    <button class="design" name="command" value="homePage"><fmt:message key="label.homePage"/></button>
</form>


<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>
