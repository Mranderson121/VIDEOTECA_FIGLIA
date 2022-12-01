<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.advancia.stage.model.*"%>
<html>
<head>
</head>
<body>
	<h1>Affitta il tuo film</h1>
	<form action="<%=request.getContextPath()%>/filmServlet" method="post">
		<div>
			<table style="float: left" width="350px" border="1">

				<tr>
					<th>Film</th>
				</tr>

				<%
				Utente utenteLoggato = (Utente) request.getSession().getAttribute("utenteLoggato");
				List<Film> listaFilm = (List<Film>) request.getAttribute("listaFilm");
				for (Film film : listaFilm) {
				%>
				<tr>
					<td><input type="checkbox" name="film"
						value="<%=film.getId()%>"> <%=film.getNome()%></td>

					<%
					}
					%>
				</tr>
			</table>

			
		</div>

		<input type="text" name="nome" id="Nome"> <input type="submit"
			name="submit" value="SUBMIT" style='background-color: red;'>


	</form>

	<h1>Lista film</h1>
	<table border="1">
		<%
		List<Film> listaFilm = utenteLoggato.getListaFilm();
		for (Film film : listaFilm) {
			StringBuilder etichetta = new StringBuilder();
			film.getListaRegisti().forEach(regista -> etichetta.append(regista.getNome()).append("; "));
		%>
		<tr>
			<td><%=film.getNome()%></td>
			<td><%=film.getRegista().getNome()%></td>
			<td><%=etichetta.toString()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>