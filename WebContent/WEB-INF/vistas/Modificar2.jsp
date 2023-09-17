<%@ page language="java" contentType="text/html; charset=UTF-81"
	pageEncoding="ISO-8859-1"%>

<%@ page import="frgp.utn.edu.ar.entidad.SBE010"%>
<%@ page import="frgp.utn.edu.ar.entidad.Userubicacion"%>
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
<title>Articulos Modificar</title>
</head>
<body>
	<%@ include file="HeaderVendedor.jsp"%>

	<div class="wrapper wrapper-content animated fadeInRight"
		style="margin: auto; width: 75%;">
		<div class="row">
			<div class="col-lg-12">
				<div class="ibox float-e-margins">
					<form>
						<%
							String id = request.getParameter("id");
							String usuario = request.getParameter("usuario");
							String filial = request.getParameter("filial");
							String localiz = request.getParameter("localiz");
							ArrayList<SBE010> listaSBE010 = null;
							if (request.getAttribute("listaSBE010") != null)
								listaSBE010 = (ArrayList<SBE010>) request.getAttribute("listaSBE010");
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
									<td id="idTd" align="center">Editar</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td align="center"><%=id%></td>
									<td align="center"><%=usuario%></td>
									<td align="center"><select name="filial" onchange="actualizarLocalizaciones()" isloading="actualizarLocalizaciones()">
											<option value="01" <%=filial.equals("01") ? "selected" : ""%>>01</option>
											<option value="02" <%=filial.equals("02") ? "selected" : ""%>>02</option>
									</select></td>
									<td align="center"><select name="localiz">
										<%
											for (SBE010 ubicacion2 : listaSBE010) {
												String selected = ubicacion2.getBe_localiz().equals(localiz) ? "selected" : "";
										%>
										<option value="<%=ubicacion2.getBe_localiz()%>"	data-filial="<%=ubicacion2.getBe_filial()%>" <%=selected%>><%=ubicacion2.getBe_localiz()%></option>
										<%
											}
										%>
									</select></td>
									<td align="center" id="idTd">
										<button type="submit" class="btn btn-modificar" name="IdArticuloModificar" value=<%=id%>>Guardar</button>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	// Función para actualizar las opciones de localizaciones según la filial seleccionada
function actualizarLocalizaciones() {
  var filialSeleccionada = document.getElementsByName("filial")[0].value;
  var localizSelect = document.getElementsByName("localiz")[0];
  var localizOptions = localizSelect.options;
  
  // Restaurar todas las opciones
  for (var i = 0; i < localizOptions.length; i++) {
    localizOptions[i].style.display = "";
  }
  
  // Ocultar las opciones que no corresponden a la filial seleccionada
  for (var i = 0; i < localizOptions.length; i++) {
    if (localizOptions[i].getAttribute("data-filial") !== filialSeleccionada) {
      localizOptions[i].style.display = "none";
    }
  }

  // Seleccionar la primera opción disponible
  for (var i = 0; i < localizOptions.length; i++) {
    if (localizOptions[i].style.display !== "none") {
      localizOptions[i].selected = true;
      break;
    }
  }
};
</script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</html>