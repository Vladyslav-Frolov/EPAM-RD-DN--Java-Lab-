<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>



<!DOCTYPE html>
<html lang="${sessionScope.lang}">

<head>
    <title>Home page</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="css/images/favicon.ico" type="image/x-icon" />
</head>

<body>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<h1><fmt:message key="main.greetings"/></h1>

<%--request form for choosing rooms by date--%>
<%@ include file="/WEB-INF/jsp/common/room_search_form.jsp" %>

</body>
</html>

<%--footer embedding--%>
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>


