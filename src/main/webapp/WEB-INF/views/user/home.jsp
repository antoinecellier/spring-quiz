<%@include file="/WEB-INF/views/user/layout/header.jsp" %>
	
	<h4>Liste des questionnaires</h4>
	<c:if test="${not empty listQuestionnaire}">
		<ul class="list-group">
		<c:forEach items="${listQuestionnaire}" var="questionnaire"> 
		    <li class="list-group-item">
		    	<a href="user/startQuestionnaire/${questionnaire.questionnaireId}">
		    	${questionnaire.name}.
		    	</a>
		    </li>
		</c:forEach>
		</ul>
	</c:if>

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

<%@include file="/WEB-INF/views/user/layout/footer.jsp" %>