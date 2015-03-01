<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp" %>
<spring:url var = "loginLink" value='/login' />
    <div class="jumbotron">
        <h1>Bienvenue sur le jeux du quizz</h1>
        <p>Réalisations : Antoine Cellier - Amaury Lavieille</p>
        <p><a class="btn btn-primary btn-lg" href="${loginLink}" role="button">Connexion</a></p>
    </div>

    <div>
        <h4>Meilleur score</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Score</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listUtilisateur}" var="utilisateur">
                <tr>
                    <td>${utilisateur.username}</td>
                    <td>${utilisateur.score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

<%@include file="/WEB-INF/views/layout/footer.jsp" %>