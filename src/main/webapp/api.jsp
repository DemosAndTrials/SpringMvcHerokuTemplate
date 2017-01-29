<%--
  Created by IntelliJ IDEA.
  User: matro
  Date: 29-Jan-17
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="/images/favicon.ico" type="image/x-icon">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="webjars/font-awesome/4.6.3/css/font-awesome.min.css">
</head>
<body>
<br>
<form class="navbar-form navbar-center" method="post">
    <div class="form-group">
        <input type="text" placeholder="url" name="url" class="form-control" value="https://www.google.com">
    </div>
    <button type="submit" class="btn btn-success"><i class="fa fa-sign-in" aria-hidden="true"></i> Sign in</button>
</form>
<br>
<p>${message}</p>
</body>
</html>
