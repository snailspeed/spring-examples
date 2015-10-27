<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<form:form method="post" action="form.html">
		<table>
			<tr>
				<td><form:label path="tekst">Tekst:</form:label></td>
				<td><form:input path="tekst" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Ga" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
