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
    <%@include file="resources/bootstrap.css"%>
    <%@include file="resources/bootstrap-theme.css"%>
    <%@include file="resources/bootstrap.js"%>
    <%--<script type="text/css" src="resources/bootstrap-theme.css"></script>
    <script type="text/css" src="resources/bootstrap.css"></script>--%>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
</head>

<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="submit" class="navbar-toggle" data-toggle="collapse" data-target="#fo">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand">LOG</a>
            </div>
            <div class="collapse navbar-collapse" id="fo">
                <form action="" class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="login" value=""/>
                        <input type="text" class="form-control" placeholder="password" value=""/>
                        <button type="submit" class="btn btn-primary">
                            <i>Войти</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container-fluid" id="all">
        <div class="row" id="cap">

        </div>
        <div class="row" id="body">
            <div class="container">

            </div>
        </div>
        <div class="row" id="basement">
            <div class="container">

            </div>
        </div>
    </div>
    <script rel="script" src="resources/bootstrap.js"></script>
    <script rel="script" src="resources/loginScript.js"></script>
</body>
</html>
