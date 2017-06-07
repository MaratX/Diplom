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
                <a href="#" id="smsLink">Сообщения</a>
            </li>
            <li>
                <a href="#" id="requestUserLink">Заявки</a>

            </li>
            <li>
                <a href="#" id="tsjLink">ТСЖ</a>

            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="#">
                    <span class="glyphicon glyphicon-user"></span>
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
    <div class="panel panel-default" id="informer">
        <div class="panel-body">Информация!</div>

    </div>
    <div class="row">
        <!--<div class="col-md-1">
            <div class="btn-group-vertical btn-lg">
                <a class="btn bg-info btnGroup bottomLink" href="#" id="q">
                    <i class="glyphicon glyphicon-envelope sizeIcon"></i>
                    <p class="bottomIcon">СМС</p>
                </a>
                <a class="btn bg-info btn-group bottomLink" href="#" id="requestUserLink1">
                    <i class="glyphicon glyphicon-bullhorn sizeIcon"></i>
                    <p class="bottomIcon">Заявка</p>
                </a>
                <a class="btn bg-info btn-group bottomLink" href="#" id="tsjLink1">
                    <i class="glyphicon glyphicon-tent sizeIcon"></i>
                    <p class="bottomIcon">ТСЖ</p>
                </a>
            </div>
        </div> -->

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
                            <tr id="smsList">
                                <td>
                                    У вас нет сообщений
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>



            </div>
            <div class="container col-md-12 contentRight" id="requestUser">
                <!--<div class="panel panel-default" id="requestUserContent">
                    <div class="panel-body text-center">
                        <h4>У вас нет Заявок!</h4>
                    </div>
                </div> -->
                <div class="text-right">
                    <button type="button" data-target="#requestModal" class="btn btn-danger rightCont bottomLink" data-toggle="modal">Создать</button>
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

                                </th>
                            </tr>
                            </thead>
                            <tbody id="MyZyavki">
                            <tr id="zyavkaList">
                                <td>
                                    У вас нет Заявок!
                                </td>
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

                            <tr id="replace">
                                <td >У вас нет Компаний!</td>
                            </tr>

                            </tbody>
                        </table>
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
                <h4 class="text-center center-block" >Организация</h4>
                <select class="selectpicker text-center center-block" id="zyavkiSelect">
                    <option>выбор</option>
                </select>
                <h4 class="text-center center-block" >Причина</h4>
                <input id="zyavkaDescription" type="text" class="text-center center-block" placeholder="Описание">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn-danger" data-dismiss="modal">Закрыть</button>
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
