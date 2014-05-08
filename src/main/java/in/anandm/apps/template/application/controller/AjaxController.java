package in.anandm.apps.template.application.controller;

import in.anandm.apps.template.domain.service.IUserService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/ajax")
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	private IUserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dashboard-boxrefresh-demo", method = RequestMethod.GET)
	public String refreshDashBoard(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "dashboard-boxrefresh-demo";
	}

	@RequestMapping(value = "/browserData", method = RequestMethod.GET)
	public String browserData(Locale locale, Model model,
			@RequestParam(value="iDisplayLength") Integer iDisplayLength,
			@RequestParam(value="iDisplayStart") Integer iDisplayStart,
			@RequestParam(value="sSearch") String sSearch
			) {
		
		
		logger.info("Welcome browser Data! The client locale is {}.", locale);
		logger.info("iDisplayLength {}.", iDisplayLength);
		logger.info("iDisplayStart {}.", iDisplayStart);
		logger.info("sSearch {}.", sSearch);


		model.addAttribute("aaData",userService.getRecords(iDisplayStart, iDisplayLength, sSearch));

		return "result";
	}
}