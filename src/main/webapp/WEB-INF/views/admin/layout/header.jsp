<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Utilisateur</title>

<!-- CSS -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<!-- JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>


</head>
<body>

<spring:url var = "questionnairesLink" value='/admin/questionnaire' />
<spring:url var = "questionsLink" value='/admin/question' />
<spring:url var = "utilisateursLink" value='/admin/utilisateur' />
<spring:url var = "userDisplay" value='/user' />

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">quiz</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li ><a href="${questionnairesLink}">Questionnaires<span class="sr-only">(current)</span></a></li>
        <li><a href="${questionsLink}">Questions</a></li> 
         <li><a href="${utilisateursLink}">Utilisateurs</a></li> 
        <sec:authorize access="hasRole('ROLE_ADMIN')">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<li><a href="javascript:formSubmit()"> Déconnexion</a></li>
		</c:if>
 
 
		</sec:authorize>
      </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${userDisplay}">Mode utilisateur</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  	
  		<!-- For login user -->
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
</nav>

  <c:if test="${not empty messageFlash}">
  	<div class="alert alert-danger" role="alert">${messageFlash}</div>
  </c:if>
  
<div class="container">
