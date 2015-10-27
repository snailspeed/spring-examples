package be.g00glen00b.selenium;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Form2Test extends SeleniumTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		startup();
	}

	@Before
	public void setUp() throws Exception {
		open("/form2.html");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		shutdown();
	}

	@Test
	public void test() {
		type("form/table/tbody/tr[1]/td[2]/input", "test");
		click("form/table/tbody/tr[2]/td/input");
		waitForElement("html/body/h1", SelectorType.XPATH);
		verifyText("h1", "De tekst is: test");
	}

}
