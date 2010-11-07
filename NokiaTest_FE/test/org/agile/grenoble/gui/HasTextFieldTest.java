package org.agile.grenoble.gui;

import static org.agile.grenoble.gui.HasTextField.hasTextField;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Test;


public class HasTextFieldTest {
	@Test
	public void describesExpectedCharacteristics() throws Exception {
		Matcher<? super String> addedConstraint = equalTo("toto");
		Matcher<JPanel> matcher = hasTextField(addedConstraint);
		StringDescription description = new StringDescription();

		matcher.describeTo(description);
		assertThat(description.toString(), equalTo("a JPanel with a TextField with " + addedConstraint.toString()));
	}
	@Test
	public void notifiesAbsenceOfTextField() throws Exception {
		Matcher<? super String> addedConstraint = equalTo("toto");
		Matcher<JPanel> matcher = hasTextField(addedConstraint);
		JPanel emptyPanel = new JPanel();
		StringDescription description = new StringDescription();
		
		matcher.describeMismatch(emptyPanel, description);
		assertThat(description.toString(), equalTo("got a JPanel with no text field"));
		
		assertThat("expected mismatch", matcher.matches(emptyPanel), is(false));
	}
	@Test
	public void notifiesForUnderlyingConstraintFailures() throws Exception {
		Matcher<? super String> addedConstraint = equalTo("some text");
		Matcher<JPanel> matcher = hasTextField(addedConstraint);
		JPanel panel = new JPanel();
		panel.add(new JTextField("some Other text"));
		StringDescription description = new StringDescription();
		
		matcher.describeMismatch(panel, description);
		assertThat(description.toString(), equalTo("got a JPanel with " + addedConstraint.toString()));

		assertThat("expected mismatch", matcher.matches(panel), is(false));
	}
}
