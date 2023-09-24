<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="frgp.utn.edu.ar.entidad.R_RegistroInventario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style type="text/css">
#idTabla {
    border: 1px solid black;
}

#idTd {
    border: 1px solid black;
}
</style>

<title>Articulos Listar</title>
</head>

<script>
    function confirmarEliminar() {
        return confirm("¿Seguro desea eliminar el registro?");
    }
</script>

<body>

<%@include file="HeaderVendedor.jsp" %>

<form action="pagArticulosAccion.html" method="post">

    <div class="row wrapper border-bottom white-bg page-heading" style="margin: auto; width: 80%;">
        <div class="col-lg-10">
            <h2>Articulos</h2>
            <ol class="breadcrumb">
                <li>
                    ABM
                </li>
                <li class="active">
                    <strong>Articulos</strong>
                </li>
            </ol>
        </div>
    </div>

    <div class="wrapper wrapper-content animated fadeInRight" style="margin: auto; width: 80%;">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <!-- TITULO -->
                        <h5>Articulos</h5>
                        <div class="ibox-tools"></div>
                    </div>
                </div>
       



    <%
    ArrayList<R_RegistroInventario> listaR_RegistroInventario = null;
	
    if (request.getAttribute("listaR_RegistroInventario") != null)
    	listaR_RegistroInventario = (ArrayList<R_RegistroInventario>) request.getAttribute("listaR_RegistroInventario");

	int totalArticulos = listaR_RegistroInventario != null ? listaR_RegistroInventario.size() : 0;
	int artPorPagina = 10; // Define la cantidad de artículos por página
	int totalPaginas = (int) Math.ceil((double) totalArticulos / artPorPagina);
	
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
    List<?> subList = listaR_RegistroInventario.subList(offset, Math.min(offset + artPorPagina, totalArticulos));
    for (Object obj : subList) {
        if (obj instanceof R_RegistroInventario) {
            articulosPaginados.add((R_RegistroInventario) obj);
        }
    }
} else {
    articulosPaginados = new ArrayList<>();
}
	%>

    <table id="idTabla" class="table table-light table-striped table-hover" style="background-color: #e3f2fd;">
        <tr>
        	<td id="idTd" align="center">Id</td>
            <td id="idTd" align="center">Codigo</td>
            <td id="idTd" align="center">Descripcion</td>
            <td id="idTd" align="center">Cantidad</td>
            <td id="idTd" align="center">Filial</td>
            <td id="idTd" align="center">Ubicacion</td>
            <td id="idTd" align="center">Usuario</td>
            <td id="idTd" align="center">Fecha</td>
            <td id="idTd" align="center">Editar</td>
            <td id="idTd" align="center">Eliminar</td>
        </tr>
        <% if (articulosPaginados != null) { %>
            <% for (R_RegistroInventario articulo : articulosPaginados) { %>
                <tr>
                    <% Integer idArticulo = articulo.getId(); %> 
                    <td><%= idArticulo %></td>
                    <td><%= articulo.getCodigo() %></td>
                    <td><%= articulo.getDescripcion() %></td>
                    <% Integer Cantidad = articulo.getCantidad(); %>
                    <td><%= Cantidad %></td>
                    <td><%= articulo.getFilial() %></td>
                    <td><%= articulo.getUbicacion() %></td>
                    <td><%= articulo.getUsuario() %></td>
                    <td><%= articulo.getFecha() %></td>
                    <td id="idTd">
                        <button type="submit" class="btn-modificar" name="IdArticuloModificar" value="<%= idArticulo %>">Modificar</button>
                    </td>
                    <td id="idTd">
                        <button type="submit" class="btn-eliminar" name="IdArticuloEliminar" value="<%= idArticulo %>" onclick="return confirmarEliminar()">Eliminar</button>
                    </td>
                </tr>
            <% } %>
        <% } %>
		<div class="text-center">
		    <ul class="pagination">
		        <% if (paginaActual > 1) { %>
		            <li><a href="?pagina=<%= paginaActual - 1 %> ">&laquo; Anterior </a></li>
		        <% } %>
		
		        <% for (int i = 1; i <= totalPaginas; i++) { %>
		            <li <% if (i == paginaActual) { %>class="active"<% } %>> <a href="?pagina=<%= i %> "> <%= i %></a></li>
		        <% } %>
		
		        <% if (paginaActual < totalPaginas) { %>
		            <li><a href="?pagina=<%= paginaActual + 1 %> "> Siguiente &raquo;</a></li>
		        <% } %>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>