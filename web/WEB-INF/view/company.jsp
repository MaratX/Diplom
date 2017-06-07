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

    <!----- BODY ------>

    <div class="container">
        <div class="row">
            <!---- rabotniki -->
            <div class="container col-md-12" id="coworker">
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
                                        Должность
                                    </th>
                                </tr>
                            </thead>
                            <tbody id="MyWorker">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!---- othecheti -->
            <div class="container col-md-12" id="report">
                <div class="panel panel-default" id="reeportContent">
                    <div id="contentReport" class="panel-body">

                    </div>
                </div>
            </div>
        </div>
    </div>



<script src="../../../resources/js/jquery.js"></script>
<script src="../../../resources/js/bootstrap.js"></script>
<script src="../../../resources/js/company.js"></script>
</body>
</html>
