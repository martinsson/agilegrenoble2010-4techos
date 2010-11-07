package org.agile.grenoble.gui;

import static java.util.Arrays.asList;
import static org.agile.grenoble.gui.HasTextField.hasTextField;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.junit.Assert.assertThat;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

import org.agile.grenoble.data.xml.QuestionsReader;
import org.agile.grenoble.questions.QuestionsType;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class NokiaSwingTest {

	private static QuestionsType questionsType;

	@BeforeClass
	public static void loadAndMarshallQuestions() throws Exception {
		String filename = "/org/agile/grenoble/data/xml/questions.xml"; //$NON-NLS-1$
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

		assertThat(scorePanel, instanceOf(QuestionPanel.class));
		MatcherAssert.assertThat(scorePanel, hasTextField(startsWith("NokiaTest result is")));
		
	}
	
//    private Matcher<Component[]> hasTextComponent(
//			Matcher<JTextComponent> matcher) {
////    	return new TypeSafeDiagnosingMatcher<Component>() {
////		};
//		return (Matcher<Component[]>)hasItemInArray(allOf(instanceOf(JTextComponent.class), matcher));
//	}
//
//	public Matcher<JTextComponent> withText(final Matcher<String> matcher) {
//		return new TypeSafeDiagnosingMatcher<JTextComponent>() {
//
//			public void describeTo(Description description) {
//				description.appendText("a text panel with ").appendDescriptionOf(matcher);
//			}
//
//			@Override
//			protected boolean matchesSafely(JTextComponent item, Description mismatchDescription) {
//				mismatchDescription.appendText("toto");
//				return matcher.matches(item.getText());
//			}
//		};
//		
//    }
    
	

}
