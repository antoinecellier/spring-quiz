<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Utilisateur</title>
</head>
<body>
	<f:form modelAttribute="utilisateurForm" method="post" action="ajouterUtilisateur">
		<label>Username</label>
		<f:input path="username"/>
		<f:errors path="username"></f:errors>
		
		<label>Password</label>
		<f:input path="password"/>
		<f:errors path="password"></f:errors>
		
		<input type="submit" value="S'enregistrer">
	</f:form>
	 
	<c:if test="${utilisateurForm.username != null && utilisateurForm.password != null}">
		<h1>Username : ${utilisateurForm.username}</h1>
		<h1>Password : ${utilisateurForm.password}</h1>
	</c:if>
</body>
</html>