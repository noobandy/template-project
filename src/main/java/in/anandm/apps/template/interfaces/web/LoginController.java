/**
 * 
 */
package in.anandm.apps.template.interfaces.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author anandm
 *
 */
@Controller
public class LoginController {

	private static final List<String> attemptReason = new ArrayList<String>();

	static{
		attemptReason.add("duplicateSession");
		attemptReason.add("logOut");
		attemptReason.add("failed");
		attemptReason.add("success");
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam(value="attempt",required=false) String attempt,Model model,
			HttpServletRequest request){

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null && attempt != null && attemptReason.contains(attempt)){

			boolean isAnonymous =  (authentication.getPrincipal() instanceof String && "anonymousUser".equals(authentication.getPrincipal()))? true : false;
			
			
				if(authentication.isAuthenticated() && !isAnonymous && "success".equals(attempt)){
					System.out.println(request.getRemoteAddr());
					return "redirect:/";
				}

				if(isAnonymous && "failed".equals(attempt)){
					System.out.println(authentication.getPrincipal());
					System.out.println(request.getRemoteAddr());
					model.addAttribute("errorMsg", "Wrong user name or password.");
					return "login/login";
				}

				if(isAnonymous && "duplicateSession".equals(attempt)){
					System.out.println(authentication.getPrincipal());
					System.out.println(request.getRemoteAddr());
					model.addAttribute("errorMsg", "concurrent session limit exceeded.");
					return "login/login";
				}

				if(isAnonymous && "logOut".equals(attempt)){
					System.out.println(authentication.getPrincipal());
					System.out.println(request.getRemoteAddr());
					model.addAttribute("successMsg", "You are successfully logged out.");
					return "login/login";
				}
		}
		return "login/login";
	}


}
