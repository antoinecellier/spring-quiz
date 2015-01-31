package test;

import java.util.ArrayList;

import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Questionnaire;
import org.dnr.devoir.entities.Reponse;
import org.dnr.devoir.entities.Utilisateur;
import org.dnr.devoir.metier.question.IQuestionMetier;
import org.dnr.devoir.metier.questionnaire.IQuestionnaireMetier;
import org.dnr.devoir.metier.utilisateur.IUtilisateurMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		// ##########UTILISATEURS
//		IUtilisateurMetier metier = (IUtilisateurMetier) context.getBean("UtilisateurMetier");
//		metier.create(new Utilisateur("antoine","antoine"));
//		Utilisateur alex = metier.create(new Utilisateur("alex","alex"));

//		alex.setPassword("root");
//		metier.update(alex);
//		metier.delete(alex);
//		metier.retrieveAllName();
//		metier.retrieveAll();
				
		// ##########QUESTIONS
		IQuestionMetier metierQuestion = (IQuestionMetier) context.getBean("QuestionMetier");
		Question q1 = metierQuestion.create(new Question("Quel est la couleur?"));
		
		ArrayList<Question> questions = (ArrayList<Question>) metierQuestion.retrieveAll();
		
		// ##########REPONSES
		Reponse bleu = metierQuestion.createReponse(new Reponse("bleu","text", q1, true));
		metierQuestion.createReponse(new Reponse("rouge","text", q1, false));
		metierQuestion.createReponse(new Reponse("noir","text", q1, false));
		
		ArrayList<Reponse> reponses = (ArrayList<Reponse>) metierQuestion.retrieveAllReponse();
		// ##########QUESTIONNAIRE
		IQuestionnaireMetier metierQuestionnaire = 
				(IQuestionnaireMetier) context.getBean("QuestionnaireMetier");
		Questionnaire first = metierQuestionnaire.create(new Questionnaire("first"));
				
		first.setQuestions(questions);
		metierQuestionnaire.update(first);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}