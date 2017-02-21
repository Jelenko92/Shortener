<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<style>
ul.nav {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li.nav {
    float: left;
}

li.nav a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li.nav a:hover {
    background-color: #111;
}
</style>
</head>
<body>

<ul class="nav">
  <li class="nav"><a href="/redirect">Redirect</a></li>
  <li class="nav"><a href="/help">Help</a></li>
</ul>

