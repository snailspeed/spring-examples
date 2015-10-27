<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<c:if test="${not empty error}">
		<span style="color: red">${error}</span>
	</c:if>
	<c:if test="${not empty msg}">
		<span style="color: green">${msg}</span>
	</c:if>
	<form:form method="post" action="index.html" modelAttribute="userAttribute">
		<table>
			<tr>
				<td><form:label path="name">Naam:</form:label></td>
				<td><form:input path="name" maxlength="32" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">Voornaam:</form:label></td>
				<td><form:input path="firstName" maxlength="32" /></td>
			</tr>
			<tr>
				<td><form:label path="mail">E-mail:</form:label></td>
				<td><form:input path="mail" maxlength="128" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Verzend" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
