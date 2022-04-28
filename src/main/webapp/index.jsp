<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.inmobiliaria.app.dao.impl.personasDAOImpl"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
</head>
<body>

	<div align="center" class="container" p-5>

		</head>
		<div class="container py-5">
			<h1 class="title is-1">Registro de Personas</h1>
			<form method="GET" action="">
				<div class="field has-addons p-5">
					<div class="control">
						<input class="input" name="listPersonas" value="${listPersonas}"
							type="text" placeholder="buscar persona">
					</div>
					<div class="control">
						<button class="button is-info">Buscar</button>
					</div>
				</div>
		</div>
		</form>
		<div>
			<table border="1" cellpadding="5"
				class="table is-striped is-bordered is-fullwidth is-hoverable">
				<thead>
					<tr>
						<th>nombre</th>
						<th>apellido</th>
						<th>fechavisita</th>
						<th>correo</th>
						<th>idpropiedad</th>
						<th>direccion</th>
					</tr>
				</thead>
				<tbody>
					<%
				personasDAOImpl api= new personasDAOImpl();
				  DefaultTableModel tabla = new DefaultTableModel();
			        tabla = api.leer();
			        
			        for (int t=0;t<tabla.getRowCount();t++){
			            out.println("<tr data-id="+ tabla.getValueAt(t, 0) + ">");
			            out.println("<td>"+ tabla.getValueAt(t, 1) +"</td>");
			            out.println("<td>"+ tabla.getValueAt(t, 2) +"</td>");
			            out.println("<td>"+ tabla.getValueAt(t, 3) +"</td>");
			            out.println("<td>"+ tabla.getValueAt(t, 4) +"</td>");
			            out.println("<td>"+ tabla.getValueAt(t, 5) +"</td>");
			            out.println("<td>"+ tabla.getValueAt(t, 6) +"</td>");
			            out.println("</tr>");
			        
			        }
			        
			        %>
				</tbody>
			</table>
		</div>
</body>
</html>