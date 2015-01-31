<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>

	<f:form modelAttribute="questionnaireForm" method="post" action="ajouterQuestionnaire">
		<label>Nom du questionnaire</label>
		<f:input path="name"/>
		<f:errors path="name"></f:errors>
		
		<input type="submit" value="Ajouter le questionnaire">
	</f:form>
 
	<c:if test="${not empty listQuestionnaire}">
		<ul>
		<c:forEach items="${listQuestionnaire}" var="questionnaire"> 
		    <li>
		    	<a href="showQuestionnaire/${questionnaire.questionnaireId}">
		    	${questionnaire.name}. Id : ${questionnaire.questionnaireId}
		    	</a>
		    	<a href="deleteQuestionnaire/${questionnaire.questionnaireId}">Delete</a>
		    </li>
		</c:forEach>
		</ul>
	</c:if>
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>