/**
 * 
 */
package in.anandm.apps.template.interfaces.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anandm
 *
 */
@Controller
@RequestMapping(value="/group")
public class GroupController {
	
	@RequestMapping(value="/grid")
	public String getGroups(){
		
		return "group/grid";
	}
	
	public String newGroup(){
		return "group/group";
	}

	public String newGroupPost(){
		return "group/grid";
	}
	
	public String group(){
		return "group/group";
	}
	
	
}
