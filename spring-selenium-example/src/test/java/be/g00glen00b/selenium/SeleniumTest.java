package be.g00glen00b.selenium;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.Wait;

public class SeleniumTest {

	private static Selenium selenium;
	private static final String FF_PROFILE = "C:\\Users\\Dimitri\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\Selenium";
	private static final String LOCATION = "http://localhost:8080";

	protected static void startup() {
		selenium = new WebDriverBackedSelenium(new FirefoxDriver(
				new FirefoxProfile(new File(FF_PROFILE))), LOCATION);
	}

	protected static void shutdown() {
		selenium.close();
		selenium.stop();
	}

	protected void open(String path) {
		selenium.open(path);
	}

	protected String getSelector(String selector, SelectorType type) {
		if (isPresent(selector) || type == SelectorType.NORMAL) {
			return selector;
		}
		if (isPresent("name=" + selector) || type == SelectorType.NAME) {
			return "name=" + selector;
		}
		if (isPresent("id=" + selector) || type == SelectorType.ID) {
			return "id=" + selector;
		}
		if (isPresent("link=" + selector) || type == SelectorType.LINK) {
			return "link=" + selector;
		}
		if (isPresent("xpath=" + selector) || type == SelectorType.XPATH) {
			return "xpath=" + selector;
		}
		if (isPresent("xpath=html/body/" + selector)) {
			return "xpath=html/body/" + selector;
		}
		if (isPresent("xpath=.//*[@id='" + selector + "']")) {
			return "xpath=.//*[@id='" + selector + "']";
		}
		if (isPresent("xpath=.//*" + selector)) {
			return "xpath=.//*" + selector;
		}
		if (isPresent("css=" + selector) || type == SelectorType.CSS) {
			return "css=" + selector;
		} else {
			throw new SeleniumException("Could not find element");
		}
	}

	protected boolean isPresent(String selector) {
		try {
			return selenium.isElementPresent(selector);
		} catch (SeleniumException ex) {
			return false;
		}
	}

	protected String getSelector(String selector) {
		return getSelector(selector, SelectorType.AUTO);
	}

	protected void type(String selector, String text) {
		selenium.type(getSelector(selector), text);
	}

	protected void click(String selector) {
		selenium.click(getSelector(selector));
	}

	protected void verifyText(String selector, String output) {
		assertEquals(output, selenium.getText(getSelector(selector)));
	}
	
	protected void waitForElement(final String selector, final SelectorType type) {
		new Wait("Element not present") {
			public boolean until() {
				return selenium.isElementPresent(getSelector(selector, type));
			}
		};
	}
}
