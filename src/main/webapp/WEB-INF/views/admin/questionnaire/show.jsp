<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>

	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<h1>${Questionnaire.name}</h1>

	<c:choose>
	      <c:when test="${not empty questionSelect}">
			<spring:url var = "action" 
						value='/admin/ajouterQuestionQuestionnaire/${Questionnaire.questionnaireId}' />
		 	<f:form modelAttribute="questionForm" method="post" action="${action}">
				<div class="form-group">
                    <label>Nom de la question</label>
                    <f:select path="questionId" cssClass="form-control" items="${questionSelect}" />
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-default" value="Ajouter la question au questionnaire">
                </div>

            </f:form>
	      </c:when>
	
	      <c:otherwise>
	      	Aucune questions de disponibles
	      </c:otherwise>
	</c:choose>
	
	<c:if test="${not empty listQuestion}">
		<ul class="list-group">
		<c:forEach items="${listQuestion}" var="question"> 
		    <li class="list-group-item">
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