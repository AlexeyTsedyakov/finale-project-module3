<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="scene" scope="session" type="com.example.finaleprojectmodule3.game.Scene"/>

<!DOCTYPE html>
<html>
<head>
    <title>Quest game - end</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/styles.css" />">
</head>

<body>
<c:if test="${sessionScope.isDeath}">
    <h1>Конец игры!</h1>
</c:if>
<c:if test="${sessionScope.isWin}">
    <h1>Победа!</h1>
</c:if>
<p>${scene.text}</p>
<br>
<button onclick="window.location='/restart'">Начать заново</button>
</body>
</html>