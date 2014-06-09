package in.anandm.apps.template.interfaces.web.controller;

import in.anandm.apps.template.domain.model.group.IGroupRepository;
import in.anandm.apps.template.domain.service.IUserService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

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
	
	@Autowired
	private IGroupRepository groupRepository;

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

	@RequestMapping(value = "/userData", method = RequestMethod.GET)
	public String userData(Locale locale, Model model,
			@RequestParam Map<String,String> params
			) {
		logger.info("Params : {}",params);
		model.addAttribute(userService.getDataTable(params));
		return "result";
	}
	
	@RequestMapping(value = "/groupData", method = RequestMethod.GET)
	public String groupDate(Locale locale, Model model,
			@RequestParam Map<String,String> params
			) {
		logger.info("Params : {}",params);
		model.addAttribute(groupRepository.getDataTable(params));
		return "result";
	}
}
