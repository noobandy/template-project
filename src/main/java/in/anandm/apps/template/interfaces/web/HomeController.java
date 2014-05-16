package in.anandm.apps.template.interfaces.web;

import in.anandm.apps.template.domain.model.user.Gender;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.domain.model.user.UserAccount;
import in.anandm.apps.template.domain.model.user.UserProfile;
import in.anandm.apps.template.domain.service.IUserService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IUserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		UserAccount userAccount = new UserAccount("anandm", "anandm", true, true, System.currentTimeMillis());
		UserProfile userProfile = new UserProfile("Anand", "Mohan", Gender.MALE, 
				System.currentTimeMillis(), "anandm@mkcl.org", "8108131239",null);
		User user = new User(userAccount, userProfile);
		userService.addUser(user);
		
		return "index";
	}
	
	//apps/pages/forms/general.html
	
	
	@RequestMapping(value = "/pages/{type}/{page}", method = RequestMethod.GET)
	public String pagesOfTypes(Locale locale, Model model,@PathVariable(value="type") String type,@PathVariable(value="page") String page) {
		logger.info("Welcome page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "pages/"+type+"/"+page;
	}
	
	@RequestMapping(value = "/pages/{page}", method = RequestMethod.GET)
	public String pages(Locale locale, Model model,@PathVariable(value="page") String page) {
		logger.info("Welcome page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "pages/"+page;
	}
}
