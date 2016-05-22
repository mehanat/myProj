<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 09.05.2016
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lunches</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="jumbotron">
  <div class="container">
    <table class="table table-striped">
      <thead>
      <tr>
        <td>Название</td>
        <td>Цена</td>
        <td>Голосов</td>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="lunch" items="${lunches}">
        <tr>
          <td><c:out value="${lunch.key.name}"/></td>
          <td><c:out value="${lunch.key.price}"/> руб.</td>
          <td><c:out value="${lunch.value}"/></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
