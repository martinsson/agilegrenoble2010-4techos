package org.agile.grenoble.gui;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

final class HasTextField extends TypeSafeDiagnosingMatcher<JPanel> {
	private final Matcher<? super String> matcher;

	private HasTextField(Matcher<? super String> matcher) {
		this.matcher = matcher;
	}

	public void describeTo(Description description) {
		description.appendText("a JPanel with a TextField with ").appendDescriptionOf(matcher);
	}

	@Override
	protected boolean matchesSafely(JPanel item, Description mismatchDescription) {
		boolean result = true;
		List<Component> components = asList(item.getComponents());
		
		if ( ! hasItem(instanceOf(JTextField.class)).matches(components)) {
			mismatchDescription.appendText("got a JPanel with no text field");
			result = false;
		}
		else if ( ! hasItem(matcher).matches(extractTextFields(components))) {
			mismatchDescription.appendText("got a JPanel with ").appendDescriptionOf(matcher);
			result = false;
		}
		return result;
	}

	private List<String> extractTextFields(List<Component> components) {
		List<String> textFieldLabels = new ArrayList<String>();
		for (Component component : components) {
			if (component instanceof JTextField) {
				JTextField textField = (JTextField) component;
				textFieldLabels.add(textField.getText());
			}
		}
		return textFieldLabels;
	}

	static Matcher<JPanel> hasTextField(final Matcher<? super String> matcher) {
		return new HasTextField(matcher);
	}
}