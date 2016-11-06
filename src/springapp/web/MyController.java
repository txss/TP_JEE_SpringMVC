package springapp.web;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/tests")
public class MyController {
	protected final Log logger = LogFactory.getLog(getClass());
	int cmpt = 0;
	
	@RequestMapping(value = "/compteur", method = RequestMethod.GET)
    public ModelAndView competeur() {
        String now = (new Date()).toString();
        String name = "Jakie Tuning";
        cmpt++;
        
        logger.info("Running " + this);
        logger.info("Running increment");
        
        ModelAndView result = new ModelAndView("hello");
        result.addObject("now", now);
        result.addObject("name", name);
        result.addObject("compteur", cmpt);
        
        return result;
    }

}
