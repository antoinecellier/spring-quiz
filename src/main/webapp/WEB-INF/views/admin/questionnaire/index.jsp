<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>

    <h3>Gérer les questionnaires </h3>

	<f:form modelAttribute="questionnaireForm" method="post" action="ajouterQuestionnaire">
		<div class="form-group">
            <label>Nom du questionnaire</label>
            <f:input cssClass="form-control"  required="required" path="name"/>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Ajouter le questionnaire">
        </div>
	</f:form>
 
	<c:if test="${not empty listQuestionnaire}">
		<ul class="list-group" >
		<c:forEach items="${listQuestionnaire}" var="questionnaire"> 
		    <li class="list-group-item">
		    	<a href="showQuestionnaire/${questionnaire.questionnaireId}">
		    	${questionnaire.name}
		    	</a>  |
                <a class="btn btn-danger btn-xs" href="deleteQuestionnaire/${questionnaire.questionnaireId}">X</a>
		    </li>
		</c:forEach>
		</ul>
	</c:if>
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>