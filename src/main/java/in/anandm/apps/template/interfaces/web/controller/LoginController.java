/**
 * 
 */
package in.anandm.apps.template.interfaces.web.controller;

import in.anandm.apps.template.domain.model.user.IPasswordResetRequestRepository;
import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.PasswordResetRequest;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.domain.service.IUserService;
import in.anandm.apps.template.interfaces.web.dto.Notification;
import in.anandm.apps.template.interfaces.web.dto.RegistrationFormDTO;
import in.anandm.apps.template.interfaces.web.helper.NotificationHelper;
import in.anandm.apps.template.interfaces.web.validator.AbstractValidator;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author anandm
 *
 */
@Controller
public class LoginController extends BaseController {

	private static final List<String> attemptReason = new ArrayList<String>();

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IPasswordResetRequestRepository passwordResetRequestRepository;

	@Autowired
	private AbstractValidator registrationFormDTOValidator;


	static{
		attemptReason.add("duplicateSession");
		attemptReason.add("logOut");
		attemptReason.add("failed");
		attemptReason.add("success");
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registration(Model model){
		model.addAttribute("registrationFormDTO", new RegistrationFormDTO());
		return "login/register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registrationPOST(Model model,
			@ModelAttribute(value="registrationFormDTO") RegistrationFormDTO registrationFormDTO,
			BindingResult errors) throws NoSuchAlgorithmException{
		registrationFormDTOValidator.validate(registrationFormDTO, errors);
		if(errors.hasErrors()){
			NotificationHelper.notify(new Notification("error", "error", "top left", "Registration failed retry."));
			model.addAttribute("registrationFormDTO", registrationFormDTO);
			return "login/register";
		}else{
			//register user here

			userService.registerUser(registrationFormDTO);

			NotificationHelper.notify(new Notification("success", "success", "top left", "You are registered successfully."));
			NotificationHelper.notify(new Notification("success", "success", "top left", "An email has been sent for verification."));


			return "redirect:/login";
		}
	}


	@RequestMapping(value="/verify",method=RequestMethod.GET)
	public String verifyEmail(Model model,@RequestParam(value="userId") String userId,
			@RequestParam(value="key") String key){

		User user = userRepository.getUserByUserId(userId);


		user.verify(key);

		userRepository.saveUser(user);

		NotificationHelper.notify(new Notification("success", "success", "top left", "Account successfully verified.Login using your credentials"));

		return "redirect:/login";
	}


	@RequestMapping(value="/forgotPassword",method=RequestMethod.GET)
	public String forgotPassword(Model model){
		return "login/forgotPassword";
	}

	@RequestMapping(value="/forgotPassword",method=RequestMethod.POST)
	public String forgotPasswordPOST(Model model,@RequestParam("userId") String userId,
			@RequestParam("recaptcha_challenge_field") String challenge,
			@RequestParam("recaptcha_response_field") String uresponse,HttpServletRequest request
			) throws NoSuchAlgorithmException{

		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LeLO-USAAAAAK-Hr4Ws546OF1DZm48LginxcegZ");// private key

		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr,
				challenge, uresponse);

		if (reCaptchaResponse.isValid()) {
			User foundUser = userRepository.getUserByUserId(userId);
			if(foundUser != null){

				userService.initiatePasswordResetRequest(foundUser, remoteAddr);

				NotificationHelper.notify(new Notification("success", "success", "top left", "Instructions to reset your password has been sent to you at your registered email id."));
				return "redirect:/login";
			}else{
				NotificationHelper.notify(new Notification("error", "error", "top left", "No user found with the given userId"));
				return "login/forgotPassword";
			}
		}else{
			NotificationHelper.notify(new Notification("error", "error", "top left", "Captcha does not match retry"));
			return "login/forgotPassword";
		}

	}

	@RequestMapping(value="/resetPassword",method=RequestMethod.GET)
	public String resetPassword(Model model,@RequestParam(value="requestId") Long requestId,
			@RequestParam(value="key") String key){

		PasswordResetRequest request = passwordResetRequestRepository.getPasswordResetRequestById(requestId);

		model.addAttribute("requestId", request.getId());

		model.addAttribute("key", key);

		return "login/resetPassword";
	}

	@RequestMapping(value="/resetPassword",method=RequestMethod.POST)
	public String resetPasswordPOST(Model model,@RequestParam(value="requestId") Long requestId,
			@RequestParam(value="key") String key,
			@RequestParam(value="password") String password,
			@RequestParam(value="repeatPassword") String repeatPassword,
			@RequestParam("recaptcha_challenge_field") String challenge,
			@RequestParam("recaptcha_response_field") String uresponse,
			HttpServletRequest request){

		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LeLO-USAAAAAK-Hr4Ws546OF1DZm48LginxcegZ");// private key

		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr,
				challenge, uresponse);

		if (reCaptchaResponse.isValid()) {

			if(repeatPassword.equals(password)){
				PasswordResetRequest passwordResetRequest = passwordResetRequestRepository.getPasswordResetRequestById(requestId);

				passwordResetRequest.resetPassword(key,password);

				passwordResetRequestRepository.savePasswordResetRequest(passwordResetRequest);

				NotificationHelper.notify(new Notification("success", "success", "top left", "Password successfully changed.Login using new password"));

				return "redirect:/login";
			}else{		
				NotificationHelper.notify(new Notification("error", "error", "top left", "password does not match retry"));
				
				model.addAttribute("requestId", requestId);
				model.addAttribute("key", key);
				return "login/resetPassword";
			}
		}else{
			NotificationHelper.notify(new Notification("error", "error", "top left", "Captcha does not match retry"));
			
			model.addAttribute("requestId", requestId);
			model.addAttribute("key", key);
			return "login/resetPassword";
		}


	}


	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam(value="attempt",required=false) String attempt,Model model,
			HttpServletRequest request){

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null && attempt != null && attemptReason.contains(attempt)){

			boolean isAnonymous =  (authentication.getPrincipal() instanceof String && "anonymousUser".equals(authentication.getPrincipal()))? true : false;


			if(authentication.isAuthenticated() && !isAnonymous && "success".equals(attempt)){
				NotificationHelper.notify(new Notification("success", "success", "top left", "You are logged in successfully."));
				return "redirect:/";
			}

			if(isAnonymous && "failed".equals(attempt)){			
				NotificationHelper.notify(new Notification("error", "error", "top left", "Wrong user name or password."));
				return "login/login";
			}

			if(isAnonymous && "duplicateSession".equals(attempt)){
				NotificationHelper.notify(new Notification("error", "error", "top left", "concurrent session limit exceeded."));
				return "login/login";
			}

			if(isAnonymous && "logOut".equals(attempt)){
				NotificationHelper.notify(new Notification("success", "success", "top left", "You are successfully logged out."));
				return "login/login";
			}
		}
		return "login/login";
	}


}
