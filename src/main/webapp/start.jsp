<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Quest game - start</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/styles.css" />">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
<h1>Пролог</h1>
<p>Эпоха освоения космоса. Вы, отважный космонавт, отправились в путешествие на планету Небесная Эклипса, обладающую
    уникальной атмосферой и загадочными ресурсами. Ваша миссия - освоить эти ресурсы для блага вашей цивилизации.
    Однако, по прибытии, неудача заставляет вас совершить аварийную посадку. Система навигации, подвергшись странному
    воздействию планетарных полей, выходит из строя, и ваш корабль, потеряв ориентацию, несется к поверхности
    в неконтролируемом свободном падении. Невозможно предвидеть, что вас ожидает в этом загадочном и непостижимом уголке
    космоса.</p>
<br>
<form>
    <div>
        <input type="text" id="playerName" required>
        <label for="playerName">Представьтесь</label>
    </div>
    <div>
        <button type="submit">Начать игру</button>
    </div>
</form>

<script>
    $('form').on("submit", function (event) {
        let playerName = $("#playerName").val();
        let body = {
            playerName: playerName
        };
        console.log('submit')
        $.ajax({
            url: '/',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(body),
            async: false,
            success: function (data) {
                window.location.href = data.redirect;
            },
        });
        event.preventDefault();
    })
</script>
</body>
</html>
