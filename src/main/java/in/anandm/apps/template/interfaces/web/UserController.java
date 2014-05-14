/**
 * 
 */
package in.anandm.apps.template.interfaces.web;

import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author anandm
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IUserService userService;
	@RequestMapping(value="/")
	public String gridPage(){
		
		return "user/grid";
	}

	@RequestMapping(value="/newUser",method=RequestMethod.GET)
	public String newUser(Model model){
		return "user/newUser";
	}

	@RequestMapping(value="/newUser",method=RequestMethod.POST)
	public String newUserPOST(Model model){
		return "redirect:/user";
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String user(@PathVariable(value="id") String id,Model model){
		return "user/user";
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String userPUT(@PathVariable(value="id") String id,Model model){
		return "redirect:/user/"+id;
	}


	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String userDELETE(@PathVariable(value="id") String id,Model model){
		return "redirect:/user/grid";
	}

}
