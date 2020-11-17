<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>

<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
    <title>Title</title>

<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%--TODO локализировать--%>
<%--TODO валидировать--%>
<%--TODO--%>
[TODO доделать регистрацию с занесением в базу данных]

<h1><fmt:message key="login.sign_up"/></h1>



<form action="/frontControllerServlet" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
    <input type="hidden" name="command" value="registration"/>
<%--    <h2 class="w3-center">Contact Us</h2>--%>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="login" type="text" placeholder="Login" required>
        </div>
    </div>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="email" type="text" placeholder="Email" required>
        </div>
    </div>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="password" type="text" placeholder="Password" required>
        </div>
    </div>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="first" type="text" placeholder="First Name" required>
        </div>
    </div>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="last" type="text" placeholder="Last Name" required>
        </div>
    </div>


    <button class="w3-button w3-block w3-section w3-blue w3-ripple w3-padding">Send</button>

</form>

</body>
</html>
