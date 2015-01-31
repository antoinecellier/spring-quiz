<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>
  
	<f:form modelAttribute="questionForm" method="post" action="ajouterQuestion">
		<label>Nom de la question</label>
		<f:input path="name"/>
		<f:errors path="name"></f:errors>
		
		<input type="submit" value="Ajouter la question">
	</f:form>
 
	<c:if test="${not empty listQuestion}">
		<ul>
		<c:forEach items="${listQuestion}" var="question"> 
		    <li>
		    	<a href="showQuestion/${question.questionId}">
		    	${question.name}. Id : ${question.questionId}
		    	</a> | 
		    	<a href="deleteQuestion/${question.questionId}">Delete</a>
		    </li>
		</c:forEach>
		</ul>
	</c:if>
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>