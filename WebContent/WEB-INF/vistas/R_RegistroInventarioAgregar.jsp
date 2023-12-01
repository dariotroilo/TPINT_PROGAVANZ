<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="frgp.utn.edu.ar.entidad.R_RegistroInventario"%>
<%@page import="frgp.utn.edu.ar.entidad.SB1010"%>
<%@page import="frgp.utn.edu.ar.entidad.SBE010"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="org.apache.commons.text.StringEscapeUtils"%>

<!DOCTYPE html>
<!--  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style type="text/css">
#idTabla {
	border: 1px solid black;
}

#idTd {
	border: 1px solid black;
}
</style>

<title>Articulos Agregar</title>

</head>



<script>
	function confirmarEliminar() {
		return confirm("¿Seguro desea eliminar el registro?");
	}

	function guardarCantidad() {

		if (document.getElementById("codigoInput").value == "") {
			return alert("Falta el Código!");

		}
		if (document.getElementById("cantidadInput").value == 0) {
			return alert("Falta la Cantidad!");
		}
		if (document.getElementById("descriInput").value == "") {
			return alert("Falta la Descripción!");
		}

	}
</script>



<body>

	<%@include file="HeaderVendedor.jsp"%>

	<form action="redireccionar_pagArticulosAccion.html" method="post">
		<%
			request.getParameter("codigo");
			request.getParameter("descri");
			request.getParameter("cantidad");
		%>


		<div class="row wrapper border-bottom white-bg page-heading"
			style="margin: auto; width: 80%;">
			<div class="col-lg-10">
				<h2>Articulos</h2>
			</div>
		</div>

		<div class="wrapper wrapper-content animated fadeInRight"
			style="margin: auto; width: 80%;">
			<div class="row">
				<div class="col-lg-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<!-- TITULO -->
							<h5>Búsqueda</h5>
							<div class="ibox-tools"></div>
						</div>
					</div>

					<%
						String codigo, descri;
						Integer cantidad;
						codigo = "";
						descri = "";
						cantidad = 0;

						if (request.getParameter("codigo") != null && request.getParameter("descri") != null) {
							codigo = "";
							descri = "";
							cantidad = 0;
						}

						//if (request.getParameter("codigo") != null || request.getParameter("codigo") != "" ) {
						//	codigo = request.getParameter("codigo");
						//}
						//else {
						//	codigo = "";
						//}
						//if (request.getParameter("descri") != null || request.getParameter("descri") != "" ) {
						//	descri = request.getParameter("descri");
						//}
						//else {
						//	descri = "";
						//}

						//String cantidadStr = request.getParameter("cantidad");
						//if (cantidadStr != null && !cantidadStr.isEmpty()) {
						//	cantidad = Float.parseFloat(cantidadStr);
						//}
						//else {

						//}

						if (request.getAttribute("SB1010Negocio") != null) {
							SB1010 SB1010Negocio = null;
							SB1010Negocio = (SB1010) request.getAttribute("SB1010Negocio");
							descri = SB1010Negocio.getB1_desc();
							codigo = SB1010Negocio.getB1_cod();
						}
					%>

					<table>
						<tr>
							<td>Codigo:</td>
							<td><input type="text" id="codigoInput" name="codigo"
								value="<%=codigo%>"></td>
							<td>
								<button type="submit" class="btn-buscar" name="btnBuscar">Buscar</button>
							</td>
						</tr>
						<tr>
							<td>Cantidad:</td>
							<td><input type="text" id="cantidadInput" name="cantidad"
								value="<%=cantidad%>"></td>
							<td>
								<button type="submit" class="btn-cantidad"
									name="btnGuardarCantidad" onclick="return guardarCantidad()">Guardar</button>
								<!-- onclick="return guardarCantidad()"  -->
							</td>
						</tr>
						<tr>
							<td>Descripción:</td>
							<td><input type="text" id="descriInput" name="descri"
								value="<%=StringEscapeUtils.escapeHtml4(descri)%>" readonly
								style="width: 300%;"></td>
						</tr>
					</table>




					<%
						ArrayList<R_RegistroInventario> listaR_RegistroInventario = null;

						if (request.getAttribute("listaR_RegistroInventario") != null)
							listaR_RegistroInventario = (ArrayList<R_RegistroInventario>) request
									.getAttribute("listaR_RegistroInventario");

						int totalR_RegistroInventario = listaR_RegistroInventario != null ? listaR_RegistroInventario.size() : 0;
						int artPorPagina = 10; // Define la cantidad de artículos por página
						int totalPaginas = (int) Math.ceil((double) totalR_RegistroInventario / artPorPagina);

						int paginaActual = 1;
						if (request.getParameter("pagina") != null) {
							paginaActual = Integer.parseInt(request.getParameter("pagina"));
							if (paginaActual < 1) {
								paginaActual = 1;
							} else if (paginaActual > totalPaginas) {
								paginaActual = totalPaginas;
							}
						}

						int offset = (paginaActual - 1) * artPorPagina;
						//List<Articulos> articulosPaginados = listaArticulos != null ? listaArticulos.subList(offset, Math.min(offset + artPorPagina, totalArticulos)) : new ArrayList<>();
						List<R_RegistroInventario> articulosPaginados = new ArrayList<>();
						if (listaR_RegistroInventario != null) {
							List<?> subList = listaR_RegistroInventario.subList(offset,
									Math.min(offset + artPorPagina, totalR_RegistroInventario));
							for (Object obj : subList) {
								if (obj instanceof R_RegistroInventario) {
									articulosPaginados.add((R_RegistroInventario) obj);
								}
							}
						} else {
							articulosPaginados = new ArrayList<>();
						}
					%>

					<table id="idTabla"
						class="table table-light table-striped table-hover"
						style="background-color: #e3f2fd;">
						<tr>
							<td id="idTd" align="center">Id</td>
							<td id="idTd" align="center">Codigo</td>
							<td id="idTd" align="center">Descripcion</td>
							<td id="idTd" align="center">Cantidad</td>
							<td id="idTd" align="center">Filial</td>
							<td id="idTd" align="center">Ubicacion</td>
							<td id="idTd" align="center">usuario</td>
							<td id="idTd" align="center">fecha</td>
							<td id="idTd" align="center">Editar</td>
							<td id="idTd" align="center">Eliminar</td>
						</tr>
						<%
							if (articulosPaginados != null) {
						%>
						<%
							for (R_RegistroInventario articulo : articulosPaginados) {
						%>
						<tr>
							<%
								Integer idArticulo = articulo.getId();
							%>
							<td align="center"><%=idArticulo%></td>
							<td align="center"><%=articulo.getCodigo()%></td>
							<td align="center"><%=StringEscapeUtils.escapeHtml4(articulo.getDescripcion())%></td>
							<td align="center"><%=articulo.getCantidad()%></td>
							<td align="center"><%=articulo.getFilial()%></td>
							<td align="center"><%=articulo.getUbicacion()%></td>
							<td align="center"><%=articulo.getUsuario()%></td>
							<td align="center"><%=articulo.getFecha()%></td>
							<td align="center" id="modificarTd">
								<!--  <button type="submit" class="btn-modificar" name="IdArticuloModificar" value="<%=idArticulo%>">Modificar</button>  -->
							</td>
							<td align="center" id="eliminarTd">
								<button type="submit" class="btn-eliminar"
									name="IdArticuloEliminar" value="<%=idArticulo%>"
									onclick="return confirmarEliminar()">Eliminar</button>
							</td>
						</tr>
						<%
							}
						%>
						<%
							}
						%>
						<div class="text-center">
							<ul class="pagination">
								<%
									if (paginaActual > 1) {
								%>
								<li><a href="?pagina=<%=paginaActual - 1%> ">&laquo;
										Anterior </a></li>
								<%
									}
								%>

								<%
									for (int i = 1; i <= totalPaginas; i++) {
								%>
								<li <%if (i == paginaActual) {%> class="active" <%}%>>
									<a href="?pagina=<%=i%> "> <%=i%></a>
								</li>
								<%
									}
								%>

								<%
									if (paginaActual < totalPaginas) {
								%>
								<li><a href="?pagina=<%=paginaActual + 1%> ">
										Siguiente &raquo;</a></li>
								<%
									}
								%>
							</ul>
						</div>
						<style>
.pagination li {
	display: inline;
	margin-right: 5px;
}
</style>
					</table>
	</form>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</html>