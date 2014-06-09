/**
 * 
 */
package in.anandm.apps.template.interfaces.web.controller;

import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.domain.service.IUserService;
import in.anandm.apps.template.interfaces.web.facade.dto.Notification;
import in.anandm.apps.template.interfaces.web.facade.dto.RegistrationFormDTO;
import in.anandm.apps.template.interfaces.web.helper.NotificationHelper;
import in.anandm.apps.template.interfaces.web.validator.AbstractValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author anandm
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IUserService userService;

	@Autowired
	private AbstractValidator registrationFormDTOValidator;

	@RequestMapping(value="/grid")
	public String gridPage(){
		return "user/grid";
	}

	@RequestMapping(value="/newUser",method=RequestMethod.GET)
	public String newUser(Model model){

		model.addAttribute("registrationFormDTO", new RegistrationFormDTO());

		return "user/newUser";
	}

	@RequestMapping(value="/newUser",method=RequestMethod.POST)
	public String newUserPOST(Model model,@ModelAttribute("registrationFormDTO") RegistrationFormDTO registrationFormDTO,
			BindingResult errors){
		registrationFormDTOValidator.validate(registrationFormDTO, errors);
		if(errors.hasErrors()){
			NotificationHelper.notify(new Notification("error", "error", "top left", "Registration failed retry."));
			model.addAttribute("registrationFormDTO", registrationFormDTO);
			return "user/newUser";
		}else{
			//register user here

			userService.registerUser(registrationFormDTO);

			NotificationHelper.notify(new Notification("success", "success", "top left", "user registered successfully."));
			NotificationHelper.notify(new Notification("success", "success", "top left", "An email has been sent for verification."));

			return "redirect:/user/grid";
		}

	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String user(@PathVariable(value="id") Long id,Model model){
		User user = userRepository.getUserById(id);
		return "user/user";
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String userPUT(@PathVariable(value="id") Long id,Model model){
		return "redirect:/user/grid";
	}


	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String userDELETE(@PathVariable(value="id") String id,Model model){
		return "redirect:/user/grid";
	}

}
