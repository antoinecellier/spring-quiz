<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>

	<h4>Ajouter un utilisateur</h4>
	<spring:url var = "action" value='ajouterUtilisateur' />
	<f:form modelAttribute="utilisateurForm" method="post" action="${action}">
		<label>Username</label>
		<f:input path="username"/>
		<f:errors path="username"></f:errors>
		
		<label>Password</label>
		<f:input path="password"/>
		<f:errors path="password"></f:errors>
		
		<label>Role</label>
		<f:select path="role" items="${roleSelect}" />
		
		<input type="submit" value="S'enregistrer">
	</f:form>
	
	<h4>Liste des utlisateurs</h4>
	<ul>
		<c:forEach items="${listUtilisateur}" var="utilisateur"> 
		    <li>
		    	${utilisateur.username} => ${utilisateur.role} |
		    	<a href="deleteUtilisateur/${utilisateur.utilisateurId}"> Delete</a>
		    </li>
		</c:forEach>
	</ul>
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>