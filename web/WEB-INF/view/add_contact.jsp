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
                        <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Фамилия" required>
                    </div>
					<div class="form-group">
						<input type="text" class="form-control" id="phone" name="phone" placeholder="Телефон" required>
					</div>
                    <div class="form-group">
                    <textarea class="form-control" type="textarea" id="description" name="description" placeholder="Описание" maxlength="140" rows="7"></textarea>
                        <span class="help-block"><p id="characterLeft" class="help-block ">Вы привысилы лимит символов</p></span>
                    </div>
            
        <input type="submit" value="Добавить">
        </form>
    </div>
</div>
</div>

<script type="text/javascript">
$(document).ready(function(){ 
    $('#characterLeft').text('140 символов осталось');
    $('#message').keydown(function () {
        var max = 140;
        var len = $(this).val().length;
        if (len >= max) {
            $('#characterLeft').text('Вы привысилы лимит символов');
            $('#characterLeft').addClass('red');
            $('#btnSubmit').addClass('disabled');            
        } 
        else {
            var ch = max - len;
            $('#characterLeft').text(ch + ' символов осталось');
            $('#btnSubmit').removeClass('disabled');
            $('#characterLeft').removeClass('red');            
        }
    });    
});

</script>
</body>
</html>
