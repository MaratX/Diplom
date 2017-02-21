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
  <style type="text/css" rel="stylesheet">
    <%@include file="resources/loginStyle.css"%>
  </style>

  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
</head>

<body id="body">

  <div class="main">

    <div class="cap">
      <input onclick="" type="submit" id="openn" value="Вход">
    </div>


    <div class="menu">

    </div>

    <div class="general">

    </div>

    <div class="basement">

    </div>

      <div class="login" id="log">

        <form action="userOpen" method="get">
          <input id="loginU" class="input" type="text" name="login" placeholder="Ваш логин">
          <input id="passU" class="input" type="password" name="pass" placeholder="Ваш пароль">
          <input id="auto" class="submit" type="submit" value="Вход">
        </form>

        <input id="close" class="submit" type="submit" value="Закрыть">
      </div>

    <div class="registration">

    </div>

  </div>
  <script rel="script">
    <%@include file="resources/loginScript.js"%>
  </script>
</body>
</html>
