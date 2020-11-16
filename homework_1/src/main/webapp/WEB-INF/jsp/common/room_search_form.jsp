<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>

<c:set var="today" value="<%=new java.util.Date()%>"/>
<c:set var="timeshift" value="<%=new java.util.Date(new java.util.Date().getTime() + 60*60*24*1000)%>"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang_var}">
<head>
    <title>Room search form</title>
</head>
<body>
<%--TODO дописать валидацию выбора дат через JSTL--%>
<%--TODO--%>
<div>[TODO: дабавить в выборку условие по количеству людей (пока выборка происходит только по датам)]</div>

<%--форма запроса на выбор номеров по дате--%>
<div id="nav_menu">
    <form id="free_rooms_list" action="/frontControllerServlet" method="post">
        <input type="hidden" name="command" value="fetchRooms"/>
        <table id="choose">
            <tr>
                <td><fmt:message key="fetch_free_rooms.check_in_date"/></td>
                <td><fmt:message key="fetch_free_rooms.check_out_date"/></td>
                <td><fmt:message key="fetch_free_rooms.adults"/></td>
                <td><fmt:message key="fetch_free_rooms.children"/></td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <input id="date_in" name="check_in_date" type="date" required
                           min="<fmt:formatDate pattern="yyyy-MM-dd" value="${today}" />"
                           value="<fmt:formatDate pattern="yyyy-MM-dd" value="${today}" />"
                    />
                </td>
                <td>
                    <input id="date_out" name="check_out_date" type="date" required
                           min="<fmt:formatDate pattern="yyyy-MM-dd" value="${timeshift}" />"
                           value="<fmt:formatDate pattern="yyyy-MM-dd" value="${timeshift}" />"
                    />
                </td>
                <td><input id="adults_" name="adults" type="number" min="1" max="3" step="1" value="1" required/></td>
                <td><input id="children_" name="children" type="number" min="0" max="2" step="1" value="0" required/>
                </td>
                <td>
                    <button class="design" type="submit">
                        <fmt:message key="fetch_free_rooms.button.choose.period"/>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
