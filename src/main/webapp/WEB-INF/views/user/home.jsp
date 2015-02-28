<%@include file="/WEB-INF/views/user/layout/header.jsp" %>
	
	<h4>Liste des questionnaires</h4>
	<c:if test="${not empty listQuestionnaire}">
		<ul class="list-group">
		<c:forEach items="${listQuestionnaire}" var="questionnaire"> 
		    <li class="list-group-item">
		    	<a href="user/startQuestionnaire/${questionnaire.questionnaireId}">
		    	${questionnaire.name}.
		    	</a>
		    </li>
		</c:forEach>
		</ul>
	</c:if>

<%@include file="/WEB-INF/views/user/layout/footer.jsp" %>