package springapp.web;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/tests")
public class MyController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/compteur", method = RequestMethod.GET)
    public ModelAndView competeur(@SessionAttribute ("compteur") Integer cmpt2, HttpSession session) {
        String now = (new Date()).toString();
        String name = "Jakie Tuning";
        
        Integer compteur = (Integer) session.getAttribute("compteur");
        if (compteur == null) 
        	compteur = 0;
        compteur++;
        
        session.setAttribute("compteur", compteur);
        
        logger.info("Running " + this); 
        logger.info("Running ---------" + cmpt2);
        logger.info("Running increment");
        
        ModelAndView result = new ModelAndView("hello");
        result.addObject("now", now);
        result.addObject("name", name);
        result.addObject("compteur", compteur);
        
        return result;
    }

}
