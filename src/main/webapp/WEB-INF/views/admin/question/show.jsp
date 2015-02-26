<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	${ prout } <br>

	<h1>${Question.name}</h1>
	
	<spring:url var = "action" value='/admin/ajouterReponse' />
		
	<f:form modelAttribute="reponseForm" method="post" action="${action}">
		<label>Réponse texte</label>
		<f:input path="name"/>
		<f:errors path="name"></f:errors>
		
		<f:input type="hidden" path="questionId" value="${Question.questionId}"/>		
		
		<f:select path="correct" items="${selectCorrect}" />
				
		<input type="submit" value="Ajouter la reponse texte">
	</f:form>

 	<spring:url var = "addReponseImage" value='/admin/ajouterReponseImage?${_csrf.parameterName}=${_csrf.token}' />
	<form modelAttribute="reponseForm" method="post" action="${addReponseImage}" 
			enctype="multipart/form-data">
			
		<label>R�ponse image</label>
		<input name="fileUpload" type="file"/>
		
		<select name="correct">
			<c:forEach items="${selectCorrect}" var="c">
				<option value="${c.key}">${c.value}</option>
			</c:forEach>
		</select>
		
		<input type="hidden" name="questionId" value="${Question.questionId}" /> 
		
		<input type="submit" value="Ajouter la reponse image">
	</form>
	<c:if test="${not empty listReponses}">
		<ul>
		<c:forEach items="${listReponses}" var="reponse"> 
			<c:choose>
			      <c:when test="${reponse.type == 'text'}">
			      		<li>
					    	${reponse.name}. ${reponse.correct} | 
					    <a href="${contextPath}/admin/deleteReponse/${reponse.reponseId}/${Question.questionId}">
					    	X
					    </a>
					    </li>
			      </c:when>

			      <c:otherwise>
			      		<li>
                            <spring:url var="picture" value='/user/image/${reponse.name}' />
                            <img height="200" width="200" src="${picture}">
					    	. ${reponse.correct} | 
					    <a href="${contextPath}/admin/deleteReponseImage/${reponse.reponseId}/${Question.questionId}">
					    	X
					    </a>
					    </li>
			      </c:otherwise>
			</c:choose>

		
		</c:forEach>
		</ul>
	</c:if> 
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>