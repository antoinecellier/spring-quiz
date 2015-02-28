<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1>${Question.name}</h1>
	
	<spring:url var = "action" value='/admin/ajouterReponse' />
		
	<f:form cssClass="form-inline" modelAttribute="reponseForm" method="post" action="${action}">
		<div class="form-group">
            <label>Réponse texte</label>
		    <f:input cssClass="form-control" required="required" path="name"/>

        </div>
        <f:input type="hidden" path="questionId" value="${Question.questionId}"/>

		<div class="form-group">
		    <f:select path="correct" cssClass="form-control " items="${selectCorrect}" />
        </div>
				
		<input type="submit" class="btn btn-default btn-sm" value="Ajouter la reponse texte">
	</f:form>

 	<spring:url var = "addReponseImage" value='/admin/ajouterReponseImage?${_csrf.parameterName}=${_csrf.token}' />
	<form modelAttribute="reponseForm" class="top-buffer form-inline" method="post" action="${addReponseImage}"
			enctype="multipart/form-data">
		<div class="form-group">
            <label>Réponse image</label>
            <input name="fileUpload" class="form-control" type="file"/>
        </div>
        <div class="form-group">
            <select name="correct" class="form-control">
                <c:forEach items="${selectCorrect}" var="c">
                    <option value="${c.key}">${c.value}</option>
                </c:forEach>
            </select>
        </div>
		
		<input type="hidden" name="questionId" value="${Question.questionId}" /> 
		
		<input  class="btn btn-default btn-sm" type="submit" value="Ajouter la reponse image">
	</form>

	<c:if test="${not empty listReponses}">
		<ul class="top-buffer list-group">
		<c:forEach items="${listReponses}" var="reponse"> 
			<c:choose>
			      <c:when test="${reponse.type == 'text'}">
			      		<li class="list-group-item">
					    	${reponse.name}. ${reponse.correct} | 
					    <a class="btn btn-danger btn-xs" href="${contextPath}/admin/deleteReponse/${reponse.reponseId}/${Question.questionId}">
					    	X
					    </a>
					    </li>
			      </c:when>

			      <c:otherwise>
			      		<li class="list-group-item">
                            <div>
                                <spring:url var="picture" value='/user/image/${reponse.name}' />
                                <img width="250" height="180" class="thumbnail" src="${picture}">
                            </div>
                            <div>
                                ${reponse.correct} |
                                <a class="btn btn-danger btn-xs" href="${contextPath}/admin/deleteReponseImage/${reponse.reponseId}/${Question.questionId}">
                                    X
                                </a>
                            </div>
					    </li>
			      </c:otherwise>
			</c:choose>

		
		</c:forEach>
		</ul>
	</c:if> 
	
<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>