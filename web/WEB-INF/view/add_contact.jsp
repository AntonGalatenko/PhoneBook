<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
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
                    <%--<div class="form-group">--%>
                    <%--<textarea class="form-control" type="textarea" id="description" name="description" placeholder="Описание" maxlength="140" rows="7"></textarea>--%>
                        <%--<span class="help-block"><p id="characterLeft" class="help-block ">Вы привысилы лимит символов</p></span>--%>
                    <%--</div>--%>
            
        <input type="submit" value="Добавить">
        </form>
    </div>
</div>
</div>

<%--&lt;%&ndash;<script type="text/javascript">&ndash;%&gt;--%>
<%--&lt;%&ndash;$(document).ready(function(){ &ndash;%&gt;--%>
    <%--&lt;%&ndash;$('#characterLeft').text('140 символов осталось');&ndash;%&gt;--%>
    <%--&lt;%&ndash;$('#message').keydown(function () {&ndash;%&gt;--%>
        <%--&lt;%&ndash;var max = 140;&ndash;%&gt;--%>
        <%--&lt;%&ndash;var len = $(this).val().length;&ndash;%&gt;--%>
        <%--&lt;%&ndash;if (len >= max) {&ndash;%&gt;--%>
            <%--&lt;%&ndash;$('#characterLeft').text('Вы привысилы лимит символов');&ndash;%&gt;--%>
            <%--&lt;%&ndash;$('#characterLeft').addClass('red');&ndash;%&gt;--%>
            <%--&lt;%&ndash;$('#btnSubmit').addClass('disabled');            &ndash;%&gt;--%>
        <%--&lt;%&ndash;} &ndash;%&gt;--%>
        <%--&lt;%&ndash;else {&ndash;%&gt;--%>
            <%--&lt;%&ndash;var ch = max - len;&ndash;%&gt;--%>
            <%--&lt;%&ndash;$('#characterLeft').text(ch + ' символов осталось');&ndash;%&gt;--%>
            <%--&lt;%&ndash;$('#btnSubmit').removeClass('disabled');&ndash;%&gt;--%>
            <%--&lt;%&ndash;$('#characterLeft').removeClass('red');            &ndash;%&gt;--%>
        <%--&lt;%&ndash;}&ndash;%&gt;--%>
    <%--&lt;%&ndash;});    &ndash;%&gt;--%>
<%--&lt;%&ndash;});&ndash;%&gt;--%>

<%--</script>--%>
</body>
</html>
