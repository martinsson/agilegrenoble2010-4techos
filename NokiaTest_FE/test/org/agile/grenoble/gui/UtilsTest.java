package org.agile.grenoble.gui;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

public class UtilsTest {

	@Test
	public void logoIsAvailableOnTheClasspath() throws Exception {
		URL image = UtilsTest.class.getResource("/resources/images/question.JPG");
		assertNotNull("ss",image);
		new File(image.getFile());
	}
}
