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
    <link href="../../../resources/css/company.css" rel="stylesheet">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
    <title>Руководитель</title>
</head>
<body>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <a class="nav navbar-brand" href="#">Компания</a>

            <ul class="nav navbar-nav">
                <li>
                    <a href="#" id="workerLink">Сотрудники</a>
                </li>
                <li>
                    <a href="#" id="reportLink">Отчеты</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <div id="Organization" ><%=session.getAttribute("organization")%></div>
                    </a>
                </li>
                <li>
                    <a href="/userOpen?login=<%=session.getAttribute("login")%>&pass=<%=session.getAttribute("pass")%>">
                        <div id="loginPublic" name="<%=session.getAttribute("pass")%>"><%=session.getAttribute("login")%></div>
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

    <!----- BODY ------>

    <div class="container">
        <div class="row">
            <!---- rabotniki -->
            <div class="container col-md-12" id="coworker">
                <div class="container">
                <div class="row text-right">
                    <button type="button" data-target="#addWorkerModal" class="btn btn-primary rightCont bottomLink " data-toggle="modal">Добавить</button>
                </div>
                </div>
                <div class="panel panel-default" id="coworkerContent">
                    <div id="contentWorker" class="panel-body">

                        <table class="table tabel-hover">
                            <thead>
                                <tr>
                                    <th>
                                        №
                                    </th>
                                    <th>
                                        Логин
                                    </th>
                                    <th>
                                       ФИО
                                    </th>
                                    <th>
                                        Адрес
                                    </th>
                                    <th>
                                        Должность
                                    </th>
                                    <th>
                                        Телефон
                                    </th>
                                </tr>
                            </thead>
                            <tbody id="MyWorker">
                                <tr id="workerList">
                                    <td>У вас нет сотрудников</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!---- Reports -->
            <div class="container col-md-12" id="report">
                <div class="panel panel-default" id="reeportContent">
                    <div id="contentReport" class="panel-body">
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#worker" aria-controls="worker" role="tab" data-toggle="tab">Заявки по сотрудникам</a>
                            </li>
                            <li role="presentation">
                                <a href="#zyavkiClose" aria-controls="zyavkiClose" role="tab" data-toggle="tab">Заявки по клиентам</a>
                            </li>
                        </ul>
                        <div class="tab-content morgan">
                            <div role="tabpanel" class="tab-pane active" id="worker">

                                <div class="container">
                                    <div class="row">
                                        <input id="startReport"  type='date'>
                                        <input id="closeReport"  type='date'>
                                        <button id="periodButton" class="btn btn-default">Приминить</button>
                                    </div>
                                </div>

                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>
                                                №
                                            </th>
                                            <th>
                                                Сотрудник
                                            </th>
                                            <th>
                                                Количество заявок
                                            </th>
                                            <th>
                                                В работе
                                            </th>
                                            <th>
                                                Завершено
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody id="workers">
                                        <tr id="reportWorkerList" class="report">
                                            <td>
                                                У вас нет сотрудников
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                            <div role="tabpanel" class="tab-pane" id="zyavkiClose">
                                <div class="container">
                                    <div class="row">
                                        <input id="startReportKlient" type='date'>
                                        <input id="closeReportKlient" type='date'>
                                        <button id="periodKlientButton" class="btn btn-default">Приминить</button>
                                    </div>
                                </div>

                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>
                                                №
                                            </th>
                                            <th>
                                                Клиент
                                            </th>
                                            <th>
                                                Количество заявок
                                            </th>
                                            <th>
                                                В работе
                                            </th>
                                            <th>
                                                Заврешено
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody id="klientReportBody">
                                        <tr id="klientReport">
                                            <td>
                                                У вас нет заявок по клиентам
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!---- Settings company -->
            <div class="container col-md-12" id="settingsCompany">
                <div class="panel panel-default" id="settingsCompanyContent">
                    <div id="contentSettingsCompany" class="panel-body">
                        <h4>Настройки</h4>
                        <hr>
                        <h5>Имя компаний : <%=session.getAttribute("organization")%></h5>
                        <hr>
                        <h5>Юредический адрес</h5>
                        <hr>
                        <h5>Город : <input id="cityU" placeholder="город"></h5>
                        <h5>Улица : <input id="streetU" placeholder="улица"></h5>
                        <h5>Дом : <input id="homeU" placeholder="дом"></h5>
                        <h5>Офис : <input id="ofisU" placeholder="офис">
                            <button id="Uaddress" class="btn btn-default">Сохранить</button>
                        </h5>
                        <hr>
                        <h5>Физический адрес</h5>
                        <hr>
                        <h5>Город : <input id="cityF" placeholder="город"></h5>
                        <h5>Улица : <input id="streetF" placeholder="улица"></h5>
                        <h5>Дом : <input id="homeF" placeholder="дом"></h5>
                        <h5>Офис : <input id="ofisF" placeholder="офис">
                            <button id="Faddress" class="btn btn-default">Сохранить</button>
                        </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--- Modal worker-->

    <div id="workerModal" class="modal fade" role="form">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Сотрудник</h4>
                </div>
                <div class="modal-body">
                    <div class="center-block">
                        <h5>Логин: <input disabled="disabled" name="" id="loginWork" type="text" placeholder="логин"></h5>
                        <h5>ФИО: <input disabled="disabled" id="fioWork" type="text" placeholder="ФИО"></h5>
                        <h5>Роль: <input  id="roleWork" type="text" placeholder="роль"></h5>
                    </div>
                </div>
                <div class="modal-footer">
                    <div id="error"></div>
                    <button id="updateWorker" type="button" class="btn btn-default">Изменить</button>
                    <button id="delWorker" type="button" class="btn btn-default">Удалить</button>
                    <button id="d" type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

    <!--- Modal workers add -->

    <div id="addWorkerModal" class="modal fade" role="form">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Добавить сотрудника</h4>
                </div>
                <div class="modal-body">
                    <div class="center-block">
                        <h5>Введите логин :<input id="loginWorker" placeholder="логин"></h5>
                        <h5>Введите роль :<input id="roleWorker" placeholder="роль"></h5>
                    </div>
                </div>
                <div class="modal-footer">

                    <button id="addWorker" type="button" class="btn btn-default">Добавить</button>
                </div>
            </div>
        </div>
    </div>




<script src="../../../resources/js/jquery.js"></script>
<script src="../../../resources/js/bootstrap.js"></script>
<script src="../../../resources/js/company.js"></script>
</body>
</html>
