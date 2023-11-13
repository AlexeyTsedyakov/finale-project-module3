<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Quest game - start</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/styles.css" />">
</head>
<body>
<h1>Пролог</h1>
<p>На грани изучения космоса, вы, отважный космонавт, отправились в путешествие на планету Небесная Эклипса, обладающую уникальной атмосферой и загадочными ресурсами. Ваша миссия - освоить эти ресурсы для блага вашей цивилизации. Однако, по прибытии, неудача заставляет вас совершить аварийную посадку. Система навигации, подвергшись странному воздействию планетарных полей, выходит из строя, и ваш корабль, потеряв ориентацию, несется к поверхности в контролируемом свободном падении. Невозможно предвидеть, что вас ожидает в этом загадочном и непостижимом уголке космоса.</p>
<button onclick="window.location='/quest-game?nextScene=startScene'">Начать игру</button>
</body>
</html>
