package be.g00glen00b.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import be.g00glen00b.domain.Text;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
public class FormControllerTest {
	
	@Autowired
	private FormController controller;
	
	private ModelMap model;

	@Before
	public void setUp() throws Exception {
		model = new ModelMap();
	}

	@Test
	public void testPostFormBean() {
		Text text = new Text();
		text.setTekst("test");
		
		assertEquals("result", controller.postFormBean(text, null, model));
		assertEquals("test", model.get("tekst"));
	}

	@Test
	public void testGetFormBean() {
		ModelAndView result = controller.getFormBean();
		
		assertEquals("form", result.getViewName());
		assertTrue(result.getModel().containsKey("command"));
		assertTrue(result.getModel().get("command") instanceof Text);
	}

	@Test
	public void testPostFormEasy() {
		assertEquals("result", controller.postFormEasy("test", model));
		assertEquals("test", model.get("tekst"));
	}

	@Test
	public void testGetFormEasy() {
		assertEquals("form2", controller.getFormEasy());
	}

}
