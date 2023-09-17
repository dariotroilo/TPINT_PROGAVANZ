<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="frgp.utn.edu.ar.entidad.Userubicacion"%>
<%@ page import="frgp.utn.edu.ar.entidad.SBE010"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
/* Estilos CSS aquí */
</style>
<title>Grupos y Ubicaciones</title>
</head>
<body>
	<%@ include file="HeaderVendedor.jsp"%>

	<div class="wrapper wrapper-content animated fadeInRight"
		style="margin: auto; width: 75%;">
		<div class="row">
			<div class="col-lg-12">
				<div class="ibox float-e-margins">
					<form action="redireccionar_pagModificar.html" method="post">
						<%
							ArrayList<Userubicacion> listaUserubicacion = null;
							if (request.getAttribute("listaUserubicacion") != null)
								listaUserubicacion = (ArrayList<Userubicacion>) request.getAttribute("listaUserubicacion");
						%>
						<br>

						<table id="idTabla"
							class="table table-light table-striped table-hover"
							style="background-color: #e3f2fd;">
							<thead>
								<tr>
									<td id="idTd" align="center">Id</td>
									<td id="idTd" align="center">Grupo</td>
									<td id="idTd" align="center">Filial</td>
									<td id="idTd" align="center">Localizacion</td>
									<td id="idTd" align="center">Ubicacion</td>
									<td id="idTd" align="center">Editar</td>
								</tr>
							</thead>
							<tbody>
								<%
									for (Userubicacion userubicacion : listaUserubicacion) {
								%>
								<tr>
									<td align="center"><%=userubicacion.getId().toString()%></td>
									<td align="center"><%=userubicacion.getUsuario()%></td>
									<td align="center"><%=userubicacion.getFilial()%></td>
									<td align="center"><%=userubicacion.getLocal()%></td>
									<td align="center"><%=userubicacion.getLocalizacion()%></td>
									<td align="center" id="idTd"><a
										href="redireccionar_pagModificar.html?id=<%=userubicacion.getId().toString()%>&usuario=<%=userubicacion.getUsuario()%>&filial=<%=userubicacion.getFilial()%>&local=<%=userubicacion.getLocal()%>&localiz=<%=userubicacion.getLocalizacion()%>"
										class="btn btn-modificar">Modificar</a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>

						<div class="row">
							<div class="col-xs-6">Mostrando 1 de 1 de 1 registros</div>
							<div class="col-xs-6 text-right">
								<ul class="pagination">
									<li><a href="#" aria-label="Anterior"><span
											aria-hidden="true">&laquo;</span> Anterior </a></li>
									<li><a href="#">1</a></li>
									<!-- Agrega aquí más números de página si es necesario -->
									<li><a href="#" aria-label="Próxima"> Próxima <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</html>
