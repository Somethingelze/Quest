<%@ taglib uri="http://jakarta.apache.org/taglibs/standard-1.2" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Игра</title>
</head>
<body>
    <h1>Игра</h1>
    <p>${game.message}</p>
    <form action="game" method="post">
        <input type="text" name="choice" placeholder="Введите ваш выбор">
        <button type="submit">Продолжить</button>
    </form>
</body>
</html>
