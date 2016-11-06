package testUnitaire;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springapp.web.paramController;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = paramController.class)
public class paramControllerTest {

	@Autowired
    private WebApplicationContext wac;
	
	paramController param;
	private MockMvc mockMvc;
	
	
	@Before
	public void init(){
		param = new paramController();
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	    this.mockMvc = builder.build();
	}
	
	
	@Test
	public void view() throws ServletException, IOException {
		ModelAndView result = param.plus10(10);
		assertEquals("hello", result.getViewName());
	}
	
	@Test
	public void plus10() throws ServletException, IOException {
		ModelAndView result = param.plus10(10);
		assertEquals(20, result.getModelMap().get("number"));
	}
	
	@Test
	public void plusEmptyURL() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.model().attribute("number", 110);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/tests/plus10");
        this.mockMvc.perform(builder)
                    .andExpect(ok);
	}
}
