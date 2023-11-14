<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="scene" scope="session" type="com.example.finaleprojectmodule3.game.Scene"/>

<!DOCTYPE html>
<html>
<head>
    <title>Quest game</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/styles.css" />">
</head>

<body>
<p>${scene.text}</p>
<br>
<form>
    <c:forEach var="choice" items="${scene.choices}">
        <div>
            <input type="radio" id="choice${scene.getChoiceIndex(choice)}" name="nextScene" value="${choice.nextScene}"
                   required/>
            <label for="choice${scene.getChoiceIndex(choice)}">${choice.text}</label>
        </div>
    </c:forEach>
    <div>
        <button type="submit">Выбрать</button>
    </div>
</form>
</body>
</html>