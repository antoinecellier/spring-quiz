<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/layout/header.jsp" %>
<div class="jumbotron">

    <h1>Panneau d'administration</h1>
    <spring:url var = "linkQuestion" value='/admin/question' />
    <spring:url var = "linkQuestinnaire" value='/admin/questionnaire' />
    <h4>Nouveau questionnaire</h4>
    <ol>
        <li>Ajouter des <a href="${linkQuestion}">questions.</a></li>
        <li>Créer un <a href="${linkQuestinnaire}">questionnaire.</a></li>
        <li>Selectionner les questions du questionnaires.</li>
    </ol>
</div>
	

<%@include file="/WEB-INF/views/admin/layout/footer.jsp" %>