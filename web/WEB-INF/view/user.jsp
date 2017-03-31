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
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <a class="nav navbar-brand" href="#">Компания</a>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">
                            <span class="glyphicon glyphicon-user"></span>
                            <%=session.getAttribute("login")%>
                        </a>
                    </li>
                    <li>
                        <a href="#">
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
                <div class="col-md-1">
                    <div class="btn-group-vertical btn-lg">
                        <a class="btn bg-info btnGroup bottomLink" href="#" id="smsLink">
                            <i class="glyphicon glyphicon-envelope sizeIcon"></i>
                            <p class="bottomIcon">СМС</p>
                        </a>
                        <a class="btn bg-info btn-group bottomLink" href="#" id="requestUserLink">
                            <i class="glyphicon glyphicon-bullhorn sizeIcon"></i>
                            <p class="bottomIcon">Заявка</p>
                        </a>
                        <a class="btn bg-info btn-group bottomLink" href="#" id="tsjLink">
                            <i class="glyphicon glyphicon-tent sizeIcon"></i>
                            <p class="bottomIcon">ТСЖ</p>
                        </a>
                    </div>
                </div>
                <div class="col-md-11">
                    <div class="container col-md-12 contentRight" id="sms">
                        <div class="panel panel-default" id="smsContent">
                            <div class="panel-body text-center">
                                <h4>У вас нет Сообщений!</h4>
                            </div>
                        </div>
                    </div>
                    <div class="container col-md-12 contentRight" id="requestUser">
                        <div class="panel panel-default" id="requestUserContent">
                            <div class="panel-body text-center">
                                <h4>У вас нет Запросов!</h4>
                            </div>
                        </div>
                        <button type="button" data-target="#requestModal" class="btn btn-danger center-block" data-toggle="modal">Создать</button>


                    </div>
                    <div class="container col-md-12 contentRight" id="tsj">
                        <div class="panel panel-default" id="tsjContent">
                            <div class="panel-body text-center">
                                <h4>У вас нет Компаний!</h4>
                            </div>
                        </div>
                        <button type="button" data-target="#tsjModal" class="btn btn-danger center-block" data-toggle="modal">Создать</button>
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
                        <p>Body modal Request.</p>
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