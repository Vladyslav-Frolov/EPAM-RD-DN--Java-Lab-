<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
    <title>Hotel</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="icon" href="../../css/images/favicon.ico" type="image/x-icon" />
</head>
<body class="main">
<div class="header-left">

    <div class="btn-group">
        <a href="?command=homePage" class="logo"><fmt:message key="navbar.logo"/></a>

        <%--language selection--%>
        <form id="lang">
            <select required name="sessionLocale" onchange="this.form.submit()">
                <option value="" hidden disabled selected>
                    ${sessionScope.lang}
                </option>
                <option value="en"><fmt:message key="label.lang.en"/></option>
                <option value="uk"><fmt:message key="label.lang.uk"/></option>
            </select>
        </form>

        <%--buttons--%>
        <%--TODO добавить смену кнопка на разлогинивание вместо кнопки залогинивания--%>
        <c:choose>
            <c:when test="${ empty user }" >
                <button form="login"><fmt:message key="navbar.login"/></button>
            </c:when>
            <c:otherwise>
                <button form="logout_"><fmt:message key="navbar.logout"/></button>
            </c:otherwise>
        </c:choose>


        <c:if test="${not empty user}">
            <button form="own_cabinet"><fmt:message key="navbar.own_cabinet"/></button>
        </c:if>
        <button form="rooms_and_price"><fmt:message key="navbar.rooms_and_price"/></button>
        <button form="main_page"><fmt:message key="navbar.main_page"/></button>


    </div>
</div>
<%--go to login page--%>
<form id="login" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="login"/>
</form>

<%--go to Main page--%>
<form id="main_page" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="homePage"/>
</form>

<%--go to personal account--%>
<form id="own_cabinet" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="ownCabinet"/>
</form>

<%--go to the numbers and prices page--%>
<form id="rooms_and_price" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="roomsAndPrice"/>
</form>

<%--log out--%>
<form id="logout_" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="logout"/>
</form>

</body>
</html>
