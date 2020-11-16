<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body class="main">
<div class="header-left">


    <div class="btn-group">
        <a href="?command=homePage" class="logo"><fmt:message key="navbar.logo"/></a>

        <%--выбор языка--%>
        <form id="lang">
            <select required name="sessionLocale" onchange="this.form.submit()">
                <option value="" hidden disabled selected>
                    ${sessionScope.lang}
                </option>
                <option value="en"><fmt:message key="label.lang.en"/></option>
                <option value="uk"><fmt:message key="label.lang.uk"/></option>
            </select>
        </form>


        <%--кнопки--%>
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
<%--перейти на страницу логина--%>
<form id="login" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="login"/>
</form>

<%--перейти на главную--%>
<form id="main_page" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="homePage"/>
</form>

<%--перейти в личный кабинет--%>
<form id="own_cabinet" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="ownCabinet"/>
</form>

<%--перейти на перень номеров и цен--%>
<form id="rooms_and_price" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="roomsAndPrice"/>
</form>

<%--выйти, разлогинится --%>
<form id="logout_" action="/frontControllerServlet" method="post">
    <input type="hidden" name="command" value="logout"/>
</form>

</body>
</html>
