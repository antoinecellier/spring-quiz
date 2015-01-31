<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>

	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<h1>${Questionnaire.name}</h1>
	<h1>Identifiant : ${Questionnaire.questionnaireId}</h1>

	<c:choose>
	      <c:when test="${not empty questionSelect}">
			<spring:url var = "action" 
						value='/admin/ajouterQuestionQuestionnaire/${Questionnaire.questionnaireId}' />
		 	<f:form modelAttribute="questionForm" method="post" action="${action}">
				<label>Nom de la question</label>
				<f:select path="questionId" items="${questionSelect}" />
				
				<input type="submit" value="Ajouter la question au questionnaire">
			</f:form>
	      </c:when>
	
	      <c:otherwise>
	      	Aucune questions de disponibles
	      </c:otherwise>
	</c:choose>
	
	<c:if test="${not empty listQuestion}">
		<ul>
		<c:forEach items="${listQuestion}" var="question"> 
		    <li>
		    	${question.name} |
		    	<a 
		    	href="${contextPath}/admin/supprimerQuestionQuestionnaire/${question.questionId}/${Questionnaire.questionnaireId}">
		    	Retirer la question du questionnaire
		    	</a>	
		    </li>
		</c:forEach>
		</ul>
	</c:if> 
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>