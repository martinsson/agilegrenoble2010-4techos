package org.agile.grenoble.data.xml;

//import org.agile.grenoble.data.Question;
import java.io.File;

import org.agile.grenoble.questions.AnswerType;
import org.agile.grenoble.questions.AnswersType;
import org.agile.grenoble.questions.ConfigurationType;
import org.agile.grenoble.questions.QuestionType;
import org.agile.grenoble.questions.QuestionsDocument;
import org.agile.grenoble.questions.QuestionsType;

	public class QuestionsReader
	{		
	    public static QuestionsType readItems(String filename) throws Exception
	    {
	    	System.out.println("get ressource ("+filename+")=>" + QuestionsReader.class.getResource(filename));
			File po = new File(QuestionsReader.class.getResource(filename).getFile() );
			
	    	//File po = new File(filename);
	        QuestionsDocument qsDoc = QuestionsDocument.Factory.parse(po);
      
	        QuestionsType qt = qsDoc.getQuestions();
	        return qt ; 
	    }
	    
	    	
	    public static void printItems(String filename) throws Exception
	    {
	        /*
	         * All XMLBeans schema types provide a nested Factory class you can
	         * use to bind XML to the type, or to create new instances of the type.
	         * Note that a "Document" type such as this one is an XMLBeans
	         * construct for representing a global element. It provides a way
	         * for you to get and set the contents of the entire element.
	         *
	         * Also, note that the parse method will only succeed if the
	         * XML you're parsing appears to conform to the schema.
	         */

	        QuestionsType qt = readItems(filename);
	        
	        QuestionType[] questions = qt.getQuestionArray();
	        print(questions,1);
	}

		private static void print(QuestionType[] questions, int depth) {
			for (int i =0; i < questions.length; i++) {
	        	QuestionType q = questions[i];
	        	for (int k=0; k < depth; k++) {
	        		System.out.print ("----" );
	        	}
	        	System.out.println (q.getLabel());
	        	AnswersType at = q.getAnswers();
	        	ConfigurationType ct = q.getConfiguration();
	        	if (ct != null ) {
	        		for (int k=0; k < depth; k++) {
		        		System.out.print ("    " );
		        	}
	        		System.out.println("Configuration = " + ct.getType() + "/" + ct.getNumber());
	        	}
	        	if (at != null) {
	        		AnswerType[] answers = at.getAnswerArray();
	        		for (int j=0; j<answers.length; j++) {
	        			AnswerType a = answers[j];
	        			for (int k=0; k < depth; k++) {
			        		System.out.print ("    " );
			        	}
	        			System.out.println("+ " + a.getLabel() + "-> " + a.getPoint() +"points " + "/ selected :" + a.getSelected());
	        		}
	        	} else {
	        		QuestionType[] subQuestions = q.getQuestionArray();
	        		print(subQuestions, depth+1);
	        		
	        	}
	        }
		}

}
