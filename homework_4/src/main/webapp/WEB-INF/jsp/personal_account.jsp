<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>

<c:set var="refresh" value="${15*60}"/>
<c:set var="timeshift" value="<%=new java.util.Date(new java.util.Date().getTime() + 15*60*1000)%>"/>
<c:set var="fiftyminute" scope="page">
    <%--TODO вытащить месяц в английской локализации при помощи формата--%>
    Dec <fmt:formatDate pattern="dd, YYYY kk:mm:ss" value="${timeshift}"/>
</c:set>


<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
    <title>Own cabinet</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="icon" href="../../css/images/favicon.ico" type="image/x-icon" />
    <meta http-equiv="refresh" content="${refresh}"/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<h1><fmt:message key="login.personal_account"/></h1>

<p>${user.firstName}, hello!</p>
<p>${user.role}</p>
<c:if test="${ commitTrue eq 'commitFalse' and not empty session_room_id}">
    <h3>Ваш заказ сформированный, но не отправленный до входа в личный кабинет (требует отправки):</h3>

    <table class="table">
        <tr>
            <th><fmt:message key="free_rooms_search_result.room_number"/></th>
            <th><fmt:message key="free_rooms_search_result.room_type"/></th>
            <th><fmt:message key="free_rooms_search_result.room_class"/></th>
            <th><fmt:message key="fetch_free_rooms.check_in_date"/></th>
            <th><fmt:message key="fetch_free_rooms.check_out_date"/></th>
            <th><fmt:message key="free_rooms_search_result.days_of_stay"/></th>
            <th><fmt:message key="free_rooms_search_result.cost_per_day"/></th>
            <th><fmt:message key="free_rooms_search_result.total_price"/></th>
            <th><fmt:message key="free_rooms_search_result.to_send"/></th>
        </tr>
        <tr>
            <td>${sessionScope.session_room_id}</td>
            <td>${sessionScope.session_room_type}</td>
            <td>${sessionScope.session_room_class}</td>
            <td>${sessionScope.session_check_in_date}</td>
            <td>${sessionScope.session_check_out_date}</td>
            <td>${sessionScope.session_days_of_stay}</td>
            <td>${sessionScope.session_cost_per_day}</td>
            <td>${sessionScope.session_total_price}</td>
            <td>
                <form id="toBook_from_cabinet" action="/frontControllerServlet" method="post">
                    <input type="hidden" name="command" value="toBook"/>
                    <input type="submit" value="<fmt:message key="free_rooms_search_result.to_send"/>"/>
<%----%>
                </form>
            </td>
        </tr>
<%----%>
    </table>
</c:if>






<h3>Ваши заказы</h3>
<div align="center" style="font-size:14px"><fmt:message key="free_rooms_search_result.page_refresh"/> <span
        align="right" id="demo" style="font-size:14px"></span></div>
<span></span>


<c:if test="${not empty ordersOfUsers}">

    <table class="table">

        <tr>
            <th><fmt:message key="free_rooms_search_result.number_in_order"/></th>
            <th><fmt:message key="free_rooms_search_result.room_number"/></th>
            <th><fmt:message key="free_rooms_search_result.room_type"/></th>
            <th><fmt:message key="free_rooms_search_result.room_class"/></th>
            <th><fmt:message key="fetch_free_rooms.check_in_date"/></th>
            <th><fmt:message key="fetch_free_rooms.check_out_date"/></th>
            <th><fmt:message key="free_rooms_search_result.days_of_stay"/></th>
            <th><fmt:message key="free_rooms_search_result.cost_per_day"/></th>
            <th><fmt:message key="free_rooms_search_result.total_price"/></th>
            <th><fmt:message key="free_rooms_search_result.status"/></th>
            <th><fmt:message key="personal_account_table.refresh"/></th>
        </tr>

        <c:forEach var="elem" items="${ordersOfUsers}" varStatus="status">
            <tr>
                <td><c:out value="${ status.count }"/></td>
                <td><c:out value="${ elem.roomId }"/></td>
                <td><c:out value="${ elem.roomType }"/></td>
                <td><c:out value="${ elem.roomClass }"/></td>
                <td>
                    <fmt:parseDate value="${elem.checkIn}"
                                   var="parsedDatetime" pattern="yyyy-MM-dd" />
                    <fmt:formatDate pattern="dd.MM.yyyy" value="${parsedDatetime}"/>
                </td>
                <td>
                    <fmt:parseDate value="${elem.checkOut}"
                                   var="parsedDatetime" pattern="yyyy-MM-dd" />
                    <fmt:formatDate pattern="dd.MM.yyyy" value="${parsedDatetime}"/>
                </td>
                <td><c:out value="${ elem.days }"/></td>
                <td><c:out value="${ elem.costPerDay }"/></td>
                <td><c:out value="${ elem.totalPrice }"/></td>
                <td>
                    <c:set var="status" scope="page">
                        <c:out value="${ elem.orderStatus.name }"/>
                    </c:set>
                    <c:choose>
                        <c:when test="${ status eq 'unavailable' }">
                            <fmt:message key="personal_account_table.under_consideration"/>
                        </c:when>
                        <c:when test="${ status eq 'expired' }">
                            <fmt:message key="personal_account_table.application_rejected"/>
                        </c:when>
                        <c:when test="${ status eq 'booked' }">
                            <fmt:message key="personal_account_table.booked"/>
                        </c:when>
                        <c:when test="${ status eq 'occupied' }">
                            <fmt:message key="personal_account_table.occupied"/>
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="personal_account_table.done"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <button value="Refresh Page" onClick="history.go(0);"><fmt:message
                            key="personal_account_table.refresh"/></button>
                </td>
            </tr>
        </c:forEach>
    </table>

</c:if>


<script>
    // Set the date we're counting down to
    var countDownDate = new Date("${fiftyminute}").getTime();

    // Update the count down every 1 second
    var countdownfunction = setInterval(function () {

        // Get todays date and time
        var now = new Date().getTime();

        // Find the distance between now an the count down date
        var distance = countDownDate - now;

        // Time calculations for days, hours, minutes and seconds
        var days = Math.floor(distance / (1000 * 60 * 60 * 24));
        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);

        // Output the result in an element with id="demo"
        document.getElementById("demo").innerHTML =
            // days + "d " + hours + "h " +
            minutes + "<fmt:message key="free_rooms_search_result.minutes"/> " + seconds + "<fmt:message key="free_rooms_search_result.seconds"/> ";

        // If the count down is over, write some text
        if (distance < 0) {
            clearInterval(countdownfunction);
            document.getElementById("demo").innerHTML = "EXPIRED";
        }
    }, 1000);
</script>
</body>
</html>

<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>