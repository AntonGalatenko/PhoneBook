<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Simple Contact Form - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        
.red{
    color:red;
    }
.form-area
{
    background-color: #FAFAFA;
	padding: 10px 40px 60px;
	margin: 10px 0px 60px;
	border: 1px solid GREY;
	}
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<div class="col-md-5">
    <div class="form-area">  
        <form role="form" action="add_contact" method="POST">
        <br style="clear:both">
                    <h3 style="margin-bottom: 25px; text-align: center;">Введите данные</h3>
    				<div class="form-group">
						<input type="text" class="form-control" id="name" name="name" placeholder="Имя" required>
					</div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Фамилия" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="patronymic" name="patronymic" placeholder="Отчество" required>
                    </div>
					<div class="form-group">
						<input type="text" class="form-control" id="phone_mobile" name="phone_mobile" placeholder="Мобильный телефон" required>
					</div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="phone_home" name="phone_home" placeholder="Домашний телефон" >
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="address" name="address" placeholder="Адрес" >
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="email" name="email" placeholder="E-mail" >
                    </div>
        <input type="submit" value="Добавить">
        </form>
    </div>
</div>
</div>
</body>
</html>
