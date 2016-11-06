package springapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/tests")
public class URLController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	//http://localhost:8080/Sprng_MVC/actions/tests/voir/12
	
	@RequestMapping(value = "/voir/{param1};{param2}", method = RequestMethod.GET)
	public ModelAndView voir(	@PathVariable("param1") Integer param1,
								@PathVariable("param2") Integer param2) {
	    
		logger.info("Running param controler with param1=" + param1);
	    logger.info("Running param controler with param2=" + param2);
	    String name = "jackie tuning";
	    
	    
	    ModelAndView result = new ModelAndView("hello");
        result.addObject("param1", param1);
        result.addObject("name", name);
        result.addObject("param2", param2);
	    
	    return result;
	}
	
}
