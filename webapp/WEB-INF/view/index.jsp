<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Phone</title>
    <link type="text/css" href="/resources/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="/resources/css/button.css" rel="stylesheet">
    <script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>

    <script type="text/javascript">
      $(document).ready(function(){
        $.ajax({
          url: "/getUserInfo",
          success: function(data){
            $("#userInfo").text(data);
          },
          error: function(data, status, er){
             $("#userInfo").text(data + " status: " + status + " er:" + er);
          }
        });
      });
    </script>

    <script>
        function updateItem(id){
            $.ajax({
                type: "GET",
                url: "/update/" + id,
                success: function(data){
                    $("#res1").text(data);
                }
            });
        }
    </script>

	<script>
        function deleteItem(phone){
          $.ajax({
            type: "DELETE",
            url: "/contact/" + phone,  
              success: function(data){  
                $("#res1").text(data);  
              }  
          });  
        }
    </script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
    <!--
        <security:authentication property="principal.username" /><br>
    -->
        <br>
        <div align="right">
            <p><a href="<c:url value="/logout" />"><img src="/resources/img/exit.png" width="50" height="55"></a>Logout</p>
        </div>
            <p id="userInfo"></p>

		<%--<div id="res1"></div>--%>
        <div class="table-responsive">
            <table id="mytable" class="table table-bordred table-striped">
                <thead>
                   <tr>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Отчество</th>
                    <th>Мобильный тел.</th>
                    <th>Домашний тел.</th>
                    <th>Адрес</th>
                    <th>E-mail</th>
                    <th>Ред.</th>
                    <th>Удалить</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="item">
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.lastName}</td>
                            <td>${item.patronymic}</td>
                            <td>${item.phoneMobile}</td>
                            <td>${item.phoneHome}</td>
                            <td>${item.address}</td>
                            <td>${item.email}</td>
                            <td><p><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-placement="top" rel="tooltip" onclick="location.href='/update/${item.id}'"><span class="glyphicon glyphicon-pencil"></span></button></p></td>
							<td><p><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-placement="top" rel="tooltip" onclick="deleteItem(${item.phoneMobile})"><span class="glyphicon glyphicon-trash"></span></button></p></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

			<div class="container">
			    <br><Br>
				<section>
                    <button type="button" onclick="location.href='/add_contact'">Добавить</button>
				</section>
            </div>
        </div>
        </div>
    </div>
</div>

</body>
</html>
