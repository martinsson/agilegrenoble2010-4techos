package org.agile.grenoble.gui;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.agile.grenoble.data.AnswersStorage;
import org.agile.grenoble.questions.QuestionsType;
import org.agile.grenoble.user.User;
import org.junit.Test;

public class NokiaControllerTest {
	
	@Test
	public void actionPerformTest() throws Exception {
		NokiaControler controler = new NokiaControler();
		QuestionsType questionsType = mock(QuestionsType.class);
		when(questionsType.sizeOfQuestionArray()).thenReturn(7);
		
		NokiaSwing nokiaSwing = mock(NokiaSwing.class);
		AnswersStorage storage = mock(AnswersStorage.class);
		User user = mock(User.class);
		
		controler.setQuestions(questionsType);
		controler.setNokiaSwing(nokiaSwing);
		controler.setStorage(storage);
		controler.currentUser = user;
		controler.currentQuestionIndex = 0;
		
		controler.actionPerformed(null);
		controler.actionPerformed(null);
		controler.actionPerformed(null);
		controler.actionPerformed(null);
		controler.actionPerformed(null);
		controler.actionPerformed(null);
		controler.actionPerformed(null);
		
		verify(nokiaSwing, times(6)).nextQuestion(anyInt(), anyBoolean());
		verify(nokiaSwing).terminateTest();		
	}

}
