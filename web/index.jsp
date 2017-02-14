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
    <%@include file="loginStyle.css"%>
  </style>
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
</head>

<body>

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

        <h6 class="text">Login</h6>
        <input class="input" type="text" name="login">

        <h6 class="text">Password</h6>
        <input class="input" type="password" name="pass">

        <input class="submit" type="submit" value="Вход">
        <input id="close" class="submit" type="submit" value="Закрыть">
      </div>

    <div class="registration">

    </div>

  </div>
</body>
<script rel="script">
  $("#openn").click(function () {
    $("#log").show("slow");
  });

  $("#close").click(function(){
            $("#log").hide('slow');
          }
  );
</script>
</html>
