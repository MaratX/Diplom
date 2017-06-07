<%--
  Created by IntelliJ IDEA.
  User: Gustovs
  Date: 13.02.2017
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../resources/css/bootstrap.css" rel="stylesheet">
    <link href="../../../resources/css/bootstrap-theme.css" rel="stylesheet">
    <link href="../../../resources/css/userStyle.css" rel="stylesheet">
    <link href="../../../resources/css/worker.css" rel="stylesheet">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
    <title>Сотрудник</title>

</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <a class="nav navbar-brand" href="#">Компания</a>

            <ul class="nav navbar-nav">
                <li>
                    <a href="#" id="smsLinkWorker">Сообщения</a>
                </li>
                <li>
                    <a href="#" id="zyavkitLinkWorker">Заявки</a>
                </li>
                <li>
                    <a href="#" id="klientLinkWorker">Клиенты</a>
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
        <div class="row">
            <!---- soobcheniya -->
            <div class="col-md-12">
                <!-- sms -->
                <div class="container col-md-12" id="sms">

                    <div class="panel panel-default">
                        <div class="panel-body ">
                            <h5>Журнал отключений</h5>

                        </div>
                    </div>
                    <div class="text-right">
                        <button type="button" data-target="#smsModal" class="btn btn-danger rightCont " data-toggle="modal">Создать</button>
                    </div>
                    <div class="panel panel-default" id="smsContent">
                        <div id="contentSms" class="panel-body">
                            <table class="table tabel-hover">
                                <thead>
                                <tr>
                                    <th>
                                        №
                                    </th>
                                    <th>
                                        Причина
                                    </th>
                                    <th>
                                        Адрес
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
                                    <tr id="replaceC">
                                        <td >У вас нет Сообщений!</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!---- zyavki -->
                <div class="container col-md-12" id="zyavki">
                    <div>
                        <button type="button" data-target="#zyavkiModal" class="btn btn-danger" data-toggle="modal">Создать</button>
                    </div>
                    <div class="panel panel-default" id="zyavkiContent">
                        <div id="contentZyavki" class="panel-body">
                            <table class="table tabel-hover">
                                <thead>
                                <tr>
                                    <th>
                                        №
                                    </th>
                                    <th>
                                        Причина
                                    </th>
                                    <th>
                                        Клиент
                                    </th>
                                    <th>
                                        Статус
                                    </th>
                                    <th>
                                        Адрес
                                    </th>
                                </tr>
                                </thead>
                                <tbody id="MyZyavki">
                                <tr id="replaceZ">
                                    <td >У вас нет Сообщений!</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!---- klienti -->
                <div class="container col-md-12" id="klient">
                    <div>
                        <button type="button" data-target="#klientModal" class="btn btn-danger" data-toggle="modal">Создать</button>
                    </div>
                    <div class="panel panel-default" id="klientContent">
                        <div id="contentKlient" class="panel-body">
                            <table class="table tabel-hover">
                                <thead>
                                <tr>
                                    <th>
                                        №
                                    </th>
                                    <th>
                                        Причина
                                    </th>
                                    <th>
                                        Адрес
                                    </th>
                                    <th>
                                        Начало
                                    </th>
                                    <th>
                                        Конец
                                    </th>
                                </tr>
                                </thead>
                                <tbody id="MyKlient">

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--- Modal sms -->
    <div id="smsModal" class="modal fade" role="form">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h5>Сообщение</h5>
                </div>
                <div class="modal-body">
                    <h6>Адрес</h6>
                    <hr>
                        <input id="city" placeholder="город">
                        <input id="street" placeholder="улица">
                        <input id="home" placeholder="дом">
                    <hr>
                    <h6>Время работ</h6>
                    <hr>
                        <input id="start" placeholder="начало">
                        <input id="close" placeholder="завершение">
                    <hr>
                    <h6>Причина</h6>
                    <hr>
                        <input id="protection" placeholder="Причина">
                </div>
                <div class="modal-footer">
                    <a href="" id="addJurnal" class="btn btn-default">Сохранить</a>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

    <!--- Modal zyavki -->
    <div id="zyavkiModal" class="modal fade" role="form">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn-danger" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

    <!--- Modal Klient -->
    <div id="klientModal" class="modal fade" role="form">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn-danger" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

<script src="../../../resources/js/jquery.js"></script>
<script src="../../../resources/js/bootstrap.js"></script>
<script src="../../../resources/js/worker.js"></script>
</body>
</html>
