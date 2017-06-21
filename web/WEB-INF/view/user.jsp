<%--
  Created by IntelliJ IDEA.
  User: Gustovs
  Date: 13.02.2017
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html id="htmlR">
<head>
    <link href="../../../resources/css/bootstrap.css" rel="stylesheet">
    <link href="../../../resources/css/bootstrap-theme.css" rel="stylesheet">
    <link href="../../../resources/css/userStyle.css" rel="stylesheet">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <a class="nav navbar-brand" href="#">Компания</a>

        <ul class="nav navbar-nav">
            <li>
                <a href="#" id="smsLink">Уведомления</a>
            </li>
            <li>
                <a href="#" id="requestUserLink">Мой заявки</a>

            </li>
            <li>
                <a href="#" id="tsjLink">Мой компаний</a>

            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="#"  >
                    <div id="loginPublic"><%=session.getAttribute("login")%></div>
                </a>
            </li>
            <li>
                <a href="index.jsp" id="exit">
                    <span class="glyphicon glyphicon-log-out"></span>
                    Выход
                </a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="container col-md-12 contentRight" id="sms">
                <div class="panel panel-default" id="smsContent">
                    <div id="contentUsersms" class="panel-body text-center">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>
                                    №
                                </th>
                                <th>
                                    Причина
                                </th>
                                <th>
                                    Организация
                                </th>
                                <th>
                                    Начало
                                </th>
                                <th>
                                    Конец
                                </th>
                            </tr>
                            </thead>
                            <tbody id="MySms">
                            <tr id="JurnalOffList">
                                <td>У вас нет уведомлений</td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container col-md-12 contentRight" id="requestUser">
                <div class="text-right">
                    <button id="zayavkaBotton" type="button" data-target="#requestModal" class="btn btn-danger rightCont bottomLink" data-toggle="modal">Создать</button>
                </div>
                <div class="panel panel-default" id="zyavkaContent">
                    <div id="contentUserZyavka" class="panel-body text-center">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>
                                    №
                                </th>
                                <th>
                                    Организация
                                </th>
                                <th>
                                    Причина
                                </th>
                                <th>
                                    Статус
                                </th>
                                <th>
                                    Адрес
                                </th>
                                <th>
                                    Описание и резултат
                                </th>
                            </tr>
                            </thead>
                            <tbody id="MyZyavki">
                                <tr class="proposal">
                                    <td>У вас нет заявок</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container col-md-12 contentRight" id="tsj">
                <div class="text-right">
                    <button type="button" data-target="#tsjModal" class="btn btn-danger rightCont bottomLink " data-toggle="modal">Создать</button>
                </div>
                <div class="panel panel-default" id="tsjContent">
                    <div id="contentUserCompany" class="panel-body text-center">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>
                                    №
                                </th>
                                <th>
                                    Название
                                </th>
                                <th>
                                    Адресс
                                </th>
                            </tr>
                            </thead>
                            <tbody id="MyCompany">
                            <tr id="replace" class="replace">
                                <td>У вас нет компаний</td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>

            </div>

            <div class="container col-md-12 contentRight" id="settings">
                <div class="panel panel-default" id="settingsContent">
                    <div id="contentSettings" class="panel-body">
                        <h5>Настройки</h5>
                        <hr>
                        <h5>Логин : <%=session.getAttribute("login")%></h5>
                        <h5 >Пароль :
                            <input id="password"  placeholder="пароль" class="">
                            <a href="#" id="pass" type="submit" class="btn btn-default">Изменить</a>
                        </h5>
                        <hr>
                        <h5>Имя : <input id="nameUser" placeholder="имя"></h5>
                        <h5>Фамилия : <input id="lastNameUser" placeholder="фамилия">
                            <a href="#" id="fio" type="submit" class="btn btn-default">Изменить</a></h5>

                        <hr>
                        <h5>Телефон : <input id="phone" placeholder="Номер телефона">
                            <a href="#" id="phoneBotton" type="submit" class="btn btn-default">Изменить</a></h5></h5>
                        <hr>
                        <h5>Адрес</h5>
                        <hr>
                        <h5>Город : <input id="city" placeholder="гор"></h5>
                        <h5>Улица : <input id="street" placeholder="улица"></h5>
                        <h5>Дом : <input id="home" placeholder="дом"></h5>
                        <h5>Квартира : <input id="apart" placeholder="квартира">
                            <a href="#" id="adressUser" type="submit" class="btn btn-default">Изменить</a></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal windows -->

<!-- Modal Request -->
<div id="requestModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Запрос</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="sel1">Организация:</label>
                    <select class="form-control" id="sel1">
                        <option id="optOrg">У вас нет компаний</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="comment">Причина обращения:</label>
                    <textarea class="form-control" rows="5" id="comment"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button id="addZyavka" type="button" class="btn btn-default" >Отправить</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal TSJ -->
<div id="tsjModal" class="modal fade" role="form">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Создать новое ТСЖ</h4>
            </div>
            <div class="modal-body">
                <div class="center-block">
                    <h4 class="text-center">Введите название Фирмы</h4>
                    <input id="companyN" type="text" class="text-center center-block" placeholder="Название" >
                    <h5 id="listMyCompany"></h5>
                </div>

            </div>
            <div class="modal-footer">
                <div id="error"></div>

                <button id="testCompanyName" type="button" class="btn-default">
                    Проверить
                </button>
                <button id="createCompanyName" type="button" class="btn-default">Создать</button>
            </div>
        </div>
    </div>


</div>

<script src="../../../resources/js/jquery.js"></script>
<script src="../../../resources/js/bootstrap.js"></script>
<script src="../../../resources/js/user.js"></script>
</body>
</html>
