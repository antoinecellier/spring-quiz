<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>

	<h4>Ajouter un utilisateur</h4>
	<spring:url var = "action" value='ajouterUtilisateur' />
	<f:form modelAttribute="utilisateurForm" method="post" action="${action}">
		<div class="form-group">
            <label>Username</label>
            <f:input cssClass="form-control" required="required" path="username"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <f:input cssClass="form-control" required="required" path="password"/>
        </div>

        <div class="form-group">
            <label>Role</label>
            <f:select cssClass="form-control"  path="role" items="${roleSelect}" />
        </div>

        <div class="form-group">
		    <input type="submit" class="btn btn-default" value="S'enregistrer">
        </div>
	</f:form>
	
	<h4 class="top-buffer">Liste des utlisateurs</h4>
	<ul class="list-group">
		<c:forEach items="${listUtilisateur}" var="utilisateur"> 
		    <li class="list-group-item">
		    	${utilisateur.username} => ${utilisateur.role} |
		    	<a class="btn btn-danger btn-xs" href="deleteUtilisateur/${utilisateur.utilisateurId}"> X</a>
		    </li>
		</c:forEach>
	</ul>
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>