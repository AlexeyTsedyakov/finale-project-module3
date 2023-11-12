<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="currentScene" scope="session" type="com.example.finaleprojectmodule3.game.Scene"/>

<!DOCTYPE html>
<html>
<head>
    <title>Quest game</title>
</head>
<body>
<h2>${currentScene.text}</h2>
<form>
    <c:forEach var="choice" items="${currentScene.choices}">
        <div>
            <input type="radio" id="choice${currentScene.getChoiceIndex(choice)}" name="userChoice" value="${choice.nextScene}" required/>
            <label for="choice${currentScene.getChoiceIndex(choice)}">${choice.text}</label>
        </div>
    </c:forEach>
    <br>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>