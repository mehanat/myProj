<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 09.05.2016
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<jsp:include page="fragments/header.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h1>Здравствуйте!</h1>
        <p>Это система выбора ресторана, в котором Вы хотели бы сегодня пообедать. Голосовать можно только зарегестрированным пользователям и только до 11:00.</p>
        <p><a class="btn btn-primary btn-lg" href="/restaurants" role="button">Рестораны &raquo;</a></p>
    </div>
</div>

</body>
</html>
