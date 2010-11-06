package org.agile.grenoble.gui;

import javax.swing.JPanel;

import org.agile.grenoble.data.xml.QuestionsReader;
import org.agile.grenoble.questions.QuestionsType;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


public class NokiaSwingTest {

	private static QuestionsType questionsType;

	@BeforeClass
	public static void loadAndMarshallQuestions() throws Exception {
		String filename = "/org/agile/grenoble/data/xml/questionsForTests.xml"; //$NON-NLS-1$
		QuestionsReader.printItems(filename);
		questionsType = QuestionsReader.readItems(filename);
	}
	
	@Ignore
	public void generateQuestionsPanels() throws Exception {
		NokiaSwing nokiaSwing = new NokiaSwing();
		JPanel[] questionsPanel = nokiaSwing.generateQuestionsPanels(questionsType);
		assertThat(questionsPanel.length, equalTo(7));
	}
	
	@Test
	public void addScorePanelToQuestionsPanels() throws Exception {
		NokiaSwing nokiaSwing = new NokiaSwing();
		JPanel[] questionsPanel = nokiaSwing.generateQuestionsPanels(questionsType);
		assertThat(questionsPanel.length, equalTo(8));
		JPanel scorePanel = questionsPanel[7];
//		scorePanel.getComponents()nokiaSwing;
		assertThat(scorePanel, instanceOf(QuestionPanel.class));
		assertThat(((QuestionPanel) scorePanel).getScoreResult(), containsString("NokiaTest result is"));
	}
}
