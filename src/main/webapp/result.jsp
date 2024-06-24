<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Результат игры</title>
</head>
<body>
    <h1>Конец игры</h1>
    <p>${game.message}</p>
    <form action="game" method="get">
        <button type="submit">Начать заново</button>
    </form>
</body>
</html>
