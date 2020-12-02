<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>


<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="icon" href="../../css/images/favicon.ico" type="image/x-icon" />
</head>
<body>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<h1><fmt:message key="main.login"/></h1>

<%--TODO локализировать--%>
<h2>
    <c:if test="${ not empty errorMessage and errorMessage eq 'you need to log in' }">
        <fmt:message key="login.you_need_to_log_in"/>
    </c:if>
</h2>

<div>
    <div class="login">
        <form id="log_in" method="post">
            <input type="hidden" name="command" value="signIn"/>

            <div>
                <input type="text" name="username" placeholder="<fmt:message key="login.username"/>" value="second client">
            </div>

            <div>
                <input type="password" name="pass" placeholder="<fmt:message key="login.password"/>" value="qwerty">
            </div>

            <div>
                <button type="submit" form="log_in">
                    <fmt:message key="login.sign_in"/>
                </button>
            </div>
        </form>
        <br/>
        <div>
            <a href="?command=signUp">
                <fmt:message key="login.sign_up"/>
            </a>
        </div>
    </div>


    <p> <span class="letter">
        ${identification_error}
    </span></p>
</div>


<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>
