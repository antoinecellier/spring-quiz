<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>
<h3>Gérer les questions </h3>

<f:form modelAttribute="questionForm" method="post" action="ajouterQuestion">
		<div class="form-group">
            <label>Nom de la question</label>
            <f:input path="name" required="required" cssClass="form-control"/>
            </div>
        <div class="form-group">
		    <input type="submit" class="btn btn-default" value="Ajouter la question">
        </div>
	</f:form>
 
	<c:if test="${not empty listQuestion}">
		<ul  class="list-group">
		<c:forEach items="${listQuestion}" var="question"> 
		    <li class="list-group-item">
		    	<a href="showQuestion/${question.questionId}">
		    	${question.name}
		    	</a> | 
		    	<a class="btn btn-danger btn-xs" href="deleteQuestion/${question.questionId}">X</a>
		    </li>
		</c:forEach>
		</ul>
	</c:if>
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>