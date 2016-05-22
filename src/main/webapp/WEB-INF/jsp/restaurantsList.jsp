<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 01.05.2016
  Time: 11:28
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

<link rel="stylesheet" type="text/css" href="../../resources/css/responsive.bootstrap.min.css">
<script type="text/javascript" src="../../resources/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="../../resources/js/datatablesUtil.js"></script>
<script type="text/javascript" src="../../resources/js/restaurantsDatatable.js"></script>

<div class="jumbotron">
  <div class="container">
    <br>

    <table id="restaurantstable" class="table table-striped table-bordered">
      <thead>
      <tr>
        <td>ID</td>
        <td>Имя</td>
        <td></td>
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
          <input type="text" hidden="hidden" id="id" name="id">

          <div class="form-group">
            <label for="name" class="control-label col-xs-3">Name</label>

            <div class="col-xs-9">
              <input type="text" class="form-control" id="name" name="name" placeholder="Name">
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
<div class="modal fade" id="lunchesModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h2 class="modal-title"></h2>
      </div>
      <div class="modal-body">
        <table id="lunchestable" class="table table-striped table-bordered">
          <thead>
            <tr>
              <td>Id</td>
              <td>Date</td>
              <td>Name</td>
              <td>Price</td>
              <td>Votes count</td>
              <td></td>
              <td></td>
              <td class="none"></td>
            </tr>
          </thead>
        </table>

        <div class="form-group">
          <div class="col-xs-offset-3 col-xs-9">
            <button type="submit" class="btn btn-primary" id="addNewLunch">Add new lunch</button>
          </div>
        </div>
        <form id="lunchForm" style="display: none" action="admin/ajax/restaurants/lunches" method="post">

          <h1>New lunch</h1>

          <input name="lunch.id" type="text" hidden="hidden" value="0">

          <div class="form-inline">
          <fieldset class="form-group">
            <label for="lunchName">Lunch name</label>
            <input name="lunch.name" type="text" class="form-control" id="lunchName" placeholder="Lunch name">
          </fieldset>

          <fieldset class="form-group">
            <label for="price">Price</label>
            <input name="lunch.price" type="text" class="form-control" id="price" placeholder="Price">
          </fieldset>
            </div>

          <h2>Dishes</h2>
          <h3>#1</h3>
            <input name="dishes[0].id" type="text" hidden="hidden" value="0">
            <fieldset class="form-group">
              <label for="dishName1">Dish name</label>
              <input name="dishes[0].name" type="text" class="form-control" id="dishName1" placeholder="Dish name">
            </fieldset>

            <fieldset class="form-group">
              <label for="dishDescr1">Descriprion</label>
              <textarea name="dishes[0].description" class="form-control" id="dishDescr1" placeholder="Descriprion"></textarea>
            </fieldset>
          <h3>#2</h3>
          <input name="dishes[1].id" type="text" hidden="hidden" value="0">
          <fieldset class="form-group">
            <label for="dishName2">Dish name</label>
            <input name="dishes[1].name" type="text" class="form-control" id="dishName2" placeholder="Dish name">
          </fieldset>

          <fieldset class="form-group">
            <label for="dishDescr2">Descriprion</label>
            <textarea name="dishes[1].description" class="form-control" id="dishDescr2" placeholder="Descriprion"></textarea>
          </fieldset>
          <h3>#3</h3>
          <input name="dishes[2].id" type="text" hidden="hidden" value="0">
          <fieldset class="form-group">
            <label for="dishName3">Dish name</label>
            <input name="dishes[2].name" type="text" class="form-control" id="dishName3" placeholder="Dish name">
          </fieldset>

          <fieldset class="form-group">
            <label for="dishDescr3">Descriprion</label>
            <textarea name="dishes[2].description" class="form-control" id="dishDescr3" placeholder="Descriprion"></textarea>
          </fieldset>
          <h3>#4</h3>
          <input name="dishes[3].id" type="text" hidden="hidden" value="0">
          <fieldset class="form-group">
            <label for="dishName4">Dish name</label>
            <input name="dishes[3].name" type="text" class="form-control" id="dishName4" placeholder="Dish name">
          </fieldset>

          <fieldset class="form-group">
            <label for="dishDescr4">Descriprion</label>
            <textarea name="dishes[3].description"  class="form-control" id="dishDescr4" placeholder="Descriprion"></textarea>
          </fieldset>



          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>
