<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 10.05.2016
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<script type="text/javascript" src="../../resources/js/datatablesUtil.js"></script>
<script type="text/javascript" src="../../resources/js/userDatatables.js"></script>
<div class="jumbotron">
  <div class="container">

    <br>



    <table id="userstable" class="table table-striped table-bordered">
      <thead>
      <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>e-mail</td>
        <td>пароль</td>
        <td>Зарегестрирован</td>
        <td></td>
        <td></td>
      </tr>
      </thead>

    </table>
    <a class="btn btn-sm btn-info" onclick="add()">Добавить</a>
  </div>
</div>

<div class="modal fade" id="editRow">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h2 class="modal-title"></h2>
      </div>
      <div class="modal-body">
        <form:form class="form-horizontal" method="post" id="detailsForm">
          <input type="text" hidden="hidden" id="id" name="id" value="0">

          <div class="form-group">
            <label for="name" class="control-label col-xs-3">Name</label>

            <div class="col-xs-9">
              <input type="text" class="form-control" id="name" name="name" placeholder="Name">
            </div>
          </div>

          <div class="form-group">
            <label for="email" class="control-label col-xs-3">Email</label>

            <div class="col-xs-9">
              <input type="email" class="form-control" id="email" name="email" placeholder="email">
            </div>
          </div>

          <div class="form-group">
            <label for="password" class="control-label col-xs-3">Password</label>

            <div class="col-xs-9">
              <input type="password" class="form-control" id="password" name="password" placeholder="">
            </div>
          </div>


          <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
              <button type="submit" class="btn btn-primary">Save</button>
            </div>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</div>

</body>
</html>
