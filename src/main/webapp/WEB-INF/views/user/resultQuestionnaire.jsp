<%@include file="/WEB-INF/views/user/layout/header.jsp" %>

	<h3>Résultat du questionnaire : ${questionnaire.name}</h3>
	
	Vous avez répondu correctement à ${correctReponse}. Votre score est de ${score}.
	
<%@include file="/WEB-INF/views/user/layout/footer.jsp" %>