<%--
  Created by IntelliJ IDEA.
  User: HMF
  Date: 14.02.2017
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <link href="../../resources/css/bootstrap.css" rel="stylesheet">
    <link href="../../resources/css/mystyle.css" rel="stylesheet">
    <link href="../../resources/css/bootstrap-theme.css" rel="stylesheet">
    <link href="../../resources/js/jquery.js" rel="script">
    <link href="../../resources/js/bootstrap.js" rel="script">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#fort">
                            <span class="sr-only"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="#" class="navbar-brand">SBERTAT</a>
                    </div>
                    <div class="collapse navbar-collapse" id="fort">
                        <nav class="nav navbar-right">
                            <div>
                                <button type="button" data-target="#registr"  class="btn btn-danger pad" data-toggle="modal">Регистрация</button>
                            </div>
                        </nav>
                        <form action="userOpen" class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" name="login" class="form-control" placeholder="login" value=""/>
                            </div>
                            <div class="form-group">
                                <input type="text" name="pass" class="form-control" placeholder="password" value=""/>
                            </div>
                            <button type="submit" class="btn btn-primary">
                                <i>Войти</i>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--  Modal -->
    <div id="registr" class="modal fade" role="form">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Регистрация</h4>
                </div>
                <div class="modal-body">
                    <div class="center-block">
                        <form action="userRegistration">
                            <div class="form-group">
                                <input type="text" name="loginReg" class="form-control" placeholder="login" value=""/>
                            </div>
                            <div class="form-group">
                                <input type="text" name="passReg" class="form-control" placeholder="password" value=""/>
                            </div>
                            <button type="submit" class="btn btn-danger">
                                <i>Регистрация</i>
                            </button>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button  type="button" class="btn btn-danger" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>
    <script src="../../resources/js/jquery.js"></script>
    <script src="../../resources/js/bootstrap.js"></script>
</body>
</html>
