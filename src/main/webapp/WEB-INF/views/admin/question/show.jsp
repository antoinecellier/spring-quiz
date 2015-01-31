<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<h1>${Question.name}</h1>
	
	<spring:url var = "action" value='/admin/ajouterReponse' />
	<f:form modelAttribute="reponseForm" method="post" action="${action}">
		<label>La réponse</label>
		<f:input path="name"/>
		<f:errors path="name"></f:errors>
		
		<f:input type="hidden" path="questionId" value="${Question.questionId}"/>		
		
		<f:select path="correct" items="${selectCorrect}" />
		<f:errors path="name"></f:errors>
				
		<input type="submit" value="Ajouter la reponse">
	</f:form>

	<c:if test="${not empty listReponses}">
		<ul>
		<c:forEach items="${listReponses}" var="reponse"> 
		    <li>
		    	${reponse.name}. ${reponse.correct} | 
		    <a href="${contextPath}/admin/deleteReponse/${reponse.reponseId}/${Question.questionId}">
		    	X
		    </a>
		    </li>
		</c:forEach>
		</ul>
	</c:if> 
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>