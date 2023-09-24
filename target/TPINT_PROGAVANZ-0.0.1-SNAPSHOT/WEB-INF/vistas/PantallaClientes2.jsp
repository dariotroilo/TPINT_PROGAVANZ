<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
.text-right{
		text-align:right;
}
.sort-icon {
    display: flex;
    justify-content: flex-end;
    align-items: flex-start;
    flex-direction: column;
    height: 100%;
  }

  .sort-icon i {
    margin-bottom: 5px;
  }

  .column-header {
    display: flex;
    align-items: center;
  }

  .column-header span {
    margin-right: 20px; /* Aumenta este valor para aumentar el espacio */
  }
</style>
<title>Inicio Clientes</title>
</head>
<body>
<%@include file="HeaderVendedor.jsp" %>


    <div class="wrapper wrapper-content animated fadeInRight" style="margin: auto; width: 75%;">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                   
<form action="redireccionar_pagContador.html" method="post" >
	
	<div>Show
  <select name="valor">
  <option value="1" selected>1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
</select>
  entries
  <div align= 'right' >Search: <input type="text"  name="txtBuscar" > <input type="submit" value="Buscar" name="btnBuscar"> </div> 

 </div>
	
	
<table id="idTabla" class="table table-light table-striped table-hover" style="background-color: #e3f2fd;">
  <thead>
    <tr>
      <th class="center" id="DNI">
      <div class="column-header">
      <span>DNI</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="Nombre">
       <div class="column-header">
      <span>Nombre</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="Apellido">
       <div class="column-header">
      <span>Apellido</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="Direccion">
       <div class="column-header">
      <span>Direccion</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="CP">
       <div class="column-header">
      <span>Codigo Postal</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="Provincia">
       <div class="column-header">
      <span>"Provincia"</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="Nacionalidad">
       <div class="column-header">
      <span>Nacionalidad</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="FechaNacimiento">
       <div class="column-header">
      <span>Fecha de Nacimiento</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="Email">
       <div class="column-header">
      <span>Email</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
       <th class="center" id="Telefono">
       <div class="column-header">
      <span>Telefono</span>
        <span class="sort-icon">
          <i class="fas fa-chevron-up"></i>
          <i class="fas fa-chevron-down"></i>
        </span>
        </div>
      </th>
</thead>
<tbody>
<tr>
<td>12345678</td>
	<td> Carlos</td>
	<td>Luna</td>
	<td>Avenida 123</td>
	<td>1646</td>
	<td>Buenos Aires</td>
	<td>Argentina</td>
	<td>08/07/1989</td>
	<td>carlosgmail.com</td>
	<td>11222333445</td>
	
</tr>

<tr>


</tbody>
</table>

<div class="row">
  <div class="col-xs-6">
    Mostrando 1 de 1 de 1 registros
  </div>
  <div class="col-xs-6 text-right">
    <ul class="pagination">
      <li>
        <a href="#" aria-label="Anterior">
          <span aria-hidden="true">&laquo;</span> Anterior
        </a>
      </li>
      <li><a href="#">1</a></li>
      <!-- Agrega aquí más números de página si es necesario -->
      <li>
        <a href="#" aria-label="Próxima">
          Próxima <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </div>
</div>
</form>
</div>
</div>
</div>
</div>   
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>