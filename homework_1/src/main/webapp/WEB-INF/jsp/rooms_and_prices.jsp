<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>


<!DOCTYPE html>
<html lang="${sessionScope.lang_var}">
<head>
    <title>Rooms and prices</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="icon" href="../../css/images/favicon.ico" type="image/x-icon" />
</head>
<body>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<h1><fmt:message key="navbar.rooms_and_price"/></h1>

<%--request form for choosing rooms by date--%>
<%@ include file="/WEB-INF/jsp/common/room_search_form.jsp" %>

<%--TODO--%>
<div>[TODO: добавить перечень номеров и скрывать его при выборке фильтра]</div>


<%--request for data entry -> TODO localization--%>
<c:if test="${not empty enter_period}">
    <fmt:message key="rooms_and_prices.enter_period"/>
</c:if>

<%--table output if parameter is not empty--%>
<c:if test="${not empty freeRoomsList}">

    <table class="table">
        <tr>
            <th><fmt:message key="free_rooms_search_result.room_number"/></th>
            <th><fmt:message key="free_rooms_search_result.room_type"/></th>
            <th><fmt:message key="free_rooms_search_result.room_class"/></th>
            <th><fmt:message key="free_rooms_search_result.days_of_stay"/></th>
            <th><fmt:message key="free_rooms_search_result.cost_per_day"/></th>
            <th><fmt:message key="free_rooms_search_result.total_price"/></th>
            <th><fmt:message key="free_rooms_search_result.booking"/></th>
        </tr>

        <c:forEach var="elem" items="${freeRoomsList}" varStatus="status">
            <tr>
                <td>
                    <c:out value="${ elem.id }"/>

                </td>
                <td><c:out value="${ elem.roomType }"/></td>
                <td><c:out value="${ elem.roomClass }"/></td>
                <td><c:out value="${ elem.daysOfStay }"/></td>
                <td><c:out value="${ elem.costPerDay }"/></td>
                <td><c:out value="${ elem.totalPrice }"/></td>
                <td>
                    <form id="to_book" action="/frontControllerServlet" method="post">
                        <input type="hidden" name="command" value="toBook"/>
                        <input type="hidden" name="commitTrue" value="commitFalse"/>
                        <input type="hidden" name="room_id" value="${ elem.id }"/>
                        <input type="hidden" name="room_type" value="${ elem.roomType }"/>
                        <input type="hidden" name="room_class" value="${ elem.roomClass }"/>
                        <input type="hidden" name="days_of_stay" value="${ elem.daysOfStay }"/>
                        <input type="hidden" name="cost_per_day" value="${ elem.costPerDay }"/>
                        <input type="hidden" name="total_price" value="${ elem.totalPrice }"/>
                        <input type="submit" name="elem_submit"
                               value="<fmt:message key="rooms_and_prices.button.to_book"/>"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</c:if>

</body>
</html>

<%--footer embedding--%>
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
