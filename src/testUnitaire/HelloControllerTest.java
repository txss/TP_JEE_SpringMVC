package testUnitaire;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import springapp.web.HelloController;

public class HelloControllerTest {

	HelloController hello;
	
	@Before
	public void init(){
		hello = new HelloController();
	}
	
	@Test
	public void test() throws ServletException, IOException {
		ModelAndView result = hello.handleRequest(null, null);
		assertEquals("hello", result.getViewName());
	}

}
