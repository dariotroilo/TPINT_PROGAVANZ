<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<style type="text/css">
.logo {
    margin-left: 5%;
}
.navbar-expand-lg .navbar-collapse {
    gap: 5%;
}
.navbar-brand {
    margin-right: 10px;
}
</style>
<body>
<nav class="navbar navbar-expand-lg navbar-white" style="background-color: black;">
    <div class="container">
        <a class="navbar-brand logo" href="redireccionar_pagArticulosAgregar.html">Carga Inventario</a>
        <sec:authorize access="hasRole('ADMIN')">
        	<a class="navbar-brand logo" href="redireccionar_pagArticulosListar.html">Articulos</a>
        	<a class="navbar-brand logo" href="redireccionar_pagPantallaUbicacion.html">GruposUbicacion</a>
        </sec:authorize>
        <a class="navbar-brand logo" href="logout.html">Logout</a>
    </div>
</nav>
</body>
</html>