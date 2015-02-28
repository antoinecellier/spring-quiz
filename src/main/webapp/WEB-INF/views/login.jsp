<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp" %>
 
	<h3>Connexion</h3>
    
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
 
		<form name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>
 
		<div class="form-group">
            <label for="username">Utilisateur</label>
            <input type='text' required="required" class="form-control" id="username" name='username'>
        </div>
        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type='password' required="required" class="form-control" id="password" name='password'>
        </div>
		<div class="form-group">
            <input class="btn btn-default" name="submit" type="submit"
                   value="submit" />
        </div>

            <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
 
		</form>
 
<%@include file="/WEB-INF/views/layout/footer.jsp" %>