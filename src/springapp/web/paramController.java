package springapp.web;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller()
@RequestMapping("/tests")
public class paramController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/plus10", method = RequestMethod.GET)
	public ModelAndView plus10(
	        @RequestParam(value = "num", defaultValue = "100") Integer value,
			@RequestParam(value = "date", required=false, defaultValue = "1/1/2000") @DateTimeFormat(pattern = "dd/MM/yyyy") Date date ){

		logger.info("Running plus10 controler with param = " + value);
		
		System.out.println(date);
		
		ModelAndView result = new ModelAndView("hello");
        result.addObject("number", value+10);
        result.addObject("date", date);
		
	    return result;
	}
	
}
