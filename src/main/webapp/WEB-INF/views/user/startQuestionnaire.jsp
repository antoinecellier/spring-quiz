<%@include file="/WEB-INF/views/user/layout/header.jsp" %>

	<h2>${questionnaire.name}</h2>
	<spring:url var = "action" value='/user/checkQuestionnaire/${questionnaire.questionnaireId}' />
	<f:form modelAttribute="jeuForm" method="post" action="${action}">
	
	<c:forEach items="${questions}" var="question">
			<h4>${question.name}</h4>
			
			<c:set var="count" value="0" />
			<c:set  var="multipleReponse" value="false"/>
			
			<c:forEach items="${question.reponses}" var="reponse">
				<c:if test="${reponse.correct}">
					<c:set var="count" value="${count + 1}" />
				</c:if>
			</c:forEach>
			
			<c:if test="${ count > 1 }">
				<c:set  var="multipleReponse" value="true"/>
			</c:if>
			

			<c:forEach items="${question.reponses}" var="reponse">
				<c:set  var="valueCheckBox" value="${question.questionId}-${reponse.reponseId}"/>
				<c:choose>
					<c:when test="${multipleReponse}">
						<div>
							<input type="checkbox" value="${reponse.reponseId}" name="c-${question.questionId}"/>
							${reponse.name}
						</div>
				   	</c:when>

      				<c:otherwise>
						<div>
							<input type="radio" value="${reponse.reponseId}" name="r-${question.questionId}"/>
							${reponse.name}
						</div>					
					</c:otherwise>
				</c:choose>
			</c:forEach>
	</c:forEach>
	
	<input type="submit" value="Envoyer le questionnaire">
	
	</f:form>

<%@include file="/WEB-INF/views/user/layout/footer.jsp" %>