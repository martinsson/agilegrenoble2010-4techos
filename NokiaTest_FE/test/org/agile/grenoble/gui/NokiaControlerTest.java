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

public class NokiaControlerTest {
    @Test
    public void tellsUiToDisplayEveryQuestionAndThenTellsItToTerminate() throws Exception {
        NokiaControler controler = new NokiaControler();
        NokiaSwing nokiaSwing = mock(NokiaSwing.class);
        controler.setNokiaSwing(nokiaSwing);
        controler.setStorage(mock(AnswersStorage.class));
        
        int nbOfQuestions = 7;
        QuestionsType questionsType = mock(QuestionsType.class);
        when(questionsType.sizeOfQuestionArray()).thenReturn(nbOfQuestions);
        controler.setQuestions(questionsType);
        
        controler.startQuestions(new User());
        controler.actionPerformed(null);
        controler.actionPerformed(null);
        controler.actionPerformed(null);
        controler.actionPerformed(null);
        controler.actionPerformed(null);
        controler.actionPerformed(null);
        controler.actionPerformed(null);
        
        verify(nokiaSwing, times(nbOfQuestions-1)).nextQuestion(anyInt(), anyBoolean());
        verify(nokiaSwing).terminateTest();     
    }
}
