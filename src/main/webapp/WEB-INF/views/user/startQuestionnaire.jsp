<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

                            <div class="checkbox">
                                <label>
                                <input  type="checkbox" value="${reponse.reponseId}" name="c-${question.questionId}"/>
                                    <c:choose>
                                      <c:when test="${reponse.type == 'text'}">${reponse.name}</c:when>
                                      <c:otherwise>
                                          <spring:url var="picture" value='/user/image/${reponse.name}' />
                                          <img height="200" width="200" src="${picture}">
                                      </c:otherwise>
                                    </c:choose>
                                </label>
                            </div>

				   	</c:when>

      				<c:otherwise>

                            <div class="radio">
                                <label >
                                    <input type="radio" value="${reponse.reponseId}" name="r-${question.questionId}"/>
                                    <c:choose>
                                      <c:when test="${reponse.type == 'text'}">${reponse.name}</c:when>
                                      <c:otherwise>
                                          <spring:url var="picture" value='/user/image/${reponse.name}' />
                                          <img height="200" width="200" src="${picture}">
                                      </c:otherwise>
                                    </c:choose>
                                </label>
                            </div>

					</c:otherwise>
				</c:choose>
			</c:forEach>
	</c:forEach>
        <div class="form-group">
	        <input class="btn btn-default" type="submit" value="Envoyer le questionnaire">
        </div>
	</f:form>

<%@include file="/WEB-INF/views/user/layout/footer.jsp" %>