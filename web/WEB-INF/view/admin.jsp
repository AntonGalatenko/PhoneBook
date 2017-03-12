<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Admin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        /***
Bootstrap Line Tabs by @keenthemes
A component of Metronic Theme - #1 Selling Bootstrap 3 Admin Theme in Themeforest: http://j.mp/metronictheme
Licensed under MIT
***/

/* Tabs panel */
.tabbable-panel {
  border:1px solid #eee;
  padding: 10px;
}

/* Default mode */
.tabbable-line > .nav-tabs {
  border: none;
  margin: 0px;
}
.tabbable-line > .nav-tabs > li {
  margin-right: 2px;
}
.tabbable-line > .nav-tabs > li > a {
  border: 0;
  margin-right: 0;
  color: #737373;
}
.tabbable-line > .nav-tabs > li > a > i {
  color: #a6a6a6;
}
.tabbable-line > .nav-tabs > li.open, .tabbable-line > .nav-tabs > li:hover {
  border-bottom: 4px solid #fbcdcf;
}
.tabbable-line > .nav-tabs > li.open > a, .tabbable-line > .nav-tabs > li:hover > a {
  border: 0;
  background: none !important;
  color: #333333;
}
.tabbable-line > .nav-tabs > li.open > a > i, .tabbable-line > .nav-tabs > li:hover > a > i {
  color: #a6a6a6;
}
.tabbable-line > .nav-tabs > li.open .dropdown-menu, .tabbable-line > .nav-tabs > li:hover .dropdown-menu {
  margin-top: 0px;
}
.tabbable-line > .nav-tabs > li.active {
  border-bottom: 4px solid #f3565d;
  position: relative;
}
.tabbable-line > .nav-tabs > li.active > a {
  border: 0;
  color: #333333;
}
.tabbable-line > .nav-tabs > li.active > a > i {
  color: #404040;
}
.tabbable-line > .tab-content {
  margin-top: -3px;
  background-color: #fff;
  border: 0;
  border-top: 1px solid #eee;
  padding: 15px 0;
}
.portlet .tabbable-line > .tab-content {
  padding-bottom: 0;
}

/* Below tabs mode */

.tabbable-line.tabs-below > .nav-tabs > li {
  border-top: 4px solid transparent;
}
.tabbable-line.tabs-below > .nav-tabs > li > a {
  margin-top: 0;
}
.tabbable-line.tabs-below > .nav-tabs > li:hover {
  border-bottom: 0;
  border-top: 4px solid #fbcdcf;
}
.tabbable-line.tabs-below > .nav-tabs > li.active {
  margin-bottom: -2px;
  border-bottom: 0;
  border-top: 4px solid #f3565d;
}
.tabbable-line.tabs-below > .tab-content {
  margin-top: -10px;
  border-top: 0;
  border-bottom: 1px solid #eee;
  padding-bottom: 15px;
}
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!--
     <script type="text/javascript">
        function doAjax() {
            $.ajax({
                type: "GET",
                url: "admin/getitem",
                contentType: "application/json",
                data: JSON.stringify({ firstName: $("#first_name").val(), lastName: $("#last_name").val(), age: $("#age").val(), email: $("#email").val(), password: $("#password").val() }),
                success :function(result) {
                    // do what ever you want with data
                }
            });
        }
    </script>
-->

</head>
<body>

<div class="container">
   <div class="row">
      <div class="col-md-12">
    		<div class="tabbable-panel">
				<div class="tabbable-line">
					<ul class="nav nav-tabs ">
						<li class="active">
							<a href="#tab_default_1" data-toggle="tab">Список пользователей </a>
						</li>
						<li>
							<a href="#tab_default_2" data-toggle="tab">Список товаров </a>
						</li>
						<li>
							<a href="#tab_default_3" data-toggle="tab">Override RTO </a>
						</li>
                  <li>
    						<a href="#tab_default_4" data-toggle="tab">Non-Standard Rates </a>
						</li>
                  <li>
    						<a href="#tab_default_5" data-toggle="tab">Anniversary Timeoffs </a>
						</li>
               </ul>

					<div class="tab-content">
                  <div class="tab-pane active" id="tab_default_1">
							<ul class="table table-striped" style="width:100%">
                        <div class="col-xs-2">
                           Имя
                        </div>        
                        <div class="col-xs-2">
                           Фамилия
                        </div>
                        <div class="col-xs-2">
                           Возраст
                        </div>
                        <div class="col-xs-2">
                           Email
                        </div>
                        <div class="col-xs-2">
                           Кол-во товара
                        </div>
                        <div class="col-xs-2">
                           Права
                        </div>
                        <br>        
                     </ul>
                     <ul class="table table-striped" style="width:100%">
                        <c:forEach items="${list}" var="user">
                           <div class="row toggle">
                              <div class="toggle" id="dropdown-detail-${user.id}" data-toggle="detail-${user.id}">
                                 <div class="col-xs-2">
                                    ${user.firstName}
                                 </div>
                                 <div class="col-xs-2">
                                    ${user.lastName}
                                 </div>
                                 <div class="col-xs-2">
                                    ${user.age}
                                 </div>
                                 <div class="col-xs-2">
                                    ${user.email}
                                 </div>
                                 <div class="col-xs-2">
                                    ${fn:length(user.items)}
                                 </div>
                              </div>   
                              <div class="col-xs-2">
                                 <select>
                                    <option value="1" ${user.usersProfile.type == 'ADMIN' ? 'selected="selected"' : ''}>ADMIN</option>
                                    <option value="2" ${user.usersProfile.type == 'USER' ? 'selected="selected"' : ''}>USER</option>
                                    <option value="3" ${user.usersProfile.type == 'PRO-USER' ? 'selected="selected"' : ''}>PRO-USER</option>
                                 </select>
                              </div>
                           </div>
                           <div id="detail-${user.id}">
                              <div class="container">
                                 <c:forEach items="${user.items}" var="item">
                                    ${item.product}<p>
                                 </c:forEach>
                              </div>
                           </div>
                        </c:forEach>
                     </ul>
                  </div>

                  <div class="tab-pane active" id="tab_default_2">
                    <h3>Hello world</h3>
                  </div>

                  <div class="tab-pane active" id="tab_default_3">
                  </div>

                  <div class="tab-pane active" id="tab_default_4">
                  </div>

                  <div class="tab-pane active" id="tab_default_5">
                  </div>
                     
               </div>
            </div>
         </div>
      </div>
   </div>
</div>

<script type="text/javascript">
$(document).ready(function() {
    $('[id^=detail-]').hide();
    $('.toggle').click(function() {
        $input = $( this );
        $target = $('#'+$input.attr('data-toggle'));
        $target.slideToggle();
    });
});


</script>


</body>
</html>