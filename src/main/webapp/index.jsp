<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<anyxmlelement xmlns:c="http://java.sun.com/jsp/jstl/core" />
<%@page import="java.sql.*"%>
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
	<%
	Connection con;
	String url = "jdbc:mysql://localhost:3306/desarrollo";
	String Driver = "com.mysql.cj.jdbc.Driver";
	String user = "root";
	String clave = "password";
	Class.forName(Driver);
	con = DriverManager.getConnection(url, user, clave);
	PreparedStatement ps;
	ResultSet rs;
	ps = con.prepareStatement("select p.nombre, p.apellido,v.fechavisita, p.correo,v.idpropiedad,p2.direccion from persona p inner join visitas v on v.idpersona = p.id inner join propiedad p2 on p2.id = v.idpropiedad");
	rs = ps.executeQuery();
	%>
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
				<tr>
					<th>nombre</th>
					<th>apellido</th>
					<th>fechavisita</th>
					<th>correo</th>
					<th>idpropiedad</th>
					<th>direccion</th>
					<%
					while (rs.next()) {
					%>
				</tr>
				<tbody>
				<c:forEach var="listPersonas" items="${listPersonas}">
					<tr>
						<td><%=rs.getString("nombre")%></td>
						<td><%=rs.getString("apellido")%></td>
						<td><%=rs.getString("fechavisita")%></td>
						<td><%=rs.getString("correo")%></td>
						<td><%=rs.getInt("idpropiedad")%></td>
						<td><%=rs.getString("direccion")%></td>
						
						<td>${listPersonas.fechavisita}</td>
<%-- 						<td>${listPersonas.correo}</td> --%>
<%-- 						<td>${listPersonas.idpropiedad}</td> --%>
<%-- 						<td>${listPersonas.direccion}</td> --%>
					</tr>

					<%
					}
					%>
				</c:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>